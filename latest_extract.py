from youtube_transcript_api import YouTubeTranscriptApi
import re
import spacy
from spacy.matcher import Matcher, PhraseMatcher

nlp = spacy.load("en_core_web_sm")

def get_video_transcript(video_id):
    try:
        transcript = YouTubeTranscriptApi.get_transcript(video_id)
        return " ".join([entry['text'] for entry in transcript])
    except Exception as e:
        print(f"Error fetching transcript: {e}")
        return None

def preprocess_transcript(text):
    text = re.sub(r'(\b(so|now|next|okay|alright)\b)', r'. \1', text, flags=re.I)
    text = re.sub(r'(\d+\.)\s+(\w)', r'\1\n\2', text)
    return text

def flatten(nested_list):
    return [item for sublist in nested_list 
            for item in (sublist if isinstance(sublist, list) else [sublist])]

def extract_questions(text):
    text = preprocess_transcript(text)
    doc = nlp(text)
    
    sentences = list(doc.sents)
    total_sentences = len(sentences)
    
    devops_terms = ["VPC", "CI/CD", "Kubernetes", "Terraform",
                    "Ansible", "Docker", "AWS", "EC2", "S3", "Sonarqube", "Python", "Shell", "Gitlab", "Git", "Load"]
    phrase_matcher = PhraseMatcher(nlp.vocab)
    patterns = [nlp(term) for term in devops_terms]
    phrase_matcher.add("DEV_OPS_TERMS", patterns)

    matcher = Matcher(nlp.vocab)
    question_patterns = [
        [{"LOWER": {"IN": ["how", "what", "explain", "describe"]}}, 
         {"POS": {"IN": ["VERB", "AUX"]}, "OP": "+"}],
        [{"LOWER": "if"}, {"LOWER": "you"}, {"LOWER": "would"}],
        [{"LOWER": {"IN": ["design", "create", "troubleshoot"]}},
         {"ENT_TYPE": {"IN": ["PRODUCT", "ORG"]}}],
        [{"LOWER": "walk"}, {"LOWER": "me"}, {"LOWER": "through"}],
        [{"LOWER": "what"}, {"LOWER": "would"}, {"LOWER": "you"}],
        [{"LOWER": "can"}, {"LOWER": "you"}, {"LOWER": "explain"}]
    ]
    
    for i, pattern in enumerate(question_patterns):
        matcher.add(f"QUESTION_{i}", [pattern])

    questions = []
    current_question = []
    question_buffer = []
    
    for i, sent in enumerate(sentences):
        sent_doc = sent.as_doc()
        
        tech_matches = phrase_matcher(sent_doc)
        if tech_matches:
            question_buffer.append(sent.text)
        
        matches = matcher(sent_doc)
        if matches or '?' in sent.text:
            current_question.append(sent.text)
            
            if i + 1 < total_sentences:
                next_sent = sentences[i+1].text
                if re.search(r'\b(and|or|also)\b', next_sent, re.I):
                    current_question.append(next_sent)
            
            question_buffer.extend(current_question)
            current_question = []
        
        if len(question_buffer) >= 3 or not matches:
            merged = " ".join(question_buffer)
            if merged:
                processed = process_question(merged)
                if isinstance(processed, list):
                    questions.extend(processed)
                else:
                    questions.append(processed)
            question_buffer = []
    
    # Flatten and clean
    questions = flatten(questions)
    questions = [clean_question(q) for q in questions if q]
    return sorted(set(questions), key=lambda x: -len(x))

def process_question(text):
    splits = re.split(r'\b(and|or|then)\b', text)
    if len(splits) > 1:
        return [s.strip() for s in splits if s.strip() not in ['and', 'or', 'then']]
    return text

def clean_question(text):
    text = re.sub(r'\b(so|basically|actually|you know|I mean)\b', '', text, flags=re.I)
    text = re.sub(r'\s+', ' ', text).strip()
    if not text:  # Handle empty strings after cleaning
        return None
    text = text[0].upper() + text[1:]
    if not text.endswith('?'):
        text = re.sub(r'[.,]$', '?', text)
    return text

def get_video_id(video_url):
    # Regex pattern to extract YouTube video ID from the URL
    video_id_pattern = re.compile(r'(?:https?://)?(?:www\.)?(?:youtube\.com/watch\?v=|youtu\.be/)([\w-]{11})')
    match = video_id_pattern.match(video_url)
    if match:
        return match.group(1)
    else:
        return None

def main():
    video_url = input("Enter YouTube video URL: ")
    video_id = get_video_id(video_url)
    
    if not video_id:
        print("Invalid YouTube URL.")
        return

    transcript = get_video_transcript(video_id)
    
    if transcript:
        questions = extract_questions(transcript)
        if questions:
            print("\nExtracted Interview Questions:")
            with open("interview_questions.txt", "w") as file:
                for i, q in enumerate(questions[:50], 1):
                    question = f"{i}. {q}"
                    print(question)
                    file.write(question + "\n")
            print("\nQuestions have been written to interview_questions.txt")
        else:
            print("No questions extracted from the transcript.")
    else:
        print("Failed to retrieve the transcript.")

if __name__ == "__main__":
    main()

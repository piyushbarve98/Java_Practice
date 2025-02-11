from youtube_transcript_api import YouTubeTranscriptApi
import re
import spacy
from spacy.matcher import Matcher, PhraseMatcher
from spacy.tokens import Span

nlp = spacy.add_pipe("merge_entities")
nlp = spacy.load("en_core_web_sm")

def preprocess_transcript(text):
    # Enhance sentence splitting for spoken language
    text = re.sub(r'(\b(so|now|next|okay|alright)\b)', r'. \1', text, flags=re.I)
    text = re.sub(r'(\d+\.)\s+(\w)', r'\1\n\2', text)  # Numbered questions
    return text

def extract_questions(text):
    text = preprocess_transcript(text)
    doc = nlp(text)
    
    # Custom DevOps entity recognition
    devops_terms = ["VPC", "CI/CD", "Kubernetes", "Terraform", "CloudFormation",
                    "Ansible", "Docker", "Jenkins", "AWS", "GCP", "Azure"]
    phrase_matcher = PhraseMatcher(nlp.vocab)
    patterns = [nlp(term) for term in devops_terms]
    phrase_matcher.add("DEV_OPS_TERMS", patterns)

    # Enhanced question patterns
    matcher = Matcher(nlp.vocab)
    question_patterns = [
        [{"LOWER": {"IN": ["how", "what", "explain", "describe"]}}, 
         {"POS": {"IN": ["VERB", "AUX"]}, "OP": "+"}],
         
        [{"LOWER": "if"}, {"LOWER": "you"}, {"LOWER": "would"}],
         
        [{"LOWER": {"IN": ["design", "create", "troubleshoot"]}},
         {"ENT_TYPE": {"IN": ["PRODUCT", "DEV_OPS_TERMS"]}}],
         
        [{"LOWER": "walk"}, {"LOWER": "me"}, {"LOWER": "through"}],
         
        [{"LOWER": "what"}, {"LOWER": "would"}, {"LOWER": "you"}],
         
        [{"LOWER": "can"}, {"LOWER": "you"}, {"LOWER": "explain"}]
    ]
    
    for i, pattern in enumerate(question_patterns):
        matcher.add(f"QUESTION_{i}", [pattern])

    questions = []
    current_question = []
    question_buffer = []
    
    for sent in doc.sents:
        # Check for technical terms first
        tech_matches = phrase_matcher(sent)
        if tech_matches:
            question_buffer.append(sent.text)
        
        # Check question patterns
        matches = matcher(sent)
        if matches or '?' in sent.text:
            current_question.append(sent.text)
            # Look ahead for continuation keywords
            next_sent = sent.nbor()
            if next_sent and re.search(r'\b(and|or|also)\b', next_sent.text, re.I):
                current_question.append(next_sent.text)
            question_buffer.extend(current_question)
            current_question = []
        
        # Process buffer every 3 sentences
        if len(question_buffer) >= 3 or not matches:
            merged = " ".join(question_buffer)
            if merged:
                questions.append(process_question(merged))
            question_buffer = []
    
    # Post-processing
    questions = [clean_question(q) for q in questions]
    return sorted(set(questions), key=lambda x: -len(x))

def process_question(text):
    # Split compound questions
    splits = re.split(r'\b(and|or|then)\b', text)
    if len(splits) > 1:
        return [s.strip() for s in splits if s.strip() not in ['and', 'or', 'then']]
    return text

def clean_question(text):
    # Remove filler phrases and normalize
    text = re.sub(r'\b(so|basically|actually|you know|I mean)\b', '', text, flags=re.I)
    text = re.sub(r'\s+', ' ', text).strip()
    text = text[0].upper() + text[1:]
    if not text.endswith('?'):
        text = re.sub(r'[.,]$', '?', text)
    return text

def main():
    video_id = input("Enter YouTube video ID: ")
    transcript = get_video_transcript(video_id)
    
    if transcript:
        questions = extract_questions(transcript)
        print("\nExtracted Interview Questions:")
        for i, q in enumerate(questions[:20], 1):  # Show top 20
            print(f"{i}. {q}")

if __name__ == "__main__":
    main()
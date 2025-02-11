from youtube_transcript_api import YouTubeTranscriptApi
import re
import spacy
from collections import deque

# Load English language model for spaCy
nlp = spacy.load("en_core_web_sm")

def get_video_transcript(video_id):
    try:
        transcript = YouTubeTranscriptApi.get_transcript(video_id)
        return " ".join([entry['text'] for entry in transcript])
    except Exception as e:
        print(f"Error fetching transcript: {e}")
        return None

def extract_questions(text):
    # Process text with spaCy
    doc = nlp(text)
    
    # Define question patterns using POS tags and syntax
    question_patterns = [
        [{"LOWER": {"IN": ["what", "how", "why", "when", "where", "can", "do", "does", "did"]}},
         {"DEP": {"IN": ["aux", "ROOT", "advcl"]}, "OP": "+"}],
        
        [{"LOWER": {"IN": ["explain", "describe", "create", "write"]}},
         {"DEP": "dobj", "OP": "+"}],
        
        [{"LOWER": "difference"}, {"LOWER": "between"}],
        
        [{"LOWER": "what"}, {"LOWER": "is"}, {"LOWER": "the"}],
        
        [{"LOWER": "how"}, {"LOWER": "would"}]
    ]
    
    # Use spaCy's Matcher
    from spacy.matcher import Matcher
    matcher = Matcher(nlp.vocab)
    for pattern in question_patterns:
        matcher.add("QUESTION", [pattern])
    
    questions = []
    # Process sentences
    for sent in doc.sents:
        # Check for question mark first
        if "?" in sent.text:
            questions.append(sent.text.strip())
            continue
            
        # Use matcher to find question patterns
        matches = matcher(sent.as_doc())
        if matches:
            # Merge tokens and clean up
            question = sent.text.strip()
            
            # Add question mark if missing
            if not question.endswith('?'):
                question += '?'
            
            questions.append(question)
    
    return questions

def main():
    video_id = input("Enter YouTube video ID: ")
    transcript = get_video_transcript(video_id)
    
    if transcript:
        questions = extract_questions(transcript)
        print("\nExtracted Interview Questions:")
        for i, question in enumerate(questions, 1):
            print(f"{i}. {question}")

if __name__ == "__main__":
    main()
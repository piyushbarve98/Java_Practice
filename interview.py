from youtube_transcript_api import YouTubeTranscriptApi
import re

def get_video_transcript(video_id):
    try:
        transcript = YouTubeTranscriptApi.get_transcript(video_id)
        return " ".join([entry['text'] for entry in transcript])
    except Exception as e:
        print(f"Error fetching transcript: {e}")
        return None

def extract_questions(text):
    # Define question starter keywords (case-insensitive)
    question_starters = {
        'how', 'what', 'write', 'create', 'can', 
        'explain', 'describe', 'why', 'when', 'where',
        'which', 'who', 'list', 'name', 'give'
    }
    
    # Split text into words while preserving apostrophes
    words = re.findall(r"\b[\w']+\b", text.lower())
    original_words = re.findall(r"\b[\w']+\b", text)
    
    questions = []
    i = 0
    max_words = 20
    
    while i < len(words):
        if words[i] in question_starters:
            # Found a question start
            question_end = None
            lookahead_end = min(i + max_words, len(words))
            
            # Look for next question starter within 20 words
            for j in range(i + 1, lookahead_end):
                if words[j] in question_starters:
                    question_end = j
                    break
            
            # If no next starter found, use 20-word limit
            end = question_end or lookahead_end
            
            # Extract original casing words
            question = " ".join(original_words[i:end]).capitalize()
            
            # Add proper punctuation if missing
            if not question.endswith('?'):
                question += '?'
            
            questions.append(question)
            i = end  # Skip processed words
        else:
            i += 1
    
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
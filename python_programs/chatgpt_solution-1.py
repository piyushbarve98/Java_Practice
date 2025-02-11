#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
This script extracts interview questions from a YouTube video transcript
using free AI packages. It uses the youtube-transcript-api to fetch the transcript
and Hugging Face Transformers' zero-shot-classification pipeline to classify
each transcript segment as a question or not.
"""

from youtube_transcript_api import YouTubeTranscriptApi
from transformers import pipeline

def get_transcript_list(video_id):
    """
    Fetches the transcript for a given YouTube video ID.
    Returns:
        A list of transcript segments (each a dict with a 'text' key), or None on error.
    """
    try:
        transcript_list = YouTubeTranscriptApi.get_transcript(video_id)
        return transcript_list
    except Exception as e:
        print("Error retrieving transcript:", e)
        return None

def extract_questions_ai(transcript_list, threshold=0.7):
    """
    Uses a zero-shot classification model to classify each transcript segment as a question.
    
    Args:
        transcript_list (list): A list of transcript segments (each with a 'text' key).
        threshold (float): The minimum confidence required for a segment to be considered a question.
    
    Returns:
        List[str]: A list of segments classified as questions.
    """
    # Initialize the zero-shot classification pipeline with a free model.
    classifier = pipeline("zero-shot-classification", model="facebook/bart-large-mnli")
    
    # We define our candidate labels.
    candidate_labels = ["question", "statement"]
    questions = []
    
    # Process each transcript segment.
    for entry in transcript_list:
        text = entry.get("text", "").strip()
        if not text:
            continue
        
        # Classify the text as either a question or a statement.
        result = classifier(text, candidate_labels)
        # The result is a dict with keys "labels" and "scores".
        # Find the score for the "question" label.
        if "question" in result["labels"]:
            question_index = result["labels"].index("question")
            question_score = result["scores"][question_index]
            if question_score >= threshold:
                questions.append(text)
    return questions

def main():
    # Prompt the user for a YouTube video ID (for example: "dQw4w9WgXcQ").
    video_id = input("Enter the YouTube video ID: ").strip()
    
    transcript_list = get_transcript_list(video_id)
    if transcript_list:
        print("Transcript retrieved. Extracting questions using AI classification...")
        questions = extract_questions_ai(transcript_list, threshold=0.7)
        if questions:
            print("\nExtracted Interview Questions:\n")
            for idx, question in enumerate(questions, 1):
                print(f"{idx}. {question}")
        else:
            print("No questions were found in the transcript using AI classification.")
    else:
        print("Transcript could not be retrieved. Make sure the video has captions available.")

if __name__ == "__main__":
    main()

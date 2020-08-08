package com.example.truecitizenquiz;

public class Question {
    private int answerResId;
    private boolean correctAnswer;

    public Question(int answerResId, boolean correctAnswer) {
        this.answerResId = answerResId;
        this.correctAnswer = correctAnswer;
    }

    public int getAnswerResId() {
        return answerResId;
    }

    public void setAnswerResId(int answerResId) {
        this.answerResId = answerResId;
    }

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
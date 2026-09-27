package model;

import java.util.List;

public class FAQ {

    private String question;
    private String answer;
    private List<String> keywords;

    // Constructor
    public FAQ(String question, String answer, List<String> keywords) {
        this.question = question;
        this.answer = answer;
        this.keywords = keywords;
    }

    // Getter for question
    public String getQuestion() {
        return question;
    }

    // Getter for answer
    public String getAnswer() {
        return answer;
    }

    // Getter for keywords
    public List<String> getKeywords() {
        return keywords;
    }
}
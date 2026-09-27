package service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import data.FAQData;
import model.FAQ;

public class ChatbotService {

    private NLPProcessor nlpProcessor;
    private List<FAQ> faqs;
    private AIService aiService;

    public ChatbotService() {

        nlpProcessor = new NLPProcessor();
        faqs = FAQData.getFAQs();
        aiService = new AIService();
    }

    public String getResponse(String userInput) {

        if (userInput == null || userInput.trim().isEmpty()) {
            return "Please enter a message.";
        }

        String cleanedInput = nlpProcessor.cleanText(userInput);

        List<String> userWords = nlpProcessor.tokenize(cleanedInput);

        if (userWords.isEmpty()) {
            return "Sorry, I could not understand your message.";
        }

        if (containsExitKeyword(userWords)) {
            return "Goodbye! Have a great day!";
        }

        FAQ bestMatch = null;
        int highestScore = 0;

        for (FAQ faq : faqs) {

            int score = calculateScore(
                    userWords,
                    faq.getKeywords()
            );

            if (score > highestScore) {
                highestScore = score;
                bestMatch = faq;
            }
        }

        // If FAQ match is found
        if (bestMatch != null && highestScore > 0) {
            return bestMatch.getAnswer();
        }

        // If FAQ match is not found, try AI API
        String aiResponse = aiService.getAIResponse(userInput);

        // If AI API gives a valid answer
        if (!aiResponse.startsWith("AI service is currently unavailable")
                && !aiResponse.startsWith("AI service is not configured")
                && !aiResponse.startsWith("Unable to connect")
                && !aiResponse.startsWith("AI authentication failed")
                && !aiResponse.startsWith("AI service error")) {

            return aiResponse;
        }

        // If AI API is unavailable, use local fallback
        return getFallbackResponse(userInput);
    }

    private int calculateScore(
            List<String> userWords,
            List<String> keywords) {

        int score = 0;

        Set<String> keywordSet = new HashSet<>(keywords);

        for (String word : userWords) {

            if (keywordSet.contains(word)) {
                score++;
            }
        }

        return score;
    }

    private boolean containsExitKeyword(List<String> words) {

        return words.contains("bye")
                || words.contains("goodbye")
                || words.contains("exit");
    }

    // Local fallback responses
    private String getFallbackResponse(String userInput) {

        String input = userInput.toLowerCase();

        if (input.contains("ramayan")
                || input.contains("ramayana")) {

            return "Ramayana is an ancient Indian epic "
                    + "traditionally attributed to Valmiki. "
                    + "It tells the story of Lord Rama, Sita, "
                    + "Lakshmana and Hanuman.";
        }

        if (input.contains("mahabharat")
                || input.contains("mahabharata")) {

            return "Mahabharata is an ancient Indian epic "
                    + "about the Pandavas and Kauravas. "
                    + "It also includes the Bhagavad Gita.";
        }

        if (input.contains("india")) {

            return "India is a country in South Asia known "
                    + "for its rich history, culture and diversity.";
        }

        if (input.contains("python")) {

            return "Python is a popular high-level programming "
                    + "language known for its simple syntax.";
        }

        if (input.contains("html")) {

            return "HTML stands for HyperText Markup Language. "
                    + "It is used to create the structure of web pages.";
        }

        if (input.contains("css")) {

            return "CSS stands for Cascading Style Sheets. "
                    + "It is used to design and style web pages.";
        }

        return "I don't have a specific answer for that yet. "
                + "Please try another question.";
    }
}

package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NLPProcessor {

    // Convert text into lowercase and remove punctuation
    public String cleanText(String text) {

        if (text == null || text.trim().isEmpty()) {
            return "";
        }

        text = text.toLowerCase();

        text = text.replaceAll("[^a-zA-Z0-9\\s]", "");

        text = text.replaceAll("\\s+", " ").trim();

        return text;
    }

    // Convert cleaned text into individual words
    public List<String> tokenize(String text) {

        String cleanedText = cleanText(text);

        if (cleanedText.isEmpty()) {
            return List.of();
        }

        return Arrays.stream(cleanedText.split(" "))
                .collect(Collectors.toList());
    }
}
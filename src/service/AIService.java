package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AIService {

    private final HttpClient client;

    public AIService() {
        client = HttpClient.newHttpClient();
    }

    public String getAIResponse(String userQuestion) {

        String apiKey = System.getenv("AI_API_KEY");

        if (apiKey == null || apiKey.isEmpty()) {
            return "AI service is not configured. Please check the API key.";
        }

        try {

            String jsonBody = """
                    {
                      "model": "gpt-4o-mini",
                      "messages": [
                        {
                          "role": "user",
                          "content": "%s"
                        }
                      ]
                    }
                    """.formatted(
                            escapeJson(userQuestion)
                    );

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.openai.com/v1/chat/completions"))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + apiKey)
                    .POST(
                            HttpRequest.BodyPublishers.ofString(jsonBody)
                    )
                    .build();

            HttpResponse<String> response =
                    client.send(
                            request,
                            HttpResponse.BodyHandlers.ofString()
                    );

            if (response.statusCode() == 200) {

                return extractAnswer(response.body());

            } else if (response.statusCode() == 401) {

                return "AI authentication failed. Please check the API configuration.";

            } else if (response.statusCode() == 429) {

                return "AI service is currently unavailable. "
                        + "Please check the API quota and try again later.";

            } else {

                return "AI service error. Status Code: "
                        + response.statusCode();
            }

        } catch (IOException e) {

            return "Unable to connect to AI service.";

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            return "AI request was interrupted.";
        }
    }

    private String escapeJson(String text) {

        return text
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r");
    }

    private String extractAnswer(String json) {

        String marker = "\"content\":\"";

        int start = json.indexOf(marker);

        if (start == -1) {
            return "Sorry, I could not generate an answer.";
        }

        start += marker.length();

        int end = json.indexOf("\"", start);

        if (end == -1) {
            return "Sorry, I could not read the AI response.";
        }

        return json.substring(start, end)
                .replace("\\n", "\n")
                .replace("\\\"", "\"");
    }
}
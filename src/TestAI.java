import service.AIService;

public class TestAI {

    public static void main(String[] args) {

        AIService aiService = new AIService();

        String question = "Explain Java in simple language.";

        String answer = aiService.getAIResponse(question);

        System.out.println("User: " + question);
        System.out.println();
        System.out.println("AI: " + answer);
    }
}
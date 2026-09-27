import service.ChatbotService;

public class TestChatbot {

    public static void main(String[] args) {

        ChatbotService chatbot = new ChatbotService();

        System.out.println("Bot: Hello! Ask me something.");

        System.out.println();
        System.out.println("User: What is Java?");
        System.out.println("Bot: " + chatbot.getResponse("What is Java?"));

        System.out.println();
        System.out.println("User: What is OOP?");
        System.out.println("Bot: " + chatbot.getResponse("What is OOP?"));

        System.out.println();
        System.out.println("User: What is NLP?");
        System.out.println("Bot: " + chatbot.getResponse("What is NLP?"));

        System.out.println();
        System.out.println("User: bye");
        System.out.println("Bot: " + chatbot.getResponse("bye"));
    }
}
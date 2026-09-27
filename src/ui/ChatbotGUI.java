package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import service.ChatbotService;

public class ChatbotGUI extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;

    private JButton sendButton;
    private JButton clearButton;
    private JButton exitButton;

    private ChatbotService chatbot;

    public ChatbotGUI() {

        chatbot = new ChatbotService();

        // Window settings
        setTitle("AI Chatbot");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Chat area
        chatArea = new JTextArea();

        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);

        chatArea.setMargin(
                new Insets(10, 10, 10, 10)
        );

        JScrollPane scrollPane = new JScrollPane(chatArea);

        scrollPane.setBorder(
                BorderFactory.createTitledBorder(
                        "Conversation"
                )
        );

        // Input field
        inputField = new JTextField();

        inputField.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );

        // Buttons
        sendButton = new JButton("Send");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");

        // Button panel
        JPanel buttonPanel = new JPanel();

        buttonPanel.add(sendButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        // Bottom panel
        JPanel bottomPanel =
                new JPanel(new BorderLayout(10, 10));

        bottomPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 10, 10, 10
                )
        );

        bottomPanel.add(
                inputField,
                BorderLayout.CENTER
        );

        bottomPanel.add(
                buttonPanel,
                BorderLayout.EAST
        );

        // Main layout
        setLayout(
                new BorderLayout(10, 10)
        );

        add(
                scrollPane,
                BorderLayout.CENTER
        );

        add(
                bottomPanel,
                BorderLayout.SOUTH
        );

        // Welcome message
        chatArea.append(
                "Bot: Hello! Welcome to AI Chatbot.\n"
                + "Bot: You can ask me about Java, OOP, "
                + "AI, NLP, programming and databases.\n\n"
        );

        // Send button
        sendButton.addActionListener(
                e -> sendMessage()
        );

        // Press Enter to send
        inputField.addActionListener(
                e -> sendMessage()
        );

        // Clear button
        clearButton.addActionListener(
                e -> clearChat()
        );

        // Exit button
        exitButton.addActionListener(
                e -> System.exit(0)
        );
    }

    private void sendMessage() {

        String userMessage =
                inputField.getText().trim();

        if (userMessage.isEmpty()) {
            return;
        }

        chatArea.append(
                "You: " + userMessage + "\n"
        );

        String response =
                chatbot.getResponse(userMessage);

        chatArea.append(
                "Bot: " + response + "\n\n"
        );

        inputField.setText("");

        chatArea.setCaretPosition(
                chatArea.getDocument().getLength()
        );
    }

    private void clearChat() {

        chatArea.setText("");

        chatArea.append(
                "Bot: Chat cleared!\n"
                + "Bot: How can I help you?\n\n"
        );
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ChatbotGUI chatbotGUI =
                    new ChatbotGUI();

            chatbotGUI.setVisible(true);
        });
    }
}
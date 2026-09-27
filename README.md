# AI Chatbot using Java

## 📌 Project Overview

AI Chatbot is a Java-based chatbot developed as part of the CodeAlpha Internship.

The chatbot accepts user questions, processes the input using basic Natural Language Processing (NLP) techniques, and provides suitable responses using a rule-based FAQ system.

The project also includes a Java Swing GUI that allows users to interact with the chatbot through a simple desktop application.

---

## 🚀 Features

- Interactive chatbot conversation
- Text preprocessing using NLP
- Lowercase conversion
- Punctuation removal
- Text tokenization
- Keyword-based FAQ matching
- 25+ predefined FAQs
- Java Swing graphical interface
- Send message using button or Enter key
- Clear conversation option
- Exit option
- Local fallback responses for unknown questions
- AI API integration

---

## 🛠️ Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Natural Language Processing (NLP)
- Rule-Based Chatbot
- Java Swing
- Java HTTP Client
- AI API
- Git
- GitHub
- VS Code

---

## 📂 Project Structure

```text
AIchatbot
│
├── src
│   ├── model
│   │   └── FAQ.java
│   │
│   ├── service
│   │   ├── NLPProcessor.java
│   │   ├── ChatbotService.java
│   │   └── AIService.java
│   │
│   ├── data
│   │   └── FAQData.java
│   │
│   ├── ui
│   │   └── ChatbotGUI.java
│   │
│   ├── TestChatbot.java
│   └── TestAI.java
│
├── screenshots
│   ├── screenshot1-main-gui.png
│   ├── screenshot2-chatbot-conversation.png
│   └── screenshot3-gui-features.png
│
├── .gitignore
└── README.md

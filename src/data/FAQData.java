package data;

import java.util.ArrayList;
import java.util.List;

import model.FAQ;

public class FAQData {

    public static List<FAQ> getFAQs() {

        List<FAQ> faqs = new ArrayList<>();

        // Java FAQs
        faqs.add(new FAQ(
                "What is Java?",
                "Java is a popular object-oriented programming language used to build many types of applications.",
                List.of("java", "programming", "language")
        ));

        faqs.add(new FAQ(
                "What is OOP?",
                "OOP stands for Object-Oriented Programming. It is based on concepts like encapsulation, inheritance, polymorphism and abstraction.",
                List.of("oop", "object", "oriented", "programming")
        ));

        faqs.add(new FAQ(
                "What is a class?",
                "A class is a blueprint or template used to create objects in Java.",
                List.of("class", "java", "object")
        ));

        faqs.add(new FAQ(
                "What is an object?",
                "An object is an instance of a class that contains data and behavior.",
                List.of("object", "instance", "class")
        ));

        faqs.add(new FAQ(
                "What is inheritance?",
                "Inheritance allows one class to acquire properties and methods of another class.",
                List.of("inheritance", "class", "parent", "child")
        ));

        faqs.add(new FAQ(
                "What is polymorphism?",
                "Polymorphism means one interface can have multiple forms. In Java it is commonly achieved using method overloading and overriding.",
                List.of("polymorphism", "overloading", "overriding")
        ));

        faqs.add(new FAQ(
                "What is encapsulation?",
                "Encapsulation means wrapping data and methods together in a class and controlling access to the data.",
                List.of("encapsulation", "data", "class")
        ));

        faqs.add(new FAQ(
                "What is abstraction?",
                "Abstraction means hiding implementation details and showing only the essential features.",
                List.of("abstraction", "abstract", "interface")
        ));

        // Programming FAQs
        faqs.add(new FAQ(
                "What is programming?",
                "Programming is the process of writing instructions that a computer can execute.",
                List.of("programming", "coding", "code")
        ));

        faqs.add(new FAQ(
                "What is an algorithm?",
                "An algorithm is a step-by-step procedure used to solve a problem.",
                List.of("algorithm", "steps", "problem")
        ));

        faqs.add(new FAQ(
                "What is a database?",
                "A database is an organized collection of data that can be stored, managed and retrieved efficiently.",
                List.of("database", "data", "storage")
        ));

        faqs.add(new FAQ(
                "What is SQL?",
                "SQL stands for Structured Query Language. It is used to manage and retrieve data from relational databases.",
                List.of("sql", "database", "query")
        ));

        faqs.add(new FAQ(
                "What is MySQL?",
                "MySQL is a popular relational database management system that uses SQL.",
                List.of("mysql", "database", "sql")
        ));

        faqs.add(new FAQ(
                "What is JDBC?",
                "JDBC stands for Java Database Connectivity. It allows Java applications to connect and interact with databases.",
                List.of("jdbc", "java", "database", "connection")
        ));

        // AI FAQs
        faqs.add(new FAQ(
                "What is Artificial Intelligence?",
                "Artificial Intelligence is the field of computer science that focuses on creating systems that can perform tasks requiring human-like intelligence.",
                List.of("artificial", "intelligence", "ai")
        ));

        faqs.add(new FAQ(
                "What is machine learning?",
                "Machine learning is a branch of AI where computers learn patterns from data and improve their performance.",
                List.of("machine", "learning", "ml", "ai")
        ));

        faqs.add(new FAQ(
                "What is NLP?",
                "NLP stands for Natural Language Processing. It helps computers understand and process human language.",
                List.of("nlp", "natural", "language", "processing")
        ));

        faqs.add(new FAQ(
                "What is a chatbot?",
                "A chatbot is a software application that communicates with users using text or voice.",
                List.of("chatbot", "bot", "communication")
        ));

        faqs.add(new FAQ(
                "How does a chatbot work?",
                "A chatbot receives user input, processes the text, identifies the user's intent and generates an appropriate response.",
                List.of("chatbot", "work", "input", "response")
        ));

        // General FAQs
        faqs.add(new FAQ(
                "Hello",
                "Hello! 👋 How can I help you today?",
                List.of("hello", "hi", "hey")
        ));

        faqs.add(new FAQ(
                "How are you?",
                "I am doing great! Thanks for asking. 😊",
                List.of("how", "are", "you")
        ));

        faqs.add(new FAQ(
                "What can you do?",
                "I can answer frequently asked questions about Java, programming, databases and basic AI concepts.",
                List.of("what", "can", "you", "do")
        ));

        faqs.add(new FAQ(
                "Who created you?",
                "I am a Java-based AI chatbot created as a learning project.",
                List.of("created", "creator", "made")
        ));

        faqs.add(new FAQ(
                "Thank you",
                "You're welcome! 😊",
                List.of("thank", "thanks")
        ));

        faqs.add(new FAQ(
                "Bye",
                "Goodbye! 👋 Have a great day!",
                List.of("bye", "goodbye", "exit")
        ));

        return faqs;
    }
}
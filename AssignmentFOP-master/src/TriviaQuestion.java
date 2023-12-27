import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TriviaQuestion {
    public JFrame frame;
    private JButton[] questionButtons;
    private JTextField answerField;
    private JButton submitButton;
    private JButton exitButton;
    private JTextArea questionArea;
    private JLabel resultLabel;
    private JPanel cards;
    private CardLayout cardLayout;
    private String[] questions;
    private String[] answers;
    private String[] correctAnswers; // New array for correct answers
    private int[] score;
    private int[] attempts;
    private int totalPoints;
    private int currentQuestion;
    private JList<String> optionsList;
    private JTextField answerText;
    private String email;
    private boolean[] answeredCorrectly;


    public TriviaQuestion(String email, Database db) {
        this.email = email;
        // frame
        frame = new JFrame("Trivia Question: ");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(800, 400);

        // Set up labels, buttons, and card layouts
        questionButtons = new JButton[10];
        answerField = new JTextField(); // Single Line text editor
        submitButton = new JButton("Submit Answer");
        exitButton = new JButton("Exit");
        questionArea = new JTextArea(); // Multiple line text editor
        resultLabel = new JLabel("");

        cards = new JPanel(new CardLayout());
        cardLayout = (CardLayout) cards.getLayout();
        questions = new String[10];
        answers = new String[10];
        correctAnswers = new String[10]; // Initialize the correctAnswers array
        attempts = new int[10];
        answeredCorrectly = new boolean[10];


        loadQuestionsFromFile("TriviaSample.txt"); // Specify the file name here

        // Create panels for different components
        JPanel questionPanel = new JPanel(new BorderLayout());
        questionPanel.add(new JLabel("Question:"), BorderLayout.NORTH);
        questionPanel.add(questionArea, BorderLayout.CENTER);

        JPanel optionsPanel = new JPanel(new BorderLayout());
        optionsList = new JList<>();
        optionsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        optionsList.setEnabled(true);
        optionsPanel.add(new JLabel("Options:"), BorderLayout.NORTH);
        optionsPanel.add(new JScrollPane(optionsList), BorderLayout.CENTER);

        JPanel answerPanel = new JPanel(new BorderLayout());
        answerText = new JTextField(); // Change to JTextField
        answerPanel.add(new JLabel("Your Answer:"), BorderLayout.NORTH);
        answerPanel.add(answerText, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(submitButton);
        buttonPanel.add(exitButton);

        JPanel resultPanel = new JPanel();
        resultPanel.add(resultLabel);

        JPanel answerPage = new JPanel(new BorderLayout());
        answerPage.add(questionPanel, BorderLayout.NORTH);
//        answerPage.add(optionsPanel, BorderLayout.WEST);
        answerPage.add(answerPanel, BorderLayout.CENTER);
        answerPage.add(resultPanel, BorderLayout.SOUTH);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(answerPage, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitAnswer(currentQuestion, answerText.getText(),db); // Use answerText.getText() instead of answerField.getText()
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.previous(cards); // Go to the previous card
                answerText.setText(""); // Clear the answer text field
                resultLabel.setText(""); // Reset the result label
            }
        });

        JPanel questionPanelMain = new JPanel();
        questionPanelMain.setLayout(new GridLayout(10, 1));
        LocalDate userRegistrationDate = db.getRegistrationDate(email);
        int dayCount = calculateDayCount(userRegistrationDate, LocalDate.now());
        for (int i = 0; i < 10; i++) {
            questionButtons[i] = new JButton("Question " + (i + 1));
            int finalI = i;
            if (i > dayCount) {
                questionButtons[i].setEnabled(false);
            }
            questionButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentQuestion = finalI;
                    displayQuestion(finalI);
                    cardLayout.next(cards);

                }
            });
            questionPanelMain.add(questionButtons[i]);

        }

        cards.add(questionPanelMain, "Question Page");
        cards.add(mainPanel, "Answer Page");

        frame.add(cards);
        frame.setVisible(true);
    }

    private void loadQuestionsFromFile(String fileName) {
        try (FileReader reader = new FileReader(fileName);
             BufferedReader br = new BufferedReader(reader)) {

            String line;
            int questionIndex = 0;

            while ((line = br.readLine()) != null && questionIndex < 10) {
                String question = line;
                String options = br.readLine();
                String answer = br.readLine();
                String blank = br.readLine();

                questions[questionIndex] = question;
                answers[questionIndex] = options; // Store the options in the answers array
                correctAnswers[questionIndex] = answer; // Store the correct answer in the correctAnswers array

                questionIndex++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> separateChoices(String option) {
        // Implement this method based on your option format
        // For simplicity, assuming the options are comma-separated
        String[] choicesArray = option.split(",");
        List<String> choices = new ArrayList<>();
        for (String choice : choicesArray) {
            choices.add(choice.trim());
        }
        return choices;
    }

    private void displayQuestion(int questionNumber) {
        List<String> choices = separateChoices(answers[questionNumber]);
        Collections.shuffle(choices); // Shuffle the options
        answers[questionNumber] = String.join(",", choices); // Update the answers with the shuffled options

        // Find the new position of the correct answer after shuffling
        int correctAnswerIndex = choices.indexOf(correctAnswers[questionNumber]);
        correctAnswers[questionNumber] = String.valueOf(correctAnswerIndex);

        questionArea.setText("Day " + (questionNumber + 1) + " Trivia (Attempt #" + (attempts[questionNumber] + 1) + ")\n" +
                "============================================================================\n" +
                questions[questionNumber] + "\n" +
                "============================================================================");
        char option = 'A';
        for (String choice : choices) {
            questionArea.append("\n[" + option + "] " + choice);
            option++;
        }
        questionArea.append("\n============================================================================\n" +
                "Enter your answer (A/B/C/D):");

        // Force the GUI to refresh and display the new text
        questionArea.repaint();
        questionArea.revalidate();
    }

    private void submitAnswer(int questionNumber, String userAnswer, Database db) {
        attempts[questionNumber]++;
        List<String> choices = separateChoices(answers[questionNumber]);
        int answerIndex = userAnswer.toUpperCase().charAt(0) - 'A';
        String selectedOption = choices.get(answerIndex); // Get the selected option based on user's input
        int correctAnswerIndex = Integer.parseInt(correctAnswers[questionNumber]); // Get the correct answer from the correctAnswers array

        int points =0;
        if (answerIndex == correctAnswerIndex) {
            if (!answeredCorrectly[questionNumber]) {  // Only update the score if the question hasn't been answered correctly yet
                points = (attempts[questionNumber] == 1) ? 2 : 1;
                db.updateScore(email, points);  // Update the score in the database
                answeredCorrectly[questionNumber] = true;  // Mark the question as answered correctly
            }
            int totalScore = db.getScore(email);  // Retrieve the updated score
            if(attempts[questionNumber] == 1){
                resultLabel.setText("Second Trial Correct! You answered it correctly. You have been awarded " + points + " points, you now have " + totalScore + " points.");}
        } else {
            if (attempts[questionNumber] == 2) {
                resultLabel.setText("Incorrect. The correct answer is: " + (char)('A' + correctAnswerIndex));
            }
            else if(attempts[questionNumber] > 2){
                resultLabel.setText("You can try again but you wont get any marks.");
            }

            else {
                resultLabel.setText("Incorrect. Try again.");
                // Update the answers with the shuffled options
            }
        }
        Collections.shuffle(choices);
        answers[questionNumber] = String.join(",", choices);

        // Find the new position of the correct answer after shuffling
        correctAnswerIndex = choices.indexOf(correctAnswers[questionNumber]);
        correctAnswers[questionNumber] = String.valueOf(correctAnswerIndex);

        // Display the next question with the shuffled options
        displayQuestion(questionNumber);
    }

    public static int calculateDayCount(LocalDate userRegistrationDate, LocalDate currentDate) {
        long days = ChronoUnit.DAYS.between(userRegistrationDate, currentDate) ;
        return (int) days;
    }
}



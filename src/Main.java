import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    // Declare GUI components
    private JLabel titleLabel;
    private JTextField inputField;
    private JButton countButton;
    private JButton resetButton; // New reset button
    private JLabel resultLabel;

    // Constructor for the main frame
    public Main() {
        setTitle("Word Count ");
        setSize(350,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set background colors
        Color lightGray = Color.decode("#F5F5F5");
        Color darkGreen = Color.decode("#4CAF50");

        // Initialize GUI components
        titleLabel = new JLabel("Enter a sentence:");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(Color.darkGray);

        inputField = new JTextField(20);
        inputField.setFont(new Font("Arial", Font.PLAIN, 14));

        countButton = new JButton("Count Words");
        countButton.setFont(new Font("Arial", Font.BOLD, 14));
        countButton.setBackground(darkGreen);
        countButton.setForeground(Color.white);
        countButton.addActionListener(this);

        resetButton = new JButton("Reset"); // Initialize reset button
        resetButton.setFont(new Font("Arial", Font.BOLD, 14));
        resetButton.setBackground(Color.red);
        resetButton.setForeground(Color.white);
        resetButton.addActionListener(this);

        resultLabel=new JLabel();
        resultLabel.setFont(new Font("Arial",Font.BOLD,16));
        resultLabel.setForeground(Color.blue);

        // Create main panel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10)); // Increased rows for additional components
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(lightGray);
        panel.add(titleLabel);
        panel.add(inputField);
        panel.add(countButton);
        panel.add(resetButton); // Add reset button to the panel

        // Panel to display the result
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout());
        resultPanel.setBackground(lightGray);
        resultPanel.add(resultLabel);

        // Add panels to the main frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(resultPanel, BorderLayout.SOUTH);

        setVisible(true); // Make the frame visible
    }

    // Action performed method to handle button clicks
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == countButton) {
            // When count button is clicked
            String sentence = inputField.getText();
            if (sentence.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a sentence!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int wordCount = countWords(sentence);
                resultLabel.setText("Word count: " + wordCount);
                inputField.setText(""); // Clear input field after counting
            }
        } else if (e.getSource() == resetButton) { // Handle reset button click
            resultLabel.setText(""); // Clear result label
            inputField.setText(""); // Clear input field
        }
    }

    // Method to count words in a sentence
    private int countWords(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return 0;
        }
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }

    // Main method to start the program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}

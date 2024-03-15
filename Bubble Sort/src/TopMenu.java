import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class TopMenu extends JFrame {
    public TopMenu() {
        super("Sorting Algorithm Visualiser");
        int[] array = {10,90,30,45,65,23,56};
        ArrayList<Integer> data = new ArrayList<>();
        for (int element : array) {
            data.add(element);
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel title = new JLabel("Sorting Algorithm Visualiser", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(Color.BLACK);

        JPanel menuContainer = new JPanel();
        String[] ALGORITHMS = {"Bubble Sort", "Selection Sort", "Placeholder"};

        JPanel inputContainer = new JPanel();

        JLabel inputMessage = new JLabel("Input the unsorted data, seperated by commas:");
        inputContainer.add(inputMessage);

        // Add input for array data
        JTextArea inputArea = new JTextArea(10, 18);
        inputArea.setLineWrap(true);
        inputContainer.add(inputArea);

        // Add combo Box
        JComboBox<String> algorithmSelection = new JComboBox<>(ALGORITHMS);
        menuContainer.add(algorithmSelection);

        // Add submit button
        JButton submit = new JButton("Submit");
        submit.addActionListener(e ->  {
            if (Objects.equals(algorithmSelection.getSelectedItem(), "Bubble Sort")) {
                dispose();
                new visualGUI(data, "Bubble Sort");
            } else if (Objects.equals(algorithmSelection.getSelectedItem(), "Selection Sort")) {
                dispose();
                new visualGUI(data, "Selection Sort");
            }

        });
        menuContainer.add(submit);

        setLayout(new BorderLayout());
        add(title, BorderLayout.NORTH);
        add(inputContainer, BorderLayout.CENTER);
        add(menuContainer, BorderLayout.SOUTH);

        // Set properties of main frame
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TopMenu();
    }
}

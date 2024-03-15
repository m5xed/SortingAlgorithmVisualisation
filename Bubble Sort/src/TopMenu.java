import javax.swing.*;
import java.awt.*;

public class TopMenu extends JFrame {
    private final int[] data = {10,20,60,30,20,70};
    public TopMenu() {
        super("Sorting Algorithm Visualiser");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel title = new JLabel("Sorting Algorithm Visualiser", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(Color.BLACK);


        JPanel menuContainer = new JPanel();
        String[] ALGORITHMS = {"Bubble Sort", "Placeholder", "Placeholder"};
        // Add combo Box
        JComboBox<String> algorithmSelection = new JComboBox<>(ALGORITHMS);
        menuContainer.add(algorithmSelection);

        // Add submit button
        JButton submit = new JButton("Submit");
        submit.addActionListener(e ->  {
            if (algorithmSelection.getSelectedItem() == "Bubble Sort") {
                dispose();
                new visualGUI(data);
            }

        });
        menuContainer.add(submit);

        setLayout(new BorderLayout());
        add(title, BorderLayout.NORTH);
        add(menuContainer, BorderLayout.CENTER);

        // Set properties of main frame
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TopMenu();
    }
}

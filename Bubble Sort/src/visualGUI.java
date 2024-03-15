/*
 * Filename - visualGUI.java
 * Date started - 14/03/2024
 * Date edited - 14/03/2024
 * Author - Max Field
 * Copyright - No copyright
 * Version 1.2:
 *             1.1 - Pure code written + Comments
 *             1.2 - Added labels to the bars
 *
 */
import javax.swing.*;
import java.awt.*;


/**
 * The {@link #visualGUI} class provides a visual representation of sorting items in an array, using Java swing
 * components.
 * It includes buttons for sorting and resetting.
 * <p>
 *     Example usage:
 *     <pre>
 *         // Create an array of unsorted integers
 *         int[] array = {10,90,40,20,67}
 *
 *         // Create the VisualGUI object using the array
 *         new visualGUI(array);
 *     </pre>
 * </p>
 *
 *
 * @see javax.swing.JFrame
 * @see javax.swing.JPanel
 * @see javax.swing.JButton
 * @see java.awt.Graphics
 * @see java.awt.event.ActionListener
 */
public class visualGUI extends JFrame {
    private JPanel visualContainer;
    private final int[] unsortedData;
    private int[] sortedData;


    // Constructor for the GUI, accepts the array of integers as an argument
    public visualGUI(int[] data) {
        super("Bubble Sort Visualisation");
        // Set closing action
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create clones of the data to allow resetting
        unsortedData = data.clone();
        sortedData = data.clone();

        // Create JPanel to contain the buttons
        JPanel buttonContainer = new JPanel();

        // "Sort" button will call the sorting algorithm when clicked, and repaint the new order
        JButton sortButton = new JButton("Sort");
        sortButton.addActionListener(e -> {
            this.sortedData = BubbleSort.BubbleSortAlgorithm(this.sortedData);
            visualContainer.repaint();
        });

        // "Reset" button will reset the GUI to the unsorted values
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            this.sortedData = unsortedData.clone();
            visualContainer.repaint();
        });

        // Add buttons to container
        buttonContainer.add(sortButton);
        buttonContainer.add(resetButton);

        // Create a JPanel to hold the visualisation of the sort
        visualContainer = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Calculate width of each bar, relative to the panel size and number of elements
                int width = getWidth() / sortedData.length;

                // Calculate the largest value in the array
                int maxHeight = 0;
                for (int element: sortedData) {
                    if (element > maxHeight) {
                        maxHeight = element;
                    }
                }

                // Calculate the factor to scale the height of each bar
                int rectHeightFactor = getHeight() / maxHeight;

                // Draw each bar
                for (int i = 0; i < sortedData.length; i++) {
                    // Coordinates of the bar
                    int x = i * width;
                    int y = getHeight() - sortedData[i] * rectHeightFactor;
                    // Height of the bar
                    int height = sortedData[i] * rectHeightFactor;

                    // Set bar properties (Fill and border colours)
                    g.setColor(Color.CYAN);
                    g.fillRect(x,y,width,height);
                    g.setColor(Color.BLACK);
                    g.drawRect(x,y,width,height);

                    // Draw labels
                    String rectLabel = String.valueOf(data[i]);
                    FontMetrics fontMetrics = g.getFontMetrics();
                    int labelWidth = fontMetrics.stringWidth(rectLabel);
                    int labelHeight = fontMetrics.getHeight();
                    int labelX = x + (width - labelWidth) / 2;
                    int labelY = y + (height - labelHeight) / 2;
                    g.setColor(Color.BLACK);
                    g.drawString(String.valueOf(sortedData[i]), labelX, labelY);
                }

            }
        };

        // Set layout of main frame
        setLayout(new BorderLayout());
        // Add the containers
        add(buttonContainer, BorderLayout.SOUTH);
        add(visualContainer, BorderLayout.CENTER);

        // Set properties of main frame
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args){
        // Test data, Change to any number of values.
        // Bubble sort will slow down with large quantities due to a time complexity of -> O(n^2)
        int[] unsorted = {10,70,30,40,22,60};
        // Initialise GUI
        new visualGUI(unsorted);
    }
}
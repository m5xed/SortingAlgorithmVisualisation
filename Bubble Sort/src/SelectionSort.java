/*
 * Filename - SelectionSort.java
 * Date started - 15/03/2024
 * Date edited - 15/03/2024
 * Author - Max Field
 * Copyright - No copyright
 * Version 1.0 (15/03):
 *             Pure code written
 * Version 1.1 (15/03):
 *             Comments added
 */
import java.util.ArrayList;

public class SelectionSort {
    public static ArrayList<Integer> SelectionSortAlgorithm(ArrayList<Integer> data) {
        // Init 2 empty ArrayLists
        ArrayList<Integer> sortedData = new ArrayList<>();
        // Iterate until all data is sorted
        while (!data.isEmpty()){
            int smallestIndex = 0;
            // Find the smallest value's index
            for(int i = 0; i < data.size(); i++) {
                if (data.get(i) < data.get(smallestIndex)) {
                    smallestIndex = i;
                }
            }
            // Remove element from the unsorted data, and add to sorted data
            sortedData.add(data.remove(smallestIndex));
        }
        return sortedData;
    }
}

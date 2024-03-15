/*
 * Filename - BubbleSort.java
 * Date started - 12/03/2024
 * Date edited - 14/03/2024
 * Author - Max Field
 * Copyright - No copyright
 * Version 1.0:
 *             Pure code written
 */
import java.util.ArrayList;
public class BubbleSort {
    public static ArrayList<Integer> BubbleSortAlgorithm(ArrayList<Integer> data) {
        boolean sorted = true;
        for(int i = 0; i < data.size() - 1; i++) {
            if(data.get(i) > data.get(i + 1)) {
                sorted = false;
                int dataBuffer = data.get(i);
                data.set(i, data.get(i + 1));
                data.set(i + 1, dataBuffer);
            }
        }
        if(sorted) {
            return data;
        } else {
            return BubbleSortAlgorithm(data);
        }
    }
}
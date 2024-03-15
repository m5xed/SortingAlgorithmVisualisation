/*
 * Filename - BubbleSort.java
 * Date started - 12/03/2024
 * Date edited - 14/03/2024
 * Author - Max Field
 * Copyright - No copyright
 * Version 1.0:
 *             Pure code written
 */

public class BubbleSort {
    public static int[] BubbleSortAlgorithm(int[] data) {
        boolean sorted = true;
        for(int i = 0; i < data.length - 1; i++) {
            if(data[i] > data[i+1]) {
                sorted = false;
                int dataBuffer = data[i];
                data[i] = data[i + 1];
                data[i + 1] = dataBuffer;
            }
        }
        if(sorted) {
            return data;
        } else {
            return BubbleSortAlgorithm(data);
        }
    }
}
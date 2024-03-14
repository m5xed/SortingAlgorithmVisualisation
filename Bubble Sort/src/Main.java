/*
 * Filename - Main.java
 * Date started - 12/03/2024
 * Date edited - 14/03/2024
 * Author - Max Field
 * Copyright - No copyright
 * Version 1.0:
 *             Pure code written
 */

import java.util.Arrays;

public class Main {
    int index = 0;
    public static int[] BubbleSort(int[] data) {
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
            return BubbleSort(data);
        }
    }

    public static void main(String[] args) {
        int[] data = {4,3,8,6,5,2,1,9,7,2,3,4,3,6,3,6,7};
        System.out.println(Arrays.toString(BubbleSort(data)));
    }
}
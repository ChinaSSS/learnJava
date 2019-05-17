package com.BasicLearn;

import java.util.Arrays;

public class ArraysUtils {
    public static void main(String[] args) {
        int[] list = {1,2,3,5,6,8,9};
        int index = Arrays.binarySearch(list,3);
        System.out.println(index);
        System.out.println(Arrays.toString(list));
        int[] list2 = Arrays.copyOf(list,4);
        System.out.println(Arrays.toString(list2));
        System.out.println(Arrays.equals(list,list2));
        Arrays.fill(list,3);
        System.out.println(Arrays.toString(list));
    }
}

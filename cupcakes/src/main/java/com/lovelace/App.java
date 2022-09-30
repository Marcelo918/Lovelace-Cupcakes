package com.lovelace;

import org.json.simple.*;

/**
 * Author: Marcelo Villalobos Diaz
 * Date: September 25-30, 2022
 * Class: CSIS26 -FA22
 * Description: write insertion sort and test the
 * json files provided by the professor. The purpose
 * is to sort all the cupcakes alphabetically.
 */
public class App {
    private static int count = 0;

    public static void main(String[] args) {
        String fileName = "/Users/CAD-DESIGNER/Documents/GitHub/Lovelace-Cupcakes/cupcakes/src/main/java/com/lovelace/cupcake_3906.json";

        // reads cupcake names
        JSONArray cupcakeArray = JSONFile.readArray(fileName);
        String[] cupcakeNameArray = nameArray(cupcakeArray);
        System.out.println(cupcakeNameArray);

        // prints unsorted list
        System.out.println("---- Unsorted Array ----");
        print(cupcakeNameArray);

        // sorts the list
        insertionSort(cupcakeNameArray);

        // prints sorted list
        System.out.println("---- Sorted Array ----");
        print(cupcakeNameArray);

        // prints statistics
        System.out.println("---- Statistics ----");
        System.out.printf("Size of array = %d\n", cupcakeNameArray.length);
        System.out.printf("Count = %d\n", count);
    }

    // prints cupcake array
    public static void print(String[] cupcakeNameArray) {
        System.out.printf("Number\tName\n");
        System.out.printf("------\t------------\n");
        for (int i = 0; i < cupcakeNameArray.length; i++) {
            System.out.printf("%04d\t%s\n", i, cupcakeNameArray[i]);
        }
    }

    // gets array of cupcake names
    public static String[] nameArray(JSONArray cupcakeArray) {
        String[] arr = new String[cupcakeArray.size()];

        // gets names from json object
        for (int i = 0; i < cupcakeArray.size(); i++) {
            JSONObject o = (JSONObject) cupcakeArray.get(i);
            String name = (String) o.get("name");
            arr[i] = name;
        }
        return arr;
    }

    // insertion sort array
    public static void insertionSort(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            String key = arr[i];
            int j = i - 1;

            while (j >= 0 && key.compareTo(arr[j]) < 0) {
                arr[j + 1] = arr[j];
                j--;
                count++;
            }
            arr[j + 1] = key;
        }
    }
}

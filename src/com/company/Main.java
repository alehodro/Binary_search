package com.company;

import java.util.Arrays;
import java.util.Scanner;

// Работает с аргументами командной строки или принимает аргументы в консоли
// тестирую гит

public class Main {

    public static void main(String[] args) {


        int size = 0;
        int[] int_array;

        if (args.length != 0) {

            size = args.length;
            int_array = new int[size];
            int i = 0;
            for (String arg : args) {
                int_array[i] = Integer.parseInt(arg);
                i += 1;

            }
            System.out.print("Raw int array ");
            System.out.println(Arrays.toString(int_array));

            // Чтобы проверить аргументы введенные в командную строку
        } else {

            System.out.println("No arguments have been refered in command line");
            String n;

            Scanner input = new Scanner(System.in);


            System.out.println("Please enter numbers in console");

            n = input.nextLine();

            //System.out.println(n);
            // Чтобы проверить что записалось в строке

            String[] string_array = n.split(" ");

            //  System.out.println(Arrays.toString(string_array));
            // Чтобы проверить, что записалось в строковый массив

            size = string_array.length;

            int_array = new int[size];
            for (int i = 0; i < size; i++) {
                int_array[i] = Integer.parseInt(string_array[i]);
            }

        }

        // System.out.println(Arrays.toString(int_array));
        // Чтобы проверить, что записалось в числовой массив

        int key_number = int_array[0];

        System.out.print("Key number ");

        System.out.println(key_number);
        // Чтобы проверить как записалось ключевое для поиска число


        int[] int_array_tosort = new int[size - 1];

        int newindexforarraytosort = size - 1;

        //  System.out.println(newindexforarraytosort);
        // Чтобы проверить корректность вычисления количества индексов для нового массива (должна быть на 1 ед меньше, чем количество вводимых чисел)

        int_array_tosort = Arrays.copyOfRange(int_array, 1, size);

        //System.out.println(Arrays.toString(int_array_tosort));
        // Чтобы проверить новый обрезанный массив


        Arrays.sort(int_array_tosort);

        System.out.print("Sorted int array ");

        System.out.println(Arrays.toString(int_array_tosort));
        // Чтобы проверить результат сортировки элементов в числовом массиве

        int left = 0;

        int right = int_array_tosort.length;


        int mid = 0;
        int mid_number = 0;
        int itterator = 1;
        int zerocounter = 0;
        int global_left = left;
        int global_right = right;

        // System.out.println(left);
        //   System.out.println(right);

        while (key_number != mid_number) {
            if (left > right) {
                //      System.out.println("left>right");
                break;
            }

            if (itterator > int_array_tosort.length) {
                //       System.out.println("itterator>=int_array_tosort. length");
                break;
            }
            if ((left == 0 & right == 0) & zerocounter > 1) {
                //     System.out.println("left==0&right==0");
                break;
            }

            mid = (right + left) / 2;

            mid_number = int_array_tosort[mid];

            if (mid_number < key_number) {
                left = mid;
            } else {
                right = mid;
            }
//System.out.println("index left "+left +" из длины "+global_right);
//            System.out.println("index right "+right);
            //           System.out.println("mid "+mid);
            //           System.out.println("itterator "+itterator);
            //           System.out.println("------------------- " );
            itterator += 1;
            if (left == 0 & right == 0) {
                zerocounter += 1;
            }


            if ((global_left == left) & (global_right == right)) {
                //         System.out.println("(global_left==left)&(global_right==right)");

                break;
            } else {
                global_left = left;
                global_right = right;

            }


        }


        if (key_number == mid_number) {
            System.out.println("index of key number" + " " + mid);


        } else {
            System.out.println("Key number is not found in the array");

        }

    }
}
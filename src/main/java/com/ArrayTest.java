package com;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        MyArray<String> myArrayTest = new MyArray<String>();
        myArrayTest.add("Me");
        myArrayTest.add("You");
        myArrayTest.add("They");

        System.out.println(myArrayTest);

        myArrayTest.trimSize();

        System.out.println(myArrayTest);

        myArrayTest.remove(1);

        System.out.println(myArrayTest);

        myArrayTest.printMinAndMax();


        System.out.println("------------------------------------------------------------");

        MyArray<Integer> myArray = new MyArray<Integer>();

        for (int i = 0; i < 25; i++) {
            myArray.add(i);
        }

        System.out.println(myArray);

        myArray.trimSize();

        System.out.println(myArray);

        myArray.remove(3);

        System.out.println(myArray);

        myArray.printMinAndMax();


        System.out.println("--------------------------------------------------------------");

        myArrayTest.arraysConcat(myArray);

        System.out.println(myArrayTest);

        myArrayTest.add("kristina");

        myArrayTest.add("Dima");

        System.out.println(myArrayTest);

//        myArray.arraysConcat(myArrayTest);
//
        myArrayTest.printMinAndMax();

        myArrayTest.sortArray();
//
//        System.out.println(myArray);

        System.out.println(myArray.binarySearch(3, 20, 13));


    }

}

package com;


import java.util.Arrays;

public class MyArray<Type> {
    public final static int CAPACITY = 10;
    private int currentPosition;
    public Type mas[];


    public MyArray() {
        mas = (Type[]) new Object[CAPACITY];
        currentPosition = 0;
    }

    public MyArray(Type[] mas) {
        this.mas = mas;
        currentPosition = mas.length;
    }


    public void add(Type newElement) {
        if (currentPosition >= mas.length) {
            mas = Arrays.copyOf(mas, mas.length + mas.length / CAPACITY + 3);

        }
        mas[currentPosition++] = newElement;
    }


    public void remove(int index) {
        int numberOfCopyElemetn = mas.length - index - 1;
        System.arraycopy(mas, index + 1, mas, index, numberOfCopyElemetn);
        currentPosition--;
        if (mas[currentPosition] instanceof Number) {
            mas[currentPosition] = (Type) "0";
        } else {
            mas[currentPosition] = null;
        }

    }


    public void printMinAndMax() {
        trimSize();
        Type min = mas[0];
        Type max = mas[0];
        int minIndex = 0;
        int maxIndex = 0;

        if (mas[0] instanceof Number) {
            for (int i = 1; i < currentPosition; i++) {

                if (Long.parseLong(String.valueOf(mas[i - 1])) > Long.parseLong((String.valueOf(mas[i])))) {
                    min = mas[i];
                    minIndex = i;
                }

                if (Long.parseLong(String.valueOf(mas[i - 1])) < Long.parseLong((String.valueOf(mas[i])))) {
                    max = mas[i];
                    maxIndex = i;
                }

            }
            System.out.println("Min = " + min + "\n" +
                    "Min index = " + minIndex + "\n" +
                    "Max = " + max + "\n" +
                    "Max index = " + maxIndex + "\n");
        } else System.out.println("It's not an array of numbers. \n");
    }


    public void sortArray() {
        trimSize();

        if (mas[0] instanceof Number) {
            for (int i = 1; i < currentPosition; i++) {
                Type permanent;
                if (Long.parseLong(String.valueOf(mas[i - 1])) > Long.parseLong((String.valueOf(mas[i])))) {
                    permanent = mas[i - 1];
                    mas[i - 1] = mas[i];
                    mas[i] = permanent;
                }
            }
        } else System.out.println("It's not an array of numbers. It can't be sorted. \n");
    }


    public void arraysConcat(MyArray newArray) {
        trimSize();
        newArray.trimSize();

        mas = Arrays.copyOf(mas, currentPosition + newArray.currentPosition);
        System.arraycopy(newArray.mas, 0, mas, currentPosition, newArray.currentPosition);
        currentPosition += newArray.currentPosition;


    }

    public Type binarySearch(int indexFrom, int indexTo, Type key) {
        sortArray();
        assert (mas[0] instanceof Number) : "It's not an array of numbers.";

        if(indexTo >= indexFrom || indexTo <= mas.length - 1){



        } else System.out.println("Wrong indexes");

    }


    public void trimSize() {
        mas = Arrays.copyOf(mas, currentPosition);
    }


    @Override
    public String toString() {
        return "currentPosition= " + currentPosition + "\n"
                + Arrays.toString(mas) + "\n";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyArray<?> myArray = (MyArray<?>) o;

        if (currentPosition != myArray.currentPosition) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(mas, myArray.mas);

    }


    @Override
    public int hashCode() {
        int result = currentPosition;
        result = 31 * result + (mas != null ? Arrays.hashCode(mas) : 0);
        return result;
    }
}

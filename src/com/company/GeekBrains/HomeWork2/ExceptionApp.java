package com.company.GeekBrains.HomeWork2;

public class ExceptionApp {

    public static class ArrayException {

        public static void main(String[] args) {
            String[][] Array = new String[4][4];
            for (int i = 0; i < Array.length; i++) {
                for (int j = 0; j < Array[i].length; j++) {
                    Array[i][j] = Integer.toString(10 + i + j);
                }
            }
            Array[2][1] = "2b";
            try {
                System.out.println(arrayException(Array));
            } catch (MyArraySizeException | MyArrayDataException e) {
                System.out.println(e.getMessage());
            }
        }

        public static int arrayException(String[][] Array) throws MyArraySizeException, MyArrayDataException {
            int sum = 0;
            if (Array.length != 4 || Array[0].length != 4) {
                throw new MyArraySizeException();
            } else {
                for (int i = 0; i < Array.length; i++) {
                    for (int j = 0; j < Array[i].length; j++) {
                        try {
                            sum += Integer.parseInt(Array[i][j]);
                        } catch (NumberFormatException e) {
                            throw new MyArrayDataException(i, j, sum);
                        }
                    }
                }
                return sum;
            }
        }

    }
}

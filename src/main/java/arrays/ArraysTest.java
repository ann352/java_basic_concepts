package arrays;

import java.util.Arrays;

public class ArraysTest

// in simple variable we can store one value, e.g of type int -> int variable1;
// to ARRAY variable we can assign an array that can store multiple numbers, e.g. int[] variable2;
// just as declaring a variable does not assign a value to it, declaring an array does not create a new array
// we have to declare the size of array by creating the array, later we can only change the data in it, not the size

{
    public static void main(String[] args) {

        // there are 2 ways of creating arrays
        //1:
        int[] numbers = new int[3];
        numbers[0] = 1;
        numbers[1] = 1;
        numbers[2] = 1;

        //2:
        int[] numbers2 = {6, 7, 8}; //in older versions of java ->   int[] numbers2 = new int[]{6, 7, 8};
        System.out.println(Arrays.toString(numbers2));

        //swap - it means changing value of cells in array
        //computer remember only values that are stored in variables, so we need additional, temporary variable

        Double[] doubleNumbers = {3.1, 2.1, 1.1};
        Double tmp = doubleNumbers[2]; //temporary variable
        doubleNumbers[2] = doubleNumbers[0]; // {3.1, 2.1, 3.1};
        doubleNumbers[0] = tmp; //{1.1, 2.1, 3.1}

        System.out.println(Arrays.toString(doubleNumbers));

        //we can also check lenght of given array
        System.out.println(doubleNumbers.length);

        //two-dimensional arrays
        //initialization
        int[][] array1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] array3 = new int[3][4]; //tree arrays with 4 zeros
        //When creating a two-dimensional array, we must specify at least the first dimension
        int[][] ints = new int[3][];

        int[] firstLine = array3[0];
        System.out.println("Pierwszy wiersz: " + Arrays.toString(firstLine));

        int[] secondLine = array3[1];
        System.out.println("Drugi wiersz: " + Arrays.toString(secondLine));

        int[] thirdLine = array3[2];
        System.out.println("Trzeci wiersz: " + Arrays.toString(thirdLine));

        //whole two-dimnesional array we can write by using method .deepToString()
        System.out.println(Arrays.deepToString(array3));
        System.out.println(Arrays.deepToString(ints));

        //irregular arrays, by creating we specify only first size,
        char[][] irregularArray = new char[5][];
        irregularArray[0]=new char[]{'A','B','C'};
        irregularArray[1]=new char[]{'D','E','F','G','H'};
        System.out.println(Arrays.deepToString(irregularArray));
        //single row
        System.out.println(Arrays.toString(irregularArray[0]));


    }
}

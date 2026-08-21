package org.example;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;


/**
 * Provides utility methods for reading, displaying, and manipulating
 * integer arrays.
 *
 * <p>The {@code read()} method reads the array size and elements from
 * standard input and returns the populated array.</p>
 *
 * @author Dinesh Bhagwat
 * @version 1.0
 */
public final class ArrayUtils {
    private final Scanner scanner;

    /**
     * Creates an {@code ArrayUtils} instance using the specified scanner.
     *
     * @param scanner the scanner used to read input
     */
    public ArrayUtils(Scanner scanner) {
        this.scanner = Objects.requireNonNull(scanner, "scanner must not be null");
    }

    /**
     * Reads an integer array from standard input.
     *
     * <p>The user is prompted to enter the number of elements followed by
     * the integer elements of the array. Each input value is validated
     * before it is stored in the array.</p>
     *
     * <p>If the array size is not a valid integer, is less than or equal
     * to zero, or if any array element is not a valid integer, the method
     * displays an appropriate error message and returns {@code null}.</p>
     *
     * @return the populated integer array, or {@code null} if the input
     *         is invalid or the specified array size is less than or equal
     *         to zero
     */
    public int[] read() {
        System.out.print("Enter the number of elements in an array: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Array size should be a valid number.");
            return null;
        }
        final int numberOfElements = scanner.nextInt();

        if (numberOfElements <= 0) {
            System.out.println("Array should contain at least one element.");
            return null;
        }
        int[] data = new int[numberOfElements];
        System.out.print("Enter the elements (each separated by a blank/tab/new-line): ");

        for (int i = 0; i < data.length; i++) {

            if (!scanner.hasNextInt()) {
                System.out.println("Array element should be an integer.");
                return null;
            }
            data[i] = scanner.nextInt();
        }
        System.out.println();
        return data;
    }


    /**
     * Prints the given integer array to standard output.
     *
     * @param data the integer array to print; must not be {@code null}
     * @throws NullPointerException if {@code data} is {@code null}
     */
    public static void print(int[] data) {
        Objects.requireNonNull(data, "data must not be null");
        System.out.println(Arrays.toString(data));
    }

    /**
     * Swaps two elements in the specified integer array.
     *
     * @param data the array containing the elements to swap
     * @param i    index of the first element
     * @param j    index of the second element
     */
    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /**
     * Reverses the specified integer array in-place using the two-pointer technique.
     *
     * <p>Time Complexity: O(n)</p>
     * <p>Space Complexity: O(1)</p>
     *
     * @param data the array to reverse; must not be {@code null}
     * @throws NullPointerException if {@code data} is {@code null}
     */
    public static void reverse(int[] data) {
        Objects.requireNonNull(data, "data must not be null");

        int left = 0;
        int right = data.length - 1;

        while (left < right) {
            swap(data, left, right);
            left++;
            right--;
        }
    }
}

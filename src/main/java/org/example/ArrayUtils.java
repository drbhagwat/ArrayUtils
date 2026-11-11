package org.example;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

/**
 * Utility class for reading, displaying, and manipulating integer arrays.
 */
public final class ArrayUtils {
  private final Scanner scanner;
  private static final int MAX_ARRAY_SIZE = 1_000_000;

  /**
   * Creates an {@code ArrayUtils} instance using the specified scanner.
   *
   * @param scanner the scanner used to read input
   */
  public ArrayUtils(Scanner scanner) {
    this.scanner = Objects.requireNonNull(scanner, "scanner must not be null");
  }

  /**
   * Reads an integer from the user input.
   *
   * @param prompt - the prompt to display to the user
   * @return the integer entered by the user
   */
  private int readInteger(String prompt) {
    System.out.print(prompt);

    while (true) {

      if (!scanner.hasNext()) {
        throw new NoSuchElementException(
            "Input ended unexpectedly."
        );
      }

      if (scanner.hasNextInt()) {
        return scanner.nextInt();
      }
      System.out.println("Please enter a valid integer.");
      scanner.next();
      System.out.print(prompt);
    }
  }

  /**
   * Reads an integer array from the user input.
   *
   * @return the integer array entered by the user
   */
  public int[] read() {
    int numberOfElements;

    while (true) {
      numberOfElements = readInteger(
          "Enter the number of elements: "
      );

      if (numberOfElements > 0 &&
          numberOfElements <= MAX_ARRAY_SIZE) {
        break;
      }

      System.out.println(
          "Array size must be between 1 and "
              + MAX_ARRAY_SIZE + "."
      );
    }

    int[] data = new int[numberOfElements];

    for (int i = 0; i < data.length; i++) {

      data[i] = readInteger(
          "Enter element " + (i + 1) + ": "
      );
    }
    System.out.println("Array successfully populated.");
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
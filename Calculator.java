import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Calculator {

  public static Scanner input = new Scanner(System.in);

  public static void exit() {
    System.exit(0);
  }

  public static int fibonacci(int number) {
    if (number <= 1) {
      return number;
    }
    return fibonacci(number - 1) + fibonacci(number - 2);
  }

  public static boolean esPrimo(int numero) {
    int contador = 2;
    boolean primo = true;
    while ((primo) && (contador != numero)) {
      if (numero % contador == 0)
        primo = false;
      contador++;
    }
    return primo;
  }

  public static void main(String[] args) {
    int option;
    do {
      System.out.print("\tOperation menu\t\n");
      System.out.print(
          "\n   1. Basics operations\n   2. Conversions\n   3. Matrix Operations\n   4. Other Operations\n   5. Exit");
      System.out.print("\nGive me an option: ");
      option = input.nextInt();

      switch (option) {
        case 1:
          System.out.println(
              "\tBasics operations menu\n   1. Add\n   2. Substraction\n   3. Multiplication\n   4. Decimal division\n   5. Division with integer and remainder\n   6. Power\n   7. Cancel");
          System.out.print("\nGive me an option: ");
          option = input.nextInt();
          basicsOperations(option);
          break;
        case 2:
          System.out.println(
              "\tConversions menu\n   1. Decimal to Binary\n   2. Decimal to Hexadecimal\n   3. Binary to Decimal\n   4. Binary to Hexadecimal\n   5. Hexadecimal to Decimal\n   6. Hexadecimal to Binary\n   7. Cancel");
          System.out.print("\nGive me an option: ");
          option = input.nextInt();
          conversions(option);
          break;
        case 3:
          System.out.println(
              "\tMatrix Operations menu\n   1. Add of 2 matrix\n   2. Substraction of 2 matrix\n   3. Transpose matrix of any size\n   4. Multiplication od 2 matrix\n   5. Cancel");
          System.out.print("\nGive me an option: ");
          option = input.nextInt();
          matrixOperations(option);
          break;
        case 4:
          System.out.println(
              "\tOther Operations menu\n   1. Order N prime numbers\n   2. Order N numbers with Fibonacci sequence\n   3. Age of a person\n   4. Obtain the IVA in a product\n   5. Cancel");
          System.out.print("\nGive me an option: ");
          option = input.nextInt();
          otherOperations(option);
          break;
        case 5:
          exit();
          break;
        default:
          System.out.println("Invalid option\n");
          break;
      }
      System.out.print("Do you want other operation? (1. Yes / 2. No): ");
      if (input.nextInt() == 2) {
        exit();
      }
    } while (option != 5);
    input.close();
  }

  public static void basicsOperations(int option) {
    int data, power;
    float result = 0, number, divisor, dividend;

    switch (option) {
      case 1:
        // Add
        System.out.print("How many numbers: ");
        data = input.nextInt();
        for (int i = 0; i < data; i++) {
          System.out.print("Number " + (i + 1) + ": ");
          number = input.nextInt();
          result += number;
        }
        System.out.println("Result: " + result);
        break;
      case 2:
        // Substraction
        System.out.print("How many numbers: ");
        data = input.nextInt();
        System.out.print("Number 1: ");
        result = input.nextInt();
        for (int i = 1; i < data; i++) {
          System.out.print("Number " + (i + 1) + ": ");
          number = input.nextInt();
          result -= number;
        }
        System.out.println("Result: " + result);
        break;
      case 3:
        // Multiplication
        System.out.print("How many numbers: ");
        data = input.nextInt();
        System.out.print("Number " + 1 + ": ");
        number = input.nextInt();
        result = number;
        for (int i = 1; i < data; i++) {
          System.out.print("Number " + (i + 1) + ": ");
          number = input.nextInt();
          result = result * number;
        }
        System.out.println("Result: " + result);
        break;
      case 4:
        // Decimal division
        System.out.print("Dividend: ");
        dividend = input.nextInt();
        System.out.print("Divisor: ");
        divisor = input.nextInt();
        result = dividend / divisor;
        System.out.println("Result: " + result);
        break;
      case 5:
        // Division with integer and remainder
        System.out.print("Dividend: ");
        dividend = input.nextInt();
        System.out.print("Divisor: ");
        divisor = input.nextInt();
        System.out.print("Result: " + (int) (dividend / divisor) + "\nResidue: " + (dividend % divisor));
        break;
      case 6:
        // Power
        System.out.print("Number: ");
        number = input.nextInt();
        System.out.println("Power: ");
        power = input.nextInt();
        System.out.println("Result: " + Math.pow(number, power));
        break;
      case 7:
        // return
        break;
    }
  }

  public static void conversions(int option) {
    int number, temp;
    String hexadecimalNumber, binaryNumber;
    switch (option) {
      case 1:
        // Decimal to binary
        System.out.print("Decimal: ");
        number = input.nextInt();
        System.out.println("Binary: " + Integer.toBinaryString(number));
        break;
      case 2:
        // Decimal to hexadecimal
        System.out.print("Decimal: ");
        number = input.nextInt();
        System.out.println("Hexadecimal: " + Integer.toHexString(number).toUpperCase());
        break;
      case 3:
        // Binary to decimal
        System.out.print("Binary: ");
        binaryNumber = input.next();
        BigInteger binary = new BigInteger(binaryNumber, 2);
        BigDecimal decimal = new BigDecimal(binary);
        System.out.println("Decimal: " + decimal);
        break;
      case 4:
        // binary to hexadecimal
        System.out.print("Binary: ");
        binaryNumber = input.next();
        try {
          binary = new BigInteger(binaryNumber, 2);
        } catch (Exception e) {
          System.out.println("Invalid binary number");
          conversions(4);

          break;
        }

        System.out.println("Hexadecimal: " + binary.toString(16).toUpperCase());

        break;
      case 5:
        // hexadecimal to decimal
        System.out.print("Hexadecimal: ");
        hexadecimalNumber = input.nextLine();
        System.out.println("Decimal: " + Integer.parseInt(String.valueOf(hexadecimalNumber), 16));
        break;
      case 6:
        // hexadecimal to binary
        System.out.print("Hexadecimal: ");
        hexadecimalNumber = input.next();
        temp = Integer.parseInt(String.valueOf(hexadecimalNumber), 16);
        System.out.println("Hexadecimal: " + Integer.toBinaryString(temp));
        break;
      case 7:
        // return
        break;
    }
  }

  public static void matrixOperations(int option) {
    int rows, cols;

    switch (option) {
      case 1:
        // Add of 2 matrix
        System.out.print("Rows: ");
        rows = input.nextInt();
        System.out.print("Cols: ");
        cols = input.nextInt();
        Matrix matrixOne = new Matrix(rows, cols);
        Matrix matrixTwo = new Matrix(rows, cols);
        System.out.println("Matrix 1");
        matrixOne.fill();
        System.out.println("Matrix 2");
        matrixTwo.fill();
        System.out.println(matrixOne.add(matrixTwo));
        break;

      case 2:
        // Substraction of 2 matrix
        System.out.print("Enter rows: ");
        rows = input.nextInt();
        System.out.print("Enter cols: ");
        cols = input.nextInt();
        matrixOne = new Matrix(rows, cols);
        matrixTwo = new Matrix(rows, cols);
        System.out.println("Matrix 1");
        matrixOne.fill();
        System.out.println("Matrix 2");
        matrixTwo.fill();
        System.out.println(matrixOne.subtract(matrixTwo));
        break;

      case 3:
        // Transpose matrix of any size
        System.out.print("Enter rows: ");
        rows = input.nextInt();
        System.out.print("Enter cols: ");
        cols = input.nextInt();
        matrixOne = new Matrix(rows, cols);
        System.out.println("Matrix 1");
        matrixOne.fill();
        System.out.println(matrixOne.transpose());
        break;

      case 4:
        // Multiplication od 2 matrix
        System.out.println("Matrix");
        System.out.print("Enter rows: ");
        rows = input.nextInt();
        System.out.print("Enter cols: ");
        cols = input.nextInt();
        matrixOne = new Matrix(rows, cols);
        matrixOne.fill();
        System.out.println("Matrix 2");
        System.out.print("Enter rows: ");
        rows = input.nextInt();
        System.out.print("Enter cols: ");
        cols = input.nextInt();
        matrixTwo = new Matrix(rows, cols);
        matrixTwo.fill();
        System.out.println(matrixOne.multiply(matrixTwo));
        break;

      case 5:
        // return
        break;

    }
  }

  public static void otherOperations(int option) {
    int number;
    switch (option) {
      case 1:
        // Order N prime numbers
        System.out.print("N numberes of primes: ");
        number = input.nextInt();
        int count = 0;
        int i = 1;
        while (count < number) {
          if (Calculator.esPrimo(i)) {
            System.out.println(i);
            count++;
          }
          i++;
        }
        break;
      case 2:
        // Order N numbers with Fibonacci sequence
        System.out.print("Number: ");
        number = input.nextInt();
        System.out.println(Calculator.fibonacci(number));

        break;
      case 3:
        // Age of a person
        System.out.print("Birthday (dd/mm/yyyy): ");
        String birthdayDate = input.next();
        System.out.print("Last date (dd/mm/yyyy): ");
        String lastDate = input.next();
        DateTimeFormatter formattert = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthday = LocalDate.parse(birthdayDate, formattert);
        LocalDate last = LocalDate.parse(lastDate, formattert);

        Period time = Period.between(birthday, last);
        System.out.printf("Tu edad es: %s años, %s meses y %s días", time.getYears(), time.getMonths(), time.getDays(),
            "\n");
        break;
      case 4:
        // Obtain the IVA in a product
        System.out.print("Product price: ");
        number = input.nextInt();
        System.out.println("IVA: " + (float) (number * 0.137931035));
        break;
      case 5:
        // return
        break;
    }
  }
}

class Matrix {
  public static Scanner input = new Scanner(System.in);

  private int rows;
  private int cols;
  private int[][] matrix;

  public Matrix(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    this.matrix = new int[rows][cols];
  }

  public void setElement(int row, int col, int value) {
    this.matrix[row][col] = value;
  }

  public int getElement(int row, int col) {
    return this.matrix[row][col];
  }

  public void setRow(int row, int[] values) {
    this.matrix[row] = values;
  }

  public String toString() {
    String result = "";
    for (int[] row : this.matrix) {
      for (int col : row) {
        result += col + " ";
      }
      result += "\n";
    }
    return result;
  }

  public void fill() {
    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < this.cols; j++) {
        System.out.print("Enter value for row " + i + " and col " + j + ": ");
        int value = input.nextInt();
        this.matrix[i][j] = value;
      }
    }
  }

  public Matrix transpose() {
    Matrix transposedMatrix = new Matrix(this.cols, this.rows);
    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < this.cols; j++) {
        transposedMatrix.setElement(j, i, this.matrix[i][j]);
      }
    }
    return transposedMatrix;
  }

  public Matrix add(Matrix matrix) {
    Matrix result = new Matrix(this.rows, this.cols);
    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < this.cols; j++) {
        result.setElement(i, j, this.matrix[i][j] + matrix.getElement(i, j));
      }
    }
    return result;
  }

  public Matrix multiply(Matrix matrix) {
    Matrix result = new Matrix(this.rows, matrix.cols);
    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < matrix.cols; j++) {
        int sum = 0;
        for (int k = 0; k < this.cols; k++) {
          sum += this.matrix[i][k] * matrix.getElement(k, j);
        }
        result.setElement(i, j, sum);
      }
    }
    return result;
  }

  public Matrix subtract(Matrix matrix) {
    Matrix result = new Matrix(this.rows, this.cols);
    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < this.cols; j++) {
        result.setElement(i, j, this.getElement(i, j) - matrix.getElement(i, j));
      }
    }
    return result;
  }

}

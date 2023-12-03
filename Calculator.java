import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Calculator {

  public static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    int option;
    do {
      System.out.print("\tOperation menu\t\n");
      System.out.print(
          "\n   1. Basics operations\n   2. Conversions\n   3. Matrix Operations\n   4. Other Operations\n   5. Exit");
      System.out.print("\nGive me an option: ");
      try {
        option = input.nextInt();
      } catch (Exception e) {
        System.out.println("Invalid option\n");
        main(args);
        break;
      }

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
          methods.exit();
          break;
        default:
          System.out.println("Invalid option\n");
          break;
      }
      try {
        if (option < 1 || option > 5) {
          System.out.println("Invalid option\n");
          main(args);
          break;
        }
      } catch (Exception e) {
        main(args);
        break;
      }
      System.out.print("\nDo you want other operation? (1. Yes / Press other key for exit): ");
      try {
        option = input.nextInt();
        if (option == 1) {
        } else {
          System.out.println("Invalid option\n");
        }
      } catch (Exception e) {
        methods.exit();
        break;
      }

    } while (option != 5);
  }

  public static void basicsOperations(int option) {
    Integer data, power;
    float result = 0, number, divisor, dividend;

    switch (option) {
      case 1:
        // Add
        System.out.print("How many numbers: ");
        try {
          data = Integer.parseInt(input.next());
        } catch (Exception e) {
          System.out.println("Ensure that you enter a number.");
          basicsOperations(1);
          break;
        }
        if (data < 2) {
          System.out.println("The number must be greater than 1.");
          basicsOperations(1);
          break;
        }
        try {
          for (int i = 0; i < data; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            number = input.nextInt();
            result += number;
          }
        } catch (Exception e) {
          System.out.println("Ensure that you enter a number.");
          basicsOperations(1);
          break;
        }
        System.out.println("Result: " + result);
        break;
      case 2:
        // Substraction
        System.out.print("How many numbers: ");
        try {
          data = Integer.parseInt(input.next());
        } catch (Exception e) {
          System.out.println("Ensure that you enter a number.");
          basicsOperations(2);
          break;
        }
        if (data < 2) {
          System.out.println("The number must be greater than 1.");
          basicsOperations(2);
          break;
        }
        System.out.print("Number 1: ");
        try {
          result = input.nextInt();
          for (int i = 1; i < data; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            number = input.nextInt();
            result -= number;
          }
        } catch (Exception e) {
          System.out.println("Ensure that you enter a number.");
          basicsOperations(2);
          break;
        }
        System.out.println("Result: " + result);
        break;
      case 3:
        // Multiplication
        result = 1;
        System.out.print("How many numbers: ");
        try {
          data = Integer.parseInt(input.next());
          if (data < 2) {
            System.out.println("The number must be greater than 1.");
            basicsOperations(3);
            break;
          }
        } catch (Exception e) {
          System.out.println("Ensure that you enter a number.");
          basicsOperations(3);
          break;
        }
        try {
          for (int i = 1; i <= data; i++) {
            System.out.print("Number " + i + ": ");
            number = input.nextInt();
            result = result * number;
          }
        } catch (Exception e) {
          System.out.println("Ensure that you enter a number.");
          basicsOperations(3);
          break;
        }
        System.out.println("Result: " + result);
        break;
      case 4:
        // Decimal division
        try {
          System.out.print("Dividend: ");
          dividend = input.nextInt();
          System.out.print("Divisor: ");
          divisor = input.nextInt();
          result = dividend / divisor;
        } catch (Exception e) {
          System.out.println("Ensure that you enter a number.");
          basicsOperations(4);
          break;
        }
        System.out.println("Result: " + result);
        break;
      case 5:
        // Division with integer and remainder
        try {
          System.out.print("Dividend: ");
          dividend = input.nextInt();
          System.out.print("Divisor: ");
          divisor = input.nextInt();
          result = dividend / divisor;
        } catch (Exception e) {
          System.out.println("Ensure that you enter a number.");
          basicsOperations(5);
          break;
        }
        System.out.println("Result: " + (int) (result) + "\nResidue: " + (dividend % divisor));
        break;
      case 6:
        // Power
        try {
          System.out.print("Number: ");
          number = input.nextInt();
          System.out.print("Power: ");
          power = input.nextInt();
        } catch (Exception e) {
          System.out.println("Ensure that you enter a number.");
          basicsOperations(6);
          break;
        }
        System.out.println("Result: " + Math.pow(number, power));
        break;
      case 7:
        // return
        break;
    }

  }

  public static void conversions(int option) {
    String hexadecimalNumber, binaryNumber;
    String numberStr;
    BigInteger binary;
    switch (option) {
      case 1:
        // Decimal to binary
        System.out.print("Decimal: ");
        numberStr = input.next();
        if (!numberStr.matches("[0-9]+")) {
          System.out.println("Ensure that you enter a number from 0-9.");
          conversions(1);
          break;
        }
        BigInteger bigDecimal = new BigInteger(numberStr, 10);
        System.out.println("Binary: " + bigDecimal.toString(2));
        break;
      case 2:
        // Decimal to hexadecimal
        System.out.print("Decimal: ");
        numberStr = input.next();
        if (!numberStr.matches("[0-9]+")) {
          System.out.println("Ensure that you enter a number from 0-9.");
          conversions(1);
          break;
        }
        bigDecimal = new BigInteger(numberStr, 10);
        System.out.println("Hexadecimal: " + bigDecimal.toString(16).toUpperCase());
        break;
      case 3:
        // Binary to decimal
        System.out.print("Binary: ");
        binaryNumber = input.next();
        try {
          binary = new BigInteger(binaryNumber, 2);
        } catch (Exception e) {
          System.out.println("Remember that the binary numbers are 0 and 1");
          conversions(4);
          break;
        }
        System.out.println("Decimal: " + binary.toString(10));
        break;
      case 4:
        // binary to hexadecimal
        System.out.print("Binary: ");
        binaryNumber = input.next();
        try {
          binary = new BigInteger(binaryNumber, 2);
        } catch (Exception e) {
          System.out.println("Remember that the binary numbers are 0 and 1");
          conversions(4);
          break;
        }
        System.out.println("Hexadecimal: " + binary.toString(16).toUpperCase());
        break;
      case 5:
        // hexadecimal to decimal
        System.out.print("Hexadecimal: ");
        try {
          hexadecimalNumber = input.next();
          if (!validationes.validHexadecimal(hexadecimalNumber)) {
            System.out.println("Remember that the hexadecimal numbers are 0-9 and A-F");
            conversions(5);
            break;
          }
        } catch (Exception e) {
          System.out.println("Remember that the hexadecimal numbers are 0-9 and A-F");
          conversions(5);
          break;
        }
        BigInteger hexadecimal = new BigInteger(hexadecimalNumber, 16);
        System.out.println("Decimal: " + hexadecimal.toString(10));
        break;
      case 6:
        // hexadecimal to binary
        System.out.print("Hexadecimal: ");
        try {
          hexadecimalNumber = input.next();
          if (!validationes.validHexadecimal(hexadecimalNumber)) {
            System.out.println("Remember that the hexadecimal numbers are 0-9 and A-F");
            conversions(5);
            break;
          }
        } catch (Exception e) {
          System.out.println("Remember that the hexadecimal numbers are 0-9 and A-F");
          conversions(5);
          break;
        }
        hexadecimal = new BigInteger(hexadecimalNumber, 16);
        System.out.println("Binary: " + hexadecimal.toString(2));
        break;
      case 7:
        // return
        break;
    }
  }

  public static void matrixOperations(int option) {
    int rows = 0;
    int cols = 0;
    Matrix matrixOne;
    Matrix matrixTwo;

    switch (option) {
      case 1:
        // Add of 2 matrix
        try {
          System.out.print("Rows: ");
          rows = input.nextInt();
          System.out.print("Cols: ");
          cols = input.nextInt();
          matrixOne = new Matrix(rows, cols);
          matrixTwo = new Matrix(rows, cols);
          System.out.println("Matrix 1");
          matrixOne.fill();
          System.out.println("Matrix 2");
          matrixTwo.fill();
        } catch (Exception e) {
          System.out.println("Ensure that you enter a number.");
          matrixOperations(1);
          break;
        }
        System.out.println(matrixOne.add(matrixTwo));
        break;

      case 2:
        // Substraction of 2 matrix
        try {
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
          if (rows < 2 || cols < 2) {
            System.out.println("Ensure that you enter a number greater than 1.");
            matrixOperations(2);
            break;
          }

        } catch (Exception e) {
          System.out.println("Ensure that you enter a number.");
          matrixOperations(2);
          break;
        }
        System.out.println(matrixOne.subtract(matrixTwo));
        break;

      case 3:
        // Transpose matrix of any size
        try {
          System.out.print("Enter rows: ");
          rows = input.nextInt();
          System.out.print("Enter cols: ");
          cols = input.nextInt();
          matrixOne = new Matrix(rows, cols);
          System.out.println("Matrix 1");
          matrixOne.fill();
          if (rows < 2 || cols < 2) {
            System.out.println("Ensure that you enter a number greater than 1.");
            matrixOperations(3);
            break;
          }
        } catch (Exception e) {
          System.out.println("Ensure that you enter a number.");
          matrixOperations(3);
          break;
        }
        System.out.println(matrixOne.transpose());
        break;

      case 4:
        // Multiplication of 2 matrix
        System.out.println("Matrix 1");
        try {
          System.out.print("Enter rows: ");
          rows = input.nextInt();
          System.out.print("Enter cols: ");
          cols = input.nextInt();
          if (rows < 2 || cols < 2) {
            System.out.println("Invalid rows or cols");
            matrixOperations(4);
            break;
          }
        } catch (Exception e) {
          System.out.println("Ensure that you enter a number.");
          matrixOperations(4);
          break;
        }

        matrixOne = new Matrix(rows, cols);
        matrixOne.fill();
        try {
          System.out.println("Matrix 2");
          rows = cols;
          System.out.print("Enter cols: ");
          cols = input.nextInt();
        } catch (Exception e) {
          System.out.println("Ensure that you enter a number.");
          matrixOperations(4);
          break;
        }
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
        int count = 0;
        int i = 1;
        try {
          System.out.print("N numberes of primes: ");
          number = input.nextInt();
          System.out.println("Wait a moment...");
          System.out.println("Primes:");

          while (count < number) {
            if (methods.esPrime(i)) {
              System.out.println(i);
              count++;
            }
            i++;
          }
        } catch (Exception e) {
          System.out.println("Ensure that you enter a number greater or equal than 1.");
          // return to option 1 from otherOperations
          otherOperations(1);
        }
        break;
      case 2:
        // Order N numbers with Fibonacci sequence
        System.out.print("Number: ");
        try {
          number = input.nextInt();
          for (int j = 2; j < number + 2; j++) {
            System.out.println(methods.fibonacci(j));
          }
        } catch (Exception e) {
          System.out.println("Ensure that you enter a number greater or equal than 1.");
          otherOperations(2);
          break;
        }
        break;
      case 3:
        // Age of a person
        Period time;
        String birthdayDate;
        LocalDate birthday;
        LocalDate last;

        System.out.print("Birthday (dd/mm/yyyy): ");
        try {
          birthdayDate = input.next();
          DateTimeFormatter formattert = DateTimeFormatter.ofPattern("dd/MM/yyyy");
          birthday = LocalDate.parse(birthdayDate, formattert);
          String checkDate = birthday.format(formattert);
          if (!birthdayDate.equals(checkDate)) {
            System.out.println("Invalid date, last date is February 28");
            otherOperations(3);
          }
        } catch (DateTimeParseException e) {
          System.out.println("Invalid date");
          otherOperations(3);
          break;
        }

        try {
          System.out.print("Last date (dd/mm/yyyy): ");
          String lastDate = input.next();
          DateTimeFormatter formattert = DateTimeFormatter.ofPattern("dd/MM/yyyy");
          last = LocalDate.parse(lastDate, formattert);
          String checkDate = last.format(formattert);
          if (!lastDate.equals(checkDate)) {
            System.out.println("Invalid date, last date is February 28");
            otherOperations(3);
          }

        } catch (Exception e) {
          System.out.println("Invalid date");
          otherOperations(3);
          break;
        }

        try {
          time = Period.between(birthday, last);
          if (birthday.isAfter(last)) {
            System.out.println("Invalid date, birthday is after last date)");
            otherOperations(3);
            break;
          }
        } catch (Exception e) {
          System.out.println("Invalid date");
          otherOperations(3);
          break;
        }
        System.out.printf("Tu edad es: %s años, %s meses y %s días", time.getYears(), time.getMonths(), time.getDays(),
            "\n");
        break;
      case 4:
        // Obtain the IVA in a product
        System.out.print("Product price: ");
        try {
          number = input.nextInt();
          if (number < 0) {
            System.out.println("Invalid price");
            otherOperations(4);
            break;
          }
        } catch (Exception e) {
          System.out.println("Ensure that you enter a number.");
          otherOperations(4);
          break;
        }
        System.out.println("Price: " + (number - (float) (number * 0.137931035)));
        System.out.println("IVA: " + (float) (number * 0.137931035));
        break;
      case 5:
        // return
        break;
    }
  }
}

class methods {
  public static Scanner input = new Scanner(System.in);

  public static void exit() {
    System.exit(0);
  }

  public static int fibonacci(int number) {
    if (number <= 1) {
      return number;
    }
    return fibonacci(number
        - 1) + fibonacci(number - 2);
  }

  public static boolean esPrime(int numero) {
    int counter = 2;
    boolean prime = true;
    while ((prime) && (counter != numero)) {
      if (numero % counter == 0)
        prime = false;
      counter++;
    }
    return prime;
  }

}

class validationes {
  public static boolean validHexadecimal(String hexadecimal) {
    Pattern pattern = Pattern.compile("[0-9A-Fa-f]+");
    Matcher matcher = pattern.matcher(hexadecimal);
    return matcher.matches();
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

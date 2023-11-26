import java.util.Scanner;
import java.biginteger.BigInteger;

public class MainMenu {
  public static void main(String[] args) {
    int col, row;
    Scanner input = new Scanner(System.in);
    Matrix matrix4;
    Matrix matrix1 = new Matrix(2, 2);
    System.out.println(matrix1);
    String str = "hola mundo";
    for (char c : str.toCharArray()) {
      System.out.println(c);
    }
    System.out.println(matrix1);
    matrix1.fill();
    System.out.println(matrix1);
    Matrix matrix2 = matrix1.add(matrix1);
    Matrix matrix3 = matrix2.subtract(matrix1);
    System.out.println(matrix1);

    System.out.println(matrix3);

    System.out.println(matrix1.subtract(matrix1).add(matrix1));
    // |-------- Matrix ------|-- Matrix --|
    System.out.print("Enter rows: ");
    row = input.nextInt();
    System.out.print("Enter cols: ");
    col = input.nextInt();
    matrix4 = new Matrix(row, col);
    matrix4.fill();
    System.out.println(matrix4);

    System.out.println("\n\n\n\n");
    System.out.print("N numberes of primes: ");
    int n = input.nextInt();
    int count = 0;
    int i = 1;
    while (count < n) {
      if (Matrix.esPrimo(i)) {
        System.out.println(i);
        count++;
      }
      i++;
    }

    String binarynumber = ""; // String to store the binary number
    binarynumber = input.nextLine(); // Read the binary number
    System.out.println(Integer.parseInt(binarynumber, 2)); // Print the decimal number
  }
}

class Matrix {

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
        System.out.println("Enter value for row " + i + " and col " + j);
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

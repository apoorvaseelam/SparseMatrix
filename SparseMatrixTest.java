package week4;

import java.util.Scanner;

public class SparseMatrixTest {

	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		
		int rowSize;
		int columnSize;
		int elements;
		System.out.print("Enter the number of rows for the matrix: ");
		rowSize = scan.nextInt();
		System.out.print("Enter the number of columns for the matrix: ");
		columnSize=scan.nextInt();
		System.out.print("Enter the number of elements for the matrix: ");
		elements=scan.nextInt();
		
		YaleAlgorithm m = new YaleAlgorithm();
		m.createMatrix(rowSize, columnSize, elements);
		m.displayMatrix();
		System.out.println("");
		
		System.out.println("Matrix Compression using Yale Algorithm: ");
		YaleAlgorithm y = m.toYale();
		y.display();
		System.out.println("");
		
		System.out.println("Changing back to a matrix form:");
		y.toMatrix();
		y.displayCompressedMatrix();
		
		scan.close();
	}

}



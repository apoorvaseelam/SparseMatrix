package week4;

import java.util.Random;

public class YaleAlgorithm {
	private int[] A;
	private int[] IA;
	private int[] JA;
	
	private int[][] matrix;
	private int rowIndex;
	private int columnIndex;
	private int number;
	
	public YaleAlgorithm(int[][] matrix, int rowIndex, int columnIndex, int number)
	{
		this.matrix = matrix;
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
		this.number = number;
	}
	public YaleAlgorithm()
	{
		this.A = null;
		this.IA = null;
		this.JA = null;
	}
	
	public YaleAlgorithm(int[] A, int[] IA, int[] JA)
	{
		this.A = A;
		this.IA = IA;
		this.JA = JA;
	}
	
	//Convert Yale algorithm format to matrix class
	public void toMatrix()
	{
		int rowIndex = max(this.JA) + 1;
		int columnIndex = this.IA.length - 1;
		int number = this.A.length;
		
		int[][] matrix = new int[rowIndex][columnIndex];
		
		for (int j = 0; j < columnIndex; j++)
		{
			for (int i = 0; i < rowIndex; i++)
			{
				matrix[i][j] = 0;
			}
		}
		
		int indexOfA = 0;
		int indexOfIA = 0;		
		
		for (indexOfIA = 0; indexOfIA < this.IA.length - 1; indexOfIA++)
		{
			int curr = this.IA[indexOfIA];
			int next = this.IA[indexOfIA + 1];
			
			while(next > curr)
			{
				matrix[this.JA[indexOfA]][indexOfIA] = this.A[indexOfA];
				indexOfA++;
				next--;
			}
		}
		
		
		this.matrix = matrix;
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
		this.number = number;
		
		displayMatrix();
		
		
	}
	
	//displays the matrix
	
	public void display()
	{
		System.out.println("Yale Display:\n------------");
		
		System.out.print("Matrix \"A\" elements = [ ");
		for (int i = 0; i < this.A.length; i++)
		{
			System.out.print(this.A[i] + " ");
		}
		System.out.println("]");
		
		System.out.print("Column Indices IA = [ ");
		for (int i = 0; i < this.IA.length; i++)
		{
			System.out.print(this.IA[i] + " ");
		}
		System.out.println("]");
		
		System.out.print("Row Indices JA = [ ");
		for (int i = 0; i < this.JA.length; i++)
		{
			System.out.print(this.JA[i] + " ");
		}
		System.out.println("]\n");
	}
	
	//for finding the maximum integer in a array
	
	private int max(int[] array)
	{
		int result = 0;
		for (int i = 0; i < array.length; i++)
		{
			if (result < array[i])
			{
				result = array[i];
			}
		}
		return result;
	}

	//Creates the matrix	
		public void createMatrix(int rowIndex, int columnIndex, int number) throws Exception
		{
			if (number < rowIndex * columnIndex)
		{
			this.matrix = new int[rowIndex][columnIndex];
			this.rowIndex = rowIndex;
			this.columnIndex = columnIndex;
			this.number = number;
			
			Random r = new Random();
			int[] numpick = new int[number];
			
			for (int i = 0; i < number; i++)
			{
				int temp = r.nextInt(rowIndex * columnIndex);
				boolean numcheck = false;

				for (int n = 0; n < i; n++)
				{
					
					{
						if (temp == numpick[n])
					{
						numcheck = true;
					}
				}
				if (numcheck)
				{
					i--;
				}
				else
				{
					numpick[i] = temp;
				}
			}
			}
		    int index = 0;
			for (int i = 0; i < rowIndex; i ++)
			{
				for (int j = 0; j < columnIndex; j++)
				{
					boolean numcheck = false;
					for (int k = 0; k < number; k++)
					{
						if (index == numpick[k])
						{
							numcheck = true;
						}					
					}
					if(numcheck)
						{
							matrix[i][j] = r.nextInt(500) + 1;
						}
					else
						{
							matrix[i][j] = 0;
						}
					index++;
				}
			}
		}
		else
		{
			throw new Exception("The size of the matrix exceeds the elements");
		}
	}
	
	
	//converting the matrix using Yale algorithm
	public YaleAlgorithm toYale()
	{
		int[] A = new int[this.number];
		int index = 0;
		int[] IA = new int[this.columnIndex + 1];
		int[] JA = new int[this.number];
		
		for (int j = 0; j < this.columnIndex; j++)
		{
			IA[j] = index;
			for (int i = 0; i < this.rowIndex; i++)
			{				
				if (this.matrix[i][j] != 0)
				{
					A[index] = this.matrix[i][j];
					JA[index] = i;
					index++;
				}
			}			
		}
		IA[this.columnIndex] = index;
		YaleAlgorithm yale = new YaleAlgorithm(A, IA, JA);
		return yale;
	}
	
	//displays the matrix
	public void displayMatrix()
	{
		System.out.println("Matrix Display:\n------------");
		
		for (int j = 0; j < this.columnIndex; j++)
		{
			for (int i = 0; i < this.rowIndex; i++)
			{
				String element = this.matrix[i][j] + "";				 
				
				System.out.printf("%6s",element);
			}
			System.out.println("");
		}
		System.out.println("\n");
	}	

	// Compresses the matrix
	
	public void displayCompressedMatrix(){
		
				
		System.out.println("Compressed Matrix elements:\n(Non-Zero)\n--------------------------");
		for (int j = 0; j < this.columnIndex; j++)
		{
			for (int i = 0; i < this.rowIndex; i++)
			{
				if(matrix[i][j] != 0)
				{
					System.out.printf("%6d", matrix[i][j]);
				}
				
			}
			System.out.println();
		}
		
		
	}
	
	
	
}
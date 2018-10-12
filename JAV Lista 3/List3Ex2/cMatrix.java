import java.util.Scanner;

public class cMatrix 
{

	private Scanner scan;
	private int matrixA[][];
	private int matrixB[][];
	private int matrixC[][];

	private int size;
 
	public cMatrix()
	{
		scan = new Scanner(System.in);
		System.out.println("Matrix Creation");
		System.out.println("\n Wpisz rozmiar macierzy M :");
		this.size = scan.nextInt();
		matrixA = new int[size][size]; 
		matrixB = new int[size][size];
		matrixC = new int[size][size];
	}

	private void create(int matrix[][], int size)
	{
		for(int i=0; i<size; i++) 
		{			
			for(int j=0; j<size; j++) 
			{
				
				matrix[i][j] = scan.nextInt();
			}
		}
	}
		
	private void display(int matrix[][]) {

		for(int i=0; i<size; i++) {
			
			for(int j=0; j<size; j++) {
				
				System.out.print("\t" + matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	private void AddMartix() //fix naming
	{
		for(int i=0; i<size; i++)
		{
			for(int j=0; j<size; j++)
			{
				matrixC[i][j] = matrixA[i][j] + matrixB[i][j];
			}
		}
	}

	public void CleanMatrixC()
	{
		for(int i=0; i<size; i++)
		{
			for(int j=0; j<size; j++)
			{
				matrixC[i][j] =0;
			}
		}
	}
	
	private void MultiplyMatrix()
	{
		int sum = 0;

		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				for(int l = 0; l < size ; l++)
				{
					sum += matrixA[i][l] * matrixB[l][j];
				}

				matrixC[i][j] = sum;
				sum = 0;
			}
		}
	}

	public void transpose(int matrix[][])
	{
		matrixC=matrix;

		for(int i = 0; i < size; ++i)
		{
			for(int j = i + 1; j < size; ++j)
			{
				int temp = matrixC[i][j];
				matrixC[i][j] =  matrixC[j][i];
				matrixC[j][i] = temp;
			}
		}
	}


	public void run()
	{
		System.out.println("Wpisz macierz A:");
		create(matrixA, size);
		System.out.println("Wpisz macierz  B:");
		create(matrixB, size);
		System.out.println("Macierz A :");
		display(matrixA);
		System.out.println("Macierz B :");
		display(matrixB);

		System.out.println("Suma Macierzy A + B :");
		AddMartix();
		display(matrixC);
		CleanMatrixC();

		System.out.println("Iloczyn macierzy A + B :");
		MultiplyMatrix();
		display(matrixC);
		CleanMatrixC();

		System.out.println("Macierz transponowana dla macierzy A :");
		transpose(matrixA);
		display(matrixC);
		CleanMatrixC();

		System.out.println(" Macierz transponowana dla macierz B :");
		transpose(matrixB);
		display(matrixC);
		CleanMatrixC();

	}
}


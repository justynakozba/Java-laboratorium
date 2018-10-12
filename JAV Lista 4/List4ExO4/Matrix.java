import java.util.Random;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Matrix
{
	
	private int[][] matrix; // class field representing int matrix
	private int dementionX;  // class field representing matrix size
	private int dementionY; // class field representing matrix size
	
	private final int maxX=20;
	private final int maxY=30;
	
	public Matrix(int dementionX, int dementionY)
	{
		if(dementionX <= maxX && dementionY <=maxY)
		{
			matrix = new int[dementionX][dementionY];
			this.dementionX = dementionX;
			this.dementionY = dementionY;
		}
		else
		{
			System.out.println("Za du¿y rozmiar macierzy");
		}
	}

	public void generate() // function generate random matrix
	{
		Random rand = new Random();
		for(int i = 0; i < dementionX; i++)
		{
			for (int j = 0; j < dementionY; j++)
			{
				matrix[i][j] = rand.nextInt(20);
			}
		}
	}

	public void manuallyGenerate()
	{
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<dementionX; i++)
		{
			for (int j = 0; j < dementionY; j++)
			{
				matrix[i][j] = scan.nextInt();
			}
		}
	}

	public void display()
	{
		for(int i=0; i<dementionX; i++)
		{
			System.out.println(" ");
			for(int j=0; j<dementionY; j++)
			{
				System.out.print(" " + matrix[i][j]);
			}
			System.out.println(" ");
		}
		System.out.println();
	}

	public int maxValue() // function calculate max value of table
	{
		int max = matrix[0][0];
		for(int i=0; i<dementionX; i++)
		{
			for (int j=0; j<dementionY; j++)
			{
				if(matrix[i][j] > max)
					{
						max =matrix[i][j];
					}
			}
		}
		return max;
	}

	//FIXME: CAN BE MORE THAN 1 ELEMENT OF TABLE
	public int indexOfmaxValue() // function calculate max value of table
	{
		int max = matrix[0][0];
		int index = 0;

		for(int i = 0; i< dementionX; i++)
		{
			for(int j= 0; j< dementionY; j++)
			{
				if(matrix[i][j] > max)
				{
					max = matrix[i][j];
					index = i;
				}
			}
		}

		return index;
		}
	
	public int maxValueOfRow()
	{
		
		int max = 0; // TODO: musi byc <0 jakas min
		int rowValue = 0;
		int rowNumber =0;
		
		for (int i=0; i < dementionX; i++)
		{
			for(int j = 0; j < dementionY; j++)
			{
				rowValue += matrix[i][j];
			}
			if (rowValue > max)
			{
				max = rowValue;
				rowValue =0;
				rowNumber = i;
			}
		}
		return rowNumber;
	}

	public boolean isInMatrix(int number)
	{
		for(int i = 0; i < dementionX; i++)
		{
			for(int j=0; j< dementionY; j++)
			{
				if(matrix[i][j] == number)
				{
					return true;
				}
			}
		}
		return false;
	}

	public boolean isMultiValued()
	{
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < dementionX; i++)
		{
			for(int j=0; j< dementionY; j++)
			{
				/*
				 * Adds the specified element to this set if it is not already present (optional operation).
				 * More formally, adds the specified element e to this set if the set contains no element e2 such that (e==null ? e2==null : e.equals(e2)).
				 * If this set already contains the element, the call leaves the set unchanged and returns false.
				 */
				if(!set.add(matrix[i][j]))
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public void transpose()
	{
		//check if matrix is square:
		if (dementionX != dementionY)
		{
			System.out.println("Nie mozna transponowac macierzy ktora nie jest kwadratowa. ");
			return;
		}

		int [][] transposedMatrix = new int[dementionX][dementionY];
		transposedMatrix=matrix;

		for(int i = 0; i < dementionX; ++i)
		{
			for(int j = i + 1; j < dementionY; ++j)
			{
				int temp = transposedMatrix[i][j];
				transposedMatrix[i][j] =  transposedMatrix[j][i];
				transposedMatrix[j][i] = temp;
			}
		}

		for(int i=0; i<dementionX; i++)
		{
			System.out.println(" ");
			for(int j=0; j<dementionY; j++)
			{
				System.out.print(" " + transposedMatrix[i][j]);
			}
			System.out.println(" ");
		}
		System.out.println();
	}
}

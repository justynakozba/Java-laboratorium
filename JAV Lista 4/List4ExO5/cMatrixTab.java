import java.util.Set;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class cMatrixTab {

	private cTable[] matrix; // class field representing matrix, which is one-dimensional table of cTable objects
	private int dimensionX; // class field representing matrix row
	private int dimensionY; // class field representing matrix columns

	private final int maxX=20; // class field representing max value of dimension X
	private final int maxY=30; // class field representing max value of dimension Y

	// class constructor which creates matrix
	public cMatrixTab(int dimensionX, int dimensionY) 
	{
		if(dimensionX <= maxX && dimensionY <=maxY)
		{

			matrix = new cTable[dimensionY];
			for(int i = 0; i< dimensionY; i++)
			{
				matrix[i] = new cTable(dimensionX);
			}
			this.dimensionX = dimensionX;
			this.dimensionY = dimensionY;
		}
		else
		{
			System.out.println("Za du¿y rozmiar macierzy");
			System.exit(0);
		}
	}

	
	public void generateAutomatically() // function generate random matrix
	{
		for(int i=0; i<dimensionY; i++)
		{
			matrix[i].generate();
		}
	}

	public void generateManually() // function manually generate matrix
	{
		for(int i=0; i<dimensionY; i++)
		{
			System.out.print("Wprowadz " + i + " wiersz macierzy :");
			matrix[i].manuallyGenerate();
		}
	}

	public void display() // function responsible for display matrix
	{
		for(cTable iter: matrix)
		{
			iter.display();
			System.out.println(" ");
		}
	}

	// function responsible for calculating sum elements in matrix
	public int sum()
	{
		int sum =0;
		for(cTable iter: matrix)
		{
			sum += iter.sum();
		}
		return sum;
	}

	// function responsible for finding max value in matrix
	public int maxValue()
	{
		int max = -10000;
		for(cTable iter: matrix)
		{
			if(iter.maxValue() > max)
			{
				max = iter.maxValue();
			}
		}
		return max;
	}

	// function responsible for finding max value in matrix row
	public int maxValueRow()
	{
		int max = -10000;
		int index = 0;
		for(int i = 0; i< dimensionY; i++)
		{				
			if(matrix[i].sum() > max)
			{
				max = matrix[i].sum();
				index = i;
			}
		}
		return index;
	}

	// function responsible for checking if given number is in table 
	public boolean isInMatrix(int number)
	{
		for(int i = 0; i < dimensionY; i++)
		{
			if(matrix[i].isInTable(number, dimensionX))
			{
				return true;
			}
		}

		return false;
	}

	// function responsible for checking if matrix is multivalued
	public boolean isMultiValued()
	{
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < dimensionY; i++)
		{
			for(int j = 0; j < dimensionX; j++)
			{
				if(!set.add(matrix[i].getElementByIndex(j)))
				{
					System.out.println("Powtarza sie : " + i );
					return false;
				}
			}
		}
		return true;
	}
}



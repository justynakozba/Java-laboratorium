import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class cTable
{

	private int[] tab; // class field representing int table
	private int size;  // class field representing table size

	public cTable()
	{
		System.out.println("To jest moja tablica");
	}

	// class constructor which generates table in given size
	public cTable(int n)
	{
		this.size = n;
		if (size <= 100)
		{
			tab= new int[size];
		}
		else
		{
			System.out.println("Za du¿y rozmiar tablicy");
			System.exit(0);
		}
	}

	// function responsible for getting element from table by index
	public int getElementByIndex(int index)
	{
		return tab[index];
	}
	
	public void generate() // function generate automatically random table
	{
		Random rand = new Random();
		for(int i=0; i<size; i++)
		{
			tab[i] = rand.nextInt(100 - (-100) +1) + (-100);//i;//rand.nextInt(100);
		}
	}

	// function generate table manually with use scanner function 
	public void manuallyGenerate()
	{
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<size; i++)
		{
			tab[i] = scan.nextInt();
		}
	}

	public void display() // function display random table
	{
		for(int i: tab)
		{
			System.out.print(" " + i);
		}
		System.out.println(" ");
	}

	public int sum() // function calculate sum part of table
	{
		int tmp =0;
		for(int i: tab)
		{
			tmp +=i;
		}

		return tmp;
	}

	public int maxValue() // function calculate max value of table
	{
		int max = tab[0];

		for(int i: tab)
		{
			if(i > max)
			{
				max = i;
			}
		}

		return max;
	}
	//FIXME: CAN BE MORE THAN 1 ELEMENT OF TABLE
	public int indexOfmaxValue() // function calculate max value of table
	{
		int max = tab[0];
		int index = 0;

		for(int i = 0; i< size; i++)
		{
			if(tab[i] > max)
			{
				max =tab[i];
				index = i;
			}
		}

		return index;
	}

	// function checking if table contains given number
	public boolean isInTable(int number, int range)
	{
		if (range > size) // check if range fits into the table
		{
			System.out.println("Podany zakres wykracza poza rozmiar tablicy");
			return false;
		}

		for(int i = 0; i < range; i++)
		{
			if(tab[i] == number)
			{
				return true;
			}
		}

		return false;
	}

	// function which checking if table i multivalued
	public boolean isMultiValued()
	{
		Set<Integer> set = new HashSet<Integer>(); // use class HashSet 
		
		for(int i : tab)
		{
			if(!set.add(i))
			{
				System.out.println("Powtarza sie : " + i );
				return false;
			}
		}
		return true;
	}

}

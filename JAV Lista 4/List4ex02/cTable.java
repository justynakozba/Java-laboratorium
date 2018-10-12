import java.util.*;

public class cTable {

	private int[] tab; // class field representing int table
	private int size;  // class field representing table size

	public cTable() {
		// TODO Auto-generated constructor stub
		System.out.println("To jest moja tablica");
	}

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

	public void generate() // function generate random table
	{
		Random rand = new Random();
		for(int i=0; i<size; i++)
		{
			tab[i] = rand.nextInt(100);//i;//rand.nextInt(100);
		}
	}
	
	public void manuallyGenerate()
	{
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<size; i++)
		{
			tab[i] = scan.nextInt();
		}
		//scan.close();
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
		int max = -10000;

		for(int i: tab) 
		{
			if(i > max)
			{
				max =i;
			}
		}

		return max;
	}
	//FIXME: CAN BE MORE THAN 1 ELEMENT OF TABLE
	public int indexOfmaxValue() // function calculate max value of table
	{
		int max = -10000; 
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

	// function checks if table contains given number
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

	// function check if table is multi-valued
	public boolean isMultiValued()
	{
		for (int i = 0; i < size; i++)
		{
			for(int j =0; j< size; j++)
			{
				if ( i!=j)
				{
					if (tab[i] == tab[j])
					{
						return false;
					}
				}
			}
		}

		return true;
	}

	// function check if table is multi-valued, directly method
	public boolean isMultiValued2()
	{
		for (int i = size-1; i > 0 ; i--)
		{
			if( isInTable(tab[i], i) )
			{
				return false;
			}
		}

		return true;
	}

	public boolean isMultiValued3()
	{
		Set<Integer> set = new HashSet<Integer>();
		
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

	public void removeNumber(int number)
	{
		int howManyOccurence= 0; // calculate occurrence of the number in table
		for(int i = 0; i < size; i ++)
		{
			if(tab[i] == number)
			{
				howManyOccurence++ ;
			}
		}

		int[] tmpTab = new int[size - howManyOccurence]; // create temporary table smaller than original table
		int j = 0;

		for(int i = 0; i < size; i ++) // copy all elements into temp table except all occurrence of given number
		{
			if(tab[i] != number)
			{
				tmpTab[j] = tab[i];
				j++;
			}
		}

		tab = tmpTab; // assignee temp table to default table
		size = size-howManyOccurence;// update table size

	}

	public void removeRepeating()
	{
		for(int i=0; i<size; i++)
		{
			for(int j=i+1; j<size; j++)
			{	
				/* If any duplicate found */
				if(tab[i] == tab[j])
				{
					/* Delete the current duplicate element
					 * create variable k and init it with value of j, then move all table elements into left */
					for(int k=j; k<size-1; k++)
					{
						tab[k] = tab[k + 1];
					}
					/* Decrement size after removing duplicate element */
					size--;
					/* If shifting of elements occur then don't increment j */
					j--;
				}
			}
		}

		//copy valid numbers to new tab, and switch tabs
		int tmpTab[]= Arrays.copyOf(tab, size);
		tab = tmpTab;
	}
}

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class cTableSorted 
{

	private int[] tab; // class field representing int table
	private int size;  // class field representing table size

	public cTableSorted() 
	{
		System.out.println("To jest moja tablica");
	}

	public cTableSorted(int n) 
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
		
		Arrays.sort(tab);
	}

	public void generate() // function generate random table
	{
		Random rand = new Random();
		for(int i=0; i<size; i++)
		{
			//FIXME:
			tab[i] = rand.nextInt(10);//i;//rand.nextInt(100);
		}
		
		Arrays.sort(tab);
	}

	//function responsible for manually generate table
	public void manuallyGenerate()
	{
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<size; i++)
		{
			tab[i] = scan.nextInt();
		}
		//scan.close();
		Arrays.sort(tab);
	}

	public void display() // function display random table
	{
		for(int i: tab)
		{
			System.out.print(" " + i);
		}
		System.out.println(" ");
	}

	public void insert(int number)
	{
		int tmpTab []  = new int [size+1]; // create new temporary table which size is greater by 1

		for (int i = 0;  i < size; i++)    // copy all existing elements into tmp table
		{
			tmpTab[i] =tab[i]; 
		}

		tmpTab[size]=number; //assignee the new element to last position in table
		size++; //increase size of table
		tab=tmpTab; // assignee tmp table to default table

		Arrays.sort(tab);
	}

	public void removeByIndex(int index)
	{
		for(int i=0; i<size; i++)
		{
				if(i == index)
				{
					/* Delete the current volume of given index
					 * create variable k and init it with value of index, then move all table elements into left */
					for(int k=index; k<size-1; k++)
					{
						tab[k] = tab[k + 1];
					}
					/* Decrement size after removing duplicate element */
					size--;
				}
		}
		

		//copy valid numbers to new tab, and switch tabs
		int tmpTab[]= Arrays.copyOf(tab, size);
		tab = tmpTab;
		Arrays.sort(tab);
	}

	// remove last occurrence given number 
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
		
		if (howManyOccurence == 0)
		{
			System.out.println("Nie ma takiego elementu w tablicy");
			return;
		}


		int[] tmpTab = new int[size - 1]; // create temporary table smaller than original table
		int j = 0;

		for(int i = 0; i < size; i ++) // copy all elements into temp table except last occurrence of given number
		{
			if(tab[i] != number) 
			{
				tmpTab[j] = tab[i];
				j++;
			}
			else //if we found the number delete last occurrence in the table
			{
				if (howManyOccurence > 1)
				{
					tmpTab[j] = tab[i];
					j++;
					howManyOccurence --;
				}
			}

			Arrays.sort(tab);
		}

		tab = tmpTab; // assignee temporary table to default table
		size = size-1;// update table size
	}

	// function remove all occurrence given number 
	public void removeNumber2(int number)
	{
		int howManyOccurence= 0; // calculate occurrence of the number in table
		for(int i = 0; i < size; i ++)
		{
			if(tab[i] == number)
			{
				howManyOccurence++ ;
			}
			
			Arrays.sort(tab);
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
			
			Arrays.sort(tab);
		}

		tab = tmpTab; // assignee temp table to default table
		size = size-howManyOccurence;// update table size
	}

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
		Arrays.sort(tab);
	}
}

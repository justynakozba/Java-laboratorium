import java.util.Scanner;
import java.util.Random;

public class ExerciseI1 
{
	private int[] sequence;				// Class field, which is table of ints representing arithmetic sequence
	private int size;					// Class field representing size of sequence
	// For all sums the type double was chosen to handle sum all of int, and the deviation all int sum by number of ints ( floating points numbers). 
	private double sum;					// Class field type double representing sum of all number in sequence.
	private double arithmeticSum;		// Class field representing arithmetic sum of positive numbers
	private double afterpositiveSum;	// Class field representing arithmetic mean of the numbers occurring after the positive numbers
		
	// Class constructor responsible for class initialization 
	public ExerciseI1()
	{
		// Getting size of sequence from user
		System.out.println("Podaj d³ugoœc ci¹gu");
		Scanner scan = new Scanner(System.in);
		size = scan.nextInt();
		
		// Initialize the table with given size;
		sequence = new int[size];
		
		// Fulfill sequence number with random data
		Random generator = new Random();
		for(int i = 0; i < size; i++)
		{
			sequence[i] = generator.nextInt() % 100; //-100 < x < 100
		}
		
		sum = 0;				// initialize sum with 0
		arithmeticSum = 0;		// initialize arithmeticSum with 0
		afterpositiveSum= 0;	// initialize afterpositiveSum with 0
	}
	
	// Helper function responsible for printing sequence
	public void printSequence()
	{
		char answer=' ';
		
		System.out.println("Czy chcesz wyœwietliæ ci¹g u¿yty do obliczeñ > [T/N]");
		Scanner scan = new Scanner(System.in);
		
		while (answer != 'T' || answer != 'N')
		{
			// Get the first character from the scanned string. 
		    answer = scan.next().charAt(0);
		    if(answer == 'T')
			{
				for (int x : sequence)
				{
					System.out.println(x);
				}
			}
		    else if(answer == 'N')
		    {
		    	break;
		    }
		    else
		    {
				System.out.println("Nie ma takiej opcji. ");
		    }
		}
	}

	// Function responsible for calculating sum of all numbers in sequence
	private void calcA() 
	{
		for (int x : sequence)
		{
			sum = sum + x;
		}
	}
	
	// Function responsible for calculating average sum of positive numbers
	private void calcB() 
	{
		int tmp = 0 ;
		double sum = 0;
		for (int x : sequence)
		{
			if (x > 0)
			{
				sum = sum + x;
				tmp++;
			}
		}
		if(tmp > 0)
		{
			arithmeticSum = sum / tmp;

		}
	}

	//Function responsible for calculating average sum numbers 
	// which is located after the positive numbers
	public void calcC()
	{
		int tmp = 0;
		double sum = 0;
		//we do not want to check last element cause 
		//there will not be i + 1 so we will be out of table range
		for (int i = 0; i < size -1; i ++) 
		{
			if(sequence[i] > 0)
			{
				sum += sequence[i +1];
				tmp++;
			}
		}
		if( tmp > 0 )
		{
			afterpositiveSum = sum / tmp;
		}
	}
	
	// Public function responsible for invoking proper calculating functions.
	public void run()
	{
		calcA();
		calcB();
		calcC();
		System.out.println("Suma wszystkich liczb= " + sum);
		System.out.println("Œrednia suma wszystkich dodatnich liczb= " + arithmeticSum);
		System.out.println("Œrednia arytmetyczna liczb wystêpuj¹cych bezpoœrednio po liczbach dodatnich= " + afterpositiveSum);
		printSequence();
	}
}


import java.util.Scanner;

public class ExerciseI4 
{
	private int k; 			// Class field representing natural number k
	private int maxDigit;	// Class field representing the max value of a given natural number k
	
	// Class constructor responsible for class initialization
	ExerciseI4()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Podaj liczbê k= ");
		k = scan.nextInt();
		maxDigit = 0;
	}
	
	// Function responsible for calculating max value of a given natural number k
	public void calc()
	{
		maxDigit = k % 10;
		while (k > 0) 
		{
			if (k % 10 > maxDigit)
			{
				maxDigit = k % 10;
			}
			k /= 10;
		}
	}
	
	// Public function responsible for invoking proper calculating functions.
	public void run()
	{
		calc();
		System.out.println("Najwiêksza cyfra z podanej liczby to " + maxDigit);
	}
}

import java.util.Scanner;

// This is base class, which will be inherited in ex7 and ex8.
public class ExerciseI6
{

	private int m; // Class field representing natural number m
	private int n; // Class field representing natural number n
	private int k; // Class field representing natural number k
	
	// Class constructor responsible for class initialization 
	public ExerciseI6()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Podaj liczbę m= ");
		m = scan.nextInt();
		System.out.println("Podaj liczbę n= ");
		n = scan.nextInt();
	}
/*
 * Get and Set functions, which allows to obtain and set private variables
 */
	public int getN()
	{
		return n;
	}

	public void setN( int n)
	{
		this.n = n;
	}
	
	public int getM()
	{
		return m;
	}
	
	public void setM( int m)
	{
		this.m = m;
	}
	
	public void setK( int k)
	{
		this.k = k;
	}
	
	// Function responsible for finding largest common divisor
	public void calc()
	{
		if ( m <= 0 || n <= 0) // check if natural +
		{
			System.out.println("Podanae liczby nie są naturalne" );
			return;
		}
		// Assuming m < n solves the problem
		if (m < n) 
		{
			int x = n;
			n = m;
			m = x;
		}
		
	    k = m;
		while (m % k != 0 || n % k != 0) 
		{ 
			k-- ; 
		}
	}
	
	// Public function responsible for invoking proper calculating functions.
	public void run()			
	{
		calc();
		System.out.println("Największy wspólny dzielnik= " + k);
	}
}

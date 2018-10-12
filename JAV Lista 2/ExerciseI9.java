import java.util.Scanner;

public class ExerciseI9 {
	
	private int k; 		// Class field representing natural number k
	private int x; 		// Class field representing exponent of power x
	private int result; // Class field representing result - x to the power of k
	
	// Class constructor responsible for class initialization 
	public ExerciseI9()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Podaj liczbê x= ");
		x = scan.nextInt();
		System.out.println("Podaj liczbê k= ");
		k = scan.nextInt();
		result = 1;
	}
	// Function responsible for calculating x to the power of and minimizing multiplication
	private void calc() 
	{
		while (k > 0) 
		{
			if (k % 2 == 0)
			{
				x *= x;
				k /= 2;
			} 
			else 
			{
				result *= x;
				k--;
			}
		}
	}
	// Public function responsible for invoking proper calculating functions.
	public void run()
	{
		calc();
		System.out.println("x ^ k = " + result);
	}
}

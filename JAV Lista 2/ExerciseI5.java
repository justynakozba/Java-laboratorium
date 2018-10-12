import java.util.Scanner;

public class ExerciseI5 {

	private int k; // Class field representing natural number K

	// Class constructor responsible for class initialization 
	public ExerciseI5()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Podaj liczbê k= ");
		k = scan.nextInt();
	}

	// Function which check if the number is the prime number
	private boolean checkifNumberIsPrime()
	{
		if(k<2)
		{
		    return false; //if number < 2 is not prime number
		}

		for(int i = 2; i * i <= k; i++)
		{
		    if(k % i == 0)
		    {
		      return false; //if find divider that this number in not prime
		    }
		    return true;
		}
		return false;
	}
	
	// Public function responsible for invoking proper calculating functions.
	public void run()
	{
		if (checkifNumberIsPrime())
		{
			System.out.println("Podana liczba jest liczb¹ pierwsz¹");
		}
		else
		{
			System.out.println("Podana liczba nie jest liczb¹ pierwsz¹");
		}
	}
}

import java.util.Scanner;

public class ExerciseI3 
{
	private int k;				// Class field representing natural number k
	private int howManyDigits;	// Class field representing how many digits has natural number k
	
	// Class constructor responsible for class initialization 
	ExerciseI3()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Podaj liczbê k= ");
		k = scan.nextInt();
		howManyDigits = 0;
	}
	
	// Function responsible for calculating how many digits has natural number k
	private void calc() 
	{	
		if(k == 0)
		{
			howManyDigits = 1;
		}
		else
		{
			while(k > 0)
			{
				k = k/10;
				howManyDigits++;
			}
		}
	}	

	// Public function responsible for invoking proper calculating functions.
	public void run()
	{
		calc();
		System.out.println("Liczba k ma " + howManyDigits + " cyfr znacz¹cych");
	}
	
}



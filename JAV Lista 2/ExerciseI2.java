import java.util.Scanner;

public class ExerciseI2
{
	private int k;				//Class field representing natural number K
	private int sumOfDigits;	//// Class field representing sum of digits
	
	// Class constructor responsible for class initialization 
	ExerciseI2()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Podaj liczbê k= ");
		k=scan.nextInt();
		
	}
	
	// Function responsible for calculating sum of numbers of a given number
	public void calc()
	{
		 while(k > 0) 
		 {
			 sumOfDigits += k % 10;
			 k /= 10;
		 }
	}	
	
	//Public function responsible for invoking proper calculating functions.
	public void run()
	{
		calc();
		System.out.println("Suma cyfr liczby k = " + sumOfDigits);
	}
 }


 import java.util.*;

public class Exercise3 {
	
	private int[] numbers; // Class field, which is table of ints representing numbers
	
	// Class constructor responsible for class initialization 
	public Exercise3()
	{
		 numbers = new int[3];
	     Scanner scan = new Scanner(System.in);
	     System.out.println("Wpisz liczbê A ");
	     numbers[0] = scan.nextInt();
	     System.out.println("Wpisz liczbê B ");
	     numbers[1] = scan.nextInt();
	     System.out.println("Wpisz liczbê C ");
	     numbers[2] = scan.nextInt();
	}

	// Method sorts the specified array of ints into ascending numerical order, using java.util.Arrays
	public void sort()
	{		Arrays.sort(numbers); 
		
		for(int a: numbers)
		{
			System.out.println(a);
		}
	}
	
	// Method sorts the specified array of ints into ascending numerical order, using own sorting algorithm
	public void sort2()
	{
		int temp;
		 
		for (int i = 0; i < 3; i++)
		{
		  for (int j = i + 1; j < 3; j++)
		    if (numbers[i] > numbers[j])
		    {
		      temp = numbers[i];
		      numbers[i] = numbers[j];
		      numbers[j] = temp;
		    }
		}

		for(int a: numbers)
		{
			System.out.println(a);
		}
	}
}

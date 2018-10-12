import java.util.Scanner;

public class Exercise2 {
	
	private int a; // Class field representing number a
	private int b; // Class field representing number b
	private int c; // Class field representing number c
	private final int MAX = 2147483647; // Class field representing max value int
	
	// Class constructor responsible for class initialization 
	public Exercise2()
	{
	     Scanner scan = new Scanner(System.in);
	     System.out.println("Wpisz liczbê A ");
	     a = scan.nextInt();
	     System.out.println("Wpisz liczbê B ");
	     b = scan.nextInt();
	     System.out.println("Wpisz liczbê C ");
	     c = scan.nextInt();
	}
	
	// Function which Sets numbers in ascending order
	public void sort()
	{
		int i = 0;
		do {
		    if(a < b && a < c)
		    {
		        System.out.println(a);
		        a = MAX;
		        i += 1;
		    }
		    if(b < a && b < c)
		    {
		        System.out.println(b);
		        b = MAX;
		        i += 1;
		    }
		    if(c < b && c < a)
		    {
		        System.out.println(c);
		        c = MAX;
		        i += 1;
		    }
		} while(i < 3);
	}
}

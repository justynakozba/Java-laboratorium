import java.util.Scanner;
import java.math.*;

public class Exercise4 {
	
	private int A; // class field representing length of the section A
	private int B; // class field representing length of the section B
	private int C; // class field representing length of the section C
	
	// Class constructor responsible for class initialization 
	Exercise4()
	{
	     Scanner scan = new Scanner(System.in);
	     System.out.println("Wpisz liczb� A ");
	     A = scan.nextInt();
	     System.out.println("Wpisz liczb� B ");
	     B = scan.nextInt();
	     System.out.println("Wpisz liczb� C ");
	     C = scan.nextInt();
	}
	 // Function responsible for calculating if triangle can be constructed
	private boolean isTriangle()
	{
		if( A+B >C && A+C >B && B+C > A)
		{
			return true;
		}
	
		return false;
	}
	// Function responsible for calculating if triangle can be equilateral, isosceles or triangular triangle
	private void checkSide()
	{
		if( A==B && A==C)
		{
			System.out.println("Tr�jk�t R�wnoboczny");
		}
		else if ( A==B || A==C || C==B)
		{
			System.out.println("Tr�jk�t R�wnoramieny");
		}
		else
		{
			System.out.println("Tr�jk�t R�nobczny");
		}
	}
	
	// Function responsible for calculating if triangle can be chevron, rectangle, rectangular triangle
	private void checkAngle()
	{
		if (Math.pow(A, 2) + Math.pow(B, 2) > Math.pow(C, 2))
		{
			System.out.println("Tr�jk�t ostrok�tny ");
		}
		else if(Math.pow(A, 2) + Math.pow(B, 2) < Math.pow(C, 2))
		{
			System.out.println("Tr�jk�t rozwartok�tny");

		}
		else if (Math.pow(A, 2) + Math.pow(B, 2) == Math.pow(C, 2))
		{
			System.out.println("Tr�jk�t prostok�tny");
		}
		else
		{
			System.out.println("NO such triangle");
		}
	}
	
	// Public function responsible for invoking proper calculating functions.
	public void run()
	{
		if(isTriangle())
		{
			checkSide();
			checkAngle();
		}
		else
		{
			System.out.println("Cannot create Triangle with such sides");
		}
	}
}

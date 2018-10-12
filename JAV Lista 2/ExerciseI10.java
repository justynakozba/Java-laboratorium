import java.util.*;

public class ExerciseI10 
{
	private final double PI=3.1415926535897932384650288; // Class field representing PI number
	private Scanner scan;// Class field responsible for Scanner object
	
	// Class constructor responsible for class initialization 
	ExerciseI10()
	{
		scan = new Scanner(System.in);
	}
	
	//Function calculating e^x 
	private double exp(double e, double x)
	{
		double a = 1;
		double f = 0;
	    double i = 0;

	    do{
	    	 i++;
		     f+=a;
	    	 a*=(x/i);
	    }
	    while(Math.abs(a) >= e);

	    return f;
	}	

	/*
	 * This is function calculating the sinus x function using Taylor series
	 * sin x = x - x^3/3! + x^5/5! -x^7/7!... . The function takes degrees as input.
	 */
	private double sin(double x)
	{
		
		double s = 1;
		if(x < 0)
		{
			s=-1.0;
			x =- x;
		}

		if( x > 360)
		{
			x -= (x/360)*360;
		}

 
		x *= PI/180.0;
		double rest=0;
		double term=x;
		int k=1;
  
		while(rest+term != rest)
		{
			rest+=term;
			k+=2;
			term*=-x*x/k/(k-1);
		}

		return s*rest;
	}
	
	/*
	 * This is function calculating the cosinus x function using Taylor series
	 * cos x = 1 -x^2/2!+x^4/4!-x^6/6!... . The function takes degrees as input.
	 */
	private double cos(double x)
	{
		if(x < 0)
		{
			x=-x;
		}

		if(x > 360)
		{
		  	x -= (x/360)*360;
		}

		x*=PI/180.0;
		double rest=0;
		double term=1;
		int k=0;

		while(rest+term!=rest)
		{
		    rest+=term;
		    k+=2;
		    term*=-x*x/k/(k-1);
		}  
	  
		return rest;
	}
	
	
	/*
	 * Public function in class responsible for getting data from user,
	 * invoking calculating functions and printing results.
	 */
	public void run()
	{
		System.out.println("Podaj liczbê eps (dok³adnoœæ obliczeñ) =");
		double e =scan.nextDouble();
		System.out.println("Podaj liczbê x =");
		double x =scan.nextDouble();
		System.out.println("Wynik = = " + exp(e,x));
		System.out.println("Wynik policzony funckj¹ exp z biblioteki Math = " + Math.exp(x));

		System.out.println("Podaj k¹t alpha sin(alpha) =");
		double a =scan.nextDouble();
		double s = sin(a);
		System.out.println("Sinus k¹t alpha sin("+ a +") =" + s);
		System.out.println("Wynik policzony funckj¹ sin z biblioteki Math " + Math.sin(Math.toRadians(a)));

		System.out.println("Podaj k¹t beta cos(beta) =");
		double b =scan.nextDouble();
		double c = cos(b);
		System.out.println("Sinus k¹t alpha cos("+ b +") =" + c);
		System.out.println("Wynik policzony funckj¹ cos z biblioteki Math" + Math.cos(Math.toRadians(b)));
	}
}

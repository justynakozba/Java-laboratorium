import java.util.Scanner;

public class Exercise1 {
	private double px; 		 // class field representing the x coordinate of the point p
	private double py; 		 // class field representing the y coordinate of the point p
	private double distance; // distance from the origin of the coordinate system
	
	/*
	 * Class constructor which initializes class field variables of double type
	 */
	public Exercise1()
	{
		 Scanner scan = new Scanner(System.in);
	     System.out.println("Wpisz wspolrzedna x punktu P ");
	     px = scan.nextDouble();
	     System.out.println("Wpisz wspolrzedna y punktu P ");
	     py = scan.nextDouble();
	     distance = 0;   
	}

	// Private helper function, which calculates distance from point P(px,py) to given point coordinates A(ax,ay).
	private  double calcDistance( double ax, double ay)
	{
		return Math.sqrt( Math.pow(px - ax, 2) + Math.pow(py - ay, 2) );
	}
	
	//Exercise D1 a Determines if point belongs to the colored areas
	private void calcA()
	{
		distance = calcDistance(0d, 0d);
		System.out.println( "distance " + distance);
		
		if (distance <= 1 && distance > 0)
		{
			System.out.println("Punkt znajdujê siê w polu 1 kolor br¹zowy");
		}
		else if (distance > 1 && distance <= 2 )
		{
			System.out.println("Punkt znajdujê siê w polu 2 kolor czerwony");
		}
		else if (distance > 2 && distance <= 3)
		{
			System.out.println("Punkt znajdujê siê w polu 3 kolor pomarañczowy");
		}
		else if (distance > 3 && distance <= 4)
		{
			System.out.println("Punkt znajdujê siê w polu 4 kolor musztardowy");
		}
		else if (distance > 4 && px <= 4 && py <= 4)
		{
			System.out.println("Punkt znajdujê siê w polu 5 kolor ¿ó³ty");
		}
		else
		{
			System.out.println("Punkt nie znajdujê siê w ¿adnym polu");
		}
	}
	
	// Exercise D1 b Determines if point belongs to the colored areas
	private void calcB()
	{
		if( px == 0 && py == 0 )
		{
				System.out.println("Punkt 0, 0");
  
		}

	    if( px >= 0 && py >= 0 )
		{
			distance = calcDistance(1, 1);
			if (distance <= 1)
			{
				System.out.println("Punkt znajduje siê w 1 æwiartce nale¿y o ko³a o kolorze musztardowym");
			}
			else if ( distance > 1 && px <= 2 && py <= 2 )
			{
				System.out.println("Punkt znajduje siê w 1 æwiartce i nale¿y do ¿ó³tego kwadratu ");
			}
			else
			{
				System.out.println("Punkt znajduje siê w 1 æwiartce ale nie nale¿y do kwadratu ");
			}
		}

	    if ( px <= 0 && py >= 0)
		{
			distance = calcDistance(-1, 1);
			if (distance <= 1)
			{
				System.out.println("Punkt znajduje siê w 2 æwiartce i nale¿y do ko³a o kolorze pomarañczowym");
			}
			else if ( distance > 1 && px <= 2 && py <= -2 )
			{
				System.out.println("Punkt znajduje siê w 2 æwiartce i nale¿y do ¿ó³tego kwadratu ");
			}
			else
			{
				System.out.println("Punkt znajduje siê w 2 æwiartce ale nie nale¿y do kwadratu ");
			}
		}

	    if (px <= 0 && py <= 0)
		{
			distance = calcDistance(-1, -1);
			if (distance <= 1)
			{
				System.out.println("Punkt znajduje siê w 3 æwiartce i nale¿y do ko³a o kolorze czerwonym");
			}
			else if ( distance > 1 && px <= -2 && py <= -2 )
			{
				System.out.println("Punkt znajduje siê w 3 æwiartce i nale¿y do ¿ó³tego kwadratu");
			}
			else
			{
				System.out.println("Punkt znajduje siê w 3 æwiartce ale nie nale¿y do kwadratu ");
			}
		}

	    if ( px >= 0 && py <= 0)
		{
			distance = calcDistance(1, -1);
			if (distance <= 1)
			{
				System.out.println("Punkt znajduje siê w 4 æwiartce i nalezy do ko³a o kolorze br¹zowym");
			}
			else if ( distance > 1 && px <= 2 && py <= -2 )
			{
				System.out.println("Punkt znajduje siê w 4 æwiartce i nale¿y do ¿ó³tego kwadratu ");
			}
			else
			{
				System.out.println("Punkt znajduje siê w 4 æwiartce ale nie nale¿y do kwadratu ");
			}
		}
	}
	
	  /*
	   *  Private helper function, which check if point P(px,py) belongs to triangle,
	   *  created by given coordinates A(ax, ay), B(bx, by) C(cx, cy).
	   */
	   private  boolean isInTriangle(double ax, double ay, double bx, double by, double cx, double cy)
	   {
		double d1 = px*(ay-by) + py*(bx-ax) + (ax*by-ay*bx);        
		double d2 = px*(by-cy) + py*(cx-bx) + (bx*cy-by*cx);
		double d3 = px*(cy-ay) + py*(ax-cx) + (cx*ay-cy*ax);
	 
		 if ( (d1<=0) && (d2<=0) && (d3<=0) || (d1>=0) && (d2>=0) && (d3>=0))
		 {
			 return true;
		 }
		 return false;
	   }
	   
	   // Exercise D1 c Determines if point belongs to the colored areas
	   private void calcC()	   
	   {
		  if (px >= 0 && py >= 0)
		  {
			   if (isInTriangle(0, 1, 1, 0, 0, 0) )
			   {
				   System.out.println("Punkt znajduje siê w 1 trójk¹cie koloru czerwonego");
			   }
			   else if (!isInTriangle(0, 1, 1, 0, 0, 0) && px <=1 && py <=1)
			   {
				   System.out.println("Punkt znajduje siê w 1 æwiartce w trójkacie koloru ¿ó³tego");
			   }
			   else
			   {
				   System.out.println("Punkt znajduje siê w 1 æwiartce ale nie znajduje siê w ¿adnym w trójk¹tów");
			   }
		  }
		  if (px <= 0 && py >= 0)
		  {
			   if (isInTriangle(0, -1, 0, 0, -1, 0) )
			   {
				   System.out.println("Punkt znajduje siê w 2 trójk¹cie koloru musztardowego");
			   }
			   else if (!isInTriangle(0, -1, 0, 0, -1, 0) && px <=1 && py <=1)
			   {
				   System.out.println("Punkt znajduje siê w 2 æwiartce w trójkacie koloru ¿ó³tego");
			   }
			   else
			   {
				   System.out.println("Punkt znajduje siê w 2 æwiartce ale nie znajduje siê w ¿adnym w trójk¹tów");
			   }
		  }
		  if (px <= 0 && py <=0 )
		  {
			   if (isInTriangle(-1, 0, -1, 0, -1, -1) )
			   {
				   System.out.println("Punkt znajduje siê w 3 trójk¹cie koloru br¹zowego");
			   }
			   else if (!isInTriangle(-1, 0, -1, 0, -1, -1) && px <=1 && py <=1)
			   {
				   System.out.println("Punkt znajduje siê w 3 æwiartce w trójkacie koloru ¿ó³tego");
			   }
			   else
			   {
				   System.out.println("Punkt znajduje siê w3 æwiartce ale nie znajduje siê w ¿adnym w trójk¹tów");
			   }
		  }   
		  if (px >= 0 && py <= 0)
		  {
			  if (isInTriangle(0, 0, 1, -1, 0, -1) )
			  {
				  System.out.println("Punkt znajduje siê w 4 trójk¹cie koloru pomarañczowego");
			  }
			  else if (!isInTriangle(0, 0, 1, -1, 0, -1) && px <=1 && py <=1)
			   {
				   System.out.println("Punkt znajduje siê w 4 æwiartce w trójkacie koloru ¿ó³tego");
			   }
			   else
			   {
				   System.out.println("Punkt znajduje siê w 4 æwiartce ale nie znajduje siê w ¿adnym w trójk¹tów");
			   }
		  }
	   }
	   
	   // Public function responsible for invoking proper calculating functions.
	   public void run()
	   {
		   calcA();
		   calcB();
		   calcC();
	   }
	   
}

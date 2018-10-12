import java.util.Scanner;

public class Exercise5 {

	   private float ax; // Class field representing the x coordinate of the point a which is a vertex of the triangle
	   private float ay; // Class field representing the y coordinate of the point a which is a vertex of the triangle
	   private float bx; // Class field representing the x coordinate of the point b which is a vertex of the triangle
	   private float by; // Class field representing the y coordinate of the point b which is a vertex of the triangle
	   private float cx; // Class field representing the x coordinate of the point c which is a vertex of the triangle
	   private float cy; // Class field representing the y coordinate of the point c which is a vertex of the triangle
	   private float px; // Class field representing the x coordinate of the point p which is a searching point
	   private float py; // Class field representing the x coordinate of the point p which is a searching point
	   private float d1; // Class field representing equation of the straight AB
	   private float d2; // Class field representing equation of the straight CB
	   private float d3;  // Class field representing equation of the straight CA
	 
	// Class constructor responsible for class initialization 
	   public Exercise5()
	   {
		     Scanner scan = new Scanner(System.in);
		     System.out.println("Wpisz wspolrzedna x wierzcho³ka A ");
		     ax = scan.nextInt();
		     System.out.println("Wpisz wspolrzedna y wierzcho³ka A ");
		     ay = scan.nextInt();
		     System.out.println("Wpisz wspolrzedna x wierzcho³ka B ");
		     bx = scan.nextInt();
		     System.out.println("Wpisz wspolrzedna y wierzcho³ka B ");
		     by = scan.nextInt();
		     System.out.println("Wpisz wspolrzedna x wierzcho³ka C ");
		     cx = scan.nextInt();
		     System.out.println("Wpisz wspolrzedna y wierzcho³ka C ");
		     cy = scan.nextInt();
		     System.out.println("Wpisz wspolrzedna x punktu P ");
		     px = scan.nextInt();
		     System.out.println("Wpisz wspolrzedna y punktu P ");
		     py = scan.nextInt();
	   }
	   
	// Function responsible for calculating if point point belongs to a straight line
	   private boolean isInTriangle()
	   {
		d1 = px*(ay-by) + py*(bx-ax) + (ax*by-ay*bx);        
		d2 = px*(by-cy) + py*(cx-bx) + (bx*cy-by*cx);
		d3 = px*(cy-ay) + py*(ax-cx) + (cx*ay-cy*ax);
	 
		 if ( (d1<=0) && (d2<=0) && (d3<=0) || (d1>=0) && (d2>=0) && (d3>=0))
		 {
			 return true;
		 }
		 return false;
	   }
	   
	   // Public function responsible for invoking proper calculating functions.
	   public void run()
	   {
		   if (isInTriangle())
		   {
			 System.out.println(" Punkt lezy wewnatrz trojkata ");
		   }
		   else
		   {
			 System.out.println(" Punkt nie lezy wewnatrz trojkata ");
		   }
	   }
}

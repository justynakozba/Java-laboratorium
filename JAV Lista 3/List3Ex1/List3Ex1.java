import java.util.Scanner;

public class List3Ex1 {

	public List3Ex1() {
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Wpisz k ");
		int k = scan.nextInt();
		scan.close();

		int[] t = new int[k];
		for(int i =0; i<k; i++)
		t[i] = (int)(Math.random()* k) +1;

		System.out.println("Ci¹g kolejnoœci utworzenia: "); // display the set in the creation order
		for (int i = 0; i<k; i++)
			System.out.println(t[i]);

		System.out.println("Ci¹g odwrotnej kolejnoœci : "); // display the set in reverse order
		for (int i = 0; i<k; i++)
		System.out.println(t[k - i -1]);

		int[] tp = new int[k];
		int[] tn = new int[k];
		int ip = 0; 
		int in = 0;
		for(int i =0; i<k; i++)
		{
			if (t[i]%2 == 0)
			{
				tp[ip]=t[i];
				ip++;
			}
			else 
			{ 
				tn[in]=t[i];
				in++;
			}
		}

		System.out.println("Parzyste: "); // display even numbers
		for(int i = 0; i < ip; i++)
		System.out.println(tp[i]);

		System.out.println("Nieparzyste: "); // display odd numbers
		for(int i =0; i< in; i++)
		System.out.println(tn[i]);
	}

}

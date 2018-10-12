import java.util.Scanner;

public class TextMenu {

	
	private void printMenu()
	{
		System.out.println("==============================================");
		System.out.println("Menu tekstowe dla listy 1");
		System.out.println("==============================================");
		System.out.println(" Aby wybraæ zadanie wpisz odpowiedni¹ liczbê");
		System.out.println(" 1 -zdanie 1");
		System.out.println(" 2 -zdanie 2");
		System.out.println(" 3 -zdanie 3");
		System.out.println(" 4 -zdanie 4");
		System.out.println(" 5 -zdanie 5");
		System.out.println(" 6 -zdanie 6");
		System.out.println(" 7 - wyjscie");
		System.out.println("==============================================");
	}
	
	public void textMenu()
	{
		while(true)
		{
			printMenu();
			Scanner menu = new Scanner(System.in);
			int choice = menu.nextInt();
			switch (choice)
			{
				case 1:
					System.out.println("zdanie 1");
					Exercise1 ex1 = new Exercise1();
					ex1.run();
					break;
					
				case 2:
					System.out.println("zdanie 2");
					Exercise2 ex2 = new Exercise2();
					ex2.sort();
					break;
					
				case 3:
					System.out.println("zdanie 3");
					Exercise3 ex3 = new Exercise3();
					ex3.sort2();
					break;
					
				case 4:
					System.out.println("zdanie 4");
					Exercise4 ex4 = new Exercise4();
					ex4.run();
					break;
					
				case 5:
					System.out.println("zdanie 5");
					Exercise5 ex5 = new Exercise5();
					ex5.run();
					break;
					
				case 6: 
					System.out.println("zdanie 6");
					Exercise6 ex6 = new Exercise6();
					ex6.calc();
					break;
					
				case 7:
					System.exit(0);				
					break;
					
				default:
					System.out.println("nie ma tkiej opcji");
					break;
			}
		}
			
	}
}

import java.util.Scanner;

public class TextMenu {

	private void printMenu()
	{
		System.out.println("==============================================");
		System.out.println("Menu tekstowe dla listy 1");
		System.out.println("==============================================");
		System.out.println(" Aby wybraæ zadanie wpisz odpowiedni¹ liczbê");
		System.out.println(" 1  -zdanie 1");
		System.out.println(" 2  -zdanie 2");
		System.out.println(" 3  -zdanie 3");
		System.out.println(" 4  -zdanie 4");
		System.out.println(" 5  -zdanie 5");
		System.out.println(" 6  -zdanie 6");
		System.out.println(" 7  -zdanie 7");
		System.out.println(" 8  -zdanie 8");
		System.out.println(" 9  -zdanie 9");
		System.out.println(" 10 -zdanie 10");
		System.out.println(" 11 -wyjscie");
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
					ExerciseI1 ex1 = new ExerciseI1();
					ex1.run();
					break;
					
				case 2:
					System.out.println("zdanie 2");
					ExerciseI2 ex2 = new ExerciseI2();
					ex2.run();
					break;
					
				case 3:
					System.out.println("zdanie 3");
					ExerciseI3 ex3 = new ExerciseI3();
					ex3.run();
					break;
					
				case 4:
					System.out.println("zdanie 4");
					ExerciseI4 ex4 = new ExerciseI4();
					ex4.run();
					break;

				case 5:
					System.out.println("zdanie 5");
					ExerciseI5 ex5 = new ExerciseI5();
					ex5.run();
					break;

				case 6: 
					System.out.println("zdanie 6");
					ExerciseI6 ex6 = new ExerciseI6();
					ex6.run();
					break;
	
				case 7:
					System.out.println("zdanie 7");
					ExerciseI7 ex7 = new ExerciseI7();
					ex7.run();
					break;

				case 8:
					System.out.println("zdanie 8");
					ExerciseI8 ex8 = new ExerciseI8();
					ex8.run();
					break;

				case 9:
					System.out.println("zdanie 9");
					ExerciseI9 ex9 = new ExerciseI9();
					ex9.run();
					break;

				case 10:
					System.out.println("zdanie 10");
					ExerciseI10 ex10 = new ExerciseI10();
					ex10.run();
					break;

				case 11:
					System.exit(0);				
					break;
					
				default:
					System.out.println("nie ma tkiej opcji");
					break;
			}
		}
			
	}
}


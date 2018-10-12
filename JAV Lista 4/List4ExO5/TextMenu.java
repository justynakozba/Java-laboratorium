import java.util.Scanner;

public class TextMenu 
{
	private void printMenu()
	{
		System.out.println("==============================================");
		System.out.println("Menu tekstowe dla listy 4");
		System.out.println("==============================================");
		System.out.println(" Aby wybraæ zadanie wpisz odpowiedni¹ liczbê");
		System.out.println(" 0  -Wyœwietl menu");
		System.out.println(" 1  -Stwórz macierz o wybranym rozmiarze");
		System.out.println(" 2  -Manualna generaja macierzy");
		System.out.println(" 3  -Automatyczna generacja macierzy");
		System.out.println(" 4  -Wyœwietlenie sumy wartoœci elementów macierzy");
		System.out.println(" 5  -Wyœwietlenie wartoœci maksymalnej macierzy");
		System.out.println(" 6  -Wyœwietlnie wiersza o maksymalnej sumie wartoœci elementów");
		System.out.println(" 7  -Czy podana wartoœæ wystêpuje w macierzy");
		System.out.println(" 8  -Czy maierz jest ró¿nowartoœciowa");
		System.out.println(" 9 -Wyœwietlenie macierzy");
		System.out.println(" 10 -Usuniêcie macierzy");
		System.out.println(" 11 -Wyjœcie");
		
		System.out.println("==============================================");
	}

	public void textMenu()
	{
		cMatrixTab matrix = null;
		Scanner menu = new Scanner(System.in);

		printMenu();
		while(true)
		{
			int choice = menu.nextInt();

			switch (choice)
			{
				case 0:
					printMenu();
					break;

				case 1:
					System.out.println("Wpisz rozmiar macierzy");
					matrix = new cMatrixTab(menu.nextInt(),menu.nextInt());
					break;

				case 2:
					System.out.println("Manualna generacja macierzy");
					System.out.println("Wpisz elementy macierzy");
					matrix.generateManually();
					break;

				case 3:
					System.out.println("Automatyczna generacja macierzy");
					matrix.generateAutomatically();
					break;

				case 4:
					System.out.println("Suma wartoœci elementów macierzy");
					int result = matrix.sum();
					System.out.println("Suma = " + result);
					break;

				case 5:
					System.out.println("Wartosæ maksymalna macierzy");
					try
					{
						result = matrix.maxValue();
						System.out.println("Maksymalna wartoœæ = " + result);
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utwórz macierz");
					}
					break;

				case 6:
					System.out.println("Wiersz o maksymalnej sumie elementów");
					try
					{
						int index = matrix.maxValueRow();
						System.out.println("Index wartoœci max  = " + index);
					}
					catch(NullPointerException e) 
					{
						System.out.println("Najpierw utwórz mcierz");
					}
					break;

				case 7:
					System.out.println("Czy podana wartoœæ wystêpuje w macierzy");
					System.out.println("Wpisz wartoœæ oraz zakres");
					try 
					{
						boolean ret = matrix.isInMatrix(menu.nextInt());
						System.out.println(" Czy jest w macierzy  = " + ret);
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utwórz macierz");
					}
					break;

				case 8: 
					System.out.println("Czy macierz jest ró¿nowartoœciowa");
					try
					{
						System.out.println(" Czy jest ró¿nowartoœciowa  = " + matrix.isMultiValued());
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utwórz macierz");
					}
					break;

				case 9:
					System.out.println("Wyœwietlenie macierzy");
					try
					{
						matrix.display();
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utwórz macierz");
					}
					
					break;

				case 10:
					System.out.println("Usuniêcie macierzy");
					matrix = null;
					break;

				case 11:
					menu.close();
					System.exit(0);
					break;


				default:
					System.out.println("Nie ma tkiej opcji");
					break;
			}
		}
	}

}


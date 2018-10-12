import java.util.Scanner;

public class TextMenu 
{
	private void printMenu()
	{
		System.out.println("==============================================");
		System.out.println("Menu tekstowe dla listy 4");
		System.out.println("==============================================");
		System.out.println(" Aby wybra� zadanie wpisz odpowiedni� liczb�");
		System.out.println(" 0  -Wy�wietl menu");
		System.out.println(" 1  -Stw�rz macierz o wybranym rozmiarze");
		System.out.println(" 2  -Manualna generaja macierzy");
		System.out.println(" 3  -Automatyczna generacja macierzy");
		System.out.println(" 4  -Wy�wietlenie sumy warto�ci element�w macierzy");
		System.out.println(" 5  -Wy�wietlenie warto�ci maksymalnej macierzy");
		System.out.println(" 6  -Wy�wietlnie wiersza o maksymalnej sumie warto�ci element�w");
		System.out.println(" 7  -Czy podana warto�� wyst�puje w macierzy");
		System.out.println(" 8  -Czy maierz jest r�nowarto�ciowa");
		System.out.println(" 9 -Wy�wietlenie macierzy");
		System.out.println(" 10 -Usuni�cie macierzy");
		System.out.println(" 11 -Wyj�cie");
		
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
					System.out.println("Suma warto�ci element�w macierzy");
					int result = matrix.sum();
					System.out.println("Suma = " + result);
					break;

				case 5:
					System.out.println("Wartos� maksymalna macierzy");
					try
					{
						result = matrix.maxValue();
						System.out.println("Maksymalna warto�� = " + result);
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utw�rz macierz");
					}
					break;

				case 6:
					System.out.println("Wiersz o maksymalnej sumie element�w");
					try
					{
						int index = matrix.maxValueRow();
						System.out.println("Index warto�ci max  = " + index);
					}
					catch(NullPointerException e) 
					{
						System.out.println("Najpierw utw�rz mcierz");
					}
					break;

				case 7:
					System.out.println("Czy podana warto�� wyst�puje w macierzy");
					System.out.println("Wpisz warto�� oraz zakres");
					try 
					{
						boolean ret = matrix.isInMatrix(menu.nextInt());
						System.out.println(" Czy jest w macierzy  = " + ret);
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utw�rz macierz");
					}
					break;

				case 8: 
					System.out.println("Czy macierz jest r�nowarto�ciowa");
					try
					{
						System.out.println(" Czy jest r�nowarto�ciowa  = " + matrix.isMultiValued());
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utw�rz macierz");
					}
					break;

				case 9:
					System.out.println("Wy�wietlenie macierzy");
					try
					{
						matrix.display();
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utw�rz macierz");
					}
					
					break;

				case 10:
					System.out.println("Usuni�cie macierzy");
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


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
		System.out.println(" 4  -Wy�wietlenie warto�ci maksymalnej macierzy");
		System.out.println(" 5  -Wy�wietlnie indeksu elementu maksymalnego macierzy");
		System.out.println(" 6  -Wy�wietlenie wiersza o maksymalnej sumie element�w");
		System.out.println(" 7  -Czy podana warto�� wyst�puje w maierzy");
		System.out.println(" 8  -Czy macierz jest r�nowarto�ciowa");
		System.out.println(" 9  -Transponowanie macierzy");
		System.out.println(" 10 -Wy�wietlenie macierzy");
		System.out.println(" 11 -Usuni�cie macierz");
		System.out.println(" 12 -Wyj�cie");
		
		System.out.println("==============================================");
	}

	public void textMenu()
	{
		Matrix matrix = null;
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
					matrix = new Matrix(menu.nextInt(), menu.nextInt());
					break;

				case 2:
					System.out.println("Manualna generacja macierzy");
					System.out.println("Wpisz elementy macierzy");
					matrix.manuallyGenerate();
					break;

				case 3:
					System.out.println("Automatyczna generacja macierzy");
					matrix.generate();
					break;

				case 4:
					System.out.println("Wartos� maksymalna macierzy");
					try
					{
						int max = matrix.maxValue();
						System.out.println("Maksymalna warto�� = " + max);
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utw�rz macierz");
					}
					break;

				case 5:
					System.out.println("Indeks elementu maksymalnego macierzy");
					try
					{
						int index = matrix.indexOfmaxValue();
						System.out.println("Index warto�ci max  = " + index);
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
						int rowNumber = matrix.maxValueOfRow();
						System.out.println("Wiersz o warto�ci max  = " + rowNumber);
					}
					catch(NullPointerException e) 
					{
						System.out.println("Najpierw utw�rz macierz");
					}
					break;

				case 7:
					System.out.println("Czy podana warto�� wyst�puje w macierzy");
					System.out.println("Wpisz warto��");
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
					System.out.println("Transonowanie macierzy");
					try
					{
						System.out.println(" Macierz transponowana");
						matrix.transpose();
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utw�rz macierz");
					}
					break;

				case 10:
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

				case 11:
					System.out.println("Usuni�cie macierzy");
					matrix = null;
					break;

				case 12:
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

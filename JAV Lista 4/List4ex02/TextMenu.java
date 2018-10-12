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
		System.out.println(" 1  -Stw�rz tablice o wybranym rozmiarze");
		System.out.println(" 2  -Manualna generaja tablicy");
		System.out.println(" 3  -Automatyczna generacja tablicy");
		System.out.println(" 4  -Wy�wietlenie sumy warto�ci element�w tablicy");
		System.out.println(" 5  -Wy�wietlenie warto�ci maksymalnej tablicy");
		System.out.println(" 6  -Wy�wietlnie indeksu elementu maksymalnego tablicy");
		System.out.println(" 7  -Czy podana warto�� wyst�puje na kt�rej� z pocz�tkowych pozycji tablicy");
		System.out.println(" 8  -Czy tablica jest r�nowarto�ciowa"); // FIXME: bad result !!!!!!!!!!!!!!!!
		System.out.println(" 9  -Czy tablica jest r�nowarto�ciowa - 2 spos�b");
		System.out.println(" 10  -Czy tablica jest r�nowarto�ciowa - 3 spos�b");
		System.out.println(" 11  -Usuni�cie wszystkich wyst�pie� podanej liczby");
		System.out.println(" 12  -Usuni�cie wszystkich powt�rze� element�w tablicy");
		System.out.println(" 13 -Wy�wietlenie tablicy");
		System.out.println(" 14 -Usuni�cie tablicy");
		System.out.println(" 15 -Wyj�cie");
		
		System.out.println("==============================================");
	}

	public void textMenu()
	{
		cTable tab = null;
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
					System.out.println("Wpisz rozmiar tablicy");
					tab = new cTable(menu.nextInt());
					break;

				case 2:
					System.out.println("Manualna generacja tablicy");
					System.out.println("Wpisz elementy tablicy");
					tab.manuallyGenerate();
					break;

				case 3:
					System.out.println("Automatyczna generacja tablicy");
					tab.generate();
					break;

				case 4:
					System.out.println("Suma warto�ci element�w tablicy");
					int result = tab.sum();
					System.out.println("Suma = " + result);
					break;

				case 5:
					System.out.println("Wartos� maksymalna tablicy");
					try
					{
						result = tab.maxValue();
						System.out.println("Maksymalna warto�� = " + result);
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utw�rz tablic�");
					}
					break;

				case 6:
					System.out.println("Indeks elementu maksymalnego tablicy");
					try
					{
						int index = tab.indexOfmaxValue();
						System.out.println("Index warto�ci max  = " + index);
					}
					catch(NullPointerException e) 
					{
						System.out.println("Najpierw utw�rz tablic�");
					}
					break;

				case 7:
					System.out.println("Czy podana warto�� wyst�puje na kt�rej� z pocz�tkowych pozycji tablicy");
					System.out.println("Wpisz warto�� oraz zakres");
					try 
					{
						boolean ret = tab.isInTable(menu.nextInt(), menu.nextInt());
						System.out.println(" Czy jest w tablicy  = " + ret);
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utw�rz tablic�");
					}
					break;

				case 8: 
					System.out.println("Czy tablica jest r�nowarto�ciowa");
					try
					{
						System.out.println(" Czy jest r�nowarto�ciowa  = " + tab.isMultiValued());
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utw�rz tablic�");
					}
					break;

				case 9: 
					System.out.println("Czy tablica jest r�nowarto�ciowa- 2 spos�b");
					try
					{
						System.out.println(" Czy jest r�nowarto�ciowa2  = " + tab.isMultiValued2());
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utw�rz tablic�");
					}
					break;

				case 10: 
					System.out.println("Czy tablica jest r�nowarto�ciowa- 3 spos�b");
					try
					{
						System.out.println(" Czy jest r�nowarto�ciowa3  = " + tab.isMultiValued3());
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utw�rz tablic�");
					}
					break;

				case 11: 
					System.out.println("Usuni�cie wszystkich wystapie� podanej liczby");
					try
					{
						System.out.println("Wpisz liczb� do usuni�cia");
						tab.removeNumber(menu.nextInt());
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utw�rz tablic�");
					}
					break;

				case 12: 
					System.out.println("Usuni�cie wszystkich powt�rze� element�w tablicy");
					try 
					{
						tab.removeRepeating();
						tab.display();
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utw�rz tablic�");
					}
					break;

				case 13:
					System.out.println("Wy�wietlenie tablicy");
					try
					{
						tab.display();
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utw�rz tablic�");
					}
					
					break;

				case 14:
					System.out.println("Usuni�cie tablicy");
					tab = null;
					break;

				case 15:
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

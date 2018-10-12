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
		System.out.println(" 1  -Stwórz tablice o wybranym rozmiarze");
		System.out.println(" 2  -Manualna generaja tablicy");
		System.out.println(" 3  -Automatyczna generacja tablicy");
		System.out.println(" 4  -Wyœwietlenie sumy wartoœci elementów tablicy");
		System.out.println(" 5  -Wyœwietlenie wartoœci maksymalnej tablicy");
		System.out.println(" 6  -Wyœwietlnie indeksu elementu maksymalnego tablicy");
		System.out.println(" 7  -Czy podana wartoœæ wystêpuje na którejœ z pocz¹tkowych pozycji tablicy");
		System.out.println(" 8  -Czy tablica jest ró¿nowartoœciowa"); // FIXME: bad result !!!!!!!!!!!!!!!!
		System.out.println(" 9  -Czy tablica jest ró¿nowartoœciowa - 2 sposób");
		System.out.println(" 10  -Czy tablica jest ró¿nowartoœciowa - 3 sposób");
		System.out.println(" 11  -Usuniêcie wszystkich wyst¹pieñ podanej liczby");
		System.out.println(" 12  -Usuniêcie wszystkich powtórzeñ elementów tablicy");
		System.out.println(" 13 -Wyœwietlenie tablicy");
		System.out.println(" 14 -Usuniêcie tablicy");
		System.out.println(" 15 -Wyjœcie");
		
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
					System.out.println("Suma wartoœci elementów tablicy");
					int result = tab.sum();
					System.out.println("Suma = " + result);
					break;

				case 5:
					System.out.println("Wartosæ maksymalna tablicy");
					try
					{
						result = tab.maxValue();
						System.out.println("Maksymalna wartoœæ = " + result);
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utwórz tablicê");
					}
					break;

				case 6:
					System.out.println("Indeks elementu maksymalnego tablicy");
					try
					{
						int index = tab.indexOfmaxValue();
						System.out.println("Index wartoœci max  = " + index);
					}
					catch(NullPointerException e) 
					{
						System.out.println("Najpierw utwórz tablicê");
					}
					break;

				case 7:
					System.out.println("Czy podana wartoœæ wystêpuje na którejœ z pocz¹tkowych pozycji tablicy");
					System.out.println("Wpisz wartoœæ oraz zakres");
					try 
					{
						boolean ret = tab.isInTable(menu.nextInt(), menu.nextInt());
						System.out.println(" Czy jest w tablicy  = " + ret);
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utwórz tablicê");
					}
					break;

				case 8: 
					System.out.println("Czy tablica jest ró¿nowartoœciowa");
					try
					{
						System.out.println(" Czy jest ró¿nowartoœciowa  = " + tab.isMultiValued());
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utwórz tablicê");
					}
					break;

				case 9: 
					System.out.println("Czy tablica jest ró¿nowartoœciowa- 2 sposób");
					try
					{
						System.out.println(" Czy jest ró¿nowartoœciowa2  = " + tab.isMultiValued2());
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utwórz tablicê");
					}
					break;

				case 10: 
					System.out.println("Czy tablica jest ró¿nowartoœciowa- 3 sposób");
					try
					{
						System.out.println(" Czy jest ró¿nowartoœciowa3  = " + tab.isMultiValued3());
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utwórz tablicê");
					}
					break;

				case 11: 
					System.out.println("Usuniêcie wszystkich wystapieñ podanej liczby");
					try
					{
						System.out.println("Wpisz liczbê do usuniêcia");
						tab.removeNumber(menu.nextInt());
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utwórz tablicê");
					}
					break;

				case 12: 
					System.out.println("Usuniêcie wszystkich powtórzeñ elementów tablicy");
					try 
					{
						tab.removeRepeating();
						tab.display();
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utwórz tablicê");
					}
					break;

				case 13:
					System.out.println("Wyœwietlenie tablicy");
					try
					{
						tab.display();
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utwórz tablicê");
					}
					
					break;

				case 14:
					System.out.println("Usuniêcie tablicy");
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

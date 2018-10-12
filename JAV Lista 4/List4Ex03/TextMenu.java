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
		System.out.println(" 1  -Stwórz tablicê o wybranym rozmiarze");
		System.out.println(" 2  -Manualna generaja tablicy");
		System.out.println(" 3  -Automatyczna generacja tablicy");
		System.out.println(" 4  -Wstaw element wskazany przez podany indeks");
		System.out.println(" 5  -Usuñ element wskazany przez podany indeks");
		System.out.println(" 6  -Usuñ element o podanej wartoœci");
		System.out.println(" 7  -Czy podana wartoœæ wystêpuje w tabeli");
		System.out.println(" 8  -Wyeliminuj powtórzenia");
		System.out.println(" 9  -Wyœwietlenie tablicy");
		System.out.println(" 10  -Usuniêcie tablicy");
		System.out.println(" 11  -Wyjœcie");
		
		System.out.println("==============================================");
	}

	public void textMenu()
	{
		cTableSorted tab = null;
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
					tab = new cTableSorted(menu.nextInt());
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
					System.out.println("Podaj index elementu jaki wstawiæ do tablicy");
					tab.insert(menu.nextInt());
					tab.display();
					break;

				case 5:
					System.out.println("Wpisz index elementu jaki usun¹æ z tablicy");
					try
					{
						tab.removeByIndex(menu.nextInt());
						tab.display();
						
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utwórz tablicê");
					}
					break;

				case 6:
					System.out.println("Podaj wartoœæ elementu jaki usun¹æ z tablicy");
					try
					{
						tab.removeNumber(menu.nextInt());
						tab.display();
					}
					catch(NullPointerException e) 
					{
						System.out.println("Najpierw utwórz tablicê");
					}
					break;

				case 7:
					System.out.println("Czy podana wartoœæ wystêpuje w tablicy");
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

				case 9:
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

				case 10:
					System.out.println("Usuniêcie tablicy");
					tab = null;
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

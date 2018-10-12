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
		System.out.println(" 1  -Stw�rz tablic� o wybranym rozmiarze");
		System.out.println(" 2  -Manualna generaja tablicy");
		System.out.println(" 3  -Automatyczna generacja tablicy");
		System.out.println(" 4  -Wstaw element wskazany przez podany indeks");
		System.out.println(" 5  -Usu� element wskazany przez podany indeks");
		System.out.println(" 6  -Usu� element o podanej warto�ci");
		System.out.println(" 7  -Czy podana warto�� wyst�puje w tabeli");
		System.out.println(" 8  -Wyeliminuj powt�rzenia");
		System.out.println(" 9  -Wy�wietlenie tablicy");
		System.out.println(" 10  -Usuni�cie tablicy");
		System.out.println(" 11  -Wyj�cie");
		
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
					System.out.println("Podaj index elementu jaki wstawi� do tablicy");
					tab.insert(menu.nextInt());
					tab.display();
					break;

				case 5:
					System.out.println("Wpisz index elementu jaki usun�� z tablicy");
					try
					{
						tab.removeByIndex(menu.nextInt());
						tab.display();
						
					}
					catch(NullPointerException e)
					{
						System.out.println("Najpierw utw�rz tablic�");
					}
					break;

				case 6:
					System.out.println("Podaj warto�� elementu jaki usun�� z tablicy");
					try
					{
						tab.removeNumber(menu.nextInt());
						tab.display();
					}
					catch(NullPointerException e) 
					{
						System.out.println("Najpierw utw�rz tablic�");
					}
					break;

				case 7:
					System.out.println("Czy podana warto�� wyst�puje w tablicy");
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

				case 9:
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

				case 10:
					System.out.println("Usuni�cie tablicy");
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

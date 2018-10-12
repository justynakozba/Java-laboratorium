import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class ContestantGenerator 
{
	// static table representing names
	private static String[] name = { "Adam", "Marek", "Jan", "Pawe�", "Tomasz",
									"Mariusz", "Anna", "Katarzyna", "Maria",
									"Zuzanna", "Paulina", "Magda", "Bartosz",
									"Piotr", "�ukasz", "Dariusz", "Cezary",
									"Arkadiusz", "Julian", "Artur", "W�odzimierz" };
	// static table representing last names
	private static String[] lastName = { "Nowak", "Kowalski", "Wi�niewski", "W�jcik", "Kowalczyk",
										"Kami�ski", "Lewandowski", "zieli�ski", "Szyma�ski",
										"Wozniak", "D�browski", "Koz�owski", "Jankowski",
										"Mazur", "Wojciechowski", "Kwiatkowski", "Krawczyk",
										"Kaczmarek", "Piotrowski", "Grabowski", "Zaj�c" };

	private final int maxContestantsNumber;
	private Scanner scan;

	// class constructor responsible for generating contestants
	public ContestantGenerator(int maxContestantsNumber) 
	{
		this.maxContestantsNumber = maxContestantsNumber;
		scan = new Scanner(System.in);
	}

	// function responsible for generating contestants
	public void generateAutomaticaly(List<Contestant> contestants, int contestantNumber)
	{
			Random rand = new Random();
			// check if contestants number is lower than 50
			if (contestantNumber > maxContestantsNumber)
			{
				System.out.println("Przekroczy�e� dozwolon� liczb� zawodnik�w : ");
				contestantNumber = maxContestantsNumber;
			}

			for (int i =0; i< contestantNumber; i++)
			{
				// create a new contestant
				Contestant cont = new Contestant(name[rand.nextInt(name.length)], lastName[rand.nextInt(lastName.length)], i+1);
				// Add contestant to array list.
				contestants.add(cont);
			}
	}

	// function responsible for manually generating  contestant list
	public void generateManually(List<Contestant> contestants, int contestantNumber)
	{
		if (contestantNumber > maxContestantsNumber)
		{
			System.out.println("Przekroczy�e� dozwolon� liczb� zawodnik�w : ");
			contestantNumber = maxContestantsNumber;
		}

		for (int i =0; i< contestantNumber; i++) 
		{
			Contestant cont = new Contestant();

			// Get contestant data from standard input and fulfill class fields.
			System.out.println("Wpisz imi�");
			cont.setName(scan.next());
			System.out.println("Wpisz nazwisko");
			cont.setLastName(scan.next()); 
			cont.setStartingNumber(i+1);

			// Add contestant to array list.
			contestants.add(cont);
		}
	}

	// function responsible for display contestant
	public void dispalyContestant(List<Contestant> contestants)
	{
		if(!contestants.isEmpty())
		{
			for(int i =0; i<contestants.size(); i++)
			{
				System.out.println("Zawodnik nr " + contestants.get(i).getStartingNumber() + "\n Imi�: " + contestants.get(i).getName()+ " Nazwisko" + contestants.get(i).getLastName());
				System.out.println("\t \t Zdobyte Punkty " + contestants.get(i).getCurrentPts());
			}
		}
		else
		{
			System.out.println("Nie ma zawodnik�w do wy�wietlania! Przed wykonaniem operacji wprowadz dane zawodnik�w");
		}
	}

	public void dispalyContestant(List<Contestant> contestants, int howMany)
	{
		if(!contestants.isEmpty())
		{
			if (howMany > contestants.size())
			{
				howMany = contestants.size();
				System.out.println("Nie mo�na wy�wietli� " + howMany + " zawodnik�w, poniewa� tylko " + contestants.size() + " wzi�o udzia� w zawodach");
				
			}
	
			for(int i =0; i<howMany; i++)
			{
				System.out.println("Zawodnik nr " + contestants.get(i).getStartingNumber() + "\n Imi�: " + contestants.get(i).getName()+ " Nazwisko" + contestants.get(i).getLastName());
				System.out.println("\t \t Zdobyte Punkty " + contestants.get(i).getCurrentPts());
			}
		}
		else
		{
			System.out.println("Nie ma zawodnik�w do wy�wietlania! Przed wykonaniem operacji wprowadz dane zawodnik�w");
		}
	}

}

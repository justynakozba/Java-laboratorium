import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;


public class TextMenu {

	private Scanner scan;
	private ContestantGenerator generator;
	private List<Contestant> contestants;
	private int howMany;
	private final int maxNrOfContestans;
	private final int maxNumEliminated1;
	private final int maxNumEliminated2;

	private enum series 
	{
		ELIMINATION,
		SERIES1,
		SERIES2;
	}

	private enum type 
	{
		AUTO,
		MANUALL,
	}

	public TextMenu() 
	{
		// 
		scan = new Scanner(System.in);
		howMany=0;
		contestants = new ArrayList<Contestant>();
		maxNrOfContestans = 200;
		maxNumEliminated1 = 50;
		maxNumEliminated2 = 30;
		generator = new ContestantGenerator(maxNrOfContestans); // Max cotestants number
	}

	// // function responsible for printing menu
	private void printMenu()
	{
		System.out.println("==============================================");
		System.out.println("Program skoki narciarskie");
		System.out.println("==============================================");
		System.out.println("Wpisz: ");
		System.out.println(" 0 - wyœwietl menu");
		System.out.println(" 1 - manualna generacja zawodników");
		System.out.println(" 2 - wyswietl liste zawdoników");
		System.out.println(" 3 - przeprowadz seriê eliminacyjn¹ ");
		System.out.println(" 4 - przeprowadz seriê 1");
		System.out.println(" 5 - przeprowadz seriê 2");
		System.out.println(" 6 - wyœwietl zawodnków zakwalifikowanych do serii 1 ");
		System.out.println(" 7 - wyœwietl zawodnków zakwalifikowanych do serii 2 ");
		System.out.println(" 8 - wyœwietl uporz¹dkowanie koñcowe");
		System.out.println(" 9 - przeprowadz kolejne zawody(skasuj poprzednie wyniki");
		System.out.println("==============================================");
		System.out.println("Opcje do testowania");
		System.out.println("==============================================");
		System.out.println(" 10 - automatyczna generacja zawodników");
		System.out.println(" 11 - symuluj seriê eliminacyjn¹ ");
		System.out.println(" 12 - symuluj seriê 1 ");
		System.out.println(" 13 - symuluj seriê 2 ");
		System.out.println(" 14 - symuluj ca³e zawody ");
		System.out.println("==============================================");
		System.out.println(" 15 - wyjscie");
		System.out.println("==============================================");
	}

	private void setData(Contestant contestant, series s, type t )
	{
		if( t == type.MANUALL)
		{
			System.out.println("Podaj dystans : ");
			int distance =  scan.nextInt();
			System.out.println("Podaj oceny sêdziów : ");
			int note1 = scan.nextInt();
			int note2 = scan.nextInt();
			int note3 = scan.nextInt();
			int note4 = scan.nextInt();
			int note5 = scan.nextInt();

			if( s == series.ELIMINATION)
			{
				contestant.JumpInElimination(distance, note1, note2, note3, note4, note5);
			}
			else if (s == series.SERIES1)
			{
				contestant.JumpInSeries1(distance, note1, note2, note3, note4, note5);
			}
			else if (s == series.SERIES2)
			{
				contestant.JumpInSeries2(distance, note1, note2, note3, note4, note5);
			}
			else
			{
				//error handling
				System.out.println("Nie ma takiej opcji, wyst¹pi³ b³¹d programu ... ");
				System.exit(1);
			}
		}
		else if (t == type.AUTO )
		{
			if( s == series.ELIMINATION)
			{
				contestant.JumpInElimination();
			}
			else if (s == series.SERIES1)
			{
				contestant.JumpInSeries1();
			}
			else if (s == series.SERIES2)
			{
				contestant.JumpInSeries2();
			}
			else
			{
				//error handling
				System.out.println("Nie ma takiej opcji, wyst¹pi³ b³¹d programu ... ");
				System.exit(1);
			}
		}
		else
		{
			//error handling
			System.out.println("Nie ma takiej opcji, wyst¹pi³ b³¹d programu ... ");
			System.exit(1);
		}
	}

	private void setContestanData(series s, type t)
	{
		if(!contestants.isEmpty())
		{
			for(int i =0; i<contestants.size(); i++)
			{
				if( s == series.ELIMINATION)
				{
					setData(contestants.get(i), s, t );
				}
				else if (s == series.SERIES1)
				{
					if (contestants.get(i).isInSeries1())
					{
						setData(contestants.get(i), s, t );
					}
				}
				else  if (s == series.SERIES2)
				{
					if (contestants.get(i).isInSeries2())
					{
						setData(contestants.get(i), s, t );
					}
				}
			}
		}
		else
		{
			System.out.println("Nie ma zawodników! Przed wykonaniem operacji wprowadz dane zawodników");
		}
	}

	private void calcResults(series s)
	{
		int tmpSize =0;

		if(!contestants.isEmpty())
		{
			Collections.sort(contestants);
		
			if( s == series.ELIMINATION)
			{
				//check if we have more than 50 contestants, otherwise all will go to next series.
				if (contestants.size() > maxNumEliminated1)
				{
					tmpSize=maxNumEliminated1;
				}
				else
				{
					tmpSize = contestants.size();
				}
			}
			else
			{
				//check if we have more than 30 contestants, otherwise all will go to next series.
				if (contestants.size() > maxNumEliminated2)
				{
					tmpSize=maxNumEliminated2;
				}
				else
				{
					tmpSize = contestants.size();
				}
			}
		
			for (int i = 0; i< tmpSize; i++)
			{
				if ( s == series.ELIMINATION)
				{
					//Qualified 50 contestants to first series
					contestants.get(i).setInSeries1(true);
				}
				else if ( s == series.SERIES1)
				{
					//Qualified 30 contestants to second series
					contestants.get(i).setInSeries2(true);
				}
			}
		}
		else
		{
			System.out.println("Nie ma zawodników! Przed wykonaniem operacji wprowadz dane zawodników");
		}

	}

	public void run()
	{
		printMenu();
		while(true)
		{
			int choice = scan.nextInt();
			switch (choice)
			{
				case 0:
					printMenu();
					break;

				case 1:
					System.out.println("Ilu zawodników wygenerowaæ : ");
					howMany = scan.nextInt();
					generator.generateManually(contestants, howMany);
					break;

				case 2:
					generator.dispalyContestant(contestants);
					break;

				case 3: //3 - przeprowadz seriê eliminacyjn¹;
					//wprowadz dane:
					calcResults(series.ELIMINATION);
					break;

				case 4: //przeprowadz seriê 1
					calcResults(series.SERIES1);
					break;

				case 5:
					calcResults(series.SERIES2);
					break;

				case 6:
					generator.dispalyContestant(contestants, 50);
					break;
				case 7:
					generator.dispalyContestant(contestants, 30);
				break;

				case 8:
					generator.dispalyContestant(contestants, 30);
				break;

				case 9:
					contestants.clear();
					break;
				case 10:
					System.out.println("Ilu zawodników wygenerowaæ : ");
					howMany = scan.nextInt();
					generator.generateAutomaticaly(contestants, howMany);
					break;

				case 11:
					setContestanData(series.ELIMINATION, type.MANUALL);
					break;

				case 12:
					setContestanData(series.SERIES1, type.MANUALL);
					break;

				case 13:
					setContestanData(series.SERIES2, type.MANUALL);
					break;

				case 14: // - simulate ski jumping competition
					System.out.println("Ilu zawodników wygenerowaæ : ");
					howMany = scan.nextInt();
					generator.generateAutomaticaly(contestants, howMany);
					setContestanData(series.ELIMINATION, type.AUTO);
					calcResults(series.ELIMINATION);
					generator.dispalyContestant(contestants, 50);

					System.out.println("\n \n \n \t \t SERIA 1 : ");

					setContestanData(series.SERIES1, type.AUTO);
					calcResults(series.SERIES1);
					generator.dispalyContestant(contestants, 30);

					System.out.println("\n \n \n \t \t SERIA 2 : ");

					setContestanData(series.SERIES2, type.AUTO);
					calcResults(series.SERIES2);
					generator.dispalyContestant(contestants, 30);

					break;

				case 15:
					System.exit(0);
					break;

				default:
					System.out.println("Nie ma Takiej opcji, wybierz 0 aby wyswietlc menu ");
					printMenu();
					break;
			}
		}
	}

}

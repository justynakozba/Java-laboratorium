import java.util.Random;

public class Jump
{

	private int distance;				// class field representing jump distance
	private int [] judgesNotes;			// class field witch is ints table representing judges notes
	private int points;					// class field representing all points
	private final int criticalPoint;	// class field representing critical points
	private final int ptsForMeter;		// class field representing points for meters
	private final int ptsForCritical;	// class field representing point
	
	// non-parametric constructor
	public Jump() 
	{
		distance = 0;
		points = 0;
		judgesNotes = new int[5];
		this.criticalPoint = 120;	// Setting critical point to 120m
		this.ptsForMeter = 2;		// Setting points for each meters to 2
		this.ptsForCritical = 60;	// Setting points for reaching critical point
		
	}

	// function responsible for setting distance
	public void setDistance(int distance) 
	{
		this.distance = distance;
	}

	// function calculate points for jump distance
	private int calcDistPts()
	{
		int distancePoints =0;
		if(distance > criticalPoint)
		{
			distancePoints = ptsForCritical;
			distancePoints += (distance - criticalPoint )*ptsForMeter;
		}
		else if (distance < criticalPoint)
		{
			distancePoints -= ((criticalPoint - distance )*ptsForMeter);
		}
		else
		{
			distancePoints= ptsForCritical;
		}

		return distancePoints;
	}

	//function responsible for setting judges notes
	public void setJudgesNotes(int note1, int note2, int note3, int note4, int note5)
	{
		judgesNotes[0] = note1;
		judgesNotes[1] = note2;
		judgesNotes[2] = note3;
		judgesNotes[3] = note4;
		judgesNotes[4] = note5;
	}
	
	// function responsible for calculate points for jump style
	private int calcStylePts()
	{
		int stylePoints = 0;
		int theLowest = 20;
		int theHightest = 0;
		for (int x:judgesNotes)
		{
			if(x > theHightest)
			{
				theHightest = x;
			}
			if (x < theLowest)
			{
				theLowest = x;
			}
			stylePoints += x; //sum all points
		}
		stylePoints -= (theLowest + theHightest) ; //removing the highest and the lowest note

		return stylePoints;
	}

	// function responsible for calculating sum of points
	public void calcPts()
	{
		points = calcDistPts() + calcStylePts();
	}

	// function responsible for getting points
	public int getPts()
	{
		return points;
	}

	// function responsible for simulation jump  
	public void simulateJump()
	{
		Random rand = new Random();
		// Getting random number from range 90 to 170
		int max = criticalPoint + 50;
		int min  = criticalPoint - 30;
		distance =rand.nextInt((max - min) + 1) + min;

		for (int i =0; i < judgesNotes.length; i++)
		{
			// Getting random number from range 0 o 20
			judgesNotes[i]=rand.nextInt(20);
		}

		calcPts();
	}
}

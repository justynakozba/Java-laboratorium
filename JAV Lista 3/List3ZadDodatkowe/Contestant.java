public class Contestant implements Comparable<Contestant>
{
	private String name;			// class field representing contestant name
	private String lastName;		// class field representing  contestant last name
	private int startingNumber;		// class field representing starting number
	private boolean series1;		// class field representing if contestant has qualified to series 1
	private boolean series2;		// class field representing if contestant has qualified to series 2
	private int currentPts;			// class field representing current points
	private Jump eliminationJump;	// class field of type Jump representing jump performed in elimination by contestant
	private Jump series1Jump;		// class field of type Jump representing jump performed in series1 by contestant
	private Jump series2Jump;		// class field of type Jump representing jump performed in series2 by contestant

	// non-parametric constructor
	public Contestant()
	{
		name=" ";
		lastName=" ";
		startingNumber=0;
		eliminationJump = new Jump();
		series1 = false;
		series2 = false;
	}

	// parametric constructor
	public Contestant(String name, String lastName, int number)
	{
		this.name =name;
		this.lastName = lastName;
		startingNumber = number;
		eliminationJump = new Jump();
		series1 = false;
		series2 = false;
	}

	// function responsible for getting name
	public String getName()
	{
		return name;
	}

	// function responsible for setting name
	public void setName(String name)
	{
		this.name = name;
	}

	// function responsible for getting last name
	public String getLastName()
	{
		return lastName;
	}

	// function responsible for setting last name
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	// function responsible for getting starting number
	public int getStartingNumber()
	{
		return startingNumber;
	}

	// function responsible for setting starting number
	public void setStartingNumber(int startingNumber)
	{
		this.startingNumber = startingNumber;
	}

	public void setInSeries1(boolean series1)
	{
		this.series1 = series1;
	}
	
	public boolean isInSeries1()
	{
		return series1;
	}
	
	public void setInSeries2(boolean series2)
	{
		this.series2 = series2;
	}
	
	public boolean isInSeries2()
	{
		return series2;
	}

	// function responsible for setting distance and calculating points
	public void JumpInElimination(int distance, int note1, int note2, int note3, int note4, int note5)
	{
		eliminationJump.setDistance(distance);
		eliminationJump.setJudgesNotes(note1, note2, note3, note4, note5);
		eliminationJump.calcPts();
		currentPts = eliminationJump.getPts();
	}

	// function responsible for simulating jump
	public void JumpInElimination()
	{
		eliminationJump.simulateJump();
		currentPts =eliminationJump.getPts();
	}

	// function responsible for getting current points
	public int getCurrentPts()
	{
		return currentPts;
	}

	//override
	public int compareTo(Contestant compareContestant)
	{
		//FIXME: we compare only elimination points this should be generic 
		int comparePts = ((Contestant)compareContestant).currentPts;
		return comparePts -this.currentPts;
	}

	public void JumpInSeries1(int distance, int note1, int note2, int note3, int note4, int note5)
	{
		series1Jump = new Jump();
		series1Jump.setDistance(distance);
		series1Jump.setJudgesNotes(note1, note2, note3, note4, note5);
		series1Jump.calcPts();
		currentPts = series1Jump.getPts();
	}

	public void JumpInSeries1()
	{
		series1Jump = new Jump();
		series1Jump.simulateJump();
		currentPts =series1Jump.getPts();
	}

	public void JumpInSeries2(int distance, int note1, int note2, int note3, int note4, int note5)
	{
		series2Jump = new Jump();
		series2Jump.setDistance(distance);
		series2Jump.setJudgesNotes(note1, note2, note3, note4, note5);
		series2Jump.calcPts();
		currentPts += series2Jump.getPts();
	}

	public void JumpInSeries2()
	{
		series2Jump = new Jump();
		series2Jump.simulateJump();
		currentPts +=series2Jump.getPts();
	}

}

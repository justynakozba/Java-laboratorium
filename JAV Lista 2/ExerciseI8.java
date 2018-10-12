// inherit class ExerciseI6
public class ExerciseI8 extends ExerciseI6 
{
	// Euclidean algorithm without the use of modulo function
	public void calc()
	{
		while(this.getM() != this.getN()) 
		{
			while(getM() > getN())
			{
	            setM(getM() - getN());
	        }
	        while(getN() > getM()) 
	        {
	            setN( getN() - getM());
	        }
	    }
	    setK(getM());
	}
}

// inherit class ExerciseI6
public class ExerciseI7 extends ExerciseI6 
{
	// Euclidean algorithm with the use of modulo function
	public void calc()
	{
		int tmp;                    
	    while(getN() != 0)             
	    {
	        tmp = getM() % getN();              
	        setM(getN());                
	        setN(tmp);              
	    }
	    setK(getM());               
	}
}

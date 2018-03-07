package tdt4140.gr1805.app.core;
import java.lang.Math;

public class SuperMethods
{
	boolean checkIfString(Object obj)		// Just checks if what is passed to it is a string and returns a boolean
	{
		if (obj instanceof String)			// Checks if obj is a String
		{
			return true;					// If obj was a String, return true
		}
		else return false;					// Else return false
	}
	
	boolean checkIfInt(Object obj)			// Just checks if what is passed to it is an integer and returns a boolean
	{
		if (obj instanceof Integer)			
		{
			return true;
		}
		else return false;
	}
	
	boolean checkIfDouble(Object obj)		// Just checks if what is passed to it is a double and returns a boolean
	{
		if (obj instanceof Double)
		{
			return true;
		}
		else return false;
	}
	
	boolean checkIfFloat(Object obj)		// Just checks if what is passed to it is a float and returns a boolean
	{
		if (obj instanceof Float)
		{
			return true;
		}
		else return false;
	}

	int stringToInt(Object obj)				// Converts a String to an int
	{
		if (!checkIfString(obj))			// If obj is not a String, throw exception
		{
			throw new IllegalArgumentException("Argument not a String.");
		}
		else
		{
			try
			{								// Tries to parse the string to an integer value
				return Integer.parseInt((String)obj);	
			}
			catch (Exception e)
			{								// If it could not parse the string, throws exception with trace.
				throw new IllegalArgumentException("Could not convert to int.", e);
			}
		}
	}
	
	int doubleToInt(Object obj)				// Converts a Double to an int
	{
		if (!checkIfDouble(obj))			// If obj was not a double then we throw exception
		{
			throw new IllegalArgumentException("Argument is not a double.");
		}
		else
		{
			try
			{
				return (obj == null) ? null : (int)Math.round(Double.valueOf((double)obj)); //Integer.valueOf(((Double) obj).intValue());
				
			}
			catch (Exception e)
			{
				throw new IllegalArgumentException("Could not convert to int", e);
			}
		}
	}

	/*
	int floatToInt(Object obj)				// Converts a Float to an int
	{
		if (!checkIfFloat(obj))
		{
			throw new IllegalArgumentException("Argument is not a float");
		}
		else 
		{
			try
			{								// Checks if obj was null, if so it returns null, else it returns a rounded int of obj
				return (obj == null) ? null : Math.round((float) obj);
			}
			catch (Exception e)
			{
				throw new IllegalArgumentException("Could not convert to int.", e);
			}
		}
	}
	*/
	
	int convertToInt(Object obj)			// Converts the argument to an int
	{
		if (checkIfInt(obj))
		{
			return (int)obj;
		}
		else if (checkIfString(obj)) 
		{
			return stringToInt(obj);
		}
		else if (checkIfDouble(obj)) 
		{
			return doubleToInt(obj);
		}
/*		else if (checkIfFloat(obj)) 
		{
			return floatToInt(obj);
		}*/
		else throw new IllegalArgumentException("Argument was not Integer, String or Double");
	}
	
	
	public double calculateAverage(int[] input)
	{
		int size = input.length;		// Starts with assigning the size of the list passed as argument.
		if (size <=0)					// If the size is 0, we throw exception
		{
			throw new IllegalArgumentException("Must pass a list with at least 1 number");
		}
		else if (size == 1)				// If size is 1, we return the value
		{
			return (double) input[0];
		}
		else
		{
			int sum = 0;
			for (int i = 0; i < input.length; i++)
			{
				sum += input[i];				
			}
			double average = sum/size;
			return average;
		}
	}
	
/*	
	public static void main(String [] args)
	{
		SuperMethods antad = new SuperMethods();
		System.out.println(antad.checkIfString("aadas"));	// True
		System.out.println(antad.checkIfString(1));			// False
		System.out.println(antad.stringToInt("10"));		// 10
	//	System.out.println(antad.stringToInt(10));			// Throws exception
	//	System.out.println(antad.stringToInt("ten"));		// Throws exception
		System.out.println(antad.checkIfDouble(0.5f));		// False
		System.out.println(antad.checkIfDouble(0.5));		// True
		System.out.println(antad.doubleToInt(2.5));
		System.out.println(antad.convertToInt(5123151231.15123151f));
		System.out.println(5123151231.15123151f);
		System.out.println(antad.doubleToInt(5123151231.15123151));
		System.out.println(antad.convertToInt(23151231.1f));
		System.out.println(123151231.15126f);
		System.out.println(antad.doubleToInt(123151231.15126));
	}
*/
	


}



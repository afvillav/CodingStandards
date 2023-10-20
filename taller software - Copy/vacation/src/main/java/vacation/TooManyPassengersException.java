// Copyright (C) 2020
// All rights reserved
package vacation;

public class TooManyPassengersException extends Exception 
{
	public String getMessage() {
		return super.getMessage() + "Too many passengers, limit is 80";
	}
}

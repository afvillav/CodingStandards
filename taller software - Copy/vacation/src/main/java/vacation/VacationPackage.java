// Copyright (C) 2020
// All rights reserved
package vacation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class VacationPackage 
{
	private String tripDestination;
	private int numberPassengers;
	private int durationDays;
	private int baseCost;
	/**
	 * This is the constructor of the class.
	 */
	public VacationPackage(String destination, int passengers, int duration) throws TooManyPassengersException {
		baseCost=1000;
		if(passengers<80) {
			numberPassengers=passengers;
		}else {
			throw new TooManyPassengersException();
		}
		tripDestination=destination;
		durationDays=duration;
	}
	/**
	 * This method checks if the destination of a trip
	 * is a popular one (New york or Paris).
	 * @return boolean if is popular.
	 */
	public boolean isPopular() {
		if (tripDestination.equals("Paris")) {
			int fee = 500;
			baseCost += fee;
			return true;
		}if (tripDestination.equals("New York")) {
			int fee = 500;
			baseCost += fee;
			return true;
		} else {
			return false;
		}
	}	
	/**
	 * This method checks if there is a discount
	 * based on the number of passengers.
	 * @return the value of the discount.
	 */
	public double discountPassenger() {
		if (numberPassengers<10 && numberPassengers>4) {
			return 0.10;
		}if (numberPassengers>10) {
			return 0.20;
		}else {
			return 0;
		}
	}
	/**
	 * This method checks if there is a discount
	 * based on the duration of trip.
	 * @return the value of the fee discount.
	 */
	public int discountDuration() {
		if(durationDays<7) {
			return -200;
		}else {
			return 0;
		}
	}
	/**
	 * This method checks if the trip is
	 * valid for a promotion.
	 * @return boolean if valid for promotion.
	 */
	public boolean promotion() {
		if(durationDays>30 || numberPassengers==2) {
			baseCost-=200;
			return true;
		}else {
			return false;
		}
	}
	/**
	 * This method calculates the cost
	 * of the trip.
	 * @return the total cost of the trip.
	 */
	public double getCost() {
		double finalCost=0;
		this.isPopular();
		this.promotion();
		int calculation=this.baseCost+this.discountDuration();
	    finalCost= calculation-(calculation*this.discountPassenger());
		return finalCost;
	}
	/**
	 * This is the main method.
	 */
//CHECKSTYLE:OFF
	public static void main(String[] args) throws TooManyPassengersException, IOException {
//"CHECKSTYLE:ON		
		System.out.println("Welcome to the cost calculator of your vacation package system");
		Scanner input= new Scanner(System.in);
		BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the days of duration of your trip:");
		int duration= input.nextInt();
		System.out.println("Enter the number of passengers of your trip:");
		int passengers= input.nextInt();
		System.out.println("Enter the destination of your trip:");
		String destination= reader.readLine();
		VacationPackage prueba= new VacationPackage(destination, passengers, duration);
		System.out.println("The cost of your trip is:");
		System.out.println(prueba.getCost());
	}
}

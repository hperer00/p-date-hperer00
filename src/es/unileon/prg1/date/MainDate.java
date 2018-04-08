package es.unileon.prg1.date;

public class MainDate {

	public static void main(String[] args) throws DateException {

		Date today = new Date(20, 3, 2018);
		Date tomorrow = new Date(21, 3, 2018);

		System.out.println(("Today is: " + today.toString()));
		System.out.println(today + " is the same day " + tomorrow + "? " + today.isSameDay(tomorrow));
		System.out.println(today + " is the same month " + tomorrow + "? " + today.isSameMonth(tomorrow));
		System.out.println(today + " is the same year " + tomorrow + "? " + today.isSameYear(tomorrow));
		System.out.println("The month " + today.nameMonth(today.getMonth()) + " has " + today.daysOfMonth(today.getMonth()) + " days.");
		System.out.println("The season is: " + today.nameSeason(today.getMonth()));
		System.out.println("These months are missing by the end of the year: " + today.monthsLeft(today.getMonth()));
		System.out.println("These days are missing by the end of the month: " + today.datesLeft());
		System.out.println("These months have the same number of days as the month of this date: " + today.sameDaysMonth(today.getMonth()));
		System.out.println("It has been " + today.numberDaysLeft() + " days since the year began");
		System.out.println("Number of attemps: " + today.randomAttempts());

	}

}

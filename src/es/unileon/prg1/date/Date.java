package es.unileon.prg1.date;

public class Date {

	private int day, month, year;

	// Constructores
	public Date(int day, int month, int year) throws DateException {

		StringBuffer mensaje = new StringBuffer();
		int diaMes = daysOfMonth(month);

		if (month < 1 || month > 12) {
			// error
			mensaje.append("Error, mes incorrecto");

		}

		if (day < 1 || day > 31) {
			// error
			mensaje.append("Error, dia incorrecto");

		}

		else if (day > diaMes) {
			// error
			mensaje.append("Error, dia incorrecto");

		}

		if (mensaje.length() > 0) {

			throw new DateException(mensaje.toString());

		} else {

			this.day = day;
			this.month = month;
			this.year = year;
		}
	}

	public Date() {

		this.day = 1;
		this.month = 1;
		this.year = 2018;

	}

	public Date(Date fecha) {

		this.day = fecha.day;
		this.month = fecha.month;
		this.year = fecha.year;

	}

	// Getter y setter
	public int getDay() {
		return day;
	}

	public void setDay(int day) throws DateException {

		StringBuffer mensaje = new StringBuffer();

		if (day > daysOfMonth(getMonth()) || day < 1) {
			mensaje.append("Error al introducir el dia");
		}
		if (mensaje.length() > 0) {
			throw new DateException(mensaje.toString());
		} else {
			this.day = day;
		}
	}

	public int getMonth() throws DateException {
		return month;
	}

	public void setMonth(int month) throws DateException {

		StringBuffer mensaje = new StringBuffer();

		if (month < 1 || month > 12) {
			mensaje.append("Error al introducir el mes");
		}

		int diasMes = daysOfMonth(month);
		if (day > diasMes) {
			mensaje.append("Error, el mes no tiene tantos dias");
		}

		if (mensaje.length() > 0) {
			throw new DateException(mensaje.toString());
		} else {
			this.month = month;
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	boolean isSameYear(Date other) {

		if (year == other.year) {
			return true;
		} else {
			return false;
		}
	}

	boolean _isSameYear(Date other) {

		return year == other.getYear();
	}

	boolean isSameMonth(Date other) {

		if (month == other.month) {
			return true;
		} else {
			return false;
		}
	}

	boolean _isSameMonth(Date other) throws DateException {

		return month == other.getMonth();
	}

	boolean isSameDay(Date other) {

		if (day == other.day) {
			return true;
		} else {
			return false;
		}
	}

	boolean _isSameDay(Date other) throws DateException {

		return day == other.getDay();
	}

	boolean isSame(Date other) {

		if (year == other.year && month == other.month && day == other.day) {
			return true;
		} else {
			return false;
		}
	}

	public int daysOfMonth(int month) {

		switch (month) {

		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		case 2:
			return 28;
		default:
			return -1;

		}

	}

	public String nameMonth(int month) {
		switch (month) {

		case 1:
			return "January";
		case 2:
			return "February";
		case 3:
			return "March";
		case 4:
			return "April";
		case 5:
			return "May";
		case 6:
			return "June";
		case 7:
			return "July";
		case 8:
			return "August";
		case 9:
			return "September";
		case 10:
			return "October";
		case 11:
			return "November";
		case 12:
			return "Decembre";
		default:
			return "Error, numero de mes incorrecto";

		}
	}

	public String nameSeason(int month) {
		switch (month) {

		case 12:
		case 1:
		case 2:
			return "Winter";
		case 3:
		case 4:
		case 5:
			return "Spring";
		case 6:
		case 7:
		case 8:
			return "Summer";
		case 9:
		case 10:
		case 11:
			return "Autumn";
		default:
			return "Error, numero de mes incorrecto";
		}

	}

	public String monthsLeft(int month) throws DateException {

		String num = "";

		for (int i = getMonth(); i <= 12; i++) {
			num = num + nameMonth(i) + " ";
		}

		return num;

	}

	public String datesLeft() throws DateException {

		Date contador[] = new Date[50];
		String meses = "";

		for (int i = getDay(); i <= daysOfMonth(getMonth()); i++) {
			day = i;
			month = getMonth();
			year = getYear();
			contador[i] = new Date(day, month, year);
			if (contador[i] != null) {

				meses = meses + toString() + " ";
			}
		}

		return meses;

	}

	public String sameDaysMonth(int month) {

		int days;
		String m = "";

		days = daysOfMonth(month);

		for (int i = 1; i <= 12; i++) {
			if (days == daysOfMonth(i)) {

				m = m + nameMonth(i) + " ";

			}
		}

		return m;
	}

	public int numberDaysLeft() throws DateException {

		int sumatorio = 0;

		for (int i = 1; i < getMonth(); i++) {

			sumatorio = sumatorio + daysOfMonth(i);

		}

		return sumatorio + getDay();
	}

	public int randomAttempts() throws DateException {

		int randomDay = 0;
		int randomMonth = 0;
		int contador = 0;

		do {
			randomDay = (int) (Math.random() * 31);
			randomMonth = (int) (Math.random() * 12);
			contador++;
		} while (randomDay != getDay() || randomMonth != getMonth());

		return contador;
	}

	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

}

public abstract class Date {
    // private instance variables: year, month and day values
    private int year;
    private int month;
    private int day;

    // constructor
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // add days to calendar method
    public void addDays(int days) {
        for (int i = 0; i < days; i++) {
            // add day
            day++;

            // if the day count is greater than the number of days in month, reset the day to 1 and increment the month
            if (day > this.getNumberOfDaysInMonth(year, month)) {
                day = 1;
                month++;

                // if the month count is 13, reset the month count and increment the year
                if (month == 13) {
                    month = 1;
                    year++;
                }
            }
        }
    }

    // subtract days from calendar method
    public void subtractDays(int days) {
        for (int i = 0; i < days; i++) {
            // decrement the day count
            day--;

            if (day == 0) {
                // if day reaches zero, decrement the month count
                month--;

                // if the month reaches zero, reset the month to 12 and decrement the year
                if (month == 0) {
                    month = 12;
                    year--;
                }

                // set the day to how many days are in the current month
                day = this.getNumberOfDaysInMonth(year, month);
            }
        }
    }

    public boolean isLeapYear() {
        return isLeapYear(year);
    }

    public abstract boolean isLeapYear(int year);

    // prints calendar date (no carriage return) in mm/dd/yyyy format
    public void printShortDate() {
        System.out.printf("%d/%d/%d", month, day, year);
    }

    // prints the calendar date (no carriage return) in MonthName dd, yyyy
    public void printLongDate() {
        System.out.printf("%s %d, %d", getMonthName(month), day, year);
    }

    private int getNumberOfDaysInMonth(int year, int month) {  // returns number of days in month (for a year)

        switch (month) {
            // for these months, return 31
            case 1, 3, 5, 7, 8, 10, 12:
                return 31;
            case 2:
                // if february, check if leap year. If so, return 29, else return 28
                if (isLeapYear(year)) { return 29; }
                else { return 28; }

                // for these months return 30
            case 4, 6, 9, 11:
                return 30;

            // default is a -1 (should not happen because of the conditionals in addDay/subtractDay)
            default:
                return -1;
        }
    }

    private int getNumberOfDaysInYear(int year) {  // returns the number of days in a month (for a year) (possible that I won't use it)
        if (isLeapYear(year)) {  // if leap year return 366
            return 366;
        } else { return 365; }  // else return 365
    }

    private String getMonthName(int month) {  // returns the name of a month; first letter capitalized, remainder lowercase
        return switch (month) {
            // return switch statement: each case from 1-12 returns its corresponding month name
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "Invalid Input";
        };
    }

    // accessor methods

    public int getDayOfMonth() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public String getMonthName() {
        return getMonthName(month);  // return the result of the getMonthName(month) method
    }

    public int getYear() {
        return year;
    }
}


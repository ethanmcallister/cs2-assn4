public class JulianDate extends Date {

    // default constructor
    public JulianDate() {
        super(1, 1, 1);

        // add in number of days until (Gregorian) January 1, 1970.
        final int NUM_DAYS_UNTIL_UNIX_EPOCH = 719164;
        addDays(NUM_DAYS_UNTIL_UNIX_EPOCH);

        // compute amount of days since unix epoch (from today)
        int numOfDaysSinceUnixEpoch = (int) ((System.currentTimeMillis() + java.util.TimeZone.getDefault().getRawOffset()) / 1000 / 60 / 60 / 24);
        super.addDays(numOfDaysSinceUnixEpoch);
    }

    // overloaded constructor
    public JulianDate(int year, int month, int day) {
        super(year, month, day);
    }

    @Override
    public boolean isLeapYear() {
        return isLeapYear(super.getYear());
    }

    @Override
    // use this method when doing things like determining how many days are in a month, for a particular year.
    public boolean isLeapYear(int year) {
        // check if year is divisible by 4 and not by 100 or if year is divisible by 400
        return (year % 4 == 0);
    }
}

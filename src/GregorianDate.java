public class GregorianDate extends Date {

    // default constructor
    public GregorianDate() {
        super(1970, 1, 1);

        // compute days since unix epoch using System.currentTimeMillis() and getRawOffset() methods
        int numOfDays = (int) ((System.currentTimeMillis() + java.util.TimeZone.getDefault().getRawOffset()) / 1000 / 60 / 60 / 24);
        super.addDays(numOfDays);
    }

    // overloaded constructor
    public GregorianDate(int year, int month, int day) {
        super(year, month, day);
    }

    @Override
    public boolean isLeapYear() {
        return isLeapYear(super.getYear());
    }

    @Override
    public boolean isLeapYear(int year) {
        // check if year is divisible by 4 and not by 100 or if year is divisible by 400
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }


}

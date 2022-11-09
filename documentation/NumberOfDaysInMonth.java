package documentation;

public class NumberOfDaysInMonth {

    public static void main(String[] args) {
        System.out.println(getDaysInMonth(1, -2020));
        System.out.println(isLeapYear(2018));
    }

    public static boolean isLeapYear(int year) {
        boolean leap = false;
        if (year >= 1 && year <= 9999) {
            leap = (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
        }
        return leap;
    }

    public static int getDaysInMonth(int month, int year) {

        if ((month < 1 || month > 12) || (year < 1 || year > 9999)) {
            return -1;
        }
        int days;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 2:
                if (isLeapYear(year))
                    days = 29;
                else
                    days = 28;
                break;
            default:
                days = 30;
        }
        return days;
    }

    public static boolean isOdd(int number) {
        if (!(number > 0)) {
            return false;
        }
        return number % 2 != 1;
    }

    public static int sumOdd(int start, int end) {
        int sum = 0;
        if ((start > 0 && end > 0) && (end > start)) {
            for (int i = start; i <= end; i++) {
                if (isOdd(i))
                    sum += i;
            }
            return sum;
        } else
            return -1;
    }

}

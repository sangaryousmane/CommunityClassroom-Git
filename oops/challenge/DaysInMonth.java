package oops.challenge;

public class DaysInMonth {

    public static void main(String[] args) throws Throwable {
        int result = getNumberOfDays(2024, 2);
        System.out.println(result);
    }

    static int getNumberOfDays(int year, int month) throws Throwable {

        int days = 0;
        switch (month){
            case 1, 3, 5, 7,8,10,12-> days=31;
            case 4,6,9,11 -> days=30;
            case 2 -> {
                if (isLeap(year))
                    days=29;
                else
                    days=28;
                return days;
            }
        }
        return days;
    }

    static boolean isLeap(int year) {
        if (year % 4 == 0) {
            if (year % 100 != 0) {
                return true;
            }
            return year % 400 == 0;
        }
        return false;
    }

}

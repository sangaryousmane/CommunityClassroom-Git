package oops.challenge;

import exceptionhandlings.InvalidTestScore;

import static documentation.Document.scanner;

public class Main {

    public static void main(String[] args) throws InvalidTestScore {
       scoresSimulate();
    }

    private static void retailItemExecute() {
        RetailItem retailItem1=new RetailItem("Jacket", 12 ,59.95);
        RetailItem retailItem2=new RetailItem("Designer Jeans", 40, 34.95);
        RetailItem retailItem3=new RetailItem("Shirt", 20, 24.95);
        System.out.println("Item #1 "+ retailItem1);
        System.out.println("Item #2 "+ retailItem2);
        System.out.println("Item #3 "+ retailItem3);
    }

    private static void testScoresExecute(){
        TestScores scores=new TestScores(99, 89, 77);
        System.out.println(scores);
        System.out.println("Total sum is: "+ scores.sum());
        System.out.printf("Average Score is: %d ", Math.round(scores.averageTestScore()));
    }

    private static int getNumberOfDays(int year, int month){
        int days;
        if (month <1 || month >12){
            throw new IllegalArgumentException("Sorry! month range is from 1-12");
        }

        switch (month){
            case 1,3, 5, 7, 8, 10, 12: days=31; break;
            case 9, 4, 6, 11: days=30;break;
            case 2:
                 if(isLeap(year))
                     days=29;
                 else
                     days=28;
                 break;
            default: days=-1;
        }

        return days;
    }

    private static boolean isLeap(int year){
        if (year%4==0){
            if (year%100 !=0)
                return true;
            else
                return year % 400 == 0;
        }
        return false;
    }

    static void temperatureSimulate(){
        int temp=scanner.nextInt();
        FreezingAndBoilingPoint fbPoint=new FreezingAndBoilingPoint(temp);

        if (fbPoint.isOxygenBoiling()){
            System.out.println("Will boil at: "+ temp + " C");
        }else {
            System.out.println(temp + " C");
        }
    }

    static void scoresSimulate() throws InvalidTestScore {
        int[] arr={99, 90, 98};

        exceptionhandlings.TestScores testScores=new exceptionhandlings.TestScores(arr, arr[0], arr[1],arr[2]);
        System.out.println(testScores.averageTestScore());
    }



}

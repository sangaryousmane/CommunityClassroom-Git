package oops;

import java.util.ArrayList;
import java.util.Random;

public class Utils{

    public static void main(String[] args) {
        ArrayList<Integer> names = new ArrayList<>();
        names.add(0);
        names.add(10);
        names.add(100);
        names.add(0, 500);
//        names.forEach(System.out::println);

//        System.out.println("After replacing");
        names.set(0, 2000);
//        names.forEach(System.out::println);

        Random random=new Random();
        int rand=random.nextInt(10) + 1;
        System.out.println(rand);
    }
}

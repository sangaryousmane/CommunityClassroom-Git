package oops.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        List<Laptop> laptops = new ArrayList<>();
        laptops.add(new Laptop(8, 300, "Mac"));
        laptops.add(new Laptop(16, 200, "Dell"));
        laptops.add(new Laptop(4, 120, "HP"));

        // Implementing comparator:
       Comparator<Laptop> comparator=new Comparator<Laptop>() {
           @Override
           public int compare(Laptop o1, Laptop o2) {
               if (o1.getPrice() > o2.getPrice())
                   return 1;
               else
                   return 0;
           }
       };

        laptops.sort(comparator);

        laptops.forEach(System.out::println);

//
//        for (Laptop lap: laptops){
//            System.out.println(lap);
//        }

//        String a="a", b="b";
//
////        System.out.println(a.compareTo(b)); // returns -1
////        System.out.println(b.compareTo(a)); // returns 1
////        System.out.println(b.compareTo(b)); // returns 0
//        System.out.println(Integer.compare(30,2)); // x > y
//        System.out.println(Integer.compare(30, 30)); // x == y
//        System.out.println(Integer.compare(2, 30)); // x < y

    }
}

class Laptop implements Comparable<Laptop>{
    private int ram;
    private int price;
    private String brand;

    public Laptop(int ram, int price, String brand) {
        this.ram = ram;
        this.price = price;
        this.brand = brand;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "ram=" + ram +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                '}';
    }

    @Override
    public int compareTo(Laptop o) {
        if (this.getPrice() > o.getPrice()){
            return 1;
        }
        else{
            return -1;
        }
    }

//    @Override
//    public int compareTo(Laptop laptop) {
//        if (this.getRam() > laptop.getRam())
//            return 1;
//        else
//            return -1;
//    }
}

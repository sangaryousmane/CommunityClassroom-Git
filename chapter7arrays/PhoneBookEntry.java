package chapter7arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookEntry {

    private String number;
    private String name;

    public PhoneBookEntry(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "PhoneBookEntry{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        PhoneBookEntry bailo=new PhoneBookEntry("2221551207", "Samba Bailo Diallo");
        PhoneBookEntry eastgar=new PhoneBookEntry("2221551117", "Eastgar");
        PhoneBookEntry kumshe=new PhoneBookEntry("2221551423", "Kumshe");

        List<PhoneBookEntry> entries=new ArrayList<>();
        entries.add(bailo);
        entries.add(eastgar);
        entries.add(kumshe);

        entries.forEach(System.out::println);
    }
}

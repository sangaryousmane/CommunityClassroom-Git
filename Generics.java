import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Generics can have a type of any classes. <T>
 * It can also be bounded to a specific class. <T extends Number>
 * @param <T>
 */
public class Generics <T extends Number & Serializable>{

    private T t; // This should be a wrapper class, not primitive type

    public Generics(T t){
        this.t=t;
    }

    public void print(){
        System.out.println(t);
    }

    // Generics use in method header...
    public static <T, U> void read(T t, U u){
        System.out.println(t);
    }

    // Wildcard character of generics
    public static void print(List<?> list){
        System.out.println(list);
    }


    public static void main(String[] args) {
        Generics<Long> t=new Generics<>(500L + 400L);
        List<Double> doubles=new ArrayList<>();
        print(doubles);
        t.print();
        read("John is going to school...", 60);
    }
}

package remaster.tim;

import java.util.ArrayList;
import java.util.List;

public class UnInformed {
    private final List<String> unInformed=new ArrayList<>();



    // add search type
    // remove search type
    // modify search type
    // return searchType


    private void addSearch(String item){
        if (!(item==null))
            unInformed.add(item);
    }

    private void remove(int position){
        unInformed.remove(unInformed.get(position));
    }

    private void modify(String newItem, int position){
        unInformed.set(position-1, newItem);
    }

    private String getItem(String item){
        int index = unInformed.indexOf(item);

        if (index >=0)
            return unInformed.get(index);
        return " ";
    }
}

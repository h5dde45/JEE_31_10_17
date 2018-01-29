package tv_26_01.p10;

import java.util.ArrayList;
import java.util.List;

public class Container {
    public static final List<String> list=new ArrayList<>();

    public synchronized void addEntry(String s){
        list.add(s);
    }

}

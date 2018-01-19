package tv_15_01.mltthr;

import java.util.ArrayList;
import java.util.List;

public class Container {
    private static final List<String> list=new ArrayList<>();

    synchronized void addEntry(String s){
        list.add(s);
    }
}

package tv_15_01.mltthr.p10;

import java.util.ArrayList;
import java.util.List;

public class Container {
    private final List<String> list=new ArrayList<>();

    synchronized void addEntry(String s){
        list.add(s);
    }
    public long size(){
        return list.size();
    }
}

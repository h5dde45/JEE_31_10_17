package test.newthread.p5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        NameList nameList = new NameList();
        nameList.add("first");

        class NewThread extends Thread{
            @Override
            public void run() {
                System.out.println(nameList.removeFirst());
            }
        }
        NewThread newThread = new NewThread();
        newThread.setName("one");
        newThread.start();
        new NewThread().start();

    }

    static class NameList {
        private List<String> list = Collections.synchronizedList(new ArrayList<>());

        public void add(String name) {
            list.add(name);
        }

        public synchronized String removeFirst() {
            if (list.size() > 0) {
                if(Thread.currentThread().getName().equals("one")){
                    Thread.yield();
                }
                return list.remove(0);
            }
            return null;
        }
    }
}

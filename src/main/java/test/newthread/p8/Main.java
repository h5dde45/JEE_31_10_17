package test.newthread.p8;

public class Main {
    public static void main(String[] args) {
        ResourceA resourceA = new ResourceA();
        ResourceB resourceB = new ResourceB();
        resourceA.resourceB = resourceB;
        resourceB.resourceA = resourceA;
        NewThread_1 newThread_1 = new NewThread_1();
        NewThread_2 newThread_2 = new NewThread_2();
        newThread_1.resourceA = resourceA;
        newThread_2.resourceB = resourceB;
        newThread_1.start();
        newThread_2.start();

    }
}

class NewThread_1 extends Thread {
    ResourceA resourceA;

    @Override
    public void run() {
        System.out.println(resourceA.getId());
    }
}

class NewThread_2 extends Thread {
    ResourceB resourceB;

    @Override
    public void run() {
        System.out.println(resourceB.getId());
    }
}

class ResourceA {
    ResourceB resourceB;

    public synchronized int getId() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return resourceB.getId2();
    }

    public synchronized int getId2() {
        return 1;
    }
}

class ResourceB {
    ResourceA resourceA;

    public synchronized int getId() {
        return resourceA.getId2();
    }

    public synchronized int getId2() {
        return 2;
    }
}

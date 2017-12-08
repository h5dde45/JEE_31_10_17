package test.newthread.p3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
//        resource.setI(5);
        resource.setI(5);
        NewThread thread = new NewThread();
        thread.setName("one");
        NewThread thread2 = new NewThread();
//        thread.setResource(resource);
//        thread2.setResource(resource);
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println(Resource.getI());

    }
}

class NewThread extends Thread {
    Resource resource;

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
//        resource.changeI();
        Resource.changeStaticI();
    }
}

class Resource {
//    private int i;
    private static int i;

    public synchronized void setI(int i) {
        this.i = i;
    }

    public static int getI() {
        return i;
    }

//    public synchronized void changeI() {
//        synchronized (this) {
//            int i = this.i;
//            if (Thread.currentThread().getName().equals("one")) {
//                Thread.yield();
//            }
//            i++;
//            this.i = i;
//        }
//    }

    public synchronized static void changeStaticI() {
            int i = Resource.i;
            if (Thread.currentThread().getName().equals("one")) {
                Thread.yield();
            }
            i++;
        Resource.i = i;
    }

}

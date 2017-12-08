package test.newthread.p3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        resource.setI(5);
        NewThread thread = new NewThread();
        thread.setName("one");
        NewThread thread2 = new NewThread();
        thread.setResource(resource);
        thread2.setResource(resource);
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println(resource.getI());

    }
}

class NewThread extends Thread {
    Resource resource;

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.changeI();
    }
}

class Resource {
    private int i;

    public void setI(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public synchronized void changeI() {
        int i=this.i;
        if(Thread.currentThread().getName().equals("one")){
            Thread.yield();
        }
        i++;
        this.i=i;
    }

}

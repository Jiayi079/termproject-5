//can implement multiple interfaces + extend 1 class

public class RunnableDemo implements Runnable{
    String name;

    RunnableDemo(String name){
        this.name = name;
    }

    public static void main(String[] args) throws InterruptedException {
        RunnableDemo r = new RunnableDemo("A");
        RunnableDemo r2 = new RunnableDemo("B");

        // you can pass same runnable object to multiple threads
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r2);
        Thread.sleep(1000); // pause in ms
        t1.start();
        t2.start();

        // be 100% sure t1 and 52 are done
        t1.join(); // don't move to line 22 until t1.run finishes
        t2.join(); // sleep/check loop until other thread is done
        System.out.println("main thread done.");

        //with lambda
        var myThread = new Thread(() -> System.out.println("This is my thread logic"));
        myThread.start();
    }
    @Override
    public void run(){
        // this will run in a different thread
        System.out.println("I am in a thread " + name);
    }
}


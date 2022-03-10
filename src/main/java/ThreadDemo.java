//can't extend more classes

public class ThreadDemo extends Thread{

    String name;

    ThreadDemo(String name){
        this.name = name;
    }

    public static void main(String[] args) {
        // Thread 0
        ThreadDemo thread1 = new ThreadDemo("A");
        ThreadDemo thread2 = new ThreadDemo("B");
        // thread1.run(); //don't do this
        thread1.start(); // "Tell OS to queue this up to run eventually"
        thread2.start();
        System.out.println("main thread done.");
    }

    @Override
    public void run(){
        // this will run in a different thread
        System.out.println("I am in a thread " + name);
    }

}

package concurrency;

public class Main {
   
    public static void main(String[] args) {
         //run all of your threads from this main class.
        (new Reasoning()).start();
        (new Thread(new TeamTC1())).start();
    }
}
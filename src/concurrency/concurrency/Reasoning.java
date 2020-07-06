package concurrency;

class Reasoning extends Thread {
    //set up this class so it can become a valid thread. 
    void distinguish() {
        //print to the console the difference between a thread and a process
        //print out you think will happen if you invoke the run() method of a thread as opposed to the start() method of a thread.
        System.out.println("A process is a program that is being executed while a thread is a smaller, lightweight part of a process. A process can have one or more threads but must have at least one thread. Mutiple threads can be run in a single process at a time.");
        System.out.println("Invoking run() instead of start() does not start a new thread but will execute in the current thread instead, preventing multithreading.");
    }
}


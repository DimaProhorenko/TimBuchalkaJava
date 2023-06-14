package com.dima;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(new CounterThread(counter), "Thread 1");
        Thread t2 = new Thread(new CounterThread(counter), "Thread 2");

        t1.start();
        t2.start();
    }
}

class Counter {
    private int i;
    public void count() {
        String color;

        switch(Thread.currentThread().getName()) {
            case "Thread 1" -> color = ThreadColor.ANSI_CYAN;
            case "Thread 2" -> color = ThreadColor.ANSI_RED;
            default -> color = ThreadColor.ANSI_PURPLE;
        }

        synchronized (this) {
            for (i = 10; i > 0; i--) {
                System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
            }
        }
    }
}

class CounterThread implements Runnable {
    private Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.count();
    }
}

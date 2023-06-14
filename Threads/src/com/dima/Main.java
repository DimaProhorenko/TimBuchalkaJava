package com.dima;

import static com.dima.ThreadColor.ANSI_GREEN;
import static com.dima.ThreadColor.ANSI_RESET;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello from main thread");
        Thread another = new AnotherThread();
        another.start();

        new Thread(() -> System.out.println(ANSI_GREEN + "Hello from the anonymous thread")).start();

        Thread runnable = new Thread(new MyRunnable()) {
            @Override
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from anonymous thread run()");
                try {
                    another.join(2000);
                    System.out.println("Another thread terminated, so I'm running again");
                } catch (InterruptedException ie) {
                    System.out.println(ie.getMessage());
                }
            }
        };

        runnable.start();

        System.out.println(ANSI_RESET + "Hello from main thread after another");
    }
}

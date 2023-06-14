package com.dima;

import static com.dima.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from another thread");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
            System.out.println(ANSI_BLUE + "Another thread woke me up");
            return;
        }
        System.out.println(ANSI_BLUE + "3 seconds hava passed and I'm awake");
    }
}

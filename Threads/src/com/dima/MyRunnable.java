package com.dima;

import static com.dima.ThreadColor.ANSI_CYAN;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(ANSI_CYAN + "Hello from MyRunnable");
    }
}

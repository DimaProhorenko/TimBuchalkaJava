package com.dima;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Message msg = new Message();

        (new Thread(new Writer(msg))).start();
        (new Thread(new Reader(msg))).start();
    }
}


class Message {
    private String msg;
    private boolean isEmpty = true;

    public synchronized String read() {
        while (isEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        isEmpty = true;
        notifyAll();
        return msg;
    }

    public synchronized void write(String msg) {
        while (!isEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        isEmpty = false;
        notifyAll();
        this.msg = msg;
    }
}

class Writer implements Runnable {
    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String[] messages = {
                "First message",
                "Second message",
                "Third message",
                "Fourth message",
                "Fifth message"
        };

        Random rand = new Random();
        for (int i = 0; i < messages.length; i++) {
            message.write(messages[i]);
            try {
                Thread.sleep(rand.nextInt(2000));
            } catch (InterruptedException e) {

            }
        }

        message.write("Finished");
    }
}

class Reader implements Runnable {
    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        Random rand = new Random();
        for (String latestMessage = message.read(); !latestMessage.equalsIgnoreCase("Finished");
             latestMessage = message.read()) {
            System.out.println(latestMessage);
            try {
                Thread.sleep(rand.nextInt(2000));
            } catch (InterruptedException e) {

            }
        }
    }
}
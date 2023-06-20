package com.dima;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String msg = input.readLine();
                if (msg.equalsIgnoreCase("exit")) {
                    break;
                }
                output.println("Output from server: " + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

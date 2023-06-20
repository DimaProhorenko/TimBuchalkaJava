package com.dima;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String msg;
            String response;

            do {
                System.out.println("Enter message");
                msg = scanner.nextLine();
                output.println(msg);
                if (!msg.equalsIgnoreCase("exit")) {
                    response = input.readLine();
                    System.out.println(response);
                }
            } while (!msg.equalsIgnoreCase("exit"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

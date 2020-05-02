package lesson6.homework.ChatApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

  public static void main(String[] args) {
    System.out.println("Simple Echo Client");
    System.out.println("Waiting for connection.....");
    //InetAddress localAddress = InetAddress.getLocalHost();
//      try (Socket clientSocket = new Socket(localAddress, 8087);
    try (Socket clientSocket = new Socket("127.0.0.1", 8087);
        PrintWriter out = new PrintWriter(
            clientSocket.getOutputStream(), true);
        BufferedReader br = new BufferedReader(
            new InputStreamReader(
                clientSocket.getInputStream()))) {
      System.out.println("Connected to server");
      Scanner scanner = new Scanner(System.in);
      while (true) {
        System.out.print("Enter text: ");
        String inputLine = scanner.nextLine();
        if ("quit".equalsIgnoreCase(inputLine)) {
          break;
        }
        out.println(inputLine);
        String response = br.readLine();
        System.out.println("Server response: " + response);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

package lesson6.homework.ChatApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ThreadedEchoServer implements Runnable {

  private static Socket clientSocket;

  public ThreadedEchoServer(Socket clientSocket) {
    ThreadedEchoServer.clientSocket = clientSocket;
  }

  public static void main(String[] args) {
    System.out.println("Threaded Echo Server");
    try (ServerSocket serverSocket = new ServerSocket(8087)) {
      while (true) {
        System.out.println("Waiting for connection.....");
        clientSocket = serverSocket.accept();
        ThreadedEchoServer echoServer =
            new ThreadedEchoServer(clientSocket);
        new Thread(echoServer).start();
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    System.out.println("Threaded Echo Server Terminating");
  }

  @Override
  public void run() {

    chatVersion();

    // echoVersion();
  }

  private void chatVersion() {
    Scanner scanner = new Scanner(System.in);
    try (BufferedReader br = new BufferedReader(
        new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(
            clientSocket.getOutputStream(), true)) {

      String inputLine;
      while ((inputLine = br.readLine()) != null) {
        System.out.println("Client request ["
            + Thread.currentThread().getName() + "]: " + inputLine);

        String outputLine = scanner.nextLine();
        printWriter.println(outputLine);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void echoVersion() {
    System.out.println("Connected to client using ["
        + Thread.currentThread().getName() + "]");

    try (BufferedReader br = new BufferedReader(
        new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(
            clientSocket.getOutputStream(), true)) {

      String inputLine;

      while ((inputLine = br.readLine()) != null) {
        System.out.println("Client request ["
            + Thread.currentThread().getName() + "]: " + inputLine);
        printWriter.println(inputLine);

      }
      System.out.println("Client [" + Thread.currentThread()
          + " connection terminated");
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}




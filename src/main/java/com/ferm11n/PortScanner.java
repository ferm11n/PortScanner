package com.ferm11n;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class PortScanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;

        // Título y saludo con color
        System.out.println("\033[0;32m===============================");
        System.out.println("   Port Scanner v1.0");
        System.out.println("   Escanea puertos en tu red");
        System.out.println("===============================\033[0m");

        // Menú de opciones
        while (true) {
            System.out.println("\n\033[0;34mSelecciona una opción:\033[0m");
            System.out.println("1. Escanear puertos");
            System.out.println("2. Salir");
            System.out.print("\033[0;33mElige una opción (1/2): \033[0m");
            userInput = scanner.nextLine();

            if (userInput.equals("1")) {
                escanearPuertos(scanner);
            } else if (userInput.equals("2")) {
                System.out.println("\033[0;31m¡Hasta luego!\033[0m");
                break;
            } else {
                System.out.println("\033[0;31mOpción no válida, por favor intenta de nuevo.\033[0m");
            }
        }
    }

    private static void escanearPuertos(Scanner scanner) {
        System.out.println("\n\033[0;36m--- Escanear Puertos ---\033[0m");

        // Pedir IP
        System.out.print("\033[0;37mIntroduce la IP a escanear: \033[0m");
        String ip = scanner.nextLine();

        // Pedir rango de puertos
        System.out.print("\033[0;37mIntroduce el rango de puertos (ejemplo: 20-80): \033[0m");
        String range = scanner.nextLine();
        String[] parts = range.split("-");
        int encenderPuerto = Integer.parseInt(parts[0]);
        int endcerrarPuerto = Integer.parseInt(parts[1]);

        System.out.println("\033[0;32mEscaneando puertos abiertos en " + ip + "...\033[0m");

        // Escanear puertos
        for (int port = encenderPuerto; port <= endcerrarPuerto; port++) {
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(ip, port), 200); // Timeout de 200ms
                System.out.println("\033[0;32mPuerto abierto: " + port + "\033[0m");
            } catch (IOException e) {
                // Si el puerto está cerrado no hace nada
            }
        }

        System.out.println("\033[0;32mEscaneo completado.\033[0m");
    }
}

package com.company;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static boolean verifyString(String text) {
        Stack<Character> stack = new Stack<Character>();
        boolean isInvalid = false;

        for (int i = 0; i < text.length(); i++) {
            char aux = text.charAt(i);
            if (aux == '[' || aux == '(' || aux == '{' || aux == '<') {
                stack.push(aux);
            } else if (aux == ']' || aux == ')' || aux == '}' || aux == '>') {
                if(stack.empty()) {
                    isInvalid = true;
                    break;
                }

                char auxSaida = stack.pop();
                if ((aux == ']' && auxSaida == '[') || (aux == ')' && auxSaida == '(')
                        || (aux == '}' && auxSaida == '{') || (aux == '>' && auxSaida == '<')) {
                    continue;
                } else {
                    isInvalid = true;
                    break;
                }
            } else {
                continue;
            }
        }

        if(stack.empty()) {
            isInvalid = true;
        }

        return isInvalid;
    }

    public static void runCode() {
        System.out.println("Alfabeto da linguagem: <{[( )]}>");
        System.out.print("Digite a string para verificar: ");

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        if (verifyString(text)) {
            System.out.println("String Inválida");
        } else {
            System.out.println("String Válida");
        }
    }

    public static void main(String[] args) {
        boolean quit = false;

        do {
            System.out.println("1- Verificar string");
            System.out.println("0- Sair");

            Scanner scannerOption = new Scanner(System.in);
            int option = scannerOption.nextInt();

            switch (option) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    runCode();
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }

        } while (quit != true);
    }
}

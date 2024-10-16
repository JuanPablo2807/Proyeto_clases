/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator.calculator_logic;

import java.util.Scanner; // Agregamos la importación de Scanner

/**
 *
 * @author Luis Alfonso
 */
public class front_prueba {
    
    public static void main(String[] args) { // Aseguramos que el método main esté dentro de la clase
        Scanner scanner = new Scanner(System.in);
        Calculator_Logic calculator = new Calculator_Logic(); 

        while (true) {
            double num = 0; 
            char operator = ' '; 
            
            while (true) {
                System.out.print("Num: o = para terminar : ");
                String inputNum = scanner.nextLine();

                if (inputNum.equals("=")) {
                    System.out.println("Resultado final: " + calculator.getResult());
                    System.out.println("Fin");
                    scanner.close(); 
                    return; 
                }

                try {
                    num = Double.parseDouble(inputNum);
                    break; 
                } catch (NumberFormatException e) {
                    System.out.println("ERR ingresa un numero");
                }
            }

            while (true) {
                System.out.print("Operador: (*,/,-,+) o = para terminar: ");
                String inputOperator = scanner.nextLine();

                if (inputOperator.equals("=")) {
                    System.out.println("Resultado final: " + calculator.getResult());
                    System.out.println("Fin");
                    scanner.close();
                    return; 
                }

                if (inputOperator.length() == 1 && "+-*/".indexOf(inputOperator.charAt(0)) != -1) {
                    operator = inputOperator.charAt(0); 
                    break; 
                } else {
                    System.out.println("ERR ingresa operador: ");
                }
            }

            calculator.calculate(num, operator);
            System.out.println("= " + calculator.getResult());
        }
    }
}

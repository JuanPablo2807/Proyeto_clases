/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package calculator.calculator_logic;

/**
 *
 * @author Luis Alfonso
 */
import java.util.Scanner;

public class Calculator_Logic {
    private double result; 
    private char currentOperator; 

    public Calculator_Logic() {
        this.result = 0;
        this.currentOperator = ' ';
    }

    public void calculate(double num, char operator) {
        switch (currentOperator) {
            case ' ':
                result = num; 
                break;
            case '+':
                result += num;
                break;
            case '-':
                result -= num;
                break;
            case '*':
                result *= num;
                break;
            case '/':
                if (num != 0) {
                    result /= num;
                } else {
                    System.out.println("Error: No se puede dividir entre 0.");
                }
                break;
            default:
                System.out.println("ERR escribe un operador.");
                return;
        }
        currentOperator = operator; 
    }

    public double getResult() {
        return result;
    }

    public void reset() {
        result = 0;
        currentOperator = ' ';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator_Logic calculator = new Calculator_Logic(); 

        while (true) {
            double num = 0; 
            char operator = ' '; 
            
            while (true) {
                System.out.print("Num: o = para terminar");
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
                System.out.print("Operador: (*,/,-,+) o = para terminar");
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
                    System.out.println("ERR ingresa operador");
                }
            }

            calculator.calculate(num, operator);
            System.out.println("= " + calculator.getResult());
        }
    }
}

package sistemanumerico;

public class SistemaNumerico {

    /**
     * Convierte un número en binario a su equivalente en decimal.
     * @param binario El número binario como cadena de caracteres (String).
     * @return El número convertido a decimal.
     * 
     * Este método recorre el número binario, interpretando cada bit 
     * y calculando su valor en decimal sumando potencias de 2.
     */
    public int binarioADecimal(String binario) {
        int decimal = 0;
        for (int i = 0; i < binario.length(); i++) {
            // Obtenemos el valor del bit y multiplicamos por 2 elevado a la posición correspondiente
            decimal += (binario.charAt(binario.length() - 1 - i) - '0') * Math.pow(2, i);
        }
        return decimal;
    }

    /**
     * Convierte un número en decimal a su equivalente en binario.
     * @param decimal El número decimal a convertir.
     * @return El número convertido a binario como cadena de caracteres.
     * 
     * El método utiliza divisiones sucesivas por 2 para obtener el equivalente binario.
     */
    public String decimalABinario(int decimal) {
        StringBuilder binario = new StringBuilder();
        while (decimal > 0) {
            // Insertamos el residuo de la división por 2 al principio de la cadena
            binario.insert(0, decimal % 2);
            decimal /= 2; // Dividimos el número decimal por 2 para la siguiente iteración
        }
        return binario.length() > 0 ? binario.toString() : "0";
    }

    /**
     * Convierte un número en octal a su equivalente en decimal.
     * @param octal El número octal como cadena de caracteres.
     * @return El número convertido a decimal.
     * 
     * Cada dígito del número octal se multiplica por una potencia de 8 según su posición.
     */
    public int octalADecimal(String octal) {
        int decimal = 0;
        for (int i = 0; i < octal.length(); i++) {
            // Multiplicamos cada dígito por 8 elevado a la posición correspondiente
            decimal += (octal.charAt(octal.length() - 1 - i) - '0') * Math.pow(8, i);
        }
        return decimal;
    }

    /**
     * Convierte un número en decimal a su equivalente en octal.
     * @param decimal El número decimal a convertir.
     * @return El número convertido a octal como cadena de caracteres.
     * 
     * Se realiza divisiones sucesivas por 8 y se construye el número octal desde los residuos.
     */
    public String decimalAOctal(int decimal) {
        StringBuilder octal = new StringBuilder();
        while (decimal > 0) {
            // Insertamos el residuo de la división por 8 al principio de la cadena
            octal.insert(0, decimal % 8);
            decimal /= 8; // Dividimos el número decimal por 8 para la siguiente iteración
        }
        return octal.length() > 0 ? octal.toString() : "0";
    }

    /**
     * Convierte un número en hexadecimal a su equivalente en decimal.
     * @param hexadecimal El número hexadecimal como cadena de caracteres.
     * @return El número convertido a decimal.
     * 
     * Cada dígito hexadecimal se multiplica por una potencia de 16 según su posición.
     */
    public int hexadecimalADecimal(String hexadecimal) {
        int decimal = 0;
        for (int i = 0; i < hexadecimal.length(); i++) {
            // Convertimos el carácter a su valor correspondiente (0-9 o A-F)
            char hexChar = hexadecimal.charAt(hexadecimal.length() - 1 - i);
            int valor = Character.isDigit(hexChar) ? hexChar - '0' : 10 + (Character.toUpperCase(hexChar) - 'A');
            decimal += valor * Math.pow(16, i);
        }
        return decimal;
    }

    /**
     * Convierte un número en decimal a su equivalente en hexadecimal.
     * @param decimal El número decimal a convertir.
     * @return El número convertido a hexadecimal como cadena de caracteres.
     * 
     * Se realiza divisiones sucesivas por 16 y se construye el número hexadecimal desde los residuos.
     */
    public String decimalAHexadecimal(int decimal) {
        StringBuilder hexadecimal = new StringBuilder();
        // Definimos un array con los caracteres hexadecimales (0-9 y A-F)
        char[] hexChars = "0123456789ABCDEF".toCharArray();
        while (decimal > 0) {
            // Insertamos el residuo convertido en carácter hexadecimal al principio de la cadena
            hexadecimal.insert(0, hexChars[decimal % 16]);
            decimal /= 16; // Dividimos el número decimal por 16 para la siguiente iteración
        }
        return hexadecimal.length() > 0 ? hexadecimal.toString() : "0";
    }

    /**
     * Convierte un número en binario a su equivalente en octal.
     * @param binario El número binario como cadena de caracteres.
     * @return El número convertido a octal.
     * 
     * Primero convierte el binario a decimal y luego de decimal a octal.
     */
    public String binarioAOctal(String binario) {
        int decimal = binarioADecimal(binario); // Convertimos a decimal
        return decimalAOctal(decimal); // Luego a octal
    }

    /**
     * Convierte un número en binario a su equivalente en hexadecimal.
     * @param binario El número binario como cadena de caracteres.
     * @return El número convertido a hexadecimal.
     * 
     * Primero convierte el binario a decimal y luego de decimal a hexadecimal.
     */
    public String binarioAHexadecimal(String binario) {
        int decimal = binarioADecimal(binario); // Convertimos a decimal
        return decimalAHexadecimal(decimal); // Luego a hexadecimal
    }

    /**
     * Convierte un número en octal a su equivalente en binario.
     * @param octal El número octal como cadena de caracteres.
     * @return El número convertido a binario.
     * 
     * Primero convierte el octal a decimal y luego de decimal a binario.
     */
    public String octalABinario(String octal) {
        int decimal = octalADecimal(octal); // Convertimos a decimal
        return decimalABinario(decimal); // Luego a binario
    }

    /**
     * Convierte un número en octal a su equivalente en hexadecimal.
     * @param octal El número octal como cadena de caracteres.
     * @return El número convertido a hexadecimal.
     * 
     * Primero convierte el octal a decimal y luego de decimal a hexadecimal.
     */
    public String octalAHexadecimal(String octal) {
        int decimal = octalADecimal(octal); // Convertimos a decimal
        return decimalAHexadecimal(decimal); // Luego a hexadecimal
    }

    /**
     * Convierte un número en hexadecimal a su equivalente en binario.
     * @param hexadecimal El número hexadecimal como cadena de caracteres.
     * @return El número convertido a binario.
     * 
     * Primero convierte el hexadecimal a decimal y luego de decimal a binario.
     */
    public String hexadecimalABinario(String hexadecimal) {
        int decimal = hexadecimalADecimal(hexadecimal); // Convertimos a decimal
        return decimalABinario(decimal); // Luego a binario
    }

    /**
     * Convierte un número en hexadecimal a su equivalente en octal.
     * @param hexadecimal El número hexadecimal como cadena de caracteres.
     * @return El número convertido a octal.
     * 
     * Primero convierte el hexadecimal a decimal y luego de decimal a octal.
     */
    public String hexadecimalAOctal(String hexadecimal) {
        int decimal = hexadecimalADecimal(hexadecimal); // Convertimos a decimal
        return decimalAOctal(decimal); // Luego a octal
    }

    public static void main(String[] args) {
        SistemaNumerico sn = new SistemaNumerico();
        
        // Ejemplos de uso
        System.out.println("Binario a Decimal: " + sn.binarioADecimal("1010"));
        System.out.println("Decimal a Binario: " + sn.decimalABinario(10));
        System.out.println("Octal a Decimal: " + sn.octalADecimal("12"));
        System.out.println("Decimal a Octal: " + sn.decimalAOctal(10));
        System.out.println("Hexadecimal a Decimal: " + sn.hexadecimalADecimal("A"));
        System.out.println("Decimal a Hexadecimal: " + sn.decimalAHexadecimal(10));
        System.out.println("Binario a Hexadecimal: " + sn.binarioAHexadecimal("1010"));
    }
}

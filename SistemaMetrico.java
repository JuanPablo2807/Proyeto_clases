package sistemametrico;

public class SistemaMetrico {

    /**
     * Convierte una cantidad dada en metros a la unidad especificada.
     * @param metros La cantidad en metros.
     * @param unidad La unidad a la que se desea convertir (cm, km, mm, dm, hm, dam).
     * @return La cantidad convertida a la unidad deseada.
     * 
     * Usa factores de conversion predefinidos para realizar la conversion.
     */
    public double metrosAUnidad(double metros, String unidad) {
        switch (unidad.toLowerCase()) {
            case "cm": // Centimetros
                return metros * 100;
            case "km": // Kilometros
                return metros / 1000;
            case "mm": // Milimetros
                return metros * 1000;
            case "dm": // Decimetros
                return metros * 10;
            case "hm": // Hectometros
                return metros / 100;
            case "dam": // Decametros
                return metros / 10;
            default:
                throw new IllegalArgumentException("Unidad no soportada: " + unidad);
        }
    }

    /**
     * Convierte una cantidad dada de una unidad metrica a metros.
     * @param cantidad La cantidad en la unidad especificada.
     * @param unidad La unidad de la cantidad proporcionada (cm, km, mm, dm, hm, dam).
     * @return La cantidad convertida a metros.
     * 
     * Usa factores de conversion predefinidos para convertir a metros.
     */
    public double unidadAMetros(double cantidad, String unidad) {
        switch (unidad.toLowerCase()) {
            case "cm": // Centimetros
                return cantidad / 100;
            case "km": // Kilometros
                return cantidad * 1000;
            case "mm": // Milimetros
                return cantidad / 1000;
            case "dm": // Decimetros
                return cantidad / 10;
            case "hm": // Hectometros
                return cantidad * 100;
            case "dam": // Decametros
                return cantidad * 10;
            default:
                throw new IllegalArgumentException("Unidad no soportada: " + unidad);
        }
    }

    /**
     * Convierte una cantidad de una unidad metrica a otra unidad metrica.
     * @param cantidad La cantidad en la unidad origen.
     * @param unidadOrigen La unidad de la cantidad original (cm, km, mm, dm, hm, dam).
     * @param unidadDestino La unidad a la que se desea convertir (cm, km, mm, dm, hm, dam).
     * @return La cantidad convertida a la unidad destino.
     * 
     * Convierte primero la cantidad a metros y luego a la unidad destino.
     */
    public double convertir(double cantidad, String unidadOrigen, String unidadDestino) {
        double metros = unidadAMetros(cantidad, unidadOrigen); // Primero convertimos a metros
        return metrosAUnidad(metros, unidadDestino); // Luego convertimos a la unidad destino
    }

    public static void main(String[] args) {
        SistemaMetrico sm = new SistemaMetrico();
        
        // Ejemplos de uso
        System.out.println("1000 cm a metros: " + sm.unidadAMetros(1000, "cm"));
        System.out.println("1 km a metros: " + sm.unidadAMetros(1, "km"));
        System.out.println("500 metros a kilometros: " + sm.metrosAUnidad(500, "km"));
        System.out.println("10 metros a centimetros: " + sm.metrosAUnidad(10, "cm"));
        System.out.println("Convertir 5000 cm a kilometros: " + sm.convertir(5000, "cm", "km"));
        System.out.println("Convertir 2 hm a milimetros: " + sm.convertir(2, "hm", "mm"));
    }
}

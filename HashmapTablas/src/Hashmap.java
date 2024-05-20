import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Hashmap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa la declaración de variable en C++ y el código en C++ (puedes usar varias líneas).");
        System.out.println("Presiona Enter en una línea vacía para finalizar:");

        StringBuilder inputBuilder = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            inputBuilder.append(line).append("\n");
        }
        String input = inputBuilder.toString();

        LinkedHashMap<String, String> tokenTable = new LinkedHashMap<>();

        String[] lines = input.split("\n");
        int row = 0;  // Inicializamos row a 0 en lugar de 1

        for (int i = 0; i < lines.length; i++) {
            String linez = lines[i];
            String[] tokens = linez.split(" ");
            int column = 0;

            for (int j = 0; j < tokens.length; j++) {
                String token = tokens[j];

                if (!token.isEmpty()) {
                    String position = String.format("%d%d", row, column);
                    tokenTable.put(position, token);
                    column += token.length() + 1; // +1 por el espacio
                }
            }

            row++;
        }

        // Print the list of words and their tokens in the desired format
        System.out.println("\nTabla de Palabras y Tokens:");
        System.out.printf("%-10s%-10s%n", "Clave", "Token");
        for (Map.Entry<String, String> entry : tokenTable.entrySet()) {
            System.out.printf("%-10s%-10s%n", entry.getKey(), entry.getValue());
        }

        System.out.print("\nIngresa el token a buscar: ");
        String tokenToSearch = scanner.nextLine();

        boolean found = false;
        for (Map.Entry<String, String> entry : tokenTable.entrySet()) {
            if (entry.getValue().equals(tokenToSearch)) {
                System.out.println("El token '" + tokenToSearch + "' se encuentra en la clave: " + entry.getKey());
                found = true;
            }
        }

        if (!found) {
            System.out.println("El token '" + tokenToSearch + "' no se encontró en la lista de palabras.");
        }
    }
}

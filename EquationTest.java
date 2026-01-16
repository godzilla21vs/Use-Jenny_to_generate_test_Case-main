import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EquationTest {
    public void generateJUnitTests(String testFilePath) {
        String outputFile = "GeneratedTests.java"; 
        try (BufferedReader reader = new BufferedReader(new FileReader(testFilePath));
             FileWriter writer = new FileWriter(outputFile)) {

            writer.write("""
                    import static org.junit.jupiter.api.Assertions.*;
                    import org.junit.jupiter.api.Test;
                    import java.util.ArrayList;

                    public class GeneratedTests {
                    """);

            String line;
            int testCount = 1;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("Équation")) continue;

                String[] parts = line.split("\\s+");
                if (parts.length < 7) continue;

                double a = Double.parseDouble(parts[0]);
                double b = Double.parseDouble(parts[1]);
                double c = Double.parseDouble(parts[2]);
                String result = parts[3];
                String status = parts[5];

                String methodName = "testCase" + testCount++;
                writer.write(generateJUnitMethod(methodName, a, b, c, result, status.equals("True")));
            }

            writer.write("\n}");
        } catch (IOException e) {
            System.err.println("Erreur lors de la génération des tests JUnit : " + e.getMessage());
        }
    }

    private String generateJUnitMethod(String methodName, double a, double b, double c, String result, boolean isValid) {
        StringBuilder method = new StringBuilder();
        method.append("\n    @Test\n");
        method.append("    public void ").append(methodName).append("() {\n");
        if (isValid) {
            // Cas valide : Vérifier les solutions
            String[] solutions = result.split(",");
            method.append("        Equation equation = new Equation();\n");
            method.append("        ArrayList<Double> solutions = equation.solve(")
                    .append(a).append(", ").append(b).append(", ").append(c).append(");\n");
            if (solutions.length == 1) {
                double expected = Double.parseDouble(solutions[0]);
                method.append("        assertEquals(").append(expected).append(", solutions.get(0), 10e-6);\n");
            } else {
                double expected1 = Double.parseDouble(solutions[0]);
                double expected2 = Double.parseDouble(solutions[1]);
                method.append("        assertEquals(").append(expected1).append(", solutions.get(0), 10e-6);\n");
                method.append("        assertEquals(").append(expected2).append(", solutions.get(1), 10e-6);\n");
            }
        } else {
            // Cas invalide : Vérifier les exceptions
            method.append("        Equation equation = new Equation();\n");
            method.append("        assertThrows(")
                    .append(a == 0 ? "NotAQuadraticEquationException.class" : "NoRealSolutionException.class")
                    .append(", () -> equation.solve(")
                    .append(a).append(", ").append(b).append(", ").append(c).append("));\n");
        }
        method.append("    }\n");
        return method.toString();
    }

    public static void main(String[] args) {
        EquationTest generator = new EquationTest();
        generator.generateJUnitTests("test_report.txt");
        System.out.println("Tests JUnit générés avec succès dans GeneratedTests.java !");
    }
}

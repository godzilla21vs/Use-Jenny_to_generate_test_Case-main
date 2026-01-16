import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String filePath = "file_jenny.txt";
        String reportFilePath = "test_report.txt";  

        try (FileWriter writer = new FileWriter(reportFilePath, true)) {
            writer.write("================================== Résultats des Équations Quadratiques ==================================\n");
            writer.write(String.format("%-10s %-10s %-10s %-25s %-10s%n", "a", "b", "c", "Solution(s)", "Résultat"));
            writer.write("======================================================================================================\n");

            ArrayList<double[]> coefficients = JennyToCoefficients.readJennyFileAndGetCoefficients(filePath);
            IEquationSolver eq = new Equation();
            double tolerance = Math.pow(10, -6);

            for (double[] coeff : coefficients) {
                double a = coeff[0];
                double b = coeff[1];
                double c = coeff[2];

                String solutionsStr = "N/A";
                boolean testResult = false;

                try {
                    ArrayList<Double> solutions = eq.solve(a, b, c);
                    StringBuilder sb = new StringBuilder();
                    for (double solution : solutions) {
                        sb.append(String.format("%.5f ", solution));
                    }
                    solutionsStr = sb.toString().trim();
                    testResult = true;
                    for (double solution : solutions) {
                        double result = a * Math.pow(solution, 2) + b * solution + c;
                        if (Math.abs(result) > tolerance) {
                            testResult = false;
                            break;
                        }
                    }
                } catch (Exception e) {
                    solutionsStr = "Exception : " + e.getMessage();
                }

                writer.write(String.format("%-10.5f %-10.5f %-10.5f %-25s %-10s%n", a, b, c, solutionsStr, testResult ? "True" : "False"));
                writer.write("------------------------------------------------------------------------------------------------------\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
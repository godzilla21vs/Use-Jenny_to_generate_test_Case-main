import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JennyToCoefficients {

    /**
     * Génère un coefficient basé sur une lettre donnée.
     *
     * @param letter La lettre représentant l'intervalle (de 'a' à 'i')
     * @return Un coefficient aléatoire correspondant à l'intervalle
     */
    public static double generateCoefficient(String letter) {
        RandomGenerator generator = new RandomGenerator();
        return generator.generateRandom(letter);
    }

    /**
     * Lit un fichier contenant des données de Jenny et récupère les coefficients correspondants.
     *
     * @param filePath Le chemin du fichier Jenny
     * @return Une liste d'arrays, chaque array contenant a, b, et c pour une ligne du fichier
     * @throws IOException si le fichier n'est pas accessible
     */
    public static ArrayList<double[]> readJennyFileAndGetCoefficients(String filePath) throws IOException {
        ArrayList<double[]> coefficientsList = new ArrayList<>();

        // Lire toutes les lignes du fichier
        List<String> lines = Files.readAllLines(Path.of(filePath));

        for (String line : lines) {

            // Séparer chaque ligne en colonnes
            String[] parts = line.split(" ");

            if (parts.length == 4) {
                // Extraire les lettres des coefficients
                String aLetter = parts[1].substring(1);
                String bLetter = parts[2].substring(1);
                String cLetter = parts[3].substring(1);

                // Générer les coefficients numériques
                double a = generateCoefficient(aLetter);
                double b = generateCoefficient(bLetter);
                double c = generateCoefficient(cLetter);

                // Ajouter le triplet [a, b, c] à la liste
                coefficientsList.add(new double[]{a, b, c});
            }
        }

        return coefficientsList;
    }


}

import java.util.Random;

public class RandomGenerator {

    /**
     * 
     *
     * @param letter 
     * @return 
     * @throws IllegalArgumentException
     */
    public static double generateRandom(String letter) {
        Random random = new Random();
        double result;

        switch (letter.toLowerCase()) {
            case "a":
                result = 0;
                break;
            case "b":
                result = 3 + random.nextInt(15 - 3 + 1); 
                break;
            case "c":
                result = 10 + random.nextDouble() * (Math.pow(10, 4) - 10); 
                break;
            case "d":
                result = Math.pow(10, 6) + random.nextDouble() * (Math.pow(10, 10) - Math.pow(10, 6)); 
                break;
            case "e":
                result = 15 + random.nextDouble() * (Math.pow(10, 4) - 15); 
                break;
            case "f":
                result = random.nextDouble() * Math.pow(10, -5); 
                break;
            case "g":
                result = -10 + random.nextDouble() * (Math.pow(10, 4) - (-10)); 
                break;
            case "h":
                result = -15 + random.nextDouble() * (-3 - (-15)); // Entre -15 et -3
                break;
            case "i":
                result = -Math.pow(10, 10) + random.nextDouble() * (-Math.pow(10, 6) - (-Math.pow(10, 10))); 
                break;
            default:
                throw new IllegalArgumentException("Lettre invalide");
        }

        return result;
    }


}

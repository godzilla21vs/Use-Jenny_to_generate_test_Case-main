import java.util.ArrayList;

public interface IEquationSolver {
    /**
     * Résout une équation du second degré ax^2 + bx + c = 0.
     *
     * @param a Coefficient de x^2
     * @param b Coefficient de x
     * @param c Terme constant
     * @return Une ArrayList contenant les solutions réelles
     * @throws NotAQuadraticEquationException si le coefficient 'a' est égal à 0
     * @throws NoRealSolutionException si le discriminant est négatif
     */
    ArrayList<Double> solve(double a, double b, double c) throws NotAQuadraticEquationException, NoRealSolutionException;
}

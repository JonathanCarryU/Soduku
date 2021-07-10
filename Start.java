import java.io.IOException;

public class Start {
    public static void main(String[] args) throws IOException {
        SudokuSolver recursive = new RecursiveSolver("../../test/resources/sample_puzzle.sdk");
        SudokuSolver iterative = new IterativeSolver("../../test/resources/sample_puzzle.sdk");

        long t1 = System.nanoTime();
        System.out.println(recursive.solve());
        long t2 = System.nanoTime();
        System.out.println("Recursive Time: " + String.valueOf(t2 - t1));

        t1 = System.nanoTime();
        System.out.println(iterative.solve());
        t2 = System.nanoTime();
        System.out.println("Iterative Time: " + String.valueOf(t2 - t1));
    }
}

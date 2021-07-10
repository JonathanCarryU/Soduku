import java.util.*;
import java.io.*;
import board.Board;

public class IterativeSolver implements SudokuSolver {
    private Board board;
    public IterativeSolver(String filePath) throws IOException {
        this.board = new Board(filePath);
    }
    public Board solve() {
        Stack<Board> stack = new Stack<>();
        
        stack.push(board);

        while (!stack.isEmpty()) {
            Board now = stack.pop();
            if (now.isSolved()) {
                return now;
            }

            for (Board potentialSolution : now.getNeighbors()) {
                stack.push(potentialSolution);
            }
        }

        System.out.println("There is no possible solution!");
        return null;
    }
}
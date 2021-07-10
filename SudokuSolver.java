import board.Board;

public interface SudokuSolver {
    Board board = new Board();
    Board solve();
}
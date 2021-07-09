// Author: Linchuan Yang

import java.io.FileNotFoundException;
import java.util.*;

public class StartGame implements SudokuSolver {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console =  new Scanner(System.in);

        System.out.println("Welecome to Sudoku Solver!");
        System.out.println();
        System.out.println("Would you like to...");
        System.out.println("    1) Use demo Sudoku Puzzle");
        System.out.println("    2) Use your own Sudoku Puzzle");

        int choice;
        Board puzzle = new Board();

        do {
            System.out.println();
            System.out.print("Please enter your choice > ");
            choice = console.nextInt();

            if (choice == 1) {
                System.out.println();
                System.out.println("Would you like to...");
                System.out.println("    1) Use demo_1(.SDK)");
                System.out.println("    2) Use demo_2(.SS)");

                int demoChoice;

                do {
                    System.out.println();
                    System.out.print("Please enter your choice > ");
                    demoChoice = console.nextInt();

                    if (demoChoice == 1) {
                        puzzle = new SDKBoardReader();
                    } else if (demoChoice == 2) {
                        puzzle = new SSBoardReader();
                    } else {
                        System.out.println("INVALID CHOICE, Please try again!");
                    }
                } while (demoChoice < 1 || demoChoice > 2);
            } else if (choice == 2) {
                System.out.print("Please enter your file path > ");
                String path = console.next();
                puzzle = new BoardReaderFactory().getBoard(path);
            } else {
                System.out.println("INVALID CHOICE, Please try again!");
            }
        } while (choice < 1 || choice > 2);

        System.out.println();
        System.out.println("Here is your puzzle: ");
        System.out.println(puzzle);

        System.out.println("Now Solving...");
        System.out.println();
        Board solvedPuzzle = solve(puzzle);
        if (solvedPuzzle != null) {
            System.out.println("Here is you solved puzzle: ");
            System.out.println(solvedPuzzle);
        } else {
            System.out.println("It seems you puzzle cannot be solved, please try an other puzzle");
        }
    }

    // I return the board object to the main, and print in the main
    public static Board solve(Board board) {
        int row = 0;
        int col = 0;
        while (board.getBoard()[row][col] != -1) {
            if (row == 8) {
                row = -1;
                col++;
            }
            row++;
        }
        return solveHelper(row, col, getNeighbors(row, col, board));
    }

    private static Board solveHelper(int row, int col, List<Board> options) {
        if (options.size() == 1 && options.get(0).isSolved()) {
            return options.get(0);
        } 

        for (Board board : options) {
            if (row == 8) {
                row = -1;
                col++;
            }
            
            int[][] newBoard = new int[9][9];
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        newBoard[i][j] = board.getBoard()[i][j];
                    }
                }
            Board b = solveHelper(row + 1, col, getNeighbors(row + 1, col, new Board(newBoard)));
            if (b != null) {
                return b;
            }
        }
        return null;
    }

    // I choose to put this function here becasue it will be easy to access the Board class. 
    public static List<Board> getNeighbors(int row, int col, Board board) {
        List<Board> options = new ArrayList<>();

        for (int choice = 1; choice <= 9; choice++) {
            Board modify = board;
            modify.modify(row, col, choice);
            if (modify.isValid()) {
                int[][] newBoard = new int[9][9];
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        newBoard[i][j] = modify.getBoard()[i][j];
                    }
                }
                options.add(new Board(newBoard));
            }
        }
        return options;
    }
}
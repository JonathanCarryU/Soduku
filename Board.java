// Author: Linchuan Yang

import java.util.*;
import java.io.*;

public class Board {

    private File file;
    private int[][] board;

    public Board() throws FileNotFoundException {
        this("../puzzle/demo.sdk");
    }

    public Board(String path) throws FileNotFoundException {
        this(new File(path));
    }

    public Board(File file) throws FileNotFoundException {
        this.file = file;
        board = new int[9][9];
        this.read();
    }

    public Board(int[][] board) {
        this.board = board;
    }

    public File getFile() {
        return file;
    }

    public int[][] getBoard() {
        return board;
    }

    public void modify(int row, int col, int num) {
        this.board[row][col] = num;
    }

    public void read() throws FileNotFoundException {
        Scanner fileScan = new Scanner(file);
        
        for (int row = 0; row < 9; row++) {
            String line = fileScan.nextLine();

            for (int col = 0; col < line.length(); col++) {
                if (line.charAt(col) == 46) {
                    board[row][col] = -1;
                } else if (line.charAt(col) >= 48 && line.charAt(col) <= 57) {
                    board[row][col] = line.charAt(col) - 48;
                } else {
                    System.out.println("Please check your file");
                }
            }
        }
    }

    private int getNumBlanks() {
        int blanks = 0;
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == -1) {
                    blanks++;
                }
            }
        }

        return blanks;
    }

    public boolean isValid() {
        for (int[] row : board) {
            for (Integer cell : row) {
                if (cell != -1 && (cell < 1 || cell > 9)) {
                    return false;
                }
            }
        }

        Set<Integer> rowConstraint = new HashSet<>();
        Set<Integer> colConstraint = new HashSet<>();
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                Integer value = this.board[i][j];
                if (rowConstraint.contains(value)) {
                    return false;
                }

                if (value != -1) {
                    rowConstraint.add(value);
                }

                value = this.board[j][i];
                if (colConstraint.contains(value)) {
                    return false;
                }

                if (value != -1) {
                    colConstraint.add(value);
                }
            }

            rowConstraint.clear();
            colConstraint.clear();
        }

        Set<Integer> gridConstraint = new HashSet<>();
        for (int i = 0; i < this.board.length; i = i + 3) {
            for (int j = 0; j < this.board[i].length; j = j + 3) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        Integer value = this.board[i + k][j + l];
                        if (gridConstraint.contains(value)) {
                            return false;
                        }
                        if (value != -1) {
                            gridConstraint.add(value);
                        }
                    }
                }
                gridConstraint.clear();
            }

        }

        return true;
    }

    public boolean isSolved() {
        return isValid() && getNumBlanks() == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("+---+---+---+---+---+---+---+---+---+\n");

        for (int row = 0; row < 9; row++) {

            sb.append("|");

            for (int col = 0; col < 9; col++) {
                sb.append(" ");
                if (board[row][col] == -1)
                    sb.append(" ");
                else
                    sb.append(board[row][col]);
                sb.append(" |");
            }

            sb.append("\n+---+---+---+---+---+---+---+---+---+\n");

        }

        return sb.toString();
    }
} 
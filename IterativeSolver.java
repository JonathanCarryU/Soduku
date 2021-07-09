import java.util.Stack;

public class IterativeSolver {
    public static void main(String[] args) {
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
     
    public static Board solve(Board board) {
        Stack<Board> stack = new Stack<>();

        stack.push
    }
}
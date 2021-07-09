// Author: Linchuan Yang

import java.util.*;
import java.io.*;

public class SSBoardReader extends Board implements BoardReader {

    public SSBoardReader() throws FileNotFoundException {
        super("../puzzle/demo.ss");
    }

    public SSBoardReader(String path) throws FileNotFoundException {
        super(path);
    }

    public SSBoardReader(File file) throws FileNotFoundException {
        super(file);
    }

    public void read() throws FileNotFoundException {
        Scanner fileScan = new Scanner(getFile());
        
        for (int row = 0; row < 9; row++) {
            String line = fileScan.nextLine();

            if (line.charAt(1) == 45) {
                line = fileScan.nextLine();
            }

            line = line.replace("|", "");

                for (int col = 0; col < 9; col++) {
                    if (line.charAt(col) == 46) {
                        getBoard()[row][col] = -1;
                    } else if (line.charAt(col) >= 49 && line.charAt(col) <= 57) {
                        getBoard()[row][col] = line.charAt(col) - 48;
                    } else {
                        System.out.println("Please check your file");
                    }
                }
        }
    }

}
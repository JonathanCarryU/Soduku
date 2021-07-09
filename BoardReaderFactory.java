// Author: Linchuan Yang

import java.io.FileNotFoundException;
import java.util.Arrays;

public class BoardReaderFactory { 
    public static Board getBoard(String path) throws FileNotFoundException {
        String[] temp = path.split("\\.");
        String extension = temp[temp.length - 1];

        if (extension.equalsIgnoreCase("sdk")) {
            return new SDKBoardReader(path);
        } else if (extension.equalsIgnoreCase("ss")) {
            return new SSBoardReader(path);
        }
        System.out.println();
        System.out.println("Extension ." + extension + " is not supported! ");
        System.out.println("WILL CONTINUE TO USE DEMO_1(.SDK) INSTEAD");
        return new Board();
    }
}
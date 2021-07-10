package board.reader;

import java.io.*;

public class BoardReaderFactory {
    public static BoardReader getReader(String filePath){
        int i = filePath.lastIndexOf('.');
        if (i > 0) {
            String extension = filePath.substring(i + 1);
            if (extension.equalsIgnoreCase("sdk")) {
                return new SdkBoardReader();

            } else if (extension.equalsIgnoreCase("ss")) {
                return new SsBoardReader();
            }
        }

        throw new UnsupportedOperationException("File has no extension.");
    }
}

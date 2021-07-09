// Author: Linchuan Yang

import java.io.*;

public class SDKBoardReader extends Board implements BoardReader{

    public SDKBoardReader() throws FileNotFoundException {
        super();
    }

    public SDKBoardReader(String path) throws FileNotFoundException {
        super(path);
    }

    public SDKBoardReader(File file) throws FileNotFoundException {
        super(file);
    }
}
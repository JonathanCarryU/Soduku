// Author: Linchuan Yang

import java.io.FileNotFoundException;

public interface BoardReader {
    void read() throws FileNotFoundException;
    String toString();
}
package board.reader;

import java.io.IOException;
import java.util.List;

public interface BoardReader {
    List<List<Integer>> parseBoard(String filePath) throws IOException;
}

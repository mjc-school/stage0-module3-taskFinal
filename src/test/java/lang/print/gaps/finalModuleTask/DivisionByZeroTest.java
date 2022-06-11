package lang.print.gaps.finalModuleTask;

import base.BaseIOTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class DivisionByZeroTest extends BaseIOTest {
    private static final String RAW_INFINITY_SOUT = "(^.+(System\\.out\\.println\\(.*(Infinity).*\\));)";
    private static final String RAW_POSITIVE_INFINITY_SOUT = "(^.+(System\\.out\\.println\\(.*(INFINITY).*\\));)";


    @Test
    void mainDividesByZeroNoException() {
        DivisionByZero.main(null);

        assertEquals("Infinity\n", updateLineSpliterators(outContent.toString()));
    }

    @Test
    void notContainsInlinePrinting() throws IOException {
        Path path = Paths.get("src/main/java/lang/print/gaps/finalModuleTask/DivisionByZero.java");
        List<String> strings = Files.readAllLines(path);
        List<String> declarationResult = strings.stream()
                .filter(line ->
                        line.matches(RAW_INFINITY_SOUT + "|" + RAW_POSITIVE_INFINITY_SOUT))
                .collect(Collectors.toList());

        assertEquals(0, declarationResult.size());
    }

}
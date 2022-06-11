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

class PrintingFalseTest extends BaseIOTest {

    private static final String RAW_FALSE_SOUT = "(^.+(System\\.out\\.println\\(.*(false).*\\));)";
    private static final String RAW_LETTER_SOUT = "(^.+(System\\.out\\.print\\(.*[false].*\\));)";


    @Test
    void mainPrintsFalse() {
        PrintingFalse.main(null);

        assertEquals("false\n", updateLineSpliterators(outContent.toString()));
    }

    @Test
    void notContainsInlinePrinting() throws IOException {
        Path path = Paths.get("src/main/java/lang/print/gaps/finalModuleTask/PrintingFalse.java");
        List<String> strings = Files.readAllLines(path);
        List<String> declarationResult = strings.stream()
                .filter(line ->
                        line.matches(RAW_FALSE_SOUT + "|" + RAW_LETTER_SOUT))
                .collect(Collectors.toList());

        assertEquals(0, declarationResult.size());
    }
}
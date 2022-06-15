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

class NumbersPrinterTest extends BaseIOTest {

    @Test
    void printIsPositivePrintsTrueWhenPositive() {
        NumbersPrinter printer = new NumbersPrinter();

        printer.printIsPositive(1);

        assertEquals("true\n", updateLineSpliterators(outContent.toString()));
    }

    @Test
    void printIsPositivePrintsFalseWhenZero() {
        NumbersPrinter printer = new NumbersPrinter();

        printer.printIsPositive(0);

        assertEquals("false\n", updateLineSpliterators(outContent.toString()));
    }

    @Test
    void printIsPositivePrintsFalseWhenNegative() {
        NumbersPrinter printer = new NumbersPrinter();

        printer.printIsPositive(-1);

        assertEquals("false\n", updateLineSpliterators(outContent.toString()));
    }

    @Test
    void notContainsIfOrTernaryPrinting() throws IOException {
        Path path = Paths.get("src/main/java/lang/print/gaps/finalModuleTask/NumbersPrinter.java");
        List<String> strings = Files.readAllLines(path);
        List<String> declarationResult = strings.stream()
                .filter(line ->
                        line.contains("if") || line.contains("?"))
                .collect(Collectors.toList());

        assertEquals(0, declarationResult.size());
    }
}
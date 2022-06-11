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

class NumberReverterTest extends BaseIOTest {

    @Test
    void revertReverts457() {
        NumberReverter reverter = new NumberReverter();

        reverter.revert(457);

        assertEquals("754\n", updateLineSpliterators(outContent.toString()));
    }

    @Test
    void revertReverts334() {
        NumberReverter reverter = new NumberReverter();

        reverter.revert(334);

        assertEquals("433\n", updateLineSpliterators(outContent.toString()));
    }

    @Test
    void containsNoLibsOrStringMethods() throws IOException {
        Path path = Paths.get("src/main/java/lang/print/gaps/finalModuleTask/NumberReverter.java");
        List<String> strings = Files.readAllLines(path);
        List<String> declarationResult = strings.stream()
                .filter(line ->
                        line.contains("import") || line.contains(".revert") || line.contains("if"))
                .collect(Collectors.toList());

        assertEquals(0, declarationResult.size());
    }
}
package negative;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import parser.JsonParser;
import parser.NoSuchFileException;
import shop.Cart;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonParserNegativeTest {
    private static JsonParser jParser;

    @BeforeAll
    public static void initVars() {
        jParser = new JsonParser();
    }

    public static List<File> params() {
        return List.of(new File("src/test/resources/fake1.json"),
                       new File("src/test/resources/fake2.json"),
                       new File("src/test/resources/fake3.json"),
                       new File("src/test/resources/fake4.json"),
                       new File("src/test/resources/fake5.json"));
    }

    @ParameterizedTest
    @MethodSource("params")
    public void testReadFromFile(File fakePath) {
        assertThrowsExactly(NoSuchFileException.class, () -> jParser.readFromFile(fakePath));
    }

    @Test
    public void testReadInvalidFile(){
        File invalidFile = new File("src/test/resources/text.txt");
        assertThrows(Exception.class, ()-> jParser.readFromFile(invalidFile));
    }

    @Test
    public void testWriteNonExistingCartToFile(){
        Cart cart = null;
        assertThrows(Exception.class, ()-> jParser.writeToFile(cart));
    }
}

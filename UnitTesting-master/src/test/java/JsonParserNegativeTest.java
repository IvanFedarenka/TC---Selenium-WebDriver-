import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
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
    private static final File INVALID_FILE = new File("src/test/resources/text.txt");
    private static final String PATH = "src/test/resources/fake";

    @BeforeAll
    public static void initVars() {
        jParser = new JsonParser();
    }

    public static List<File> params() {
        return List.of(
                new File(PATH + "1.json"),
                new File(PATH + "2.json"),
                new File(PATH + "3.json"),
                new File(PATH + "4.json"),
                new File(PATH + "5.json")
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    @DisplayName("when readFromFile() method try to read data from non existing file" +
                "there are 'NoSuchFileException' expecting")
    public void testReadFromFile(File fakePath) {
        assertThrowsExactly(NoSuchFileException.class, () -> jParser.readFromFile(fakePath));
    }

    @Test
    @DisplayName("in this case ")
    public void testReadInvalidFile() {
        assertThrows(Exception.class, () -> jParser.readFromFile(INVALID_FILE));
    }

    @Test
    @DisplayName("expecting an exception, when trying to write uninitialized Cart to file")
    @Disabled
    public void testWriteNonExistingCartToFile() {
        Cart cart = null;
        assertThrows(Exception.class, () -> jParser.writeToFile(cart));
    }
}

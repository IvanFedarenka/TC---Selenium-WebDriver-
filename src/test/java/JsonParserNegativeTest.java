
import org.testng.annotations.*;
import com.Coherent.sample.parser.JsonParser;
import com.Coherent.sample.parser.NoSuchFileException;
import com.Coherent.sample.shop.Cart;

import java.io.File;

import static org.testng.Assert.*;

public class JsonParserNegativeTest {

    private JsonParser jParser;
    private static final String PATH = "src/test/resources/fake";

    @BeforeClass
    public void initVars() {
        jParser = new JsonParser();
    }

    @DataProvider(name = "fakeFiles")
    public static Object[][] getParamsForFeature() {
        return new Object[][]{
                {PATH + "1.json"},
                {PATH + "2.json"},
                {PATH + "3.json"},
                {PATH + "4.json"},
                {PATH + "5.json"}};
    }

    @Test(dataProvider = "fakeFiles",
          description = "when readFromFile() method try to read data from non existing file" +
                        "there are 'NoSuchFileException' expecting")
    public void testReadFromFile(String param) {
        assertThrows(NoSuchFileException.class, () -> jParser.readFromFile(new File(param)));
    }

    @Parameters({"param"})
    @Test(description = "in this case ")
    public void testReadInvalidFile(String invalidFile) {
        assertThrows(Exception.class, () -> jParser.readFromFile(new File(invalidFile)));
    }

    @Test(description = "expecting an exception, when trying to write uninitialized Cart to file")
    @Ignore
    public void testWriteNonExistingCartToFile() {
        Cart cart = null;
        assertThrows(Exception.class, () -> jParser.writeToFile(cart));
    }
}

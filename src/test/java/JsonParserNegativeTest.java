import jdk.jfr.Description;
import org.testng.annotations.*;
import com.Coherent.sample.parser.JsonParser;
import com.Coherent.sample.parser.NoSuchFileException;
import com.Coherent.sample.shop.Cart;

import java.io.File;

import static org.testng.Assert.*;

public class JsonParserNegativeTest {

    private static JsonParser jParser;
    private static final String INVALID_FILE = "src/test/resources/text.txt";
    private static final String PATH = "src/test/resources/fake";

    @BeforeTest
    public static void initVars() {
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

    @Test(dataProvider = "fakeFiles")
    @Description("when readFromFile() method try to read data from non existing file" +
            "there are 'NoSuchFileException' expecting")
    public void testReadFromFile(String fakePath) {
        assertThrows(NoSuchFileException.class, () -> jParser.readFromFile(new File(fakePath)));
    }

    @Test
    @Description("in this case ")
    public void testReadInvalidFile() {
        assertThrows(Exception.class, () -> jParser.readFromFile(new File(INVALID_FILE)));
    }

    //--------------------DISABLED TEST--------------------------
    @Test
    @Ignore
    @Description("expecting an exception, when trying to write uninitialized Cart to file")
    public void testWriteNonExistingCartToFile() {
        Cart cart = null;
        assertThrows(Exception.class, () -> jParser.writeToFile(cart));
    }
}

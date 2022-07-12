
import jdk.jfr.Description;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.Coherent.sample.parser.JsonParser;
import com.Coherent.sample.shop.Cart;
import com.Coherent.sample.shop.RealItem;

import java.io.File;

import static org.testng.Assert.*;

public class JsonParserTest {

    private JsonParser jParser;
    private Cart fakeCart;
    private static final String CART_NAME = "testCart";
    private static final String TEST_READING_FILE = "src/test/resources/testCart.json";
    private static final String TEST_WRITTEN_FILE = "src/main/resources/testCart.json";
    private static final double ITEM_PRICE = 12.4;
    private static final double ITEM_WEIGHT = 1.2;
    private static final String ITEM_NAME = "fake item";

    @BeforeMethod
    public void setParams() {
        jParser = new JsonParser();
        fakeCart = new Cart(CART_NAME);

        RealItem testReal = new RealItem();
        testReal.setWeight(ITEM_WEIGHT);
        testReal.setPrice(ITEM_PRICE);
        testReal.setName(ITEM_NAME);

        fakeCart.addRealItem(testReal);
    }

    @Test
    @Description("checking if writeToFile() method call does not throw exception and еру written file actually exists")
    public void testWriteToFile() {
        jParser.writeToFile(fakeCart);
        assertTrue(new File(TEST_WRITTEN_FILE).exists(), "'testWriteToFile', new file wasn't created");

    }

    //------------------Grouped assertion--------------------
    @Test
    @Description("checking if readFromFile() method is able to read data correctly")
    public void testReadValidFile() {
        Cart tempCart = jParser.readFromFile(new File(TEST_READING_FILE));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(tempCart.getCartName(), CART_NAME);
        softAssert.assertEquals(tempCart.getTotalPrice(), fakeCart.getTotalPrice());
        softAssert.assertAll("Soft assert fail");
    }

    @AfterMethod
    public void eraseWrittenTestData() {
        new File(TEST_WRITTEN_FILE).delete();
    }
}

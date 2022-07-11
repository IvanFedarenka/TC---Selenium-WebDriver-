
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import parser.JsonParser;
import shop.Cart;
import shop.RealItem;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class JsonParserTest {
    private JsonParser jParser;
    private Cart fakeCart;
    private static final String CART_NAME = "testCart";
    private static final File TEST_READING_FILE = new File("src/test/resources/" + CART_NAME + ".json");
    private static final File TEST_WRITTEN_FILE = new File ("src/main/resources/" + CART_NAME + ".json");
    private static final double ITEM_PRICE = 12.4;
    private static final double ITEM_WEIGHT = 1.2;
    private static final String ITEM_NAME = "fake item";

    @BeforeEach
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
    @DisplayName("checking if writeToFile() method call does not throw exception and еру written file actually exists")
    public void testWriteToFile() {
        assertAll(
                ()-> assertDoesNotThrow(() -> jParser.writeToFile(fakeCart)),
                ()-> assertTrue(TEST_WRITTEN_FILE.exists())
        );
    }

    @Test
    @DisplayName("checking if readFromFile() method is able to read data correctly")
    public void testReadValidFile() {
        Cart tempCart = jParser.readFromFile(TEST_READING_FILE);
        assertAll(
                () -> assertEquals(tempCart.getCartName(), CART_NAME),
                () -> assertEquals(tempCart.getTotalPrice(), fakeCart.getTotalPrice())
        );
    }
    @AfterEach
    public void eraseWrittenTestData(){
        TEST_WRITTEN_FILE.delete();
    }
}

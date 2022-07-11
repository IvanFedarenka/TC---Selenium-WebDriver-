
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
    private static final String TEST_READING_FILE = "src/test/resources/testCart.json";
    private static final String TEST_WRITTEN_FILE = "src/main/resources/testCart.json";
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
                () -> assertDoesNotThrow(() -> jParser.writeToFile(fakeCart), "failed 'testWriteToFile' with valid file"),
                () -> assertTrue(new File(TEST_WRITTEN_FILE).exists(), "failed 'testWriteToFile', written file not found")
        );
    }

    @Test
    @DisplayName("checking if readFromFile() method is able to read data correctly")
    public void testReadValidFile() {
        Cart tempCart = jParser.readFromFile(new File(TEST_READING_FILE));
        assertAll(
                () -> assertEquals(tempCart.getCartName(), CART_NAME, "failed 'testReadValidFile', names of Cart not matches"),
                () -> assertEquals(tempCart.getTotalPrice(), fakeCart.getTotalPrice(), "failed 'testReadValidFile', price values not matches")
        );
    }

    @AfterEach
    public void eraseWrittenTestData() {
        new File(TEST_WRITTEN_FILE).delete();
    }
}


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import parser.JsonParser;
import shop.Cart;
import shop.RealItem;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonParserTest {
    private static JsonParser jParser;

    @BeforeAll
    public static void initData() {
        jParser = new JsonParser();
    }

    public static List<Cart> params() {
        Cart fakeCart1 = new Cart("cart1.xml");
        fakeCart1.addRealItem(new RealItem());
        Cart fakeCart2 = new Cart("cart2.exe");
        fakeCart2.addRealItem(new RealItem());
        Cart fakeCart3 = new Cart("cart3.doc");
        fakeCart3.addRealItem(new RealItem());
        Cart fakeCart4 = new Cart("cart4");
        fakeCart4.addRealItem(new RealItem());
        Cart fakeCart5 = new Cart("cart5");
        fakeCart5.addRealItem(new RealItem());
        return List.of(fakeCart1, fakeCart2, fakeCart3, fakeCart4, fakeCart5);
    }

    @ParameterizedTest
    @MethodSource("params")
    public void testWriteToFile(Cart fakeCart){
        assertDoesNotThrow(()-> jParser.writeToFile(fakeCart));
    }

    @Test
    public void testReadValidFileSmoke(){
        assertTrue(jParser.readFromFile(new File("src/test/resources/andrew-cart.json")) instanceof Cart);

    }
    @Test
    public void testReadValidFile(){
        Cart cart = jParser.readFromFile(new File("src/test/resources/eugen-cart.json"));
        assertAll(
                ()-> assertNotNull(cart.getCartName()),
                ()-> assertTrue(cart.getTotalPrice()!=0)

        );
    }
}

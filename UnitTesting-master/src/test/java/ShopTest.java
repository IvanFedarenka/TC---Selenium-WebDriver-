
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import static org.junit.jupiter.api.Assertions.*;

public class ShopTest {
    private Cart testCart;
    private RealItem realItem;
    private VirtualItem virtualItem;
    private final String cartName = "TestCart";
    private final double realItemWeight = 1.52;
    private final double virtualItemSize = 11.63;
    private final double realItemPrice = 11.2;
    private final double virtualItemPrice = 11.2;

    @BeforeEach
    public void createData() {
        testCart = new Cart(cartName);
        realItem = new RealItem();
        virtualItem = new VirtualItem();
        realItem.setPrice(realItemPrice);
        virtualItem.setPrice(virtualItemPrice);
        testCart.addRealItem(realItem);
        testCart.addVirtualItem(virtualItem);
    }

    @Test
    @DisplayName("Cart class test#1: checking does Cart.addRealItem() method increases the 'total Price' value")
    public void testTotalPrice() {
        double expectedTotalPrice = realItemPrice + virtualItemPrice + (realItemPrice + virtualItemPrice) * 0.2;
        assertEquals(expectedTotalPrice, testCart.getTotalPrice());
    }

    @Test
    @DisplayName("Cart class test#2: testing whether the cart name is set correctly")
    public void testGetCartName() {
        assertEquals(cartName, testCart.getCartName());
    }

    @Test
    @DisplayName("RealItem class test: testing whether the item's weight is set correctly ")
    public void testRealItemSetWeight() {
        realItem.setWeight(realItemWeight);
        assertEquals(realItemWeight, realItem.getWeight());
    }

    @Test
    @DisplayName("VirtualItem class test: testing whether the item's size is set correctly ")
    public void testVirtualItemSetSize() {
        virtualItem.setSizeOnDisk(virtualItemSize);
        assertEquals(virtualItemSize, virtualItem.getSizeOnDisk());
    }
}

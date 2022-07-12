
import jdk.jfr.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Coherent.sample.shop.Cart;
import com.Coherent.sample.shop.RealItem;
import com.Coherent.sample.shop.VirtualItem;

import static org.testng.Assert.*;

public class ShopTest {

    private Cart testCart;
    private RealItem realItem;
    private VirtualItem virtualItem;
    private final String cartName = "TestCart";
    private final double realItemWeight = 1.52;
    private final double virtualItemSize = 11.63;
    private final double realItemPrice = 11.2;
    private final double virtualItemPrice = 11.2;

    @BeforeMethod
    public void createData() {
        testCart = new Cart(cartName);
        realItem = new RealItem();
        virtualItem = new VirtualItem();

        realItem.setPrice(realItemPrice);
        virtualItem.setPrice(virtualItemPrice);

        testCart.addRealItem(realItem);
        testCart.addVirtualItem(virtualItem);
    }

    @Test(groups = {"Cart"})
    @Description("Cart class test#1: checking does Cart.addRealItem() method increases the 'total Price' value")
    public void testTotalPrice() {
        double expectedTotalPrice = realItemPrice + virtualItemPrice;
        assertEquals(expectedTotalPrice, testCart.getTotalPrice(), "'testTotalPrice', total price calculating error");
    }

    @Test(groups = {"Cart"})
    @Description("Cart class test#2: testing whether the cart name is set correctly")
    public void testGetCartName() {
        assertEquals(cartName, testCart.getCartName(), "'testGetCartName', cart names aren't matches");
    }

    @Test(groups = {"Items"})
    @Description("RealItem class test: testing whether the item's weight is set correctly ")
    public void testRealItemSetWeight() {
        realItem.setWeight(realItemWeight);
        assertEquals(realItemWeight, realItem.getWeight(), "'testRealItemSetWeight', real Item weight not matches with expected");
    }

    @Test(groups = {"Items"})
    @Description("VirtualItem class test: testing whether the item's size is set correctly ")
    public void testVirtualItemSetSize() {
        virtualItem.setSizeOnDisk(virtualItemSize);
        assertEquals(virtualItemSize, virtualItem.getSizeOnDisk(), "'testVirtualItemSetSize', virtual item's size not matches with expected");
    }
}

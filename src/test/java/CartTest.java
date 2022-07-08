
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import shop.Cart;
import shop.Item;
import shop.RealItem;
import shop.VirtualItem;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class CartTest {
    static Cart testCart;
    static RealItem[] testRealItems;
    static VirtualItem[] testVirtualItems;

    @BeforeAll
    public static void createData() {
        testCart = new Cart("TestCart");
        RealItem item1 = new RealItem();
        RealItem item2 = new RealItem();
        item1.setPrice(11.2);
        item2.setPrice(22.4);
        testRealItems = new RealItem[]{item1, item2};
        VirtualItem item3 = new VirtualItem();
        VirtualItem item4 = new VirtualItem();
        item3.setPrice(123.1);
        item4.setPrice(3.4);
        testVirtualItems = new VirtualItem[]{item3, item4};
    }


    @Test
    public void testAddRealItem() throws NoSuchFieldException, IllegalAccessException {
        final double totalPrice = testCart.getTotalPrice();
        testCart.addRealItem(testRealItems[0]);
        testCart.addRealItem(testRealItems[1]);
        List<RealItem> list = (List<RealItem>) getPrivateField("realItems");

        assertAll(
                () -> assertEquals(2, list.size()),
                () -> assertTrue(list.contains(testRealItems[0]) && list.contains(testRealItems[1])),
                () -> assertTrue(testCart.getTotalPrice() > totalPrice)
        );
    }

    @Test
    public void testAddVirtualItem() throws NoSuchFieldException, IllegalAccessException {
        final double totalPrice = testCart.getTotalPrice();
        testCart.addVirtualItem(testVirtualItems[0]);
        testCart.addVirtualItem(testVirtualItems[1]);
        List<VirtualItem> list = (List<VirtualItem>) getPrivateField("virtualItems");

        assertAll(
                () -> assertEquals(2, list.size()),
                () -> assertTrue(list.contains(testVirtualItems[0]) && list.contains(testVirtualItems[1])),
                () -> assertTrue(testCart.getTotalPrice() > totalPrice)
        );
    }

    private List<? extends Item> getPrivateField(String fieldName) throws IllegalAccessException, NoSuchFieldException {
        Field realItems = testCart.getClass().getDeclaredField(fieldName);
        realItems.setAccessible(true);
        return (List<? extends Item>) realItems.get(testCart);
    }
}

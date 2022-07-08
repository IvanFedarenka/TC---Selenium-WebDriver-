import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shop.VirtualItem;

public class VirtualItemTest {



    @Test
    public void testToString() {
        VirtualItem virtualItem = new VirtualItem();
        double size = 11.63;
        virtualItem.setSizeOnDisk(size);
        String expected = "Size on disk: " + size;
        Assertions.assertTrue(virtualItem.toString().endsWith(expected));
    }
}

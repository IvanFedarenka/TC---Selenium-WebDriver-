import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shop.RealItem;

public class RealItemTest {

    @Test
    public void testToString(){
        RealItem realItem = new RealItem();
        double weight = 1.52;
        realItem.setWeight(weight);
        String expected = "Weight: " + weight;
        Assertions.assertTrue(realItem.toString().endsWith(expected));
    }
}

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by mayz985 on 9/1/15.
 */
public class CarTest {
    @Test
    public void testWholeName() {
        String wholeName = (new Car()).wholeName("may", "zhang");
        Assert.assertEquals(wholeName, "may, zhang", "Failed with wholeName");
    }
}

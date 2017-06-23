import org.apache.commons.lang3.StringEscapeUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Created by mayz985 on 9/1/15.
 */
public class CarTest {
    @Test
    public void testWholeName() {
        String wholeName = (new Car()).wholeName("may", "zhang");
        Assert.assertEquals(wholeName, "may, zhang", "Failed with wholeName");
    }

    @Test
    public void testJacksonMarshalToObject() {

        String jsonFileName = "json/MyCar.json";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Car jsonCar = objectMapper.readValue(getClass().getResourceAsStream(jsonFileName), Car.class);

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testJacksonUnmarshalFromObjectToTxt() {
        Car myCar = new Car();
        myCar.setCarAge("19");
        myCar.setCarName("CreatedFromCode");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File("/tmp/MyCarOutput.json"), myCar);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

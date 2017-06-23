import Pattern.Elvis;

import java.util.Calendar;

/**
 * Created by mayz985 on 9/1/15.
 */
public class Car {



    String carName;
    String carAge;


    private Car(String carName, String carAge) {
        this.carName = carName;
        this.carAge = carAge;
    }



    public String getCarName() {


        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarAge() {
        return carAge;
    }

    public void setCarAge(String carAge) {
        this.carAge = carAge;
    }

    public Calendar calendar;
    public String wholeName(String firstname, String lastname) {
        return firstname + ", " + lastname;
    }

    public String nickName(String firstname, String lastname) {
        return firstname + ", " + lastname;
    }



    Car() {}

    public static class CarBuilder {
        String carName;
        String carAge;
        public CarBuilder carName(String carName) {
            this.carName = carName;
            return this;
        }
        public CarBuilder carAge(String carAge) {
            this.carAge = carAge;
            return this;
        }
        Car build() {
            return new Car(carName, carAge);
        }
    }


    public static void main(String[] args) {
        new CarBuilder().carName("name").carAge("10").build();
    }

}

import java.io.IOException;
import java.util.Date;

/**
 * Created by mayz985 on 9/1/15.
 */

public class Name {
    static{
        System.out.println("I am in initialization block.");
    }

    public String wholeName(String firstname, String lastname) {
        return firstname + ", " + lastname;
    }

    public String nickName(String firstname, String lastname) {
        return firstname + ", " + lastname;
    }

    public String processTime() {
        Date myDate = new Date();
        return myDate.toString();
    }

    private String getBirthDate() {
        System.out.println("private method is invoked....");
        return "privateBirthDate";
    }


    public String processBirthDate() {


        return getBirthDate() + " processed";
    }

    public static String getStaticYear() {
        return "2015";
    }

    public String getCountry() throws IOException {
        return "US";
    }

    Name() {
        System.out.println("In Constructor Name. ");
    }

    Name(String input) {
        System.out.println("In constructor with parameters");
    }

    public static void main(String[] args) {
        Car myCar = new Car();
        System.out.println("Hello World");
    }
}

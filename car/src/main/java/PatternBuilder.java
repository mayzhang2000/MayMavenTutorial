/**
 * Created by mayz985 on 9/8/16.
 */



public class PatternBuilder{
    String name;

    private PatternBuilder(String name) {
        this.name = name;
    }

    public static class CarWithBuilderDemoBuilder {
        String name;
        public CarWithBuilderDemoBuilder withName(String name) {
            this.name = name;


            return this;
        }
        public PatternBuilder build() {
            return new PatternBuilder(this.name);
        }

    }

    public void printName() {
        System.out.println(name);
    }

    public static void main(String[] args) {
        new PatternBuilder.CarWithBuilderDemoBuilder().withName("lexus").build().printName();


    }

}

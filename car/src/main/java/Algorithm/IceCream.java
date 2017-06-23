package Algorithm;

/**
 * Created by mayz985 on 1/13/17.
 */
public class IceCream implements Comparable {
    int index;
    int price;
    IceCream(int index, int price) {
        this.index = index;
        this.price = price;
    }

    @Override
    public int compareTo(Object o) {
        return this.price - ((IceCream) o).price;
    }

    public boolean equals(Object o) {
        return this.price == ((IceCream) o).price;
    }
}

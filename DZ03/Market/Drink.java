package DZ03.Market;

import java.util.Date;

public class Drink extends Food{
    private double volume;

    public Drink(String name, int price, String prodDate, int shelfLife, double volume) {
        super(name, price, prodDate, shelfLife);
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }
}

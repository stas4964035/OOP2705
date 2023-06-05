package DZ03.Market;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Food extends Product{
    private String prodDate;
    private int shelfLife;
    private int 

    public Food(String name, int price, String prodDate, int shelfLife) {
        super(name, price);
        this.prodDate = prodDate;
        this.shelfLife = shelfLife;
    }

    public String getProdDate() {
        return prodDate;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    @Override
    public String toString() {
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            int daysLeft = (int) ((now.getTime() - format.parse(this.getProdDate()).getTime()) / (24 * 60 * 60 * 1000));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return super.getName() + "(годен до: " + this.
    }
}

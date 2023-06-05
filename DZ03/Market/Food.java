package DZ03.Market;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Food extends Product {
    private Date prodDate;
    private long shelfLong;
    private Date shelfEnd;

    /***
     *
     * @param name
     * @param price
     * @param prodDate
     * @param shelfLong
     */
    public Food(String name, int price, String prodDate, long shelfLong) {
        super(name, price);
        SimpleDateFormat parser = new SimpleDateFormat("dd.MM.yyyy");
        try {
            this.prodDate = parser.parse(prodDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.shelfLong = shelfLong;
        this.shelfEnd = new Date(this.prodDate.getTime() + this.shelfLong * (24 * 60 * 60 * 1000));
    }

    public String getProdDate() {
        return new SimpleDateFormat("dd.MM.yyyy").format(this.prodDate);
    }

    public long getShelfLife() {
        return shelfLong;
    }

    public String getShelfEnd() {
        return new SimpleDateFormat("dd.MM.yyyy").format(this.shelfEnd);
    }

    @Override
    public String toString() {
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return super.getName() + " " + super.getPrice() + "(годен до: " + this.getShelfEnd() + ")" +
                (this.shelfEnd.before(new Date()) ? "ЗАКОНЧИЛСЯ СРОК ГОДНОСТИ!" : "");
    }
}

import java.io.Serializable;

public class BirthDayCake implements Serializable {

    private String message = "誕生日おめでとう🍰";
    private int candles = 0;
    private double price = 0;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCandles() {
        return candles;
    }

    public void setCandles(int candles) {
        this.candles = candles;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

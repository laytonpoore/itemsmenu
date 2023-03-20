import java.io.Serializable;

public class Item implements Serializable {

    private String upc;
    private String description;
    private int price;

    public Item(String upc, String description, int price) {
        this.upc = upc;
        this.description = description;
        this.price = price;
    }

    public String getUpc() {
        return upc;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }
}

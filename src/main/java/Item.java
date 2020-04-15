/**
 * Description:
 * User: Lzj
 * Date: 2020-04-14
 * Time: 11:26
 */
public class Item {
    private String name;
    private int price; // 分为单位

    public Item() {
    }

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
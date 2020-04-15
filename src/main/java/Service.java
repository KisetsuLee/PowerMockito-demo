/**
 * Description:
 * User: Lzj
 * Date: 2020-04-14
 * Time: 11:24
 */
public class Service {
    private Dao dao;

    public Service(Dao dao) {
        this.dao = dao;
    }

    public Item createItem(Item item) {
        checkItemHasName(item);
        int price = checkPrice(item.getPrice());
        item.setPrice(price * 2);
        return dao.createNewItem(item);
    }

    private void checkItemHasName(Item item) {
        if (item.getName() == null) {
            throw new RuntimeException("没有名字");
        }
    }

    private int checkPrice(int price) {
        if (price > 100) {
            throw new RuntimeException("太贵了");
        }
        return price;
    }
}

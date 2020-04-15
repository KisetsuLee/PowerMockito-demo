import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.times;

/**
 * Description:
 * User: Lzj
 * Date: 2020-04-14
 * Time: 11:36
 */
@RunWith(PowerMockRunner.class)
// We prepare PartialMockClass for test because it's final or we need to mock private or static methods
@PrepareForTest(Service.class)
class ServiceTest {

    @Test
    void createItem() throws Exception {
        Dao dao = PowerMockito.mock(Dao.class);
        Service service = PowerMockito.spy(new Service(dao));
        Item item = PowerMockito.mock(Item.class);

        Mockito.when(item.getName()).thenReturn("name");
        Mockito.when(item.getPrice()).thenReturn(90);
        Mockito.when(dao.createNewItem(item)).thenReturn(item);
        // PowerMockito.doNothing()
        //         .when(service, "checkItemHasName", item);
        Assertions.assertEquals(item, service.createItem(item));

        Mockito.verify(item).getName();
        PowerMockito.verifyPrivate(service, times(1))
                .invoke("checkItemHasName", item);
        PowerMockito.verifyPrivate(service, times(1))
                .invoke("checkPrice", item.getPrice());
    }
}

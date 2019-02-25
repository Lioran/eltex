import com.ex.Abonent;
import org.junit.Test;
import junit.framework.Assert;

public class TestAbonent {
    @Test
    public void testSetFio(){
        Abonent somebodyAbonent = new Abonent();
        somebodyAbonent.setFio("Lioran");
        String name = "Lioran";
        Assert.assertEquals(somebodyAbonent.getFio(), name);
    }

    @Test
    public void testSetPhone(){
        Abonent somebodyAbonent = new Abonent();
        somebodyAbonent.setPhone("123456789");
        String phone = "123456789";
        Assert.assertEquals(somebodyAbonent.getPhone(), phone);
    }

    @Test
    public void testSetAdress(){
        Abonent somebodyAbonent = new Abonent();
        somebodyAbonent.setAdress("street");
        String street = "street";
        Assert.assertEquals(somebodyAbonent.getAdress(), street);
    }
}

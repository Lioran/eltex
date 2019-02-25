import com.ex.Abonent;
import com.ex.AbonentInPhoneBook;
import org.junit.Test;
import junit.framework.Assert;

import java.util.*;

public class TestWorkOfAbonent {
    @Test
    public void testFindById(){
        AbonentInPhoneBook abonentInPhoneBook = new AbonentInPhoneBook();
        Abonent for_check = new Abonent();
        for_check.setFio("Dimas");
        for_check.setPhone("1");
        for_check.setAdress("1");
        Assert.assertEquals(for_check.getFio(), abonentInPhoneBook.findById(1).getFio());
        Assert.assertEquals(for_check.getPhone(), abonentInPhoneBook.findById(1).getPhone());
        Assert.assertEquals(for_check.getAdress(), abonentInPhoneBook.findById(1).getAdress());
    }
    
}

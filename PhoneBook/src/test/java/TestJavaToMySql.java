import com.ex.Abonent;
import com.ex.JavaToMySql;
import org.junit.Test;
import junit.framework.Assert;

public class TestJavaToMySql {
    @Test
    public void testAddToJDBC(){
        JavaToMySql for_check = new JavaToMySql();
        Abonent somebodyAbonent = new Abonent();
        somebodyAbonent.setFio("Lioran");
        somebodyAbonent.setPhone("123");
        somebodyAbonent.setAdress("street");
        String result  = for_check.addToJDBC(somebodyAbonent);
        String query = "INSERT INTO abonents (fio, phone, adress) VALUE('Lioran','123','street');";
        Assert.assertEquals(query, result);
    }
    @Test
    public void testDeleteToJDBC(){
        JavaToMySql for_check = new JavaToMySql();
        String result  = for_check.delToJDBC(1);
        String query = "DELETE FROM abonents WHERE id = 1;";
        Assert.assertEquals(query, result);
    }
    @Test
    public void testAllToJDBC(){
        JavaToMySql for_check = new JavaToMySql();
        String result  = for_check.allToJDBC();
        String query = "SELECT * FROM abonents;";
        Assert.assertEquals(query, result);
    }
    @Test
    public void testSearchToJDBC(){
        JavaToMySql for_check = new JavaToMySql();
        String result  = for_check.searchToJDBC("Lioran");
        String query = "SELECT * FROM abonents WHERE fio = Lioran;";
        Assert.assertEquals(query, result);
    }
}

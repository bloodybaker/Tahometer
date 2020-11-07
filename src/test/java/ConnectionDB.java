import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class ConnectionDB {
    private Data data = new Data();

    @Rule
    public TestName name = new TestName();

    @Test
    public void connection() {
        System.out.println(name.getMethodName() + ": " + data.isConnected());
        Assert.assertTrue(data.isConnected());
    }
    @Test
    public void loginCheck() {
        System.out.println(name.getMethodName() + ": " + data.login("admin","Lock2612"));
        Assert.assertTrue(data.login("admin","Lock2612"));
    }
}

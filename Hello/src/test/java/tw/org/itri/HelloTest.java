package tw.org.itri;
import org.junit.Test;
import static junit.framework.Assert.*;

public class HelloTest {
    @Test
    public void testSayHello() {
        Hello hello = new Hello();
        String results = hello.sayHello();
        assertEquals("Hello John", results);
    }

    @Test
    public void testGetFriendName() {
        Hello hello = new Hello();
        String results = hello.getFriendName();
        assertEquals("John", results);
    }
}
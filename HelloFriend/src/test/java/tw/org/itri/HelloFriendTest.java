package tw.org.itri;

import org.junit.Test;
import static junit.framework.Assert.*;
import tw.org.itri.Hello;

public class HelloFriendTest {
    @Test
    public void testSayHelloToFriend() {
        HelloFriend helloFriend = new HelloFriend();
        String results = helloFriend.sayHelloToFriend();
        assertEquals("Hello John, I'm Austin", results);
    }

    @Test
    public void testSayMyName() {
        HelloFriend helloFriend = new HelloFriend();
        String results = helloFriend.sayMyName();
        assertEquals(", I'm Austin", results);
    }
}
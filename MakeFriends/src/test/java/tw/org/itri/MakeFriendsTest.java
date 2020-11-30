package tw.org.itri;
import org.junit.Test;
import static junit.framework.Assert.*;

public class MakeFriendsTest {

    @Test
    public void testMakeFriends() {
        MakeFriends makeFriends = new MakeFriends();
        String results = makeFriends.makeFriends();
        assertEquals("Hello John, I'm Austin. Nice to meet you!", results);
    }

    @Test
    public void testSayNiceToMeetYou() {
        MakeFriends makeFriends = new MakeFriends();
        String results = makeFriends.sayNiceToMeetYou();
        assertEquals(". Nice to meet you!", results);
    }
}
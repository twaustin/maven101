package tw.org.itri;

public class MakeFriends {

	public String makeFriends() {
		HelloFriend friend = new HelloFriend();
		friend.sayHelloToFriend();
		String str = friend.sayHelloToFriend() + sayNiceToMeetYou();
		return str;
	}

	public String sayNiceToMeetYou() {
        return ". Nice to meet you!";
	}

	public static void main(String[] args) {
        MakeFriends makeFriends = new MakeFriends();
        System.out.println(makeFriends.makeFriends());
    }

}

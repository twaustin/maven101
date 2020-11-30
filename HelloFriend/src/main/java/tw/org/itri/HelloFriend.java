package tw.org.itri;
import tw.org.itri.Hello;

public class HelloFriend {
    public String sayHelloToFriend() {
        Hello hello = new Hello();
        String str = hello.sayHello() + this.sayMyName();
        return str;
    }

    public String sayMyName() {
        return ", I'm Austin";
    }
}
package tw.org.itri;

public class Hello {

    public String sayHello() {
        return "Hello " + getFriendName();
    }

    public String getFriendName() {
        return "John";
    }

    public static void main(String[] args) {
        Hello hello = new Hello();
        System.out.println(hello.sayHello());
    }
}
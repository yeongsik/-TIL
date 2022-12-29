package book.jungsuk.ch07;

class F {
    void methodA() {
        I2 i = InstanceManager.getInstance();
        i.methodB();
        System.out.println(i.toString());
    }
}

interface I2 {
    void methodB();
}

class D implements I2 {
    @Override
    public void methodB() {
        System.out.println("methodB in B class");
    }

    public String toString() {
        return "class B";
    }
}

class InstanceManager {
    public static I2 getInstance() {
        return new D();
    }
}

public class InterfaceTest3 {
    public static void main(String[] args) {
        F f = new F();
        f.methodA();

        /*
        JDBC의 DriverManager 클래스가 이런 방식으로 되어있음
        제 3의 클래스를 통해 인터페이스 제공
        나중에 다른 캘르스의 인스턴스로 변경되어도 A클래스 변경 없이 getInstance()만 변경하면 된다는 장점 갖고 있다.
         */
    }
}

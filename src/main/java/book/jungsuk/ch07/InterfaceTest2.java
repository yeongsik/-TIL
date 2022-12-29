package book.jungsuk.ch07;

class A {
    void autoPlay(I i) {
        i.play();
    }
}

interface I {
    void play();
}

class B implements I {
    @Override
    public void play() {
        System.out.println("play in B class");
    }
}

class C implements I {
    @Override
    public void play() {
        System.out.println("play in C class");
    }
}
public class InterfaceTest2 {
    public static void main(String[] args) {
        A a = new A();
        a.autoPlay(new B());
        a.autoPlay(new C());

        /*
        Thread 클래스의 생성자가 이런 방식으로 구성되어 있다.

        public Thread(Runnable target) {
            this(null, target, "Thread-" + nextThreadNum(), 0);
        }

        Runnable은 인터페이스
        @FunctionalInterface
        public interface Runnable {
            public abstract void run();
        }
         */
    }
}

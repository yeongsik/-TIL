package book.jungsuk.ch06;

class Data {
    int x;
}
public class PrimitiveParamEx {
    public static void main(String[] args) {
        // 기본형 매개변수는 값을 읽기만 할 수 있다.
        // 값이 복사
        Data d = new Data();
        d.x = 10;
        System.out.println("main() : x = " + d.x);
        change(d.x);

        System.out.println("After change(d.x)");
        System.out.println("main() : x = " + d.x);

    }

    static void change(int x) {
        x = 1000;
        System.out.println("change() : x = " + x);

    }
}

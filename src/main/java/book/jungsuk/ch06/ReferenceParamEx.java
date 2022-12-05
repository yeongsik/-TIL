package book.jungsuk.ch06;


public class ReferenceParamEx {

    public static void main(String[] args) {

        // 참조형 매개변수는 주소를 복사하기 때문에 메서드 매개변수로 받은 참조형 인수도 같은 주소값을 바라보고 있음
        // 변수 값을 읽고, 변경 가능
        Data d = new Data();
        d.x = 10;

        System.out.println("main() : x = " + d.x);
        change(d);
        System.out.println("After change(d.x)");
        System.out.println("main() : x = " + d.x);
    }

    static void change(Data data) {
        data.x = 1000;
        System.out.println("change() : x = " + data.x);
    }
}

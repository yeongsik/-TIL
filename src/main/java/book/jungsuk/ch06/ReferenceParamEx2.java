package book.jungsuk.ch06;

public class ReferenceParamEx2 {

    // 배열도 객체와 같이 참조변수를 통해 데이터가 저장된 공간에 접근하기 때문에 객체와 같이 수정과 읽기가 가능
    public static void main(String[] args) {
        int[] x = {10};
        System.out.println("main() : x = " + x[0]);

        change(x);
        System.out.println("After change(d.x)");
        System.out.println("main() : x = " + x[0]);
    }

    static void change(int[] x) {
        x[0] = 1000;
        System.out.println("change() : x = " + x[0]);
    }
}

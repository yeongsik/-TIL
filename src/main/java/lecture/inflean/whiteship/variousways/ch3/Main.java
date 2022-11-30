package lecture.inflean.whiteship.variousways.ch3;

public class Main {

    public void work() {
        /*
            Main 클래스가 로딩이 되면
            Main.class 인스턴스가 저장이 된다.
         */

        Class<Main> mainClass = Main.class; // 이런 타입의 객체가 힙영역에 생성 -> 모든 쓰레드에서 공용으로 사용

    }
}

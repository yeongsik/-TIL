package lecture.inflean.whiteship.variousways.ch2;

public class Main {

    static String myName; // 클래스 로더에서 초기화 : 스태틱 변수들이 초기화

    static { // 스태틱 블록
        myName = "YEONGSIK";
    }

    private String foo = "bar"; // 메소드 영역에 저장된다. -> 다른 영역에서도 참조할 수 있는 정보들

    public static void main(String[] args) {
        System.out.println(Main.class.getSuperclass()); // 상속 안 받아서 상위 클래스 : Object ( 기본 )
        // JVM 메모리에 메소드 영역에 해당 클래스 수준 정보가 저장된다. ( 풀 패키지 경로의 클래스 이름, 부모 클래스 이름 , 변수, 메소드 등 )

        // 힙 영역에는 인스턴스(객체)들이 저장된다.
        Main main = new Main(); // heap 메모리에 저장

        // 스택 , PC 레지스터 , 네이티브 메소드 스택 -> 쓰레드에 국한된다. 모든 영역에 공유되진 않음
        // 힙과 메소드 영역은 모든 영역 공유되는 공간

        // 스택 영역 : 쓰레드 마다 런타임 스택을 만들고 그 안에다가 스택 프레임을 쌓는다. 스택 프레임 == 메소드 콜 -> 콜 스택을 쌓는다.
        // 에러 메세지 로그에 메서드가 쭉 쌓여있는 것
        // PC 레지스터(PC register) : 쓰레드마다 쓰레드 내 현재 실행할 스택 프레임을 가리키는 포인터 생성 ( 해당 쓰레드에 국한 )
        // PC -> Program Counter
        // 네이티브 메소드 스택 : 네이티브 메소드 호출할 때 사용되는 스택

        // 이러한 배경 지식은 자바 애플리케이션을 프로파일링할 때 사용

        // 네이티브 메소드 : 자바로 구현된 것이 아닌 C나 C++로 구현된 메소드
        Thread.currentThread();
        /*
            메소드의 native가 붙어 있다.
            @HotSpotIntrinsicCandidate
            public static native Thread currentThread();
         */

        // 위와 같은 것들을 JNI(Java Native Interface)라 부른다.
        // 실제 구현된 것을 네이티브 메소드 라이브러리 ( JNI를 통해 사용 )

        /*
            네이티브 메소드를 사용하는 코드가 있다면
            내부적으로 네이티브 메소드 스택 에 JNI 호출하는 프레임이 쌓인다.
         */

    }
}

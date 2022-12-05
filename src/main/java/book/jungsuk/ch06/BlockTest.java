package book.jungsuk.ch06;

public class BlockTest {
    /*
        객체 생성 과정
        클래스변수들 메모리 생성 -> 클래스 초기화 블록(클래스 로딩될 때 처음 실행)-> 인스턴스 초기화 블록 -> 생성자

        클래스 변수 초기화 순서 : 기본값 -> 명시적초기화 -> 초기화블록
        인스턴스 변수의 초기화 순서 : 기본값 -> 명시적초기화 -> 인스턴스 초기화블록 -> 생성자
     */
    static {
        System.out.println("static 초기화 (클래스 변수 초기화)");
    }

    {
        System.out.println("인스턴스 변수 초기화 블록");
    }

    public BlockTest(){
        System.out.println("생성자");
    }


    public static void main(String[] args) {
        System.out.println("BlockTest bt = new BlockTest()");
        BlockTest bt = new BlockTest();

        System.out.println("BlockTest bt2 = new BlockTest()");
        BlockTest bt2 = new BlockTest();

    }
}

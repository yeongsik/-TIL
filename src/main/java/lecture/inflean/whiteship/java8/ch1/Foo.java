package lecture.inflean.whiteship.java8.ch1;

public class Foo {
    public static void main(String[] args) {

        // 함수형 인터페이스를 구현해서 써야함 자바 8 이전 방법 : 익명 내부 클래스 anonymous inner class
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("Hello");
                System.out.println("lambda");
            }
        };

        // 자바 8 버전 부터 줄여서 쓸 수 있는 문법이 생겼다 : 람다 표현식
        /*
            함수형 인터페이스를 구현할 때 쓸 수 있는 람다형태의 표현식
            코드를 많이 줄일 수 있다. 내부적으로 동일
            특수한 형태의 오브젝트(First class Object : 일급 객체)라고 볼 수 있다.

            자바는 객체지향 언어이기 때문에 함수처럼 보여도 특수한 형태의 오브젝트이기에
            변수 할당, 메서드 파라미터 전달, 리턴 타입으로 리턴이 가능하다.

            고차 함수 : 함수가 함수를 파라미터로 받거나 함수를 리턴하는 경우를 고차함수라 한다.
            -> 자바에서
         */
        RunSomething runSomething2 = () -> System.out.println("Hello");

        // 내부에서 해야하는 일이 한 줄이 아닐 때
        RunSomething runSomething3 = () -> {
            System.out.println("Hello");
            System.out.println("lambda");
        };

        runSomething2.doIt();
        runSomething3.doIt();

        RunSomething2 runSomething4 = ( num ) -> {
            return num + 10;
        };

        // 순수함수 : 입력받은 값이 동일하면 결과값이 같아야 한다. -> 이 조건이 보장되지 않으면 함수형 프로그래밍이라고 볼 수 없다.
        System.out.println(runSomething4.doIt(1));
        System.out.println(runSomething4.doIt(1));
        System.out.println(runSomething4.doIt(1));

        // 같은 값이 나오지 않는 경우 1 : 밖에 있는 값을 참조해서 쓰는 경우
        // 어떤 상태값에 의존한다고 볼 수 있다.
        int baseNumber = 10; // 여기도 함수의 밖

        RunSomething2 runSomething21 = new RunSomething2() {
            // 여기도 함수의 밖
            @Override
            public int doIt(int number) {
                return number + baseNumber ;
                // 로컬 변수를 참조할 때 변경 불가능 -> 컴파일 에러 발생
            }
        };

        // 같은 값이 나오지 않는 경우 1 : 외부 값을 변경하려고 하는 경우 - 함수형 프로그래밍이 아니다.
        RunSomething2 runSomething22 = new RunSomething2() {
            // 여기도 함수의 밖
            int baseNumber2 = 10;
            @Override
            public int doIt(int number) {
                baseNumber2++;
                return number + baseNumber ;
            }
        };

    }
}

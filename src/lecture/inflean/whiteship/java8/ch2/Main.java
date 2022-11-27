package lecture.inflean.whiteship.java8.ch2;

import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1));

        // 클래스 생략 해서 바로 생성
        Function<Integer, Integer> plusTen = (i) -> i + 10;
        System.out.println(plusTen.apply(1));


        // 함수 조합 ( 조합 메서드는 디폴트 메서드로 제공 -> andThen , compose
        Function<Integer,Integer> multiply = (i) -> i * 2;

        // compose 입력값을 가지고 먼저 뒤에오는 함수에 적용
        Function<Integer, Integer> multyply2AndPlus10 = plusTen.compose(multiply);// 10을 더하기 전에 곱하겠다.
        System.out.println(multyply2AndPlus10.apply(2)); // 2 * 2 + 10 = 14


        // andThen 뒤에다가 붙인다.
        Function<Integer, Integer> plus10AndMultyply2 = plusTen.andThen(multiply);
        System.out.println(plus10AndMultyply2.apply(2)); // ( 10 + 2 ) * 2 = 24

        // BiFunction<T,U,R> 입력 값이 두개 , 리턴 값이 하나인 함수형 인터페이스

        // Consumer<T> 입력 받아서 리턴하지 않음

        Consumer<Integer> print = (i) -> System.out.println(i);
        print.accept(10);

        // Supplier<T> 내가 어떤 값을 받아올 것이냐? 입력값이 없고, 반환만 있음
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        // Predicate<T> 인자값을 받아서 true , false 를 리턴해주는 함수형 인터페이스
        Predicate<String> startWithKwon = (s) -> s.startsWith("Kwon");
        Predicate<Integer> isEven = (i) -> i % 2 == 0;
        // or , and , negate로 조합 가능

        // UnaryOperator<T>  -> 특수 케이스 ( 입력값과 리턴값의 타입이 같을 때 사용 할 수 있다. Function 를 상속받았다.

        Function<Integer,Integer> minus10 = (i) -> i - 10;
        UnaryOperator<Integer> minusTen = (i) -> i -10;

        System.out.println(minus10.apply(15)); // 5
        System.out.println(minusTen.apply(15)); // 5
        // minus10 와 minusTen 는 같은 동작을 한다.
        // BinaryOperator<T> -> BiFunction 은 세 개의 값이 다를 가정으로 만들어진 것 ,
        // BiFunction의 특수한 형태 -> 세 개의 타입이 전부 같은 경우에 사용

    }
}

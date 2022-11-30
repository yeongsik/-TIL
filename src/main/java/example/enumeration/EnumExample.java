package example.enumeration;

enum Gender {
    MALE,
    FEMALE


}
public class EnumExample {


    // 기존 상수 설정 방법
    public static final String MALE = "MALE";
    public static final String FEMALE = "FEMALE";

    public static void main(String[] args) {

        // gender 객체에는 상수값만 넣으려는 목적을 가지고 있다.
        // 상수로 설정한 값이 아닌 다른 값이 설정될 때 컴파일 에러가 나타나지 않음
        String gender1;
        gender1 = EnumExample.MALE;
        gender1 = EnumExample.FEMALE;
        gender1 = "boy"; // 상수값이 아닌 값이 들어갈 수 있다.

        // Enum 클래스로 상수값을 사용할 때 다른 값이 설정 될 시 타입이 다르기에 컴파일 에러 발생 -> 상수값 타입안전성
        Gender gender2;
        gender2 = Gender.MALE;
        gender2 = Gender.FEMALE;
//        gender2 = "boy"; // 컴파일 에러 발생 부분

    }
}

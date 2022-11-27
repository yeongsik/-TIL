package example.enumeration;


public class Developer {

    // Enum 선언 방법 -> 내부 선언 , 외부 선언

    // 내부 선언
    private enum Dtype {
        WEB,DB
    }

    // 외부 선언
    private Dtype2 dtype;


    private String name;
    private int career;

    public Dtype2 getDtype() {
        return dtype;
    }

    public void setDtype(Dtype2 dtype) {
        this.dtype = dtype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCareer() {
        return career;
    }

    public void setCareer(int career) {
        this.career = career;
    }

    public static void main(String[] args) {
        Developer developer = new Developer();
        developer.setName("홍길동");
        developer.setCareer(3);
        developer.setDtype(Dtype2.WEB);
        System.out.println("개발자 이름 : " + developer.getName());
        System.out.println("개발자 경력 : " + developer.getCareer());
        System.out.println("개발자 직무 : " + developer.getDtype());

        // Enum static method : values() , valueOf()
        for (Dtype2 type : Dtype2.values()) {
            System.out.println(type);
        }
        // valueOf() : 매개변수로 주어진 String과 열거형에서 일치하는 이름을 갖는 원소를 리턴
        Dtype2 test1 = Dtype2.DB;
        Dtype2 test2 = Dtype2.valueOf("WEB"); // 일치하지 않을 경우 - IllegalArgumentException 발생

        System.out.println(test1);
        System.out.println(test2);

        // Enum non-static method : ordinal()
        /*
            원소에 열거된 순서를 정수 값으로 리턴
         */
        System.out.println(developer.getDtype().ordinal());
        developer.setDtype(Dtype2.DB);
        System.out.println(developer.getDtype().ordinal());
    }
}


// 외부 선언
enum Dtype2 {
    WEB,DB
}

// 열거형 상수 다른 값과 연결
enum Dtype3 {
    WEB("웹"),
    DB("데이터베이스"),
    JAVA("자바");

    final private String name;
    public String getName() {
        return name;
    }
    Dtype3(String name) {
        this.name = name;
    }
}

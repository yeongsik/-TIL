# 9장 lang 패키지, 유용한 클래스

# Object 클래스

- 모든 클래스의 최고 조상 , 오직 11개의 메서드만을 가지고 있음
- nofify() , wait() 등은 스레드와 관련된 메서드 → 뒤에 다룸
- finalize() → 거의 사용 X (생성자의 반대 개념 메서드 , 객체가 소멸할 때 마무리 작업)
    - 메모리를 정리할 때 finalize() 메서드 때문에 정리시간이 증가될 수 있기 때문에
- equals(obj) : 객체자신과 객체 obj가 같은 객체 여부 체크
- toString() : 객체 자신의 정보를 문자열로 반환
- getClass() : 객체의 클래스 정보를 담고 있는 Class인스턴스를 반환
    - Class : 클래스 정보를 담기 위한 클래스

### equals(Object obj)

- 반환 타입 boolean
- 오버라이딩 전 기본 : 객체의 주소를 비교 (참조변수 값 비교)
- 객체안에 들어있는 iv값을 비교하려면 오버라이딩을 해야한다.
    - 오버라이딩 시 매개변수가 Object 이므로 instanceof로 형변환 여부 체크

### hashCode()

- 객체의 해시코드를 반환하는 메서드
    - 해시코드 : 정수값 , 해싱 알고리즘에서 사용
- Object 클래스의 hashCode() 기능
    - 객체의 주소를 int로 변환해서 반환, 객체마다 다른 값 반환 → 객체의 지문
    - native 제어자를 갖고 있다.
        - OS의 메서드(C언어 작성)
        - native 메서드가 내용이 없는 이유 → OS의 메서드를 호출(JNI)

⚠️ equals를 오버라이딩 한다면 hashCode()도 같이 오버라이딩을 해야 한다.

⇒ 결과가 true인 두 객체의 해시코드도 같아야하기 때문이다.

- 만약 hashCode()를 오버라이딩 후 원래 hashCode() 기능이 필요할 경우 System.identityHashCode(Object obj) 를 사용

### toString()

- Object의 toString()
    
    return getClass().getName() + “@” + Integer.toHexString(HashCode());
    
    - 해당 클래스의 명과 해시코드 반환값을 16진으로 바꾼 숫자를 붙여서 보여준다.
- 원래 기본 메서드의 유용성이 떨어지므로 오버라이딩을 진행

# String 클래스

- 문자열을 다루는 클래스
- 데이터(char[]) + 메서드(문자열 관련)으로 이루어져있다.
- 내용을 변경할 수 없는 불변(Immutable) 클래스
- 문자열을 결합할 때 마다 새로운 객체가 생성된다. ⇒ 불변 클래스이기 때문
    
    ```java
    String a = "a"; => 0x100 객체주소
    String b = "b"; => 0x200 객체주소
    a = a+b; => a+b 결합한 객체가 생성되고 해당 주소 0x300가 참조변수에 재할당  
    ```
    
    ⇒ 문자열을 결합을 자주해야할 땐 StringBuffer 혹은 StringBuilder 사용
    

### 문자열 비교

- String str = “abc” 와 String str = new String(”abc”) 비교

```java
String str1 = "abc"; 0x100
String str2 = "abc"; 0x100
// 하나의 객체주소를 두개의 참조변수가 바라본다.
// str1 == str2 true

String str3 = new String("abc"); // 0x200 new 연산자로 새로운 객체 생성
String str4 = new String("abc"); // 0x300

// 같은 내용이지만 new 연산자로 새로 생성된 객체이므로 다른 주소를 두 참조변수가 바라본다.
// str3 == str4 false
```

- 문자열의 내용 비교는 equals()를 사용
- 문자열을 리터럴로 생성시 프로그램 실행시 자동생성된다 (Constant Pool에 저장)
    - 같은 내용의 문자열 리터럴은 하나만 만들어진다. (불변객체이기 때문에)

### 빈 문자열

String str = “”; → 크기가 0인 배열

- 문자 초기화
    - char c = ‘ ‘;
    - String s = “”;

# 문자와 숫자 형변환

- 숫자를 문자열로 바꾸는 방법

```java
int i = 100;
String str1 = i""; -> 편리
String str2 = String.valueOf(i); -> 빠르다 
```

- 문자열을 숫자로 바꾸는 방법

```java
int i = Integer.parseInt("100");
int i2 = Integer.valueOf("100"); 
// 원래는 반환타입 Integer지만 언박싱 때문에 int로도 받을 수 있다.
```

1. 숫자 래퍼 클래스엔 여러 parse 메서드 사용해서 바꿀 수 있다.
2. 숫자 래퍼 캘래스에 통일된 valueOf 메서드를 사용해서 문자열을 숫자로 바꿀 수 있다.
    1. 문자열 → 숫자도 valueOf , 숫자 → 문자열도 valueOf 둘다 가능

# StringBuffer

- 문자열을 저장하고 다루기 위한 클래스
- String처럼 내부적으로 문자열 배열을 갖고 있다
- String 과 달리 변경 가능
- 생성자에 따라 내부에 있는 문자열 배열 길이를 세팅할 수 있다.
    - 기본 생성자 : 기본값 16
    - 매개변수 int : 해당 int 값으로 배열 길이 지정
    - 매개변수 문자열 : 16 + 해당 문자열의 길이로 배열 길이 지정
- append() : 끝에 문자열 추가
- delete() : 삭제
- insert() : 삽입
    - delete , insert 특정 위치이나 범위를 설정할 수 있다.
- length() : 문자열 길이
- capacity() : 배열 길이
- replace : 치환

### 비교시 주의사항

StringBuffer는 equals가 오버라이딩이 되지 않았다.

⇒ 객체 주소 비교, 그러므로 String으로 변경 후 equals()를 사용

# StringBuilder

- StringBuffer와 똑같다 , 차이점은 Buffer는 동기화 (멀티쓰레드에서 안전) Builder는 동기화X
- 멀티스레드 프로그램이 아닐 경우 Builder 사용 → 요새 대부분 멀티쓰레드 프로그램

# Math

- 수학관련 static 메서드 집합
- abs : 절대값 반환
- ceil : 올림 , 그냥 올림
- floor : 버림
- max(a,b) : a,b, 중 큰거 반환
- min(a,b) : a , b 중 작은거 반환
- rint : 짝수 반올림
- round : 우리가 알고 있는 반올림
    - 여러 반올림 총합은 round even 이 더 정확

# 래퍼(Wrapper) 클래스

- 기본형 값을 감싸주는 클래스
- 기본형을 객체로 다뤄야할 때 사용

# Numbers 클래스

- 모든 숫자 래퍼 클래스의 조상

# 오토박싱 , 언박싱

- JDK 1.5 부터 나타난 기능
- 컴파일러가 자동으로 기본형 → 래퍼 클래스 , 래퍼클래스 → 기본형으로 변경시켜준다.
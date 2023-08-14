# Java Optional

### Optional<T>

- T 타입 객체의 래퍼클래스 - Optional<T>
    - 래퍼클래스 예 : Integer , Long

    ```java
    public final Class Optional<T> {
    	private final T value; // T타입의 참조 변수
    }
    ```

    1. null 를 직접 다루면 위험하다 → NullPointerException
    2. null 체크 (if문) 필요 ⇒ 코드가 지저분해진다.

- Result 객체를 반환하는 getResult라는 메서드가 있으면 반환값은 null OR 객체이다.
- 만약 반환값이 null이면 NPE 발생한다.

  ⇒ if(result ≠ null ) { } 이런 식으로 **널 체크** 필요


Null 일 수 있는 값을 다룰 때는 NPE 발생할 가능성도 있고, null 체크 로직이 필요하다. ⇒ Optional으로 해결

### 처리 방식

- Optional 객체안에 null을 넣어서 처리
- null 값을 직접 다루지 않고 Optional 객체에 넣어서 다룬다.
- Optional 객체는 무조건 주소가 있기 떄문에 **항상 널이 아니다.**
    - NPE , if 널 체크 필요 없어진다.

### Null을 직접 다루지 않는 경우

- **String**
    - 초기화 String str = “”; ⇒ 길이가 0인 char[]
    - 기본적으로 String은 null로 초기화하기 보다, 빈 문자열로 초기화하자

### Optional<T> 객체 생성하기

```java
String str = "abc";
Optional<String> optVal = Optional.of(str);
Optional<String> optVal = Optional.of("abc");
**Optional<String> optVal = Optional.of(null);** // NPE 발생
Optional<String> optVal = Optional.ofNullable(null); // OK
```

Optional 안에 value에 스트링 값이 들어있다. (주소값이 들어있다.)

of안에 null를 넣는 것은 안된다.

null을 저장하려면 ofNullable를 사용

- null 대신 빈 Optional<T> 객체를 사용하자

```java
// null로 초기화 방법
Optional<String> optVal = null; // 가능은 하지만 바람직 하지 않다.
Optional<String> optVal = Optional.empty(); // 빈 객체로 초기화 , 바람직한 방법
```

- NPE 줄이기 위한 움직임

### Optional<T> 객체의 값 가져오기

```java
Optional<String> optVal = Optional.of("abc");
String str1 = optVal.get(); // optVal에 저장된 값 반환. null이면 예외발생 , 많이 사용X
String str2 = optVal.orElse(""); // optVal에 저장된 값이 null 일때 ""를 반환
String str3 = optVal.orElseGet(String::new); // **람다식 사용 가능** () -> new String();
String str4 = optVal.orElseThrow(NullPointerException::new); // 널이면 예외 발생

T orElseGet(Supplier<? extends T> other)
T orElseThrow(Supplier<? extends X> exceptionSupplier)
```

- isPresent() - Optional객체의 값이 null이면 false , 아니면 true 반환
- ifPresent() - 널이 아닐 때만 작업 수행, 널이면 아무일도 안함.

### OptionalInt , OptionalLong, OptionalDouble

- 기본형 값을 감싸는 래퍼클래스
- Optional<T>를 사용 해도되는데 성능 때문에 사용

  Optional<T>는 final T value; 참조형

- OptionalInt는 final int value; ⇒ value의 타입이 기본형으로 되어있다.

- 값 가져오기
    - getAsInt() , getAsLong() , getAsDouble();

- 빈 Optional 객체와의 비교
    - OptionalInt opt = OptionalInt.of(0);
    - OptionalInt opt2 = OptionalInt.empty();
        - 값은 똑같이 0이지만 opt.isPresent()는 true , opt2.isPresent()는 false
        - opt.equals(opt2) ⇒ false
            - isPresent 값도 같아야지 true가 되게 오버라이딩 되어 있음
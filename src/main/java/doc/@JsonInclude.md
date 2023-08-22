# ****@JsonInclude 어노테이션****

- 자바 객체 ⇒ Json , Json ⇒ 자바 객체로 변환할 때 옵션에 따라 특정 필드 값이 제외하는 어노테이션

- 기본적으로 Jackson은 객체를 JSON 변환할 때 모든 필드를 포함한다. 그러나 @JsonInclude 의 옵션을 지정해서 조건에 따라 제외시킬 수 있다.

- @JsonInclude 옵션
    - JsonInclude.Include.ALWAYS (기본값)
        - 항상 포함
    - JsonInclude.Include.NON_NULL
        - null이 아닐 때 포함
    - JsonInclude.Include.NON_EMPTY
        - null 아니거나 빈값(빈 컬렉션 , 빈 맵)이 아닐 때 포함
    - JsonInclude.Include.NON_DEFAULT
        - EMPTY를 제외 , 필드의 기본값과 다를 경우에 포함
    - JsonInclude.Include.CUSTOM
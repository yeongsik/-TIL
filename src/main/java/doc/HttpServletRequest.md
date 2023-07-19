# HttpServletRequest

- 인터페이스. 구현체는 WAS별로 각각 존재
- tomcat의 Servlet 구현체
    - org.apache.catalina.connector.RequestFacade
    - org.apache.catalina.connector.Request

### RequestFacade
- RequestFacade 객체는 Request를 감싸고 있는 Wrapper 객체
- Request에 있는 몇몇 퍼블릭 메서드를 접근하지 못하게 하기 위해서 감싸서 전달한다.

### Facade
- 개발에서 Facade 는 Facade 디자인 패턴을 가르키는 경우가 많은 것으로 보인다. 우선 Facade 붙은 클래스가 있으면 퍼사드 패턴인지 RequestFacade 같은 Wrapper 클래스인지 확인하자
- 톰캣의 RequestFacade는 Facade 패턴이라기 보다 request 의 접근 제한을 둔 Wrapper 클래스

- Facade 패턴 (구조 패턴)
    - 서브 시스템의 여러 메서드를 묶어서 하나의 퍼사드 클래스에서 진행할 때 사용하는 것 (추가 공부 필요)
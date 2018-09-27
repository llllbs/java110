# java110

비트캠프 **자바 110기** 실습 프로젝트

## java110-project
- 자바 프로젝트 폴더 생성
- 'gradle init --type java-application' 실행
- *build.gradle* 파일에 'id' eclipse'' 플러그인 추가
- 'gradle eclipse' 실행하여 이클립스 설정 파일을 생성
- 이클립스로 프로젝트를 import함

## java110-project(tag:v0.1)
- 반복문 활용

## java110-project(tag:v0.2)
- 배열 활용

## java110-project(tag:v0.3)
- 메서드 활용하여 리팩토링

## java110-project(tag:v0.4)
- 클래스 활용

## java110-project(tag:v0.5)
- 강사, 학생, 매니저 구분해서 관리

## java110-project(tag:v0.6)
- 패키지 활용 및 클래스의 접근 범위

## java110-project(tag:v0.7)
- 목록 다루기
- 배열에 항목을 추가하고 삭제하는 기능을 추가
- 배열의 값 목록을 다루는 기능을 별도의 클래스로 분리

## java110-project(tag:v0.8)
- 목록을 다루는 클래스들을 리펙토링 하기
- StudentList, ManagerList, TeacherList를 한 클래스로 합침
- 다형적 변수를 사용하여 Student, Manager, Teacher 객체를 모두 저장할 수 있게 함
- 클래스 멤버(변수, 메서드, 블록)와 인스턴스 멤버의 차이점
- 다형적 변수의 활용법

## java110-project(tag:v0.9)
- 제네릭 활용법
- ArrayList에 제네릭 적용하기

## java110-project(tag:v1.0)
- linkedlist 구동 원리 및 적용
- linkedlist 만들기
- linkedlist 구동하기

## java110-project(tag:v1.1)
- 인터페이스 적용
- 데이터목록을 다룰때 호출하는 메서드의 규칙을 정의
- 다양한 방법으로 구현한 객체를 사용할 수 있다
- 즉, 규칙을 따르기만 한다면 어떤 객체라도 대체할 수 있다
- 인터페이스의 default를 활용

## java110-project(tag:v1.2)
- 자바 컬렉션 API 사용
- 직접 제작한 list, ArrayList, LinkedList 대신에 자바에서 제공하는 Collection API를 사용

## java110-project(tag:v1.3)
- 인터페이스 활용
- App 클래스와 Controller들 사이의 호출규칙(사용규칙)을 인터페이스로 정의한다

## java110-project(tag:v1.4)
- 리플렉션 API 활용
- 미니 IoC 컨테이너 작성
- 파일 클래스로 디렉토리 및 파일 다루기

## java110-project(tag:v1.5)
- 리플렉션 API 활용2
- 애노테이션 활용
- 미니 IoC 컨테이너 개선
- 작업 
    - 자동으로 생성되어야 할 객체에 붙일 애노테이션 정의
    - 컨트롤러 객체에 에노테이션 적용
    - 애노테이션이 붙은 클래스만 객체를 생성

## java110-project(tag:v1.6)
- Command 디자인 패턴 적용
- 컨트롤러 구조 변경
- 작업
    - 컨트롤러에서 명령을 처리하는  각각의 메서드를 별도의 클래스로 분리한다

## java110-project(tag:v1.7)
- DAO(Data Access Object)) 도입하기
    - 데이터를 저장하는 방식이 바뀌더라도 기존 클래스에 영향을 주지 않게 하려면, 데이터를 다루는 부분을 List가 아니라 별도의 클래스로 정의해야 한다.
    - 즉, List를 통해 데이터를 메모리에 저장하는 대신에 파일이나 데이터베이스에 저장한다면 기존 코드를 변경해야 하는 문제가 있다.
    - 이 부분을 해결하기 위함이다.
-작업
    - 학생관리, 강사관리, 매니저관리 각각에 사용할 DAO 클래스를 정의한다.

## java110-project(tag:v1.8)
- 의존 객체 주입하기
- 미니 IoC 컨테이너 개선
- 작업
    - 의존객체를 주입 받을 수 있도록 setter를 준비한다
    - IoC 컨테이너가 setter를 자동으로 호출하도록 애노테이션으로 표시한다

## java110-project(tag:v1.9)
- IoC 컨테이너가 객체 생성 후, 수행하는 작업을 별도의 클래스로 분리한다.
- 향후 객체 생성 후에 또 다른 작업을 추가하기 쉽도록 한다.
- 작업
    - 객체 생성 후 수행할 작업 별도의 클래스로 분리한다

## java110-project(tag:v2.0)
- DAO에 파일 입출력 도입
- DAO에 인터페이스 적용
- 작업
    - DAO에 데이터를 파일로 저장하고 읽는 기능 추가

## java110-project(tag:v2.1)
- 객체 Serialize/Deserialize 적용
- java.io.Serializable 인터페이스 활용
- transient modifer

## java110-project(tag:v2.2)
- 예외처리 적용
- 예외처리 문법이 없던 시절, 리턴값으로 예외 상황을 호출자에게 알렸다
- 문제
    - 특정타입의 값을 리턴하는 경우, 이 방법을 사용하기 곤란하다
- 예외처리 문법이 등장
    - 리턴 값이 아닌 별도의 경로로 예외 상황을 호출자에게 알린다
    - 이전 방식에 비해 메서드의 리턴 타입에 영향을 받지 않는다
    - 또한, 예외 상황을 자세하게 호출자에게 알릴 수 있다.

## java110-project(tag:v2.3)
- DAO에 JDBC 적용
- 작업
    - Data Modeling과 forward engineering 수행
    - 테이블 준비
    - JDBC API 활용
    - 트랜잭션 다루기

## java110-project(tag:v2.4)
- DB 커넥션 공유하기
- DB 연결 객체를 재사용하여 가비지를 줄이고, 실행 속도를 높이기 위함

## java110-project(tag:v2.5)
- Spring IoC 컨테이너 도입
- 기존에 만들었던 ApplicationContext 대신에 Spring 프레임 워크에서 제공하는 ApplicationContext 사용하기
- 작업
    - Spring IoC 컨테이너 라이브러리 추가(build.gradle 파일 편집)
        - Spring context로 mvnrepository.com에서 검색한다.
        - 명령창에서 gradle eclipse 실행
        - 이클립스에서 프로젝트를 refresh
    - 스프링 설정 파일 추가(application-context.xml)
        -bitcamp/java110/cms/conf/application-context.xml
    - 기존의 ApplicationContext 관련 클래스들을 제거한다
    - 기존의 @Autowired, @Component 애노테이션을 제거한다.
    - 기존 클래스에서 사용한 애노테이션을 Spring 프레임워크에서 제공하는 것으로 바꾼다

## java110-project(tag:v2.6)
- Client/Server 구조로 변경
    - 소켓 프로그래밍 구현
    - 프로토콜 개념 이해

## java110-project(tag:v2.7)
- 멀티스레드 적용하기(Connection-Oriented에서 Stateful방식으로 요청 처리)
- 별도의 스레드를 만들어 클라이언트의 요청을 처리하게 한다
- 즉 동시에 여러 클라이언트 요청을 처리한다

## java110-project(tag:v2.8)
- 멀티스레드 적용하기(Connection-Oriented에서 Stateless방식으로 요청 처리)
- 별도의 스레드를 만들어 클라이언트의 요청을 처리하게 한다
- 즉 동시에 여러 클라이언트 요청을 처리한다

## java110-project(tag:v2.9)
- Command 패턴으로 분할된 메서드를 한 클래스로 합치기
- 관련된 컨트롤러 클래스를 한 클래스로 만든다
- ManagerListController, ManagerAddController, ManagerDetailController, ManagerDeleteController 클래스를 ManagerController 클래스로 합친다
- 학생 관리와 강사 관리도 마찬가지로 만든다
- 각각의 컨트롤러가 크지 않을 때는 관리하기 쉽게 한 클래스로 합치기도 한다

## java110-project(tag:v3.0)
- 웹브라우저를 클라이언트로 사용하기
- 서버에 HTTP프로토콜을 처리하는 기능 추가
- ServerApp 클래스를 HTTP프로토콜 요청과 응답을 처리하는 방식으로 변경한다

##java110-project(tag:v3.1)
- 웹서버를 중계 서버로 사용하기
- 서블릿 컨테이너 적용
    - 톰캣 서버 설치
    - build.gradle에 servlet-api 라이브러리 추가

----------------------------------------------------------------- 최신기술


##java110-project(tag:v4.0)
- 서블릿 기술을 적용하여 서버 애플리케이션 만들기
- 클라이언트 요청을 처리하는 컨트롤러를 서블릿으로 만들기

##java110-project(tag:v4.1)
- 서블릿의 loadOnStartup 배치 속성을 이용하여 공동 자원을 준비하기
- ServletContext를 이용하여 공용자원을 공유하기
- 작업
    - InitServlet 클래스 생성
    - Initservlet에서 DAO와 DataSource 준비하기
    - ServletContext에 DAO 보관하기
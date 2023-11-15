### 기능 구현 목록
- [X] 개발 요청 사항
  - [X] 방문 날짜는 1이상 31이하의 숫자로 입력 받는다.
    - [X] 방문 날짜가 공백일 수 없음
    - [X] 방문 날짜가 숫자가 아닐 때
    - [X] 방문 날짜가 1 ~ 31 사이의 숫자가 아닐 때
  - [X] 주문할 메뉴와 개수를 입력받는다
    - [X] 메뉴와 개수는 map에 저장해서 유효성 검사를 한다.
    - [X] 메뉴판에 대한 입력값이 공백일 때
    - [X] 메뉴판의 형식이랑 다를 때
    - [X] 메뉴의 개수가 1보다 작을때
    - [X] 모든 메뉴 개수의 총합이 20보다 클 때
    - [X] 메뉴판에 없는 메뉴를 입력할 때
    - [X] 중복된 메뉴를 입력할때
    - [X] 음료만 단독으로 주문할 때

- [] 프로그래밍 요구 사장
  - [] else 예약어를 쓰지 않는다
  - [] 도메인 로직에 단위 테스트를 구현한다.
  - [] 잘못된 값을 입력할 경우 그 부분부터 입력을 다시 받는다

└── src
├── main
│   └── java
│       ├── christmas
│       │   ├── Amount.java -> 입력값으로 받은 메뉴와 메뉴의 개수 가격을 계산하여 총 금액을 게산하는 클래스
│       │   ├── Application.java
│       │   ├── ChampagneDiscount.java -> 총 금액에 따라서 샴페인 증정 여부를 판단하는 클래스
│       │   ├── ChristmasDiscount.java -> 크리스마스 디데이 할인 금액을 리턴해주는 클래스
│       │   └── DateDiscount.java -> 평일 할인과 주말 할인을 계산하는 클래스
│       ├── controller
│       │   └── ChristmasController.java
│       ├── dto
│       │   ├── Order.java - 주문할 메뉴와 개수를 입력값으로 받는 클래스
│       │   ├── TotalDiscountDto.java - 전반적인 할인 금액들을 관리하고, 총 할인 혜택 금액을 계산하고 특별 할인 여부를 결정하는 클래스
│       │   └── VisitDate.java -> 날짜 입력값을 받는 클래스
│       ├── enums
│       │   ├── ErrorMessage.java - 에러 메세지들을 관리하는 클래스
│       │   ├── Numbers.java - 매직 넘버들을 관리하는 클래스
│       │   ├── OutputMessage.java - 출력값을 관리하는 클래스
│       │   └── core
│       │       ├── Badge.java - 할인 혜택에 따라서 다른 뱃지를 리턴받는 클래스
│       │       ├── Days.java - 입력값으로 받은 날짜의 주말 / 평일 여부를 판단하는 클래스
│       │       └── Menu.java - 기존에 생성된 메뉴판을 저장하는 클래스
│       ├── utils
│       │   ├── Parser.java - 요구되는 자료구조 타입에 따라 convert 해주는 클래스
│       │   └── RepeatInput.java - 입력값이 잘못 되었을 떄, ERROR를 출력하고 그 부분부터 다시 입력받는 클래스
│       ├── validation
│       │   ├── InputValidator.java - 인풋값 유효성 검사
│       │   ├── MenuValidator.java - 메뉴판 유효성 검사
│       │   └── RangeValidator.java - 숫자(범위) 유효성 검사
│       └── view
│           ├── InputView.java - 입력을 담당하는 클래스
│           └── OutputView.java - 출력을 담당하는 클래스


  
    
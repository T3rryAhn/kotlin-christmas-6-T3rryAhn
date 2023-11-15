작성자: 안태리

# 🎅크리스마스 프로모션

**이벤트 목표**
````
1. 중복된 할인과 증정을 허용해서, 고객들이 혜택을 많이 받는다는 것을 체감할 수 있게 하는 것
2. 올해 12월에 지난 5년 중 최고의 판매 금액을 달성
3. 12월 이벤트 참여 고객의 5%가 내년 1월 새해 이벤트에 재참여하는 것
````

---------------
## ⚙ 기능 목록

### 사용자 인터페이스
   - 사용자에게 입력을 요청하는 안내 메시지 출력
   - 사용자 입력 에러 발생 시, '[ERROR]'로 시작하는 에러 메시지 출력 
### 날짜 입력 및 검증
   - 사용자로부터 12월 중 예상 방문 날짜를 숫자로 입력받음
   - 입력받은 날짜가 1 이상 31 이하인지 검증
   - 유효하지 않은 날짜 입력 시 에러 메시지 전달 및 재입력 요청 
### 메뉴 주문 입력 및 검증
   - 사용자로부터 주문할 메뉴와 수량을 입력받음 (예: 해산물파스타-2, 레드와인-1)
   - 입력받은 메뉴가 메뉴판에 있는지, 수량이 유효한지 주문 검증
   - 유효하지 않은 주문 입력 시 에러 메시지 전달 및 재입력 요청
### 할인 및 증정 이벤트 계산
   - 크리스마스 디데이 할인 계산
   - 평일 할인 계산 (디저트 메뉴)
   - 주말 할인 계산 (메인 메뉴)
   - 특별 할인 계산 (달력에 별 표시된 날)
   - 증정 이벤트 적용 (총주문 금액이 12만 원 이상일 경우 샴페인 증정)
### 혜택 내역 및 총혜택 금액 계산
   - 할인 금액의 합계 계산
   - 증정 메뉴 가격 계산
   - 총혜택 금액 계산
### 예상 결제 금액 계산
   - 할인 후 예상 결제 금액 계산
### 이벤트 배지 부여
   - 총혜택 금액에 따른 이벤트 배지 부여 (별, 트리, 산타)
### 결과 출력
   - 주문 메뉴, 할인 전 총주문 금액, 증정 메뉴, 혜택 내역, 총혜택 금액, 할인 후 예상 결제 금액, 이벤트 배지를 출력
### 단위 테스트
   - 각 기능별로 JUnit 5와 AssertJ를 이용하여 단위 테스트 작성

------------

## 크리스마스 프로모션 프로젝트 구조

```
🔻📁main
    🔻📁java
        🔻📁christmas
            🔻📁controller
                EventPlanner.java
            🔻📁domain
                🔻📁logic
                    ChristmasEventCalculator.java
                    EventCalculator.java
                    EventService.java
                🔻📁model
                    DecemberEvent.java
                    EventResult.java
                    OrderInfo.java
                🔻📁type
                    Badge.java (enum)
                    Benefit.java (enum)
                    Menu.java (enum)
            🔻📁view
                InputView.java
                OutputView.java
            🔻📁util
                DateValidator.java
                MapToStringConverter.java
                OrderValidator.java
                ValidationException.java
        Application.java
```
### 설명
#### controller
> 사용자의 요청을 처리하고, 모델을 조작, 적절한 응답을 뷰에 전달하는 클래스가 위치합니다.

#### domain
> 도메인 로직을 담당하는 클래스들이 위치합니다. <br>

- #### logic
> **EventCalculator**: 이벤트 할인을 계산합니다. <br>
> **ChristmasEventCalculator**: 날짜 기반 할인 로직을 처리합니다. <br>
> **EventService**: 주문 정보로 이벤트 결과를 만들어주는 클래스입니다. <br>

- #### model
> **DecemberEvent**: 이벤트 관련 로직을 처리합니다. <br>
> **EventResult**: 이벤트 결과를 담는 클래스입니다. <br>
> **OrderInfo**: 주문 정보를 담는 클래스입니다. <br>

- #### type
> **Benefit**: 혜택 종류를 나타내는 열거형입니다. <br>
> **Menu**: 메뉴를 나타내는 열거형입니다. <br>
> **Badge**: 뱃지를 나타내는 열거형입니다. <br>


#### view
> 사용자 인터페이스를 담당하는 클래스들이 위치합니다. <br>
>
> **InputView**: 사용자 입력을 처리. <br>
> **OutputView**: 결과 출력을 처리. <br>

#### util
> 유틸리티 클래스들이 위치합니다. <br>
>
> **DateValidator**: 날짜 유효성 검사 로직을 포함. <br>
> **MapToStringConverter**: Map의 key, value 값을 문자열로 변환하는 작업처리.
> **OrderValidator**: 메뉴와 수량 입력 유효성 검사 로직을 포함. <br>
> **ValidationException**: 사용자 정의 예외처리 클래스. <br>


-------------------
## 예외 상황

//TODO 중간중간 생각나는 에러상황 작성하기.
날짜 입력
- 문자열 입력, 공백 입력

주문 입력
- **case 1: 공백만을 제외한 잘못된 입력을 받았다면 유효성 검사를 통과 시킬 것인가?** 
````
입력 예시: 타파스 -1, 제로 콜라-1,초코 케이크- 3
 
사용자 친화적 방안: 공백 제거 기능을 이용하면 되므로 유효성 검사를 통과시킨다.
하지만,  데이터의 일관성 유지하기 어려울 수 있음, 로직이 복잡해져서 오류발생 가능성이 있음.
(ex. 타 파스, 타파스, 타파 스)와 같이 공백이 제대로 제거가 안되게 로직을 짰는지 잘 확인해야함.
결론: 프론트에서 공백여부를 잘 가공해서 전달받아 백엔드에서는 정확한 값을 입력받도록 구현하는 것하는 것이 맞는것 같다.
```` 

- 중복된 메뉴를 입력받는다.
- 없는 메뉴를 입력받는다.

주문 입력: 샴페인-1-1, 초코케이크-1 을 통과해서 받음.


--------
## 리펙토링 할법한 것들

util에 MapReader 클래스 만들기
```
private void readMenuAndQuantity(Map<Menu, Integer> menuAndQuantity) {
    for (Map.Entry<Menu, Integer> entry : menuAndQuantity.entrySet()) {
        Menu menu = entry.getKey();
        int quantity = entry.getValue();

        //연산 명령
    }
    
}
```
이유: 위와 같은 형태가 많이 반복해서 쓰이고 있음.

//연산 명령 부분만 갈아끼우는 방법이 없을까? > BiConsumer 알아보기.

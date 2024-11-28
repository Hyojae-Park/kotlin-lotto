# kotlin-lotto

## 1단계 - 문자열 덧셈 계산기
### 기능 요구 사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

### 프로그래밍 요구 사항
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.

### 기능 목록
- [x] 숫자와 콤마(,)로 구성된 문자열을 콤마를 기준으로 분리해서 합을 구한다.
- [x] 숫자와 콜론(:)으로 구성된 문자열을 콤마를 기준으로 분리해서 합을 구한다.
- [x] 숫자와 구분자[콤마(,) 혹은 콜론(:)]으로 구성된 문자열을 구분자를 기준으로 분리해서 합을 구한다.
- [x] 기본 구분자 외에 커스텀 구분자를 지정할 수 있다.
- [x] 입력 문자열을 구분자로 분리하고, 분리한 각 숫자의 합을 반환한다.
- [x] 빈문자열 또는 null을 입력할 경우 0을 반환해야 한다.
- [x] 문자열에 구분자가 연속해서 있는 경우 RuntimeException 예외를 발생시킨다.
- [x] 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 발생시킨다.
- 프로그래밍 구현 요구사항
  - [x] 함수의 길이가 10라인을 넘어가지 않도록 구현한다.

<br>

## 2단계 - 로또(자동)
### 기능 요구 사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

### 프로그래밍 요구 사항
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

### 힌트
- 로또 자동 생성은 `shuffled()`을 활용한다.
- `sorted()`를 활용해 정렬 가능하다.
- `contains()`를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.

### 기능 목록
- [x] 로또는 1장에 중복되지 않는 6개의 숫자를 가진다.
- [x] 로또를 생성할때, 중복된 번호를 갖고 있으면 IllegalArgumentException 예외를 발생시킨다.
- [x] 로또는 매칭된 숫자의 개수를 기록할 수 있다.
- [x] 구입 금액을 입력하면 구매 가능한 개수의 로또를 생성해서 반환한다.
- [x] 로또를 생성할 때 중복되는 않는 6개의 숫자를 랜덤으로 자동 배정한다.
- [x] 지난 주 당첨 번호를 입력받는다.
- [x] 입력받은 당첨 번호와 로또를 비교해서 매칭되는 숫자를 업데이트한다.
- [x] 로또 당첨 등수별로 몇개의 로또가 당첨되었는지 분류한다.
- [x] 로또 수익률을 계산한다.
- [x] 당첨 통계(당첨 번호, 당첨 등수, 당첨금)를 출력한다.
- [x] 총 수익률을 출력한다.


<br>


## 3단계 - 로또(2등)
### 기능 요구 사항
- 2등을 위해 추가 번호를 하나 더 추첨한다.
- 당첨 통계에 2등도 추가해야 한다.

### 실행 결과

```
[... 생략 ...]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6
보너스 볼을 입력해 주세요.
7

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```

### 프로그래밍 요구 사항
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
- Enum 클래스를 적용해 프로그래밍을 구현한다.
- 일급 컬렉션을 쓴다.
  - [일급 컬렉션을 사용하는 이유](https://woowacourse.github.io/javable/post/2020-05-08-First-Class-Collection)
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

### 힌트
- 일급 컬렉션을 쓴다.
  - 6개의 숫자 값을 가지는 컬렉션을 감싸는 객체를 추가해 구현해 본다.
- 하드 코딩을 하지 않기 위해 상수 값을 사용하면 많은 상수 값이 발생한다. Enum 클래스를 활용해 상수 값을 제거한다. 즉, Enum 클래스를 활용해 일치하는 수를 로또 등수로 변경해 본다.

```kotlin
enum class Rank(val countOfMatch: Int, val winningMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    companion object {
        fun valueOf(countOfMatch: Int, matchBonus: Boolean): Rank {
            return values().find {
                // ...
            }
        }
    }
}
```
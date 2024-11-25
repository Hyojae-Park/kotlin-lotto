# kotlin-lotto

## 2단계 - 로또(자동)

### 기능 요구사항

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

### 프로그래밍 요구사항

- 로또 숫자
  - 로또 숫자는 1부터 45까지의 정수로 구성된다.

- 로또
  - 로또는 6개의 로또 숫자로 구성된다.
  - 로또는 로또 숫자를 정렬하여 제공한다.
  - 로또는 입력받은 숫자들과 일치하는 숫자의 개수를 구할 수 있다.

- 로또 숫자 생성기
  - 로또 숫자는 1부터 45까지의 숫자 중 6개를 랜덤으로 생성해야 한다.
  - 숫자는 중복되지 않아야 한다.

- 로또 팩토리
  - 로또 팩토리는 로또 숫자 생성기를 이용해 입력받은 개수만큼 로또를 생성한다.

- 금액
  - 금액은 1000원 단위로 구성된다.

- 로또 가게
  - 로또 가게는 로또 팩토리를 이용해 로또를 생성한다.
  - 로또 가게는 금액을 입력받아 로또를 판매한다.

- 결과
  - 결과는 일치한 숫자의 개수와 당첨 금액, 로또의 개수를 가지고 있다.

- 수익률
  - 수익률은 당첨 금액을 구매 금액으로 나눈 값이다.
  - 수익률은 소수점 2자리까지 표현한다.

# 그리디 알고리즘

## 그리디 알고리즘이란
* 매 선택에서 현재 당장 최적의 답을 선택하는 알고리즘 기법
* 최적의 값을 언제나 도출하지 않는다.


## 예제) 동전 문제
* 지불해야 하는 값이 4720원일 때 1원,50원,100원, 500원 동전으로 동전의 수가 가장 적게 지불하게끔 구현하라.

### 코드 
``` java
 		int price = 4720;
		int[] coins = {500, 100, 50, 1};
		int totalCoinNum = 0;
		
		for(int coin: coins) {
			int coinNum = price / coin;
			price -= coinNum * coin;
			totalCoinNum += coinNum;
		}

 ```
 *  풀이: 가장 비싼 동전부터 갯수를 계산한다.


 
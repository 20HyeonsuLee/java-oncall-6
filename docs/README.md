# 기능 목록

## 도메인
- 공휴일
  - 날짜를 유지(월, 일)
- 날짜
  - 월, 일, 요일 유지
  - 연도 고려 X
  - 평일, 휴일이 있다.
- 월
  - 2월은 28일 까지 있다.
  - 7월 보다 작거나 같으면 홀수 월은 31일 까지 있다.
  - 8월 이상인 경우 짝수 월은 31일 까지 있다.
- 요일
  - 일, 월, 화, 수, 목, 금, 토요일이 있다.
- 사원
  - 닉네임은 중복될 수 없다.
  - 최대 5자이다.
- 비상 근무 인원
  - 같은 사람은 한번만 포함되어야 한다.
  - 근무 인원은 5~35명 이다.
- 평일 비상 근무
  - 평일 비상 근무 인원이 참여한다.
  - 평일에만 참여한다.
- 휴일 비상 근무
  - 휴일 비상 근무 인원이 참여한다.
  - 휴일에만 참여한다.
- 비상 근무
  - 특정 근무자가 3일 이상 근무할 수 없다.
  - 특정 근무자가 연속 2일 근무하게 되는 상황에는 다음 근무자와 순서를 바꿔서 편성한다.

## 입력
- 비상 근무를 배정할 월과 시작 요일 입력
  - `,`를 기준으로 입력받음
  - 잘못된 월 또는 요일 입력 시 재입력 받기
- 비상 근무 인원 입력받기
  - 평일 비상 근무인원 입력받기
    - 중복된 사원 이름이 없게 5~35명 입력받기
  - 휴일 비상 근무 인원 입력받기
    - 중복된 사원 이름이 없게 5~35명 입력받기.
  - 평일, 휴일 둘중 하나라도 잘못 입력하면 처음부터 다시 비상 근무 인원 입력받기.

## 출력
- 입력받은 월의 비상 근무 인원 편셩표 출력하기
```angular2html
5월 1일 월 준팍
5월 2일 화 도밥
5월 3일 수 고니
5월 4일 목 수아
5월 5일 금(휴일) 루루
5월 6일 토 수아
5월 7일 일 글로
5월 8일 월 루루
5월 9일 화 글로
5월 10일 수 솔로스타
5월 11일 목 우코
5월 12일 금 슬링키
5월 13일 토 솔로스타
5월 14일 일 우코
5월 15일 월 참새
5월 16일 화 도리
5월 17일 수 준팍
5월 18일 목 도밥
5월 19일 금 고니
5월 20일 토 슬링키
5월 21일 일 참새
5월 22일 월 수아
5월 23일 화 루루
5월 24일 수 글로
5월 25일 목 솔로스타
5월 26일 금 우코
5월 27일 토 도리
5월 28일 일 준팍
5월 29일 월 슬링키
5월 30일 화 참새
5월 31일 수 도리
```

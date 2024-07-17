# 🛒 Order
이 프로젝트는 e-commerce 도메인의 MSA 환경을 고려한 주문 서비스 프로젝트 입니다. <br>
[ 선물하기 프로젝트 ](https://github.com/pie2457/gift)

## 기술 스택

### Infra
![AWS EC2](https://img.shields.io/badge/amazonec2-FF9900?style=flat&logo=amazonec2&logoColor=white)
![GitHub Actions](https://img.shields.io/badge/github%20actions-%232671E5.svg?style=for-the-flat&logo=githubactions&logoColor=white)
![AWSCodeDeploy](https://img.shields.io/badge/CodeDeploy-%23009639.svg?style=for-the-flat&logo=amazoncodedeploy&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-%2496ED.svg?style=for-the-flat&logo=docker&logoColor=white)

### Backend
![Java](https://img.shields.io/badge/-Java-FF7800?style=flat&logo=Java&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-flat&logo=spring&logoColor=white)
![SpringBoot](https://img.shields.io/badge/-SpringBoot-6DB33F?style=flat&logo=SpringBoot&logoColor=white)
![SpringDataJPA](https://img.shields.io/badge/SpringDataJpa-236DB33F?style=flat&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=MySQL&logoColor=white)
![AmazonSQS](https://img.shields.io/badge/AmazonSQS-FF4F8B?style=flat&logo=auth0&logoColor=white)

## 인프라 구조
<img width="760" alt="스크린샷 2024-07-17 오후 4 30 25" src="https://github.com/user-attachments/assets/8126daa4-2dd6-4788-b716-31ff7423baf6">

## 도메인별 다이어그램
<img width="1001" alt="스크린샷 2024-07-17 오후 4 31 02" src="https://github.com/user-attachments/assets/05b0c958-713a-495c-885f-e13f5b9831bd">

## DIP 적용 예시
<img width="784" alt="스크린샷 2024-07-17 오후 4 42 47" src="https://github.com/user-attachments/assets/3528c0c4-1bb7-448f-8d94-62e4f67916b3">


## 프로젝트 아키텍처
<img width="538" alt="스크린샷 2024-07-17 오후 4 33 04" src="https://github.com/user-attachments/assets/2760c3a0-bab1-4f91-b26a-9b9e9e16f3aa">

## 클래스별 역할
|변수명|설명|
|:---:|:---:|
|XxxCommand|Service 메서드의 처리와 조회를 위한 파라미터|
|XxxInfo|리턴객체 : DB에서 조회하여 가져온 Entity를 그대로 리턴하지 않기 위함|
|XxxStore|도메인의 저장을 담당|
|XxxReader|도메인을 읽어오는 담당|
|XxxFacade|비즈니스 결정을 내리지 않고 수행할 작업을 정의함|
|XxxFactory|객체를 생성하는 일이 복잡해지거나 내부 구조를 너무 많이 드러내는 경우 사용|

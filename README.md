# 이커머스 - 물품 구매, 판매

### 상세정보
1. 회원 가입: 회원가입 할 때는 고객, 판매자의 PW, 이름, 계좌 번호, 핸드폰 번호를 기입하고, ID는 등록한 순서대로 부여 받는다. 결과로 리뷰도 쓸 수 있게 한다. 

3. 로그인: 고객, 판매자가 회원가입 할 때 이름, PW 집어넣고 
이름, PW 맞는지 확인한 뒤 로그인. 로그인한 회원(고객,판매자)의 정보 받아옴. 로그아웃 기능도 가능하게 함. 회원정보(고객, 판매자) 수정 및 삭제 추가.
삭제시 고객, 판매자의 ID, PW 집어넣고 확인되면 삭제.

3. 상품 등록, 찾기, 수정, 삭제 - 상품의 정보: 상품/ 판매자 ID, 이름, 가격 등 정보 기입. ID는 등록한 순서대로 부여 받는다.

4. 장바구니 추가, 찾기, 변경, 삭제 - 장바구니의 정보: 상품/ 판매자 ID, 이름, 가격 등 정보 기입 고객이 장바구니에다 상품을 추가시킨 뒤
상품 확인. ID는 등록한 순서대로 부여 받는다.

5. 주문 추가, 찾기, 변경, 삭제 - 고객이 상품을 주문한 뒤 주문 확인 및 상품 구매 등을 할 수 있음. 주문은 등록한 순서대로 부여 받는다.

6. ResponseEntity를 활용하여 http 요청을 보낸 뒤 상품 등을 등록, 찾기, 수정, 삭제.//[13]

7. 새로운 계정을 만들 때, PW, 이름 등에 각종 조건 및 제약을 걸어 조건에 맞춰 정보 작성.//[7][9][10][11][19]

### build.gradle
Spring Web, Spring Data JPA, H2 Database, Lombok, Spring Security, Validation

### 기술 스택
Java, Spring, H2 Database //[2][4][5][6]

### ERD

<img width="961" alt="스크린샷 2024-06-17 오후 4 57 10" src="https://github.com/mtgv999/Ecommerce/assets/149506393/68af50d5-45f3-4764-9110-cbaf8cdc3d49">

//[12][14][18]

### 출처
[1] 미상, 제로베이스, “Part11. 이커머스 강의 전반”, 미상, 미상.(커밋 올리는 형식: Ch3, 4-4강 20:32)

[2] mgcztech576(본인), Github, ecommercemain, https://github.com/mgcztech576/ecommercemain, 2023.10.16

[3] dev-sam32, GitHub, zerobase-cms-project,
https://github.com/dev-sam32/zerobase-cms-project/blob/main/README.md, 미상, 미상. 2024.05.19 -Order 관련 아이디어

[4] 본인, Github, SpringAssignment2, https://github.com/mtgv999/SpringAssignment2, 2024.05.06

[5]계란, 티스토리, “Chapter 08. Account(계좌) 시스템 개발”, https://oranthy.tistory.com/270, 2022.08.02([4]의 원출처)

[6] 계란, 티스토리, “Chapter 07. 사전 준비“, https://oranthy.tistory.com/269, 2022.08.02 ([4]의 원출처)

[7] chatgpt, response to “여러 종류의 상품들을 주문하려고 할 때, 자바 스프링(gradle),위 코드를 바탕으로 Product, Order, OrderItem, 
이 클래스들과 관련된 DTO, 사용자 인증, 예외처리, Controller, Service, Repository로 어떻게 코딩을 작성할 수 있습니까?”(외 여러 개 질문),
https://chatgpt.com/c/803aac98-990b-4922-bd9e-97cda05ad57f, stock, 2024.5~2024.6 사이, https://chat.openai.com.

[8] 미상, 제로베이스, Part3. 예제를 통해 학습하는 스프링(Java)_Chapter 01. 사전 준비.pdf, “의존성” 외, 미상, 미상.

[9] 자바신생아, okky, “비밀번호의 길이를 4~17자 사이로 제한하고 싶습니다.”, https://okky.kr/questions/1502513#answer-775248, 2024.06.03

[10] ChatGPT, response to “Long cPW, cAccountNumber, cPhoneNumber은 1~10,000,000,000,000,000 사이의 값으로 제한을 하고 싶고,
String cName의 길이는 1~30으로 제한하고 싶은데 이 코드를 어떻게 수정하면 되겠습니까?”, June 3, 2024, https://chat.openai.com.

[11] ChatGPT, response to “generated-requests.http에서 POST http://localhost:8080/customer/make Content-Type: application/json
{"cpw": 12345678901234567890, "cname": "abcdefg", "cAccountNumber": 0, "cPhoneNumber": 0} 에서 cpw의 값을 0~10의 16제곱 미만으로 설정하려면
Controller, Service를 어떻게 작성해야 됩니까?(비밀번호를 숫자를 1자리 이상 16자리 이하로 설정)”,
https://chatgpt.com/c/87ba814d-5a81-4d8d-9f8b-3fe437c75670, June 3, 2024, https://chat.openai.com.

[12] 본인, DBeaver, Create Table… (General-Connetctions-localhost:3306 -Database - testdb1 - Tables - <localhost> Script 18, 미상, 미상.(테이블 제작 형식)

[13] Sanha Ko, 산하개발실록, “[SpringBoot] ResponseEntity로 http 응답 생성”, https://headf1rst.github.io/spring/response-entity/, 2022.05.27

[14] Chatgpt, response to “CREATE TABLE ORDERS( 'ordersNumber' varchar(100) DEFAULT NULL, 'ordersName' varchar(100) DEFAULT NULL,
'customerID' varchar(100) DEFAULT NULL, 'sellerID'varchar(100) DEFAULT NULL, 'cartID' varchar(100) DEFAULT NULL, 'productName'
varchar(100) DEFAULT NULL, 'ordersCount' varchar(100) DEFAULT NULL, 'category' varchar(100) DEFAULT NULL, 'cost' varchar(100) 
DEFAULT NULL); 이 것이 잘못인가요? sql로 테이블 만들려면 어떻게 해야 되나요?,
https://chatgpt.com/c/609a4b93-63f2-495f-9b54-d98978688065, June 17, 2024, https://chat.openai.com.

[15] Chatgpt, response to “클래스 Seller, SellerRegister(내용 기반) ,클래스 SellerCustomer, Service: makeSeller(메서드 기반),
CRUD(Create, Read, Update, Delete를 ResponseEntity를 통한 http 요청)”(질문이 너무 길고, 여러 개임),
https://chatgpt.com/c/562a5ef7-dab1-4a28-b590-44653a58f161, June 11(추측), https://chat.openai.com.

[16] Chatgpt, response to “클래 스 SellerCustomer, Service(내용 기반)에서의 회원가입, 로그인, 로그아웃을 작성하는 방법(핵심 키워드: Register, Login, Logout,
GetProfile) (질문이 너무 길고, 여러 개임) “, “여기서 Seller, SellerRegister 클래스를 모두 PW 형태를 String으로 바꿔야 할 때 어떻게 코드를 바꿀 수 있겠습니까?”,
https://chatgpt.com/c/45fd204e-7b44-48f7-a187-ca540d09f8df, June 11, 2024(추측), https://chat.openai.com.

[17] Chatgpt, response to “(질문이 너무 길어 앞 부분 생략)어떻게 바꿔야 회원가입(계정을 새로 만들때) 중복된 이름이 확인되면 안 만들 수 있습니까?”, 
https://chatgpt.com/c/2ebd068f-9c34-4f7a-8859-ee0f171c13f3, June 11, 2024(추측), https://chat.openai.com.

[18] Chatgpt, response to "Foreign key constraint is incorrectly formed" dbeaver에서 무엇이 문제이고 어떻게 해서 foreign key를 만들 수 있습니까?",
https://chatgpt.com/c/50776e5e-6bc1-4169-b534-925e3ea88e97, June 17, 2024. https://chat.openai.com.

[19]  ChatGPT, response to “How can i limit pw length to 4~17 characters in java spring intellij?”,
https://chatgpt.com/c/47feb45b-b732-4bdf-a312-1ee1695653fd,  June 03, 2024, https://chat.openai.com. 
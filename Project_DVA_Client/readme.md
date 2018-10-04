# 멀티 채팅 애플리케이션 Dva (Client)

## 개요
OOP 기본 원리, Exception, Collection, AWT, Stream, Thread, Network API 등을 이용하여 End User用 Messenger Client-Server System의 클라이언트 개발



## 기능 요구사항

#### 사용자 접속 및 관리

* 동시 다중 클라이언트 접속 가능

* 클라이언트 접속 시 대화명(Nickname) 중복 여부 체크 및 결과 통보

#### 대기실

* 접속 후 자동으로 대기실 입장ㄴ

* 대기실 전체 접속자(Nickname) 목록 출력

* 개설된 전체 대화방(대화방이름, 방장이름, 참여자수/방 크기) 목록 출력

* 특정 대화방 선택 시 참여자 목록 출력

* 개설된 특정 대화방 입장

* 신규 대화방 개설

* 접속 종료

####  대화방

- 대화방 참여자(Nickname) 전체 목록 출력
- 대화방 내 모든 사용자들과 멀티 채팅 가능
- 대화방 내 특정 사용자에게만 메시지 보내기 가능
- 대기실 내 특정 사용자에게 초대 메시지 보내기 가능



## 화면 설계

#### 대기실

![](https://github.com/uyk/HanaTI_Workspace/blob/new/Project_DVA_Client/img/UI_waitingRoom.png?raw=true)



#### 채팅방

![](https://github.com/uyk/HanaTI_Workspace/blob/new/Project_DVA_Client/img/UI_chatingRoom.png?raw=true)



## UML 클래스 다이어그램

![](https://github.com/uyk/HanaTI_Workspace/blob/new/Project_DVA_Client/img/dva_client_uml.jpg?raw=true)

## 프로토콜 설계

| 요청         | type | time | 요청보낸nick |                                         |
| ------------ | ---- | ---- | ------------ | --------------------------------------- |
| 로그인       | 1000 |      |              |                                         |
| 로그아웃요청 | 1100 |      |              |                                         |
| 리스트요청   | 2000 |      |              | ROOM_LISTUSER_LISTROOM_USER_LIST/방제목 |
| 방생성       | 3000 |      |              | 방이름/허용량                           |
| 방입장       | 3100 |      |              | 방이름                                  |
| 방나가기     | 3200 |      |              |                                         |
| 채팅방메시지 | 4000 |      |              | 메시지                                  |
| 쪽지         | 4100 |      |              | 받는사람/메시지                         |
| 초대         | 5000 |      |              | 받는사람                                |



|               | type | time | 받는 사람 nick |                           |
| ------------- | ---- | ---- | -------------- | ------------------------- |
| 로그인성공    | 1001 |      |                |                           |
| 로그인실패    | 1002 |      |                |                           |
| 방목록        | 2001 |      |                | 방제/방장/현인원/총인원…. |
| 방에있는 유저 | 2002 |      |                | 방제/닉네임...            |
| 전체유저      | 2003 |      |                | 닉네임/위치...            |
| 방 생성 성공  | 3001 |      |                | 방제/방장/현인원/총인원   |
| 방 생성 실패  | 3002 |      |                | 방이름                    |
| 방 입장 성공  | 3101 |      |                | 방이름                    |
| 방 입장 실패  | 3102 |      |                | 방이름                    |
| 새 입장       | 3103 |      |                | 닉네임                    |
| 누가 나감     | 3104 |      |                | 닉네임                    |
| 방 나감       | 3201 |      |                |                           |
| 방 정보 변경  | 3301 |      |                | 방제/방장/현인원/총인원   |
| 채팅방메시지  | 4001 |      |                | 닉네임/메시지             |
| 쪽지성공      | 4101 |      |                |                           |
| 쪽지실패      | 4102 |      |                |                           |
| 쪽지메시지    | 4103 |      |                | 닉네임/메시지             |
| 초대성공      | 5001 |      |                |                           |
| 초대실패      | 5002 |      |                |                           |
| 초대거절      | 5003 |      |                | 거절한사람 닉네임         |
| 초대          | 5101 |      |                | 보내는사람/방이름         |

## 실행 화면

![](https://github.com/uyk/HanaTI_Workspace/blob/new/Project_DVA_Client/img/01.png?raw=true)

![](https://github.com/uyk/HanaTI_Workspace/blob/new/Project_DVA_Client/img/05.png?raw=true)
![](https://github.com/uyk/HanaTI_Workspace/blob/new/Project_DVA_Client/img/07.png?raw=true)
![](https://github.com/uyk/HanaTI_Workspace/blob/new/Project_DVA_Client/img/08.png?raw=true)
![](https://github.com/uyk/HanaTI_Workspace/blob/new/Project_DVA_Client/img/09.png?raw=true)
![](https://github.com/uyk/HanaTI_Workspace/blob/new/Project_DVA_Client/img/11.png?raw=true)
![](https://github.com/uyk/HanaTI_Workspace/blob/new/Project_DVA_Client/img/12.png?raw=true)
![](https://github.com/uyk/HanaTI_Workspace/blob/new/Project_DVA_Client/img/13.png?raw=true)
![](https://github.com/uyk/HanaTI_Workspace/blob/new/Project_DVA_Client/img/14.png?raw=true)
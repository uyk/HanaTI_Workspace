# 멀티 채팅 애플리케이션 Dva

## 개요
OOP 기본 원리, Exception, Collection, AWT, Stream, Thread, Network API 등을 이용하여 End User用 Messenger Client-Server System을 구축한다.



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

![](C:\KOSTA187\workspace\Project_DVA_Client\UI_waitingRoom.png)

#### 채팅방

![](C:\KOSTA187\workspace\Project_DVA_Client\UI_chatingRoom.png)



## UML 클래스 다이어그램

![](C:\KOSTA187\workspace\Project_DVA_Client\dva_client_uml.jpg)


## 실행 화면
package kr.or.kosta.dva.server.entity;

public interface Protocol {
	
	//서버 정보
	public static final String SERVER_IP = "127.0.0.1";
	public static final int PORT = 9094;
	public static final String ANTEROOM = "Anteroom";
	
	//구분자
	public static final String DELEMETER = "☆☆";
	public static final String INNER_DELEMETER = "★★";
	
	//클라 to 서버

	public static final int CS_LOGIN = 1000;
	public static final int CS_LOGOUT = 1100;
	public static final int CS_GET_LIST = 2000;
	public static final String CS_ROOMLIST = "RoomList";
	public static final String CS_ROOMUSERLIST = "RoomUserList";
	public static final String CS_USERLIST = "UserList";
	public static final int CS_ROOM_ADD = 3000;
	public static final int CS_ENTRANCE = 3100;
	public static final int CS_ROOM_OUT = 3200;
	public static final int CS_CHAT_MESSAGE = 4000;
	public static final int CS_WHISPER = 4100;
	public static final int CS_INVITE = 5000;
	public static final int CS_INVITE_OK = 5200;
	public static final int CS_INVITE_NO = 5300;
	
	
	// 서버 TO 클라
	public static final int SC_LOGIN_SUCCESS = 1001;
	public static final int SC_LOGIN_FAIL = 1002;
	public static final int SC_ROOMLIST = 2001;
	public static final int SC_ROOMUSERLIST = 2002;
	public static final int SC_USERLIST = 2003;
	public static final int SC_ROOM_ADD_SUCCESS = 3001;
	public static final int SC_ROOM_ADD_FAIL = 3002;
	public static final int SC_ENTRANCE_SUCCESS = 3101;
	public static final int SC_ENTRANCE_FAIL = 3102;
	public static final int SC_ENTRANCE_MEMBER = 3103;
	public static final int SC_OUT_MEMBER = 3104;
	public static final int SC_ROOM_OUT_SUCCESS = 3201;
	public static final int SC_ROOM_INFO_CHANGE = 3301;
	public static final int SC_CHAT_MESSAGE = 4001;
	public static final int SC_WHISPER_SUCCESS = 4101;
	public static final int SC_WHISPER_FAIL = 4102;
	public static final int SC_WHISPER_MESSAGE = 4103;
	public static final int SC_INVITE_SUCCESS = 5001;
	public static final int SC_INVITE_FAIL = 5002;
	public static final int SC_INVITE_MESSAGE = 5101;
	public static final int SC_INVITE_REJECT = 5301;
}

package kr.or.kosta.dva.server.boundary;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

import kr.or.kosta.dva.server.entity.DvaServer;

/**
 * 서버 화면 구성 및 동작 
 * @author 남수현
 */
public class MainFrame extends Frame{

	private Panel panel;
	private Label logMessageL, roomListL, wrongMessageL, clientListL;
	private TextArea logMessageTA, wrongMessageTA;
	private List roomList, clientList;
	private GridBagLayout gridBagLayout;
	private GridBagConstraints gridBagConstraints;

	/**
	 * 서버 화면 구성 Class 사용을 위한 기본 생성자
	 */
	public MainFrame() {
		this("DVA Server Management");
	}
	/**
	 * 계좌 화면 구성 Class 사용을 위한 생성자
	 * @param title 프로그램 title
	 */
	public MainFrame(String title) {
		super(title);
		logMessageL = new Label("Log Message");
		roomListL = new Label("Room List");
		wrongMessageL = new Label("Wrong Message");
		clientListL = new Label("Client List");
		logMessageTA = new TextArea();
		roomList = new List(20,false);
		wrongMessageTA = new TextArea();
		clientList = new List(20,false);
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		panel = new Panel();
	}
	/**
	 * 콘텐츠 부착
	 */
	public void setContents() {
		panel.setLayout(gridBagLayout);
		Insets insets = new Insets(2,2,2,2);
		add(new Label(" ")	, 0, 0, 1, 1,0,0,insets);
		add(new Label(" ")	, 4, 0, 1, 1,0,0,insets);
		add(new Label(" ")	, 0, 5, 1, 1,0,0,insets);
		add(new Label(" ")	, 4, 5, 1, 1,0,0,insets);
		add(new Label(" ")	, 2, 0, 1, 1,0,0,insets);
		add(logMessageL		, 1, 1, 1, 1,0,0,insets);
		add(new Label(" ")  , 2, 1, 1, 1,0,0,insets);
		add(clientListL		, 4, 1, 1, 1,0,0,insets);
		add(logMessageTA	, 1, 2, 2, 1,0,0,insets);
		add(clientList    	, 4, 2, 1, 1,0,0,insets);
		add(wrongMessageL   , 1, 3, 1, 1,0,0,insets);
		add(roomListL       , 4, 3, 1, 1,0,0,insets);
		add(wrongMessageTA  , 1, 4, 2, 1,0,0,insets);
		add(roomList      	, 4, 4, 1, 1,0,0,insets);
		add(panel);
	}
	/**
	 * 화면을 가운데에 위치 시키기
	 */
	public void setCenter() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int)(screen.getWidth()-getSize().getWidth())/2,(int)(screen.getHeight()-getSize().getHeight())/2);
	}
	/**
	 * 프로그램 종료 메소드
	 */
	private void finish() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	/**
	 * logMessage TrexArea에 append
	 * @param message append 할 메세지
	 */
	public void appendLog(String message) {
		logMessageTA.append(message);
	}
	/**
	 * logMessage TextArea에 setText
	 * @param message set 할 메세지
	 */
	public void setLog(String message) {
		logMessageTA.setText(message);
	}
	/**
	 * wrongMessage TextArea에 append
	 * @param message append 할 메세지
	 */
	public void appendWrongMessage(String message) {
		wrongMessageTA.append(message);
	}
	/**
	 * wrongMessage TextArea에 setText
	 * @param message set 할 메세지
	 */
	public void setWrongMessage(String message) {
		wrongMessageTA.setText(message);
	}
	/**
	 * Client List에 클라이언트 add
	 * @param addItem add 할 클라이언트 닉네임
	 */
	public void addClient(String addItem) {
		clientList.add(addItem);
	}
	
	/**
	 * Client List에서 클라이언트 remove
	 * @param removeItem remove 할 클라이언트 닉네임
	 */
	public void removeClient(String removeItem) {
		clientList.remove(removeItem);
	}
	/**
	 * Room List에 룸 add
	 * @param addItem add 할 룸 방제
	 */
	public void addRoom(String addItem) {
		roomList.add(addItem);
	}
	/**
	 * Room List에서 룸 삭제
	 * @param removeItem remove 할 룸 방제
	 */
	public void removeRoom(String removeItem) {
		roomList.remove(removeItem);
	}
	/**
	 * GridBagLayout에 입력된 값에 따라 component 부착
	 * @param component 부착할 component
	 * @param gridX 부착할 x위치
	 * @param gridY 부착할 y위치
	 * @param gridWidth 차지할 x영역 크기
	 * @param gridHeight 차지할 y영역 크기
	 * @param weightX x가중치
	 * @param weightY y가중치
	 * @param insets component 여백
	 */
	private void add(Component component, int gridX, int gridY, int gridWidth, int gridHeight, double weightX, double weightY, Insets insets) {
		gridBagConstraints.gridx = gridX;
		gridBagConstraints.gridy = gridY;
		gridBagConstraints.gridwidth = gridWidth;
		gridBagConstraints.gridheight = gridHeight;
		gridBagConstraints.weightx =weightX;
		gridBagConstraints.weighty =weightY;
		gridBagConstraints.fill = gridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = insets;
		gridBagLayout.setConstraints(component, gridBagConstraints);
		panel.add(component);
	}
	public void eventRegist() {
		addWindowListener(
		new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
	}
}

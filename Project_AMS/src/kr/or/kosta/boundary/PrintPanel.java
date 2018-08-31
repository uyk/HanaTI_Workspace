///*
//package kr.or.kosta.boundary;
//
//import java.awt.Button;
//import java.awt.Choice;
//import java.awt.Component;
//import java.awt.Frame;
//import java.awt.GridBagConstraints;
//import java.awt.GridBagLayout;
//import java.awt.Insets;
//import java.awt.Label;
//import java.awt.List;
//import java.awt.Panel;
//import java.awt.TextArea;
//import java.awt.TextField;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//
///**
// * 계좌 관리 프로그램
// * 
// * PrintPanel : 데이터의 출력을 위한 패널.
// * 부모클래스 : Panel
// * 
// * @author 유예겸
// *
// */
//
//public class PrintPanel extends Panel {
//// 인스턴스 변수
//	TextArea accountsList;
//
//// 생성자
//	/**
//	 * 디폴트 생성자. 각 컴포넌트와 레이아웃 변수 초기화.
//	 */
//	public PrintPanel() {		
//		accountsList = new TextArea(
//				"----------------------------------------------------"
//				+ "\n계좌종류\t 계좌번호\t 예금주명\t 현재잔액\t 대출금액"
//				+ "\n====================================================");
//		setContents();
//	}
//	
//// 인스턴스 메소드
//	public void setContents() {
//		add(accountsList);
//	}
//	
//// 테스트를 위한 메인	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Frame frame = new Frame("GridBagLayout Mission");
//		PrintPanel panel = new PrintPanel();
//
//		
//		frame.add(panel);
//		frame.setSize(800,500);
////		frame.pack();
//		frame.setVisible(true);
//		
//		frame.addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				//finish();
//				frame.setVisible(false);
//				frame.dispose();
//				System.exit(1);
//			}
//		});
//	}
//	
//}

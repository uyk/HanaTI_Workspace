package memo;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class MemoUI extends Frame {
	static final String defaultTitle = "제목없음 - 메모장";
// 인스턴스 변수
	MenuBar menuBar;
	Menu fileMenu;
	MenuItem newMI, openMI, saveMI, exitMI;
	
	TextArea textArea;
	
	FileDao fileDao;
	String currentName;
	


	// 생성자
	/**
	 * 디폴트 생성자. 
	 * 다른 생성자를 호출
	 */
	public MemoUI() {
		this(defaultTitle);
	}
	
	/**
	 * 타이틀을 인자로 받는 생성자.
	 * 컴포넌트 초기화, 윈도우 리스너 등록.
	 * 
	 * @param string 프레임 제목
	 */
	public MemoUI(String string) {
		super(string);
		menuBar = new MenuBar();
		fileMenu = new Menu("파일(F)");
		newMI = new MenuItem("새로만들기(N)");
		openMI = new MenuItem("열기(O)...");
		saveMI = new MenuItem("저장(S)");
		exitMI = new MenuItem("끝내기");

		textArea = new TextArea();

		setMenu();
		setContents();
		eventRegist();		
	}
	
	
// getter, setter
	
	public FileDao getFileDao() {
		return fileDao;
	}

	public void setFileDao(FileDao fileDao) {
		this.fileDao = fileDao;
	}
	
	/**
	 * 프로그램을 종료하는 메소드
	 */
	public void finish() {
		setVisible(false);
		dispose();
		System.exit(NORMAL);
	}
	
	/**
	 * 메뉴를 설정하는 메소드
	 */
	public void setMenu() {
		fileMenu.setShortcut(new MenuShortcut(KeyEvent.VK_F));		
		newMI.setShortcut(new MenuShortcut(KeyEvent.VK_N));
		openMI.setShortcut(new MenuShortcut(KeyEvent.VK_O));
		saveMI.setShortcut(new MenuShortcut(KeyEvent.VK_S));
		exitMI.setShortcut(new MenuShortcut(KeyEvent.VK_X));

		fileMenu.add(newMI);
		fileMenu.add(openMI);
		fileMenu.add(saveMI);
		fileMenu.addSeparator();
		fileMenu.add(exitMI);
		
		menuBar.add(fileMenu);
		setMenuBar(menuBar);

	}
	
	/**
	 *  컨텐츠를 설정하는 메소드
	 */
	public void setContents() {
		add(textArea);
	}
	
	/**
	 * 이벤트를 등록하는 메소드
	 */
	public void eventRegist() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		
		// 새로만들기 메뉴 아이템
		newMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if( !(textArea.getText().equals(""))) {
						String path = showFileDialog("파일 저장", FileDialog.SAVE);
						fileDao.saveFile(path, textArea.getText());
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				textArea.setText("");
				setTitle(defaultTitle);
			}
		});
		
		// 열기 메뉴 아이템
		openMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				try {
					String path = showFileDialog("파일 열기", FileDialog.LOAD);
					if(path != "nullnull") {		
						textArea.append(fileDao.openFile(path));
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		// 저장 메뉴 아이템
		saveMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String path = showFileDialog("파일 저장", FileDialog.SAVE);
					fileDao.saveFile(path, textArea.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		// 종료 메뉴 아이템
		exitMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				finish();
			}
		});
		
		
	}
	
	public String showFileDialog(String title, int type) {
		FileDialog fileDialog = new FileDialog(this, title, type);
		fileDialog.setVisible(true);
		String path = null;
		if(type == FileDialog.SAVE) {
			setTitle(fileDialog.getFile() + ".txt");
			path = fileDialog.getDirectory() + fileDialog.getFile() + ".txt";
		}
		else {
			setTitle(fileDialog.getFile());
			path = fileDialog.getDirectory() + fileDialog.getFile();
		}
		return path;
	}

}

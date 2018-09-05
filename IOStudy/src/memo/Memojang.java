package memo;
/**
 * 메모장 애플리케이션
 * 
 * @author 유예겸
 *
 */
public class Memojang {

	public static void main(String[] args) {
		MemoUI memoUI = new MemoUI("제목없음 - 메모장");
		FileDao fileDao = new FileDao(memoUI);
		memoUI.setFileDao(fileDao);
		
		memoUI.setSize(600,400);
		memoUI.setVisible(true);
	}

}

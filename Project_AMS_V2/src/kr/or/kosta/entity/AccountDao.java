package kr.or.kosta.entity;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * 계좌 관리 프로그램
 * 
 * AccountDao : 계좌 정보를 파일에 저장, 파일에서 탐색 등의 기능을 수행하는 클래스.
 * 
 * @author 유예겸
 *
 */
public class AccountDao {
	/** 저장 파일 경로*/
	private static final String FILE_PATH = "accounts.dbf";
	
	/** 레코드(계좌)수 저장을 위한 파일 컬럼 사이즈 고정 */
	private static final int RECORD_COUNT_LENGTH = 4;
	
	/** 레코드(계좌 번호, 이름, 비밀번호, 잔액, 대출금) 저장을 위한 컬럼별 사이즈 고정 */
	private static final int NUM_LENGTH = 32;		// 계좌번호(30바이트)
	private static final int OWNER_LENGTH = 20;		// 예금주명(20바이트)
	private static final int PASSWD_LENGTH = 4;     // 비밀번호(4바이트)
	private static final int MONEY_LENGTH = 8;		// 잔액(8바이트)
	private static final int BORROW_LENGTH = 8;		// 대출금(8바이트)
	
	/** 계좌정보 저장을 위한 레코드 사이즈 : 80바이트 */	
	public static final int RECORD_LENGTH = NUM_LENGTH + OWNER_LENGTH + PASSWD_LENGTH + MONEY_LENGTH + BORROW_LENGTH;
	
	private RandomAccessFile file;
	
	/** 저장된 계좌(레코드)수 */
	private int recordCount = 0;
	
	public AccountDao() throws IOException {
		file = new RandomAccessFile(FILE_PATH, "rw");
		
		// 저장된 파일이 있는 경우..
		if(file.length() != 0){
			recordCount = file.readInt();
		}
	}	

	/** getter */
	public int getRecordCount() {
		return recordCount;
	}
	
	/** 계좌 정보 저장 
	 * @throws IOException */
	public boolean create(Account account) throws IOException {
		// 파일의 마지막 레코드끝으로 파일 포인터 이동.
		file.seek((recordCount * RECORD_LENGTH) + RECORD_COUNT_LENGTH);
		// 이미 있는 계좌면 추가 안함
		// 0번째부터 (recordCount-1)번째의 계좌의 정보를 읽기
		for(int i=0; i<recordCount; i++){
			Account tempAccount = read(i);	
			if (tempAccount.getAccountNum().equals(account.getAccountNum())) {
				return false;
			}
		}
		
		// 새로운 레코드(계좌) 추가
		// 30 + 20 + 4 + 8 + 8
		String num = account.getAccountNum();
		String owner = account.getAccountOwner();
		int passwd = account.getPasswd();
		long restMoney = account.getRestMoney();
		// account가 MinusAccount의 인스턴스가 아니면 0을 기본값으로
		long borrowMoney = (account instanceof MinusAccount) ? ((MinusAccount)account).getBorrowMoney() : -1L;
		
		int charCount = num.length();		
		// 30바이트(15글자)로 계좌번호 저장
		for(int i = 0; i < (NUM_LENGTH/2); i++){		
			// EX) "1111-2222-3333 "
			file.writeChar(( i < charCount ? num.charAt(i) : ' '));
		}
		
		charCount = owner.length();		
		// 20바이트(10글자)로 예금주 저장
		for(int i = 0; i < (OWNER_LENGTH/2); i++){		
			// EX) "유예겸       "
			file.writeChar(( i < charCount ? owner.charAt(i) : ' '));
		}
		
		// 비밀번호(4바이트)
		file.writeInt(passwd);
		// 잔액(8바이트)
		file.writeLong(restMoney);
		// 대출금(8바이트)
		file.writeLong(borrowMoney);

		// 레코드 저장 후 파일포인터를 파일의 처음으로 이동시켜
		// 등록된 레코드(계좌) 수 1 증가
		file.seek(0);
		file.writeInt(++recordCount);
		
		return true;
	}
	
	public void writeAccountAt(Account account, int index) throws IOException {
		// 파일의 마지막 레코드끝으로 파일 포인터 이동.
		file.seek((index * RECORD_LENGTH) + RECORD_COUNT_LENGTH);
		
		// 새로운 레코드(계좌) 추가
		// 30 + 20 + 4 + 8 + 8
		String num = account.getAccountNum();
		String owner = account.getAccountOwner();
		int passwd = account.getPasswd();
		long restMoney = account.getRestMoney();
		// account가 MinusAccount의 인스턴스가 아니면 0을 기본값으로
		long borrowMoney = (account instanceof MinusAccount) ? ((MinusAccount)account).getBorrowMoney() : -1L;
		
		int charCount = num.length();		
		// 30바이트(15글자)로 계좌번호 저장
		for(int i = 0; i < (NUM_LENGTH/2); i++){		
			// EX) "1111-2222-3333 "
			file.writeChar(( i < charCount ? num.charAt(i) : ' '));
		}
		
		charCount = owner.length();		
		// 20바이트(10글자)로 예금주 저장
		for(int i = 0; i < (OWNER_LENGTH/2); i++){		
			// EX) "유예겸       "
			file.writeChar(( i < charCount ? owner.charAt(i) : ' '));
		}
		
		// 비밀번호(4바이트)
		file.writeInt(passwd);
		// 잔액(8바이트)
		file.writeLong(restMoney);
		// 대출금(8바이트)
		file.writeLong(borrowMoney);
	}
	
	
	/** 등록된 전체리스트 반환 */
	public List<Account>  listAll() throws IOException{
		List<Account> list = new ArrayList<Account>();
		// 0번째부터 (recordCount-1)번째의 계좌의 정보를 읽어 account에 저장하고 list에 추가
		for(int i=0; i<recordCount; i++){
			Account account = read(i);
			list.add(account);		
		}
		return list;
	}

	
	/**
	 * 레코드에서 accountNum 계좌의 정보를 Account로 반환
	 * @param accountNum	찾을 계좌의 계좌번호
	 * @return	찾으면 찾은 계좌정보 Account, 없으면 null
	 * @throws IOException
	 */
	public Account searchByNum(String accountNum) throws IOException{
		
		// 0번째부터 (recordCount-1)번째의 계좌의 정보를 읽기
		for(int i=0; i<recordCount; i++){
			Account tempAccount = read(i);	
			if (tempAccount.getAccountNum().equals(accountNum)) {
				return tempAccount;
			}
		}
		return null;
	}
	
	/**
	 * 레코드에서 accountOwner 계좌의 정보를 List로 반환
	 * @param accountOwner	찾을 계좌의 예금주명
	 * @return	찾으면 찾은 계좌들의 List, 없으면 null
	 * @throws IOException
	 */
	public List<Account> searchByOwner(String accountOwner) throws IOException{
		List<Account> list = new ArrayList<Account>();
		
		// 0번째부터 (recordCount-1)번째의 계좌의 정보를 읽기
		for(int i=0; i<recordCount; i++){
			Account tempAccount = read(i);	
			if (tempAccount.getAccountOwner().equals(accountOwner)) {
				list.add(tempAccount);
			}
		}
		return list;
	}
	
	/**
	 * accounts에서 계좌 번호로 검색하여 일치하는 계좌의 정보를 제거
	 * 
	 * @param accountNumber 제거할 계좌의 계좌번호
	 * @return 제거에 성공하면 true, 제거할 계좌가 없으면 false
	 */
	public boolean remove(String accountNum) throws IOException{
		int index = -1;
		// 0번째부터 (recordCount-1)번째의 계좌의 정보를 읽기
		for(int i=0; i<recordCount; i++){
			Account tempAccount = read(i);	
			if (tempAccount.getAccountNum().equals(accountNum))
				index = i;
		}
		// 계좌가 없음
		if (index == -1) return false;

		// 계좌 당기기
		for(int i = index + 1; i<recordCount; i++){
			Account account = read(i);
			writeAccountAt(account, i - 1);	
		}	
		
		// 레코드 제거 후 파일포인터를 파일의 처음으로 이동시켜
		// 등록된 레코드(계좌) 수 1 증가
		file.seek(0);
		file.writeInt(--recordCount);
		
		return true;

	}
	
	/** 레코드에서 index 위치의 정보를 Account로 반환 */
	private Account read(int index) throws IOException{
		Account account = null;
		
		file.seek((index * RECORD_LENGTH) + RECORD_COUNT_LENGTH);

		
		// NUM_LENGTH 공간에서 계좌번호를 읽어와 num에 저장
		String num = "";
		for(int i=0; i<(NUM_LENGTH/2); i++){
			num += file.readChar();
		}
		// 빈공간 제거
		num = num.trim();
			
		// OWNER_LENGTH 공간에서 예금주를 읽어와 owner에 저장
		String owner = "";
		for(int i=0; i<(OWNER_LENGTH/2); i++){
			owner += file.readChar();
		}
		// 빈공간 제거
		owner = owner.trim();
				
		int passwd = 0;
		passwd = file.readInt();
		
		long restMoney = 0L;
		restMoney = file.readLong();
		
		long borrowMoney = 0L;
		borrowMoney = file.readLong();

		
		if(borrowMoney == -1L)
			account = new Account(num, owner, passwd, restMoney);
		else 
			account = new MinusAccount(num, owner, passwd, restMoney, borrowMoney);
		
		return account;
	}
	

	
	// 스트림 닫기
	public void close(){
		try{
			if(file != null) file.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}

}

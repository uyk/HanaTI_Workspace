import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarExample {
	
	// 근무일 수를 계산하는 메소드
	public static int getWorks(String year, String month, String date) {
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		cal2.set(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(date));
		
		System.out.println(String.format("%1$tF %1$tT", cal));
		System.out.println(String.format("%1$tF %1$tT", cal2));
		
		//System.out.println(cal.getTimeInMillis());
		//System.out.println(cal2.getTimeInMillis());
		long l = (cal.getTimeInMillis() - cal2.getTimeInMillis()) / 1000L / 60L / 60L / 24L;		// 밀리/초/분/시간

		return (int)l;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Calendar today = new Calendar();
		//Calendar today = new GregorianCalendar();
		
		Calendar today = Calendar.getInstance(); 
		today.set(Calendar.YEAR,1987);		
		
		
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		int date = today.get(Calendar.DATE);
		
		//int day = 
				
		/*
		switch(day) {
		case Calendar.SUNDAY : System.out.println("일요일"); break;
		case Calen : System.out.println("일요일"); break;
		}
		*/
		System.out.println(String.format("%tY", Calendar.getInstance())); //4자리년도
		System.out.println(String.format("%ty", Calendar.getInstance())); //2자리년도
		System.out.println(String.format("%tm", Calendar.getInstance())); //숫자월 
		System.out.println(String.format("%tB", Calendar.getInstance())); //문자열월
		System.out.println(String.format("%td", Calendar.getInstance())); //일
		System.out.println(String.format("%tA", Calendar.getInstance())); //요일

		System.out.println(String.format("%tH", Calendar.getInstance())); //24시간
		System.out.println(String.format("%1$tp %tI", Calendar.getInstance())); //오전/오후 12시간System.out.println(String.format("%tM", Calendar.getInstance())); //분
		System.out.println(String.format("%tS", Calendar.getInstance())); //초

		System.out.println(String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS %1$tA", Calendar.getInstance()));

		// 날짜/시간 합성문자 사용
		System.out.println(String.format("%1$tF %1$tT", Calendar.getInstance()));
		
		
		// 근무일 수 구하기
		 int value = getWorks("1987", "3", "1");	//오늘까지의 근무일 수 구하기
		 System.out.println(value);
	
	}
}

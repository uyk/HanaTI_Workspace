import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * DNS와의 통신을 통해 IP <----> Domain 정보 제공
 * @author 유예겸
 *
 */
public class InetAdressExample {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress ia = InetAddress.getLocalHost();
		System.out.println(ia.getHostAddress());
		
		System.out.println(InetAddress.getByName("www.naver.com"));
		System.out.println(InetAddress.getByName("www.daum.net"));
		for (InetAddress string : InetAddress.getAllByName("www.naver.com")) {
			System.out.println(string);
		}
	}

}

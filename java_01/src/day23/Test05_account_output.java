package day23;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Test05_account_output {

	public static void main(String[] args) {

		String fileName = "account.obj";
				// -> 경로를 지정해주지 않으면 Eclipse에서는 class, dos에서는 bin folder!
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {

			fos = new FileOutputStream(fileName);
			oos =  new ObjectOutputStream(fos);

			Set <Account> set = new HashSet<Account>();
			
			Account a = new Account("2019-001", "김주현", 100, "1234");
			Account b = new Account("2019-002", "박주현", 1000, "1111");
			
			set.add(a);
			set.add(b);
			
			//set은 중복 걸러주므로 이건 걸러질거얌
			set.add(a);
			set.add(new Account("2019-004", "임주현", 10000, "9999"));
			
			
			
			oos.writeObject(set);
			oos.flush();  // buffering 한다는걸 알 수 있음
			
			
			System.out.println("파일에 저장되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (oos != null) {
					oos.close();
					oos = null;
				}

				if (fos != null) {
					fos.close();
					fos = null;
				}

			} catch (Exception e2) {
			}
		}

		// -> 이렇게 만들고 생성된 파일 열어보면 JAVA가 알아볼 수 있는 내용으로 저장해 놓은 것을 알수 있음!
		System.out.println("main end");
	}

}

class Account extends Object implements Serializable{
				// -> Serializable을 implements 해야 Stream 통과 가능! => File 저장 가능
	
	
	String number;
	String name;
	int money;
	transient String pw;
	// [ Transient ]
	// : Stream을 통과하지 못하게 막는 예약어!
	//   -> PW는 소중하니까~ 보안상 위험한 정보는 빼야하니까~
	
	Account(){
		
	}

	public Account(String number, String name, int money, String pw) {
		this.number = number;
		this.name = name;
		this.money = money;
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "Account [number=" + number + ", name=" + name + ", money=" + money + ", pw=" + pw + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + money;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (money != other.money)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		return true;
	}

	
	
}


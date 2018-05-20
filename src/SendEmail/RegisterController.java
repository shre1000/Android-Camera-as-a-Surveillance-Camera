package SendEmail;

import java.util.*;

public class RegisterController {

  private List _accounts = new ArrayList();

	public void register(String name, int age) {
		Account account = new Account();
		account.setId(1);
		account.setName(name);
		account.setAge(age);
		_accounts.add(account);
	}
	
	public List getAccounts(){
		return _accounts;
	}
}
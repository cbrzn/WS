package first;

import javax.jws.WebService;

@WebService
public interface WSInterface {

	void add(String string);
	
	void erase(int number);
	
	String show();
	
	boolean check();
}

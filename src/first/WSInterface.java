package first;

import javax.jws.WebService;

@WebService
public interface WSInterface {

	void add(String string);
		
	String show();
	
	boolean check();
	
}

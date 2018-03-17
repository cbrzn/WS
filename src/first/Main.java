package first;

import java.io.File;

import javax.servlet.ServletException;
import javax.xml.ws.Endpoint;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Main {
	
	public static WSImplementation ws = new WSImplementation();
	
	public static void main(String[] args) throws LifecycleException, ServletException {
		
		Integer port = 8200;
		String webService = "http://localhost:8520/test";
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(port);
		Endpoint.publish(webService, ws);
		Context ctxt = tomcat.addContext("/", new File(".").getAbsolutePath());
		tomcat.addWebapp("/App", new File(".").getAbsolutePath() + "/WebContent");
		Tomcat.addServlet(ctxt, "Servlet", new Servlet());
		ctxt.addServletMappingDecoded("/Servleting", "Servlet");
		tomcat.start();
		tomcat.getServer().await();
		
	}

}

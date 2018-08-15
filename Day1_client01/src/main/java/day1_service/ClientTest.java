package day1_service;

public class ClientTest {
	public static void main(String[] args) {
		WebService webServicePort = new WebServiceService().getWebServicePort();
	    String name=webServicePort.get("–°¡·");
	      System.out.println("name"+name);
	
	}

}

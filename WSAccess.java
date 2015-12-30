package wSAccess;

import java.net.*;
import java.io.*;

public class WSAccess implements IWSAccess {
	private String send_url;
	private String response;
	private String request;
	
	@Override
	public void setRequest(String request) {
		this.request = request;
	}

	@Override
	public void setServerUrl(String send_url) {
		this.send_url = send_url;

	}

	@Override
	public String getResponse() {
		//String end_url = "http://mvolpato.com.br/teste-soap/service.wsdl";
		this.response = "";
		URL url;
		try {
			url = new URL(send_url);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setDoOutput(true);
	        connection.setRequestMethod("POST");
	        connection.setRequestProperty("Content-type", "text/xml; charset=utf-8");
	        connection.setRequestProperty("SOAPAction", 
	        		send_url);
	        /*String reqXML = "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">"
	        		   +"<soapenv:Header/>"
	        		   +"<soapenv:Body/>"
	        		   +"</soapenv:Envelope>";
	        */
	        OutputStream reqStream = connection.getOutputStream();
	        reqStream.write(this.request.getBytes());
	        reqStream.close();
	        //	
	        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String decodedString;
	        while ((decodedString = in.readLine()) != null) {
	        	this.response += decodedString;
	        }
	        in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.response;
	}

}

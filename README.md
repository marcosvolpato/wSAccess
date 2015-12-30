# wSAccess

Usage sample

    String reqXML_2 = "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">"
     		   +"<soapenv:Header/>"
     		   +"<soapenv:Body/>"
     		   +"</soapenv:Envelope>";
		IWSAccess access = new WSAccess();
		access.setServerUrl("http://mvolpato.com.br/teste-soap/server.php");
		access.setRequest(reqXML_2);
		String response = access.getResponse();
		System.out.println(response);

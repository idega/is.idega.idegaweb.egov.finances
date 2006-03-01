package is.idega.idegaweb.egov.finances.business;

import is.idega.idegaweb.egov.finances.wsclient.GetStateRequest;
import is.idega.idegaweb.egov.finances.wsclient.Getmovements_request;
import is.idega.idegaweb.egov.finances.wsclient.Getmovements_responseMovements;
import is.idega.idegaweb.egov.finances.wsclient.Getstate_responseRecords;
import is.idega.idegaweb.egov.finances.wsclient.Gettypes_request;
import is.idega.idegaweb.egov.finances.wsclient.Gettypes_response;
import is.idega.idegaweb.egov.finances.wsclient.Gettypes_responseTypes;
import is.idega.idegaweb.egov.finances.wsclient.WSFinanceDataGetMovements_GetMovements_SoapPortLocator;
import is.idega.idegaweb.egov.finances.wsclient.WSFinanceDataGetMovements_GetMovements_SoapPortSoap_PortType;
import is.idega.idegaweb.egov.finances.wsclient.WSFinanceDataGetState2_GetState_SoapPortLocator;
import is.idega.idegaweb.egov.finances.wsclient.WSFinanceDataGetState2_GetState_SoapPortSoap_PortType;
import is.idega.idegaweb.egov.finances.wsclient.WSFinanceDataGetTypes_GetTypes_SoapPortLocator;
import is.idega.idegaweb.egov.finances.wsclient.WSFinanceDataGetTypes_GetTypes_SoapPortSoap_PortType;

import java.net.URL;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.EngineConfigurationFactory;
import org.apache.axis.configuration.EngineConfigurationFactoryDefault;

public class TestClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String endpoint = "http://213.167.155.148/WSFinanceDataGetTypes/WSFinanceDataGetTypes_GetTypes_SoapPort.asmx";
			String endpoint2 = "http://213.167.155.148/WSFinanceDataGetState2/WSFinanceDataGetState2_GetState_SoapPort.asmx";
			String endpoint3 = "http://213.167.155.148/WSFinanceDataGetMovements/WSFinanceDataGetMovements_GetMovements_SoapPort.asmx";

//			String endpoint = "http://10.30.11.55/WSFinanceDataGetTypes/WSFinanceDataGetTypes_GetTypes_SoapPort.asmx";
//			String endpoint2 = "http://10.30.11.55/WSFinanceDataGetState2/WSFinanceDataGetState2_GetState_SoapPort.asmx";
//			String endpoint3 = "http://10.30.11.55/WSFinanceDataGetMovements/WSFinanceDataGetMovements_GetMovements_SoapPort.asmx";

			
			/*System.out.println("STARTING TYPE HANDLING");
			WSFinanceDataGetTypes_GetTypes_SoapPortLocator locator = new WSFinanceDataGetTypes_GetTypes_SoapPortLocator();
			WSFinanceDataGetTypes_GetTypes_SoapPortSoap_PortType port = locator.getWSFinanceDataGetTypes_GetTypes_SoapPortSoap(new URL(
					endpoint));
			Gettypes_response response = port.getTypes(new Gettypes_request("1"));
			System.out.println("response = " + response.toString());
			//System.out.println("response.getSf_id() = " + response.getSf_id());
			if (response == null) {
				System.out.println("response is null");
			}
			Gettypes_responseTypes types[] = response.getTypes();
			for (int i = 0; i < types.length; i++) {
				Gettypes_responseTypes type = types[i];
				System.out.println("description = " + type.getDescription());
				System.out.println("type = " + type.getType());
				System.out.println("type id = " + type.getType_id());
			}*/
			
			System.out.println("STARTING STATE HANDLING");
			WSFinanceDataGetState2_GetState_SoapPortLocator state_locator = new WSFinanceDataGetState2_GetState_SoapPortLocator();
			WSFinanceDataGetState2_GetState_SoapPortSoap_PortType state_port = state_locator.getWSFinanceDataGetState2_GetState_SoapPortSoap(new URL(endpoint2));
			Getstate_responseRecords state_records[] = state_port.getState(new GetStateRequest("1", "2707724049"));
			for (int i = 0; i < state_records.length; i++) {
				Getstate_responseRecords state_record = state_records[i];
				System.out.println("balance = " + state_record.getBalance());
				System.out.println("description = " + state_record.getDescription());
				System.out.println("oldest unpaid date = " + state_record.getOldest_unpaid_date());
				System.out.println("sf_id = " + state_record.getSf_id());
				System.out.println("ssn = " + state_record.getSocial_security());
				System.out.println("type = " + state_record.getType_id());
			}
			
			System.out.println("STARTING MOVEMENTS HANDLING");
			WSFinanceDataGetMovements_GetMovements_SoapPortLocator movement_locator = new WSFinanceDataGetMovements_GetMovements_SoapPortLocator();
			WSFinanceDataGetMovements_GetMovements_SoapPortSoap_PortType movement_port = movement_locator.getWSFinanceDataGetMovements_GetMovements_SoapPortSoap(new URL(endpoint3));
			Getmovements_responseMovements movements[] = movement_port.getMovements(new Getmovements_request(1, "2707724049", "2005-12-01", "2006-03-01", 1));
			for (int i = 0; i < movements.length; i++) {
				Getmovements_responseMovements movement = movements[i];
				System.out.println("balance = " + movement.getBalance());
				System.out.println("description = " + movement.getDescription());
				System.out.println("movement = " + movement.getMovement());
				System.out.println("payment_date = " + movement.getPayment_date());
				System.out.println("publish_date = " + movement.getPublish_date());
				System.out.println("sf_id = " + movement.getSf_id());
				System.out.println("ssn = " + movement.getSocial_security());
				System.out.println("type = " + movement.getType());
				System.out.println("type id = " + movement.getType_id());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

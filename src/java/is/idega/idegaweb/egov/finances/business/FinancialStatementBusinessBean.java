/*
 * $Id: FinancialStatementBusinessBean.java,v 1.3 2006/02/27 13:41:44 palli Exp $
 * Created on Feb 3, 2006
 *
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package is.idega.idegaweb.egov.finances.business;

import is.idega.idegaweb.egov.finances.data.PaymentItem;
import is.idega.idegaweb.egov.finances.data.StatementItem;
import is.idega.idegaweb.egov.finances.wsclient.GetStateRequest;
import is.idega.idegaweb.egov.finances.wsclient.Getstate_responseRecords;
import is.idega.idegaweb.egov.finances.wsclient.WSFinanceDataGetState2_GetState_SoapPortLocator;
import is.idega.idegaweb.egov.finances.wsclient.WSFinanceDataGetState2_GetState_SoapPortSoap_PortType;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Vector;

import javax.xml.rpc.ServiceException;

import com.idega.business.IBOServiceBean;
import com.idega.util.IWTimestamp;


public class FinancialStatementBusinessBean extends IBOServiceBean  implements FinancialStatementBusiness{

	protected final static String PAYMENT_ITEMS_ENDPOINT = "http://213.167.155.148/WSFinanceDataGetState2/WSFinanceDataGetState2_GetState_SoapPort.asmx"; 
	
	public Collection getPaymentItems(String communeNumber, String personalId, String endpoint) {
		Collection c = new Vector();
		
		if (endpoint == null) {
			endpoint = PAYMENT_ITEMS_ENDPOINT;
		}
		
		try {
		WSFinanceDataGetState2_GetState_SoapPortLocator state_locator = new WSFinanceDataGetState2_GetState_SoapPortLocator();
		WSFinanceDataGetState2_GetState_SoapPortSoap_PortType state_port = state_locator.getWSFinanceDataGetState2_GetState_SoapPortSoap(new URL(endpoint));
		Getstate_responseRecords state_records[] = state_port.getState(new GetStateRequest(communeNumber, personalId));
		for (int i = 0; i < state_records.length; i++) {
			Getstate_responseRecords state_record = state_records[i];
			System.out.println("balance = " + state_record.getBalance());
			System.out.println("description = " + state_record.getDescription());
			System.out.println("oldest unpaid date = " + state_record.getOldest_unpaid_date());
			System.out.println("sf_id = " + state_record.getSf_id());
			System.out.println("ssn = " + state_record.getSocial_security());
			System.out.println("type = " + state_record.getType_id());
		}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		
		PaymentItem p1 = new PaymentItem();
		p1.setName("Fasteignagjöld");
		p1.setAmount(45346);
		p1.setLastDate( new IWTimestamp() );

		PaymentItem p2 = new PaymentItem();
		p2.setName("Leikskólagjöld");
		p2.setAmount(12234);
		p2.setLastDate( new IWTimestamp(23, 11, 1977) );
		
		PaymentItem p3 = new PaymentItem();
		p3.setName("Tónlistarskóli");
		p3.setAmount(54000);
		p3.setLastDate( new IWTimestamp() );
		
		PaymentItem p4 = new PaymentItem();
		p4.setName("Hundaleyfisgjald");
		p4.setAmount(8000);
		p4.setLastDate( new IWTimestamp() );

		c.add(p1);
		c.add(p2);
		c.add(p3);
		c.add(p4);
		
		return c;
	}
	
	public Collection getStatementItems(String communeNumber, String personalId, PaymentItem pType, IWTimestamp fromStamp, IWTimestamp toStamp, String endpoint) {
		Collection c = new Vector();
		
		StatementItem s1 = new StatementItem();
		s1.setName("Upphafsstaða");
		s1.setAmount(0);
		s1.setLastDate( new IWTimestamp() );

		StatementItem s2 = new StatementItem();
		s2.setName("Fasteignagjöld");
		s2.setAmount(22500);
		s2.setLastDate( new IWTimestamp(23, 11, 77) );
		
		StatementItem s3 = new StatementItem();
		s3.setName("Dráttarvextir");
		s3.setAmount(178);
		s3.setLastDate( new IWTimestamp() );
		
		StatementItem s4 = new StatementItem();
		s4.setName("Fasteignagjöld");
		s4.setAmount(22500);
		s4.setLastDate( new IWTimestamp() );
		
		c.add(s1);
		c.add(s2);
		c.add(s3);
		c.add(s4);
		
		return c;
	}

	public String getHomeCommuneNumber() {
		
		
		return "1";
	}
}
/*
 * $Id: FinancialStatementBusinessBean.java,v 1.10 2006/03/09 12:07:50 palli Exp $
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
import is.idega.idegaweb.egov.finances.wsclient.Getmovements_request;
import is.idega.idegaweb.egov.finances.wsclient.Getmovements_responseMovements;
import is.idega.idegaweb.egov.finances.wsclient.Getstate_responseRecords;
import is.idega.idegaweb.egov.finances.wsclient.WSFinanceDataGetMovements_GetMovements_SoapPortLocator;
import is.idega.idegaweb.egov.finances.wsclient.WSFinanceDataGetMovements_GetMovements_SoapPortSoap_PortType;
import is.idega.idegaweb.egov.finances.wsclient.WSFinanceDataGetState2_GetState_SoapPortLocator;
import is.idega.idegaweb.egov.finances.wsclient.WSFinanceDataGetState2_GetState_SoapPortSoap_PortType;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Vector;

import javax.ejb.FinderException;
import javax.xml.rpc.ServiceException;

import com.idega.business.IBOLookupException;
import com.idega.business.IBOServiceBean;
import com.idega.core.location.business.CommuneBusiness;
import com.idega.core.location.data.Commune;
import com.idega.data.IDOLookupException;
import com.idega.util.IWTimestamp;

public class FinancialStatementBusinessBean extends IBOServiceBean implements
		FinancialStatementBusiness {

	protected final static String PAYMENT_ITEMS_ENDPOINT = "http://10.30.11.55/WSFinanceDataGetState2/WSFinanceDataGetState2_GetState_SoapPort.asmx";

	protected final static String MOVEMENTS_ITEMS_ENDPOINT = "http://10.30.11.55/WSFinanceDataGetMovements/WSFinanceDataGetMovements_GetMovements_SoapPort.asmx";

	public Collection getPaymentItems(String communeNumber, String personalId,
			String endpoint) {
		Collection c = new Vector();

		if (endpoint == null) {
			endpoint = PAYMENT_ITEMS_ENDPOINT;
		}

		try {
			WSFinanceDataGetState2_GetState_SoapPortLocator state_locator = new WSFinanceDataGetState2_GetState_SoapPortLocator();
			WSFinanceDataGetState2_GetState_SoapPortSoap_PortType state_port = state_locator
					.getWSFinanceDataGetState2_GetState_SoapPortSoap(new URL(
							endpoint));
			Getstate_responseRecords state_records[] = state_port
					.getState(new GetStateRequest(communeNumber, personalId));
			for (int i = 0; i < state_records.length; i++) {
				Getstate_responseRecords state_record = state_records[i];

				PaymentItem p = new PaymentItem();
				p.setAmount(state_record.getBalance().doubleValue());
				p.setName(state_record.getDescription());
				String dateString = state_record.getOldest_unpaid_date();
				dateString = dateString.replace('T', ' ');
				p.setLastDate(new IWTimestamp(dateString));
				p.setEntryTypeId(Integer.parseInt(state_record.getType_id()));

				c.add(p);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return c;
	}

	public Collection getStatementItems(String communeNumber,
			String personalId, PaymentItem pType, IWTimestamp fromStamp,
			IWTimestamp toStamp, String endpoint) {
		Collection c = new Vector();

		if (endpoint == null) {
			endpoint = MOVEMENTS_ITEMS_ENDPOINT;
		}

		try {
			WSFinanceDataGetMovements_GetMovements_SoapPortLocator movement_locator = new WSFinanceDataGetMovements_GetMovements_SoapPortLocator();
			WSFinanceDataGetMovements_GetMovements_SoapPortSoap_PortType movement_port = movement_locator
					.getWSFinanceDataGetMovements_GetMovements_SoapPortSoap(new URL(
							endpoint));
			Getmovements_responseMovements movements[] = movement_port
					.getMovements(new Getmovements_request(Integer.parseInt(communeNumber), personalId,
							fromStamp.getDateString("yyyy-MM-dd"), toStamp.getDateString("yyyy-MM-dd"), pType.getEntryTypeId()));
			for (int i = 0; i < movements.length; i++) {
				Getmovements_responseMovements movement = movements[i];
				
				StatementItem s = new StatementItem();
				s.setName(movement.getDescription());
				s.setAmount(movement.getMovement().doubleValue());
				s.setBalance(movement.getBalance().doubleValue());
				String dateString = movement.getPayment_date();
				dateString = dateString.replace('T', ' ');
				s.setLastDate(new IWTimestamp(dateString));

				c.add(s);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return c;
	}

	public String getHomeCommuneNumber() {

		String communeNumber = "1";
		try {
			Commune defaultCommune = getCommuneBusiness().getCommuneHome().findDefaultCommune();
			communeNumber = defaultCommune.getCommuneCode();
		} catch (IDOLookupException e) {
			e.printStackTrace();
		} catch (IBOLookupException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (FinderException e) {
			e.printStackTrace();
		}
		
		return communeNumber;
	}
	
	protected CommuneBusiness getCommuneBusiness() throws IBOLookupException {
		return (CommuneBusiness) getServiceInstance(CommuneBusiness.class);
	}

}
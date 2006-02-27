/**
 * 
 */
package is.idega.idegaweb.egov.finances.business;

import is.idega.idegaweb.egov.finances.data.PaymentItem;

import java.util.Collection;


import com.idega.business.IBOService;
import com.idega.util.IWTimestamp;

/**
 * @author bluebottle
 *
 */
public interface FinancialStatementBusiness extends IBOService {
	/**
	 * @see is.idega.idegaweb.egov.finances.business.FinancialStatementBusinessBean#getPaymentItems
	 */
	public Collection getPaymentItems(String communeNumber, String personalId,
			String endpoint) throws java.rmi.RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.finances.business.FinancialStatementBusinessBean#getStatementItems
	 */
	public Collection getStatementItems(String communeNumber,
			String personalId, PaymentItem pType, IWTimestamp fromStamp,
			IWTimestamp toStamp, String endpoint)
			throws java.rmi.RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.finances.business.FinancialStatementBusinessBean#getHomeCommuneNumber
	 */
	public String getHomeCommuneNumber() throws java.rmi.RemoteException;

}

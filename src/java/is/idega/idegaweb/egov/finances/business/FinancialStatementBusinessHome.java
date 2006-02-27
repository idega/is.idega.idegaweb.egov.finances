/**
 * 
 */
package is.idega.idegaweb.egov.finances.business;



import com.idega.business.IBOHome;

/**
 * @author bluebottle
 *
 */
public interface FinancialStatementBusinessHome extends IBOHome {
	public FinancialStatementBusiness create()
			throws javax.ejb.CreateException, java.rmi.RemoteException;

}

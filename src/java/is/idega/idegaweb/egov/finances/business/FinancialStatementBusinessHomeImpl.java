/**
 * 
 */
package is.idega.idegaweb.egov.finances.business;



import com.idega.business.IBOHomeImpl;

/**
 * @author bluebottle
 *
 */
public class FinancialStatementBusinessHomeImpl extends IBOHomeImpl implements
		FinancialStatementBusinessHome {
	protected Class getBeanInterfaceClass() {
		return FinancialStatementBusiness.class;
	}

	public FinancialStatementBusiness create() throws javax.ejb.CreateException {
		return (FinancialStatementBusiness) super.createIBO();
	}

}

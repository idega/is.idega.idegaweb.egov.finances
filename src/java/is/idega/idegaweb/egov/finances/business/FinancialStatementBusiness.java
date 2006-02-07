/*
 * $Id: FinancialStatementBusiness.java,v 1.1 2006/02/07 10:52:42 gimmi Exp $
 * Created on Feb 3, 2006
 *
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package is.idega.idegaweb.egov.finances.business;

import is.idega.idegaweb.egov.finances.data.PaymentItem;
import java.util.Collection;
import com.idega.business.IBOService;
import com.idega.util.IWTimestamp;


/**
 * <p>
 * TODO gimmi Describe Type FinancialStatementBusiness
 * </p>
 *  Last modified: $Date: 2006/02/07 10:52:42 $ by $Author: gimmi $
 * 
 * @author <a href="mailto:gimmi@idega.com">gimmi</a>
 * @version $Revision: 1.1 $
 */
public interface FinancialStatementBusiness extends IBOService {

	/**
	 * @see is.idega.idegaweb.egov.finances.business.FinancialStatementBusinessBean#getPaymentItems
	 */
	public Collection getPaymentItems(String kt) throws java.rmi.RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.finances.business.FinancialStatementBusinessBean#getStatementItems
	 */
	public Collection getStatementItems(String kt, PaymentItem pType, IWTimestamp fromStamp, IWTimestamp toStamp)
			throws java.rmi.RemoteException;
}

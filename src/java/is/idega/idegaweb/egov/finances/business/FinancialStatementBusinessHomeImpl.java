/*
 * $Id: FinancialStatementBusinessHomeImpl.java,v 1.1 2006/02/07 10:52:42 gimmi Exp $
 * Created on Feb 3, 2006
 *
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package is.idega.idegaweb.egov.finances.business;

import com.idega.business.IBOHomeImpl;


/**
 * <p>
 * TODO gimmi Describe Type FinancialStatementBusinessHomeImpl
 * </p>
 *  Last modified: $Date: 2006/02/07 10:52:42 $ by $Author: gimmi $
 * 
 * @author <a href="mailto:gimmi@idega.com">gimmi</a>
 * @version $Revision: 1.1 $
 */
public class FinancialStatementBusinessHomeImpl extends IBOHomeImpl implements FinancialStatementBusinessHome {

	protected Class getBeanInterfaceClass() {
		return FinancialStatementBusiness.class;
	}

	public FinancialStatementBusiness create() throws javax.ejb.CreateException {
		return (FinancialStatementBusiness) super.createIBO();
	}
}

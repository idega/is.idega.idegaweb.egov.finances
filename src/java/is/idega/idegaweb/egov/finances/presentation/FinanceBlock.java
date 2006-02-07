/*
 * $Id: FinanceBlock.java,v 1.1 2006/02/07 10:52:42 gimmi Exp $
 * Created on Feb 3, 2006
 *
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package is.idega.idegaweb.egov.finances.presentation;

import java.rmi.RemoteException;
import com.idega.idegaweb.IWResourceBundle;
import com.idega.presentation.Block;
import com.idega.presentation.IWContext;


public abstract class FinanceBlock extends Block {
	
	protected IWResourceBundle iwrb = null;
	public static final String FINANCE_BLOCK_BUNDLE_IDENTIFIER = "is.idega.idegaweb.egov.finances";
	
	public String getBundleIdentifier() {
		return FinanceBlock.FINANCE_BLOCK_BUNDLE_IDENTIFIER;
	}
	
	public void main(IWContext iwc) throws RemoteException {
		iwrb = getResourceBundle(iwc);
		present(iwc);
	}
	
	protected abstract void present(IWContext iwc) throws RemoteException;
}

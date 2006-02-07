/*
 * $Id: FinancialStatementBusinessBean.java,v 1.1 2006/02/07 10:52:42 gimmi Exp $
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
import java.util.Collection;
import java.util.Vector;
import com.idega.business.IBOServiceBean;
import com.idega.util.IWTimestamp;


public class FinancialStatementBusinessBean extends IBOServiceBean  implements FinancialStatementBusiness{

	public Collection getPaymentItems(String kt) {
		Collection c = new Vector();
		
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
	
	public Collection getStatementItems(String kt, PaymentItem pType, IWTimestamp fromStamp, IWTimestamp toStamp) {
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

}

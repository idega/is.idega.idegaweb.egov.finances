/*
 * $Id: PaymentItem.java,v 1.3 2006/04/09 12:00:08 laddi Exp $
 * Created on Feb 3, 2006
 *
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package is.idega.idegaweb.egov.finances.data;

import com.idega.util.IWTimestamp;

public class PaymentItem {

	private String name;

	private double amount;

	private IWTimestamp lastDate;

	private int entryTypeId;

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public IWTimestamp getLastDate() {
		return this.lastDate;
	}

	public void setLastDate(IWTimestamp lastDate) {
		this.lastDate = lastDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEntryTypeId() {
		return this.entryTypeId;
	}

	public void setEntryTypeId(int entryTypeId) {
		this.entryTypeId = entryTypeId;
	}

}

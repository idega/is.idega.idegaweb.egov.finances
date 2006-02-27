/*
 * $Id: PaymentItem.java,v 1.2 2006/02/27 14:03:13 palli Exp $
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
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public IWTimestamp getLastDate() {
		return lastDate;
	}

	public void setLastDate(IWTimestamp lastDate) {
		this.lastDate = lastDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEntryTypeId() {
		return entryTypeId;
	}

	public void setEntryTypeId(int entryTypeId) {
		this.entryTypeId = entryTypeId;
	}

}

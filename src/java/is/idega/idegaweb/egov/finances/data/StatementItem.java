/*
 * $Id: StatementItem.java,v 1.3 2006/03/09 12:07:50 palli Exp $
 * Created on Feb 3, 2006
 *
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package is.idega.idegaweb.egov.finances.data;

import com.idega.util.IWTimestamp;

public class StatementItem {

	private String name;

	private double amount;
	
	private double balance;

	private IWTimestamp lastDate;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
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

}

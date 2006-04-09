/*
 * $Id: FinancialStatement.java,v 1.12 2006/04/09 12:00:08 laddi Exp $
 * Created on Feb 3, 2006
 *
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package is.idega.idegaweb.egov.finances.presentation;

import is.idega.idegaweb.egov.finances.business.FinancialStatementBusiness;
import is.idega.idegaweb.egov.finances.data.PaymentItem;

import java.rmi.RemoteException;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Iterator;

import com.idega.business.IBOLookup;
import com.idega.business.IBOLookupException;
import com.idega.business.IBORuntimeException;
import com.idega.core.builder.data.ICPage;
import com.idega.presentation.IWContext;
import com.idega.presentation.Layer;
import com.idega.presentation.Table2;
import com.idega.presentation.TableCell2;
import com.idega.presentation.TableRow;
import com.idega.presentation.TableRowGroup;
import com.idega.presentation.text.Link;
import com.idega.presentation.text.Text;
import com.idega.util.IWTimestamp;

public class FinancialStatement extends FinanceBlock {

	protected static final String PARAMETER_PAYMENT_ITEM_NAME = "fs_payment_item_name";

	protected static final String PARAMETER_PAYMENT_ITEM_AMOUNT = "fs_payment_item_amount";

	protected static final String PARAMETER_PAYMENT_ITEM_TYPE_ID = "fs_payment_item_type_id";
	
	protected static final String PARAMETER_COMMUNE_ID = "fs_commune_id";
	
	protected static final String PARAMETER_PERSONAL_ID = "fs_personal_id";

	private String fixedPersonalId = null;
	
	private String fixedCommuneNumber = null;
	
	private String tableStyleClass = "caseTable";
	
	private String stateEndPoint = null;
	
	private ICPage page = null;
	
	
	private int iMaxNumberOfEntries = -1;

	protected void present(IWContext iwc) throws RemoteException {
		if (this.fixedPersonalId == null) {
			this.fixedPersonalId = iwc.getCurrentUser().getPersonalID();
		}
		
		if (this.fixedCommuneNumber == null) {
			this.fixedCommuneNumber = getBusiness(iwc).getHomeCommuneNumber();
		}
		
		add(getStatement(this.fixedCommuneNumber, this.fixedPersonalId, iwc));
	}

	private Layer getStatement(String communeNumber, String personalId, IWContext iwc) throws RemoteException {
		Layer layer = new Layer(Layer.DIV);
		layer.setStyleClass("caseElement");
		layer.setID("financialStatement");
		
		Layer headerLayer = new Layer(Layer.DIV);
		headerLayer.setStyleClass("caseHeader");
		layer.add(headerLayer);
		
		Layer headingLayer = new Layer(Layer.DIV);
		headingLayer.setStyleClass("caseHeading");
		headingLayer.add(new Text(this.iwrb.getLocalizedString("financial_statement", "Financial statement")));
		headerLayer.add(headingLayer);
		
		Table2 table = new Table2();
		table.setCellpadding(0);
		table.setCellspacing(0);
		table.setWidth("100%");
		table.setStyleClass(this.tableStyleClass);
		table.setStyleClass("ruler");
		layer.add(table);
		
		TableRowGroup group = table.createHeaderRowGroup();
		TableRow row = group.createRow();
		row.setStyleClass("header");
		
		TableCell2 cell = row.createHeaderCell();
		cell.setStyleClass("paymentType");
		cell.setStyleClass("firstColumn");
		cell.add(new Text(this.iwrb.getLocalizedString("payment_type",
				"Payment type")));

		cell = row.createHeaderCell();
		cell.setStyleClass("balance");
		cell.add(new Text(this.iwrb.getLocalizedString("balance", "Balance") + " (" + IWTimestamp.RightNow().getDateString("dd.MM.yy") + ")"));

		cell = row.createHeaderCell();
		cell.setStyleClass("firstDueDate");
		cell.setStyleClass("lastColumn");
		cell.add(new Text(this.iwrb.getLocalizedString("first_due_date",
				"First due date")));

		group = table.createBodyRowGroup();

		boolean odd = true;
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(iwc.getCurrentLocale());
		currencyFormat.setGroupingUsed(true);
		currencyFormat.setMaximumFractionDigits(0);
		currencyFormat.setMinimumFractionDigits(0);

		Collection coll = getBusiness(iwc).getPaymentItems(communeNumber, personalId, this.stateEndPoint);
		Iterator iter = coll.iterator();
		int iRow = 1;
		while (iter.hasNext()) {
			PaymentItem p = (PaymentItem) iter.next();
			row = group.createRow();
			if (iRow == 1) {
				row.setStyleClass("firstRow");
			}
			if (odd) {
				row.setStyleClass("oddRow");
			} else {
				row.setStyleClass("evenRow");
			}
			odd = !odd;

			Link link = new Link(new Text(p.getName()));
			link.addParameter(PARAMETER_PAYMENT_ITEM_TYPE_ID, p.getEntryTypeId());
			link.addParameter(PARAMETER_COMMUNE_ID, communeNumber);
			link.addParameter(PARAMETER_PERSONAL_ID, personalId);
			link.addParameter(PARAMETER_PAYMENT_ITEM_NAME, p.getName());
			link.addParameter(PARAMETER_PAYMENT_ITEM_AMOUNT, Double.toString(p.getAmount()));
			if (this.page != null) {
				link.setPage(this.page);
			}
			
			cell = row.createCell();
			cell.setStyleClass("paymentType");
			cell.setStyleClass("firstColumn");
			cell.add(link);

			cell = row.createCell();
			cell.setStyleClass("balance");
			cell.add(new Text(currencyFormat.format(p.getAmount())));

			cell = row.createCell();
			cell.setStyleClass("firstDueDate");
			cell.add(new Text(p.getLastDate().getLocaleDate(
					iwc.getCurrentLocale(), IWTimestamp.SHORT)));

			
			if (this.iMaxNumberOfEntries != -1 && iRow == this.iMaxNumberOfEntries) {
				row.setStyleClass("lastRow");
				break;
			}
			
			if (!iter.hasNext()) {
				row.setStyleClass("lastRow");
			}
			iRow++;
		}

		return layer;
	}

	protected FinancialStatementBusiness getBusiness(IWContext iwc) {
		try {
			return (FinancialStatementBusiness) IBOLookup.getServiceInstance(
					iwc, FinancialStatementBusiness.class);
		} catch (IBOLookupException e) {
			throw new IBORuntimeException(e);
		}
	}

	public void setCommuneNumber(String communeNumber) {
		this.fixedCommuneNumber = communeNumber;
	}
	
	public void setPersonalId(String personalId) {
		this.fixedPersonalId = personalId;
	}
	
	public void setTableStyleClass(String tableStyleClass) {
		this.tableStyleClass = tableStyleClass;
	}
	
	public void setStateEndPoint(String endPoint) {
		this.stateEndPoint = endPoint;
	}
	
	public void setMaximumNumberOfEntries(int maxNumberOfEntries) {
		this.iMaxNumberOfEntries = maxNumberOfEntries;
	}
	
	public void setResponsePage(ICPage page) {
		this.page = page;
	}
}
/*
 * $Id: FinancialStatement.java,v 1.4 2006/02/27 15:02:35 palli Exp $
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
import is.idega.idegaweb.egov.finances.data.StatementItem;

import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Iterator;

import com.idega.business.IBOLookup;
import com.idega.business.IBOLookupException;
import com.idega.business.IBORuntimeException;
import com.idega.presentation.IWContext;
import com.idega.presentation.Layer;
import com.idega.presentation.Table2;
import com.idega.presentation.TableCell2;
import com.idega.presentation.TableRow;
import com.idega.presentation.TableRowGroup;
import com.idega.presentation.text.Link;
import com.idega.presentation.text.Text;
import com.idega.presentation.ui.BackButton;
import com.idega.presentation.ui.DateInput;
import com.idega.presentation.ui.Form;
import com.idega.presentation.ui.SubmitButton;
import com.idega.util.IWTimestamp;

public class FinancialStatement extends FinanceBlock {

	private static String PARAMETER_PAYMENT_ITEM = "paym_id";

	private static String PARAMETER_FROM_DATE = "fromDate";

	private static String PARAMETER_TO_DATE = "toDate";
	
	private String fixedPersonalId = null;
	
	private String fixedCommuneNumber = null;
	
	private String tableStyleClass = "CaseTable";
	
	private String stateEndPoint = null;
	
	private String movementsEndPoint = null;

	protected void present(IWContext iwc) throws RemoteException {
		if (fixedPersonalId == null) {
			fixedPersonalId = iwc.getCurrentUser().getPersonalID();
		}
		
		if (fixedCommuneNumber == null) {
			fixedCommuneNumber = getBusiness(iwc).getHomeCommuneNumber();
		}
		
		add(getStatement(fixedCommuneNumber, fixedPersonalId, iwc));
	}

	private Layer getStatement(String communeNumber, String personalId, IWContext iwc) throws RemoteException {
		Layer layer = new Layer(Layer.DIV);
		Form form = new Form();
		form.setId("financial_statement");
		layer.add(form);

		Table2 table = new Table2();
		table.setCellpadding(0);
		table.setCellspacing(0);
		table.setWidth("100%");
		table.setStyleClass(tableStyleClass);
		table.setStyleClass("ruler");
		form.add(table);
		TableRowGroup group = table.createHeaderRowGroup();
		TableRow row = group.createRow();
		row.setStyleClass("header");
		TableCell2 cell = row.createHeaderCell();
		cell.setStyleClass("paymentType");
		cell.setStyleClass("firstColumn");
		cell.add(new Text(iwrb.getLocalizedString("payment_type",
				"Payment type")));

		cell = row.createHeaderCell();
		cell.setStyleClass("amount");
		cell.add(new Text(iwrb.getLocalizedString("amount", "Amount")));

		cell = row.createHeaderCell();
		cell.setStyleClass("firstDueDate");
		cell.setStyleClass("lastColumn");
		cell.add(new Text(iwrb.getLocalizedString("first_due_date",
				"First due date")));

		group = table.createBodyRowGroup();

		boolean odd = true;
		String selected = iwc.getParameter(PARAMETER_PAYMENT_ITEM);

		Collection coll = getBusiness(iwc).getPaymentItems(communeNumber, personalId, stateEndPoint);
		Iterator iter = coll.iterator();
		while (iter.hasNext()) {
			PaymentItem p = (PaymentItem) iter.next();
			row = group.createRow();
			if (odd) {
				row.setStyleClass("oddRow");
			} else {
				row.setStyleClass("evenRow");
			}
			odd = !odd;

			Link link = new Link(new Text(p.getName()));
			link.addParameter(PARAMETER_PAYMENT_ITEM, p.getName());
			cell = row.createCell();
			cell.setStyleClass("paymentType");
			cell.setStyleClass("firstColumn");
			cell.add(link);

			cell = row.createCell();
			cell.setStyleClass("amount");
			cell.add(new Text(Double.toString(p.getAmount())));

			cell = row.createCell();
			cell.setStyleClass("firstDueDate");
			cell.add(new Text(p.getLastDate().getLocaleDate(
					iwc.getCurrentLocale())));

			if (selected != null && selected.equals(p.getName())) {
				cell.setStyleClass("selected");
				IWTimestamp fromStamp = new IWTimestamp();
				IWTimestamp toStamp = new IWTimestamp();
				String from = iwc.getParameter(PARAMETER_FROM_DATE);
				String to = iwc.getParameter(PARAMETER_TO_DATE);
				if (from != null) {
					fromStamp = new IWTimestamp(from);
				}
				if (to != null) {
					toStamp = new IWTimestamp(to);
				} else {
					toStamp.addDays(14);
				}

				Collection items = getBusiness(iwc).getStatementItems(communeNumber, personalId,
						p, fromStamp, toStamp, movementsEndPoint);
				Iterator iIter = items.iterator();

				row = group.createRow();
				if (odd) {
					row.setStyleClass("oddRow");
				} else {
					row.setStyleClass("evenRow");
				}
				odd = !odd;
				cell = row.createCell();
				cell.setColumnSpan(3);

				Layer l = new Layer(Layer.DIV);
				l.setStyleClass("dateForm");
				cell.add(l);
				// FORM part
				DateInput inp = new DateInput(PARAMETER_FROM_DATE, true);
				inp.setDate(fromStamp.getDate());
				DateInput toInp = new DateInput(PARAMETER_TO_DATE, true);
				toInp.setDate(toStamp.getDate());

				l.add(new BackButton(iwrb.getLocalizedString("back", "Back")));
				l.add(new Text(p.getName()));
				l.add(new Text(iwrb.getLocalizedString("date", "Date") + "."));
				l.add(new Text(iwrb.getLocalizedString("from", "From")));
				l.add(inp);
				l.add(new Text(iwrb.getLocalizedString("to", "To")));
				l.add(toInp);
				l.add(new SubmitButton(iwrb.getLocalizedString("get", "Get"),
						PARAMETER_PAYMENT_ITEM, p.getName()));
				// formpart

				double sum = 0;
				row = group.createRow();
				if (odd) {
					row.setStyleClass("oddRow");
				} else {
					row.setStyleClass("evenRow");
				}
				odd = !odd;
				cell = row.createCell();
				cell.setStyleClass("description");
				cell.setStyleClass("firstColumn");
				cell.setStyleClass("statementHeader");
				cell.add(new Text(iwrb.getLocalizedString("description",
						"Description")));
				cell = row.createCell();
				cell.setStyleClass("statementHeader");
				cell.setStyleClass("amount");
				cell.add(new Text(iwrb.getLocalizedString("amount", "Amount")));
				cell = row.createCell();
				cell.setStyleClass("statementHeader");
				cell.setStyleClass("dueDate");
				cell.setStyleClass("lastColumn");
				cell.add(new Text(iwrb.getLocalizedString("due_date",
						"Due date")));

				DecimalFormat format = new DecimalFormat("#,###.##");
				
				while (iIter.hasNext()) {
					StatementItem s = (StatementItem) iIter.next();
					row = group.createRow();
					if (odd) {
						row.setStyleClass("oddRow");
					} else {
						row.setStyleClass("evenRow");
					}
					odd = !odd;
					cell = row.createCell();
					cell.setStyleClass("description");
					cell.setStyleClass("firstColumn");
					cell.setStyleClass("statement");
					cell.add(new Text(s.getName()));
					cell = row.createCell();
					cell.setStyleClass("statement");
					cell.setStyleClass("amount");
					
					if (s.getAmount() == 0.0d) {
						cell.add(new Text("-"));
					} else {
						cell.add(new Text(format.format(s.getAmount()) + ".-"));
					}
					cell = row.createCell();
					cell.setStyleClass("statement");
					cell.setStyleClass("dueDate");
					cell.setStyleClass("lastColumn");
					cell.add(new Text(s.getLastDate().getLocaleDate(
							iwc.getCurrentLocale())));
					sum += s.getAmount();
				}
				row = group.createRow();
				if (odd) {
					row.setStyleClass("oddRow");
				} else {
					row.setStyleClass("evenRow");
				}
				odd = !odd;
				cell = row.createCell();
				row.setStyleClass("total");
				cell.setStyleClass("firstColumn");
				cell.setStyleClass("statement");
				cell.add(new Text(iwrb.getLocalizedString("total", "Total")));
				cell = row.createCell();
				cell.setStyleClass("statement");
				cell.setStyleClass("amount");
				cell.setStyleClass("lastColumn");
				cell.add(new Text(format.format(sum)));
				cell = row.createCell();

				row = group.createRow();
				if (odd) {
					row.setStyleClass("oddRow");
				} else {
					row.setStyleClass("evenRow");
				}
				odd = !odd;
			}
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
	
	public void setMovementEndPoint(String endPoint) {
		this.movementsEndPoint = endPoint;
	}
}
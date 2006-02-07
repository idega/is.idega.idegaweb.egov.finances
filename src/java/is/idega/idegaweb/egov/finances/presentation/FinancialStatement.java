/*
 * $Id: FinancialStatement.java,v 1.1 2006/02/07 10:52:42 gimmi Exp $
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
	
	protected void present(IWContext iwc) throws RemoteException {
		add(getStatement(iwc));
	}
	
	private Layer getStatement(IWContext iwc) throws RemoteException {
		Layer layer = new Layer(Layer.DIV);
		Form form = new Form();
		form.setId("financial_statement");
		layer.add(form);
		
		Table2 table = new Table2();
		table.setCellpadding(3);
		table.setCellspacing(0);
		form.add(table);
		TableRowGroup group = table.createHeaderRowGroup();
		TableRow row = group.createRow();
		row.setStyleClass("header");
		TableCell2 cell = row.createCell();
		cell.setStyleClass("payment_type");
		cell.add(new Text(iwrb.getLocalizedString("payment_type", "Payment type")));
		
		cell = row.createCell();
		cell.setStyleClass("amount");
		cell.add(new Text(iwrb.getLocalizedString("amount", "Amount")));
		
		cell = row.createCell();
		cell.setStyleClass("first_due_date");
		cell.add(new Text(iwrb.getLocalizedString("first_due_date", "First due date")));
		
		group = table.createBodyRowGroup();
		
		boolean odd = true;
		String selected = iwc.getParameter(PARAMETER_PAYMENT_ITEM);
		
		Collection coll = getBusiness(iwc).getPaymentItems("tempKT");
		Iterator iter = coll.iterator();
		while (iter.hasNext()) {
			PaymentItem p = (PaymentItem) iter.next();
			row = group.createRow();
			if (odd) {
				row.setStyleClass("odd");
			} else {
				row.setStyleClass("even");
			}
			odd = !odd;
			
			Link link = new Link(new Text(p.getName()));
			link.addParameter(PARAMETER_PAYMENT_ITEM, p.getName());
			cell = row.createCell();
			cell.setStyleClass("payment_type");
			cell.add(link);
			
			cell = row.createCell();
			cell.setStyleClass("amount");
			cell.add(new Text(Double.toString(p.getAmount())));

			cell = row.createCell();
			cell.setStyleClass("first_due_date");
			cell.add(new Text(p.getLastDate().getLocaleDate(iwc.getCurrentLocale())));
			
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

				
				Collection items = getBusiness(iwc).getStatementItems("tempKR", p, fromStamp, toStamp);
				Iterator iIter = items.iterator();
				
				row = group.createRow();
				if (odd) {
					row.setStyleClass("odd");
				} else {
					row.setStyleClass("even");
				}
				odd = !odd;
				cell = row.createCell();
				cell.setColumnSpan(3);
				
				Layer l = new Layer(Layer.DIV);
				l.setStyleClass("date_form");
				cell.add(l);
				// FORM part
				DateInput inp = new DateInput(PARAMETER_FROM_DATE, true);
				inp.setDate(fromStamp.getDate());
				DateInput toInp = new DateInput(PARAMETER_TO_DATE, true);
				toInp.setDate(toStamp.getDate());
				
				l.add(new BackButton(iwrb.getLocalizedString("back", "Back")));
				l.add(new Text(p.getName()));
				l.add(new Text(iwrb.getLocalizedString("date", "Date")+"."));
				l.add(new Text(iwrb.getLocalizedString("from", "From")));
				l.add(inp);
				l.add(new Text(iwrb.getLocalizedString("to", "To")));
				l.add(toInp);
				l.add(new SubmitButton(iwrb.getLocalizedString("get", "Get"), PARAMETER_PAYMENT_ITEM, p.getName()));
				// formpart
				
				double sum = 0;
				row = group.createRow();
				if (odd) {
					row.setStyleClass("odd");
				} else {
					row.setStyleClass("even");
				}
				odd = !odd;
				cell = row.createCell();
				cell.setStyleClass("description");
				cell.setStyleClass("first_column");
				cell.setStyleClass("statement_header");
				cell.add(new Text(iwrb.getLocalizedString("description", "Description")));
				cell = row.createCell();
				cell.setStyleClass("statement_header");
				cell.setStyleClass("amout");
				cell.add(new Text(iwrb.getLocalizedString("amount", "Amount")));
				cell = row.createCell();
				cell.setStyleClass("statement_header");
				cell.setStyleClass("due_date");
				cell.add(new Text(iwrb.getLocalizedString("due_date", "Due date")));

				while (iIter.hasNext()) {
					StatementItem s = (StatementItem) iIter.next();
					row = group.createRow();
					if (odd) {
						row.setStyleClass("odd");
					} else {
						row.setStyleClass("even");
					}
					odd = !odd;
					cell = row.createCell();
					cell.setStyleClass("description");
					cell.setStyleClass("first_column");
					cell.setStyleClass("statement");
					cell.add(new Text(s.getName()));
					cell = row.createCell();
					cell.setStyleClass("statement");
					cell.setStyleClass("amount");
					cell.add(new Text(Double.toString(s.getAmount())));
					cell = row.createCell();
					cell.setStyleClass("statement");
					cell.setStyleClass("due_date");
					cell.add(new Text(s.getLastDate().getLocaleDate(iwc.getCurrentLocale())));
					sum += s.getAmount();
				}
				row = group.createRow();
				if (odd) {
					row.setStyleClass("odd");
				} else {
					row.setStyleClass("even");
				}
				odd = !odd;
				cell = row.createCell();
				row.setStyleClass("total");
				cell.setStyleClass("first_column");
				cell.setStyleClass("statement");
				cell.add(new Text(iwrb.getLocalizedString("total", "Total")));
				cell = row.createCell();
				cell.setStyleClass("statement");
				cell.setStyleClass("amount");
				cell.add(new Text(Double.toString(sum)));
				cell= row.createCell();

				group.createRow();
				if (odd) {
					row.setStyleClass("odd");
				} else {
					row.setStyleClass("even");
				}
				odd = !odd;

			}
			
		}
		
		return layer;
	}
	
	protected FinancialStatementBusiness getBusiness(IWContext iwc) {
		try {
			return (FinancialStatementBusiness) IBOLookup.getServiceInstance(iwc, FinancialStatementBusiness.class);
		}
		catch (IBOLookupException e) {
			throw new IBORuntimeException(e);
		}
	}
	
}

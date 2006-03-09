package is.idega.idegaweb.egov.finances.presentation;

import is.idega.idegaweb.egov.finances.business.FinancialStatementBusiness;
import is.idega.idegaweb.egov.finances.data.PaymentItem;
import is.idega.idegaweb.egov.finances.data.StatementItem;

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
import com.idega.presentation.text.Text;
import com.idega.presentation.ui.DateInput;
import com.idega.presentation.ui.Form;
import com.idega.presentation.ui.GenericButton;
import com.idega.presentation.ui.Label;
import com.idega.presentation.ui.Parameter;
import com.idega.presentation.ui.SubmitButton;
import com.idega.util.IWTimestamp;

public class FinancialStatementMovements extends FinanceBlock {

	protected static final String PARAMETER_PAYMENT_ITEM_TYPE_ID = FinancialStatement.PARAMETER_PAYMENT_ITEM_TYPE_ID;

	protected static final String PARAMETER_COMMUNE_ID = FinancialStatement.PARAMETER_COMMUNE_ID;

	protected static final String PARAMETER_PERSONAL_ID = FinancialStatement.PARAMETER_PERSONAL_ID;

	protected static final String PARAMETER_PAYMENT_ITEM_NAME = FinancialStatement.PARAMETER_PAYMENT_ITEM_NAME;

	protected static final String PARAMETER_PAYMENT_ITEM_AMOUNT = FinancialStatement.PARAMETER_PAYMENT_ITEM_AMOUNT;

	private static final String PARAMETER_FROM_DATE = "fromDate";

	private static final String PARAMETER_TO_DATE = "toDate";

	private String movementsEndPoint = null;

	private String tableStyleClass = "caseTable";
	
	private ICPage backPage = null;

	protected void present(IWContext iwc) throws RemoteException {
		String paymentItemTypeId = iwc
				.getParameter(PARAMETER_PAYMENT_ITEM_TYPE_ID);
		String communeNumber = iwc.getParameter(PARAMETER_COMMUNE_ID);
		String personalId = iwc.getParameter(PARAMETER_PERSONAL_ID);
		String name = iwc.getParameter(PARAMETER_PAYMENT_ITEM_NAME);
		String amount = iwc.getParameter(PARAMETER_PAYMENT_ITEM_AMOUNT);

		PaymentItem item = new PaymentItem();
		item.setEntryTypeId(Integer.parseInt(paymentItemTypeId));
		item.setName(name);
		item.setAmount(new Double(amount).doubleValue());

		add(getStatementMovements(iwc, communeNumber, personalId, item));
	}

	private Layer getStatementMovements(IWContext iwc, String communeNumber,
			String personalId, PaymentItem item) throws RemoteException {
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(iwc
				.getCurrentLocale());
		currencyFormat.setGroupingUsed(true);
		currencyFormat.setMaximumFractionDigits(0);
		currencyFormat.setMinimumFractionDigits(0);

		
		Layer layer = new Layer(Layer.DIV);
		layer.setStyleClass("caseElement");
		layer.setID("financialStatementMovements");

		Layer headerLayer = new Layer(Layer.DIV);
		headerLayer.setStyleClass("caseHeader");
		layer.add(headerLayer);

		Layer headingLayer = new Layer(Layer.DIV);
		headingLayer.setStyleClass("caseHeading");
		headingLayer.add(new Text(iwrb.getLocalizedString(
				"financial_statement_movements",
				"Financial statement movements")));
		headerLayer.add(headingLayer);

		Layer headingInfoLayer = new Layer(Layer.DIV);
		headingInfoLayer.setStyleClass("caseInfoHeading");
		headingInfoLayer.add(new Text(item.getName()));
		headingInfoLayer.add(" ");
		headingInfoLayer.add(new Text(iwrb.getLocalizedString("balance", "Balance") + " (" + IWTimestamp.RightNow().getDateString("dd.MM.yy") + ") : "));
		headingInfoLayer.add(currencyFormat.format(item.getAmount()));
		headerLayer.add(headingInfoLayer);
		
		IWTimestamp fromStamp = new IWTimestamp();
		IWTimestamp toStamp = new IWTimestamp();
		String from = iwc.getParameter(PARAMETER_FROM_DATE);
		String to = iwc.getParameter(PARAMETER_TO_DATE);
		if (from != null) {
			fromStamp = new IWTimestamp(from);
		} else {
			fromStamp.addYears(-1);
		}
		if (to != null) {
			toStamp = new IWTimestamp(to);
		}

		Form form = new Form();
		layer.add(form);

		Layer section = new Layer(Layer.DIV);
		section.setStyleClass("formSection");
		form.add(section);

		// FORM part
		DateInput inp = new DateInput(PARAMETER_FROM_DATE, true);
		inp.setDate(fromStamp.getDate());
		inp.setStyleClass("dateInput");
		DateInput toInp = new DateInput(PARAMETER_TO_DATE, true);
		toInp.setDate(toStamp.getDate());
		toInp.setStyleClass("dateInput");
		
		Layer formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		Label label = new Label();
		label.add(new Text(iwrb.getLocalizedString("from", "From")));
		formItem.add(label);
		formItem.add(inp);
		section.add(formItem);

		formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		label = new Label();
		label.add(new Text(iwrb.getLocalizedString("to", "To")));
		formItem.add(label);
		formItem.add(toInp);
		section.add(formItem);

		SubmitButton button = new SubmitButton(iwrb.getLocalizedString("get", "Get"));
		button.setStyleClass("indentedButton");
		section.add(button);
		
		Layer clearLayer = new Layer(Layer.DIV);
		clearLayer.setStyleClass("Clear");
		section.add(clearLayer);
		
		form.add(new Parameter(PARAMETER_PAYMENT_ITEM_TYPE_ID, Integer.toString(item.getEntryTypeId())));
		form.add(new Parameter(PARAMETER_COMMUNE_ID, communeNumber));
		form.add(new Parameter(PARAMETER_PERSONAL_ID, personalId));
		form.add(new Parameter(PARAMETER_PAYMENT_ITEM_NAME, item.getName()));
		form.add(new Parameter(PARAMETER_PAYMENT_ITEM_AMOUNT, Double.toString(item.getAmount())));

		Table2 table = new Table2();
		table.setCellpadding(0);
		table.setCellspacing(0);
		table.setWidth("100%");
		table.setStyleClass(tableStyleClass);
		table.setStyleClass("ruler");
		layer.add(table);

		TableRowGroup group = table.createHeaderRowGroup();
		TableRow row = group.createRow();
		row.setStyleClass("header");

		TableCell2 cell = row.createHeaderCell();
		cell.setStyleClass("description");
		cell.setStyleClass("firstColumn");
		cell.add(new Text(iwrb.getLocalizedString("description",
		"Description")));

		cell = row.createHeaderCell();
		cell.setStyleClass("amount");
		cell.add(new Text(iwrb.getLocalizedString("amount", "Amount")));

		cell = row.createHeaderCell();
		cell.setStyleClass("balance");
		cell.add(new Text(iwrb.getLocalizedString("balance", "Balance")));
		
		cell = row.createHeaderCell();
		cell.setStyleClass("dueDate");
		cell.setStyleClass("lastColumn");
		cell.add(new Text(iwrb.getLocalizedString("due_date", "Due date")));

		group = table.createBodyRowGroup();

		boolean odd = true;

		Collection items = getBusiness(iwc).getStatementItems(communeNumber,
				personalId, item, fromStamp, toStamp, movementsEndPoint);
		Iterator iIter = items.iterator();

		double sum = 0.0d;
		double sumBalance = 0.0d;
		
		while (iIter.hasNext()) {
			StatementItem s = (StatementItem) iIter.next();
			row = group.createRow();
			if (!iIter.hasNext()) {
				row.setStyleClass("lastRow");
			}
			if (odd) {
				row.setStyleClass("oddRow");
			}
			else {
				row.setStyleClass("evenRow");
			}
			odd = !odd;
			
			cell = row.createCell();
			cell.setStyleClass("description");
			cell.setStyleClass("firstColumn");
			cell.add(new Text(s.getName()));

			cell = row.createCell();
			cell.setStyleClass("amount");
			cell.add(new Text(currencyFormat.format(s.getAmount())));
			
			cell = row.createCell();
			cell.setStyleClass("balance");
			cell.add(new Text(currencyFormat.format(s.getBalance())));
			
			cell = row.createCell();
			cell.setStyleClass("dueDate");
			cell.setStyleClass("lastColumn");
			cell.add(new Text(s.getLastDate().getLocaleDate(
					iwc.getCurrentLocale(), IWTimestamp.SHORT)));
			sum += s.getAmount();
			sumBalance += s.getBalance();
		}
		
		group = table.createFooterRowGroup();
		
		row = group.createRow();
		cell = row.createCell();
		row.setStyleClass("total");
		cell.setStyleClass("firstColumn");
		cell.add(new Text(iwrb.getLocalizedString("total", "Total")));
		cell = row.createCell();
		cell.setStyleClass("amount");
		cell.add(new Text(currencyFormat.format(sum)));
		cell = row.createCell();
		cell.setStyleClass("balance");
		cell.setStyleClass("lastColumn");
		cell.add(new Text(currencyFormat.format(sumBalance)));

		Layer buttonLayer = new Layer(Layer.DIV);
		buttonLayer.setStyleClass("buttonLayer");
		layer.add(buttonLayer);
		
		GenericButton backLink = new GenericButton("back", iwrb.getLocalizedString("back", "Back"));
		if (backPage != null) {
			backLink.setPageToOpen(backPage);
		}
		buttonLayer.add(backLink);
		
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

	public void setMovementEndPoint(String endPoint) {
		this.movementsEndPoint = endPoint;
	}
	
	public void setBackPage(ICPage page) {
		backPage = page;
	}
}
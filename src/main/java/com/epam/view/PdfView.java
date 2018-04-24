package com.epam.view;

import com.epam.spring.hometask.domain.Ticket;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class PdfView extends AbstractPdfView{

    public PdfView() {
    }

    @Override
	protected void buildPdfDocument(Map model, Document document,
		PdfWriter writer, HttpServletRequest request,
		HttpServletResponse response) throws Exception {

		List<Ticket> tickets = (List<Ticket>) model.get("tickets");

		Table table = new Table(2);
		table.addCell("Movie");
		table.addCell("User");

		for (Ticket ticket: tickets) {
			if (ticket.getEventId()!=null){
				table.addCell(ticket.getEventId().toString());
			}
			if (ticket.getUserId() != null) {
				table.addCell(ticket.getUserId().toString());
			}
		}
		document.add(table);
	}
}
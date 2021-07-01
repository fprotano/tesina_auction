package it.exolab.tesina.auction.util;

import java.io.ByteArrayOutputStream;
import java.util.stream.Stream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.Barcode128.Barcode128CodeSet;
import com.itextpdf.text.pdf.draw.LineSeparator;

import it.exolab.tesina.auction.model.AuctionOrder;
import it.exolab.tesina.auction.model.Invoice;
import it.exolab.tesina.auction.model.User;
import it.exolab.tesina.auction.model.UserItem;

public class InvoicePdfMaker extends UtilData {
	
	Invoice invoice = new Invoice();
	User user = new User();
	UserItem userItem = new UserItem();
	AuctionOrder auctionOrder = new AuctionOrder();
	// crea oggetto 'documento' vuoto
	
	public byte[] pdfMaker() {
		
		Document document = new Document();
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 16, BaseColor.BLACK);
		PdfPTable table = new PdfPTable(4);
		LineSeparator line = new LineSeparator();
		
		addTableHeader(table);
		addRows(table, invoice, userItem, auctionOrder);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {
			
			// crea un file di tipo pdf
			// PdfWriter.getInstance(document, new FileOutputStream("pdfDiProva.pdf"));
			
			PdfWriter.getInstance(document, baos);
			document.open();
			// il 'chunk' e' l'elemento piu' piccolo che si puo aggiungere
//			Chunk chunk = new Chunk("riga di prova", font);
			document.add(new Paragraph(RAGIONE__SOCIALE));
			document.add(new Paragraph(INDIRIZZO1));
			document.add(new Paragraph(INDIRIZZO2));
//			document.add(Chunk.NEWLINE);
//			document.add(line);
//			document.add(new Paragraph(INTESTAZIONE + SPAZIATURA + DATA_FATTURA + invoice.getCreateAt()));
//			document.add(new Paragraph(user.getSurname() + " " + user.getName() + SPAZIATURA + NUMERO_FATTURA + invoice.getInvoiceNo()));
//			document.add(new Paragraph(" "));
//			document.add(table);
//			document.add(new Paragraph(SPAZIATURA + SUBTOTALE + auctionOrder.getAmount()));
//			document.add(new Paragraph(SPAZIATURA + IVA + ((auctionOrder.getAmount()/100)*VALORE_IVA)));
//			document.add(new Paragraph(TOTALE + (auctionOrder.getAmount()+((auctionOrder.getAmount()/100)*VALORE_IVA))));
			document.close();

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(baos.toString());
		return baos.toByteArray() ;
		
	}
	
	
	
// intestazione colonne
	private void addTableHeader(PdfPTable table) {
		
	    Stream.of(NUMERO_ORDINE, DESCRIZIONE, PREZZO, IVA).forEach(columnTitle -> {
	        PdfPCell header = new PdfPCell();
	        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        header.setBorderWidth(2);
	        header.setExtraParagraphSpace(10.0f);
	        header.setPhrase(new Phrase(columnTitle));
	        table.addCell(header);
	    });
	}
	
	// aggiunhe righe
	private void addRows(PdfPTable table, Invoice invoice, UserItem userItem, AuctionOrder auctionOrder) {
		table.addCell(QUANTITA);
		//table.addCell(invoice.getAuctionOrderId().toString()); da scommentare
	    table.addCell("prova");
	    table.addCell(userItem.getDescription());
//		    table.addCell(auctionOrder.getAmount().toString()); da scommentare
	    table.addCell("prova");
	}

}

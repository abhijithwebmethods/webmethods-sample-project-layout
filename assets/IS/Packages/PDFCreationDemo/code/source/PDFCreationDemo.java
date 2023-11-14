

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
// --- <<IS-END-IMPORTS>> ---

public final class PDFCreationDemo

{
	// ---( internal utility methods )---

	final static PDFCreationDemo _instance = new PDFCreationDemo();

	static PDFCreationDemo _newInstance() { return new PDFCreationDemo(); }

	static PDFCreationDemo _cast(Object o) { return (PDFCreationDemo)o; }

	// ---( server methods )---




	public static final void generatePDFFile (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(generatePDFFile)>> ---
		// @sigtype java 3.5
		// [i] field:0:required body
		// [i] field:1:required order
		// [i] field:0:required number
		// [i] field:0:required fileName
		String Output="";
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		List<List<String>> data = new ArrayList<List<String>>();
		String[]	order = IDataUtil.getStringArray( pipelineCursor_1, "order" );
		String number=IDataUtil.getString(pipelineCursor_1,"number");
		String fName=IDataUtil.getString(pipelineCursor_1,"fileName");
		int n=Integer.parseInt(number);
		data.add(Arrays.asList(order));
		PdfPTable table = new PdfPTable(1);
		table.setWidthPercentage(25);
		
		table.addCell("Order Numbers");
		 
		for (List<String> record : data) {
		    for (String field : record) {
		    	
		        table.addCell(field);
		    }
		}
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	body = IDataUtil.getString( pipelineCursor, "body" );
			try {
				String fileName="D:/SampleOrders.pdf";
				
				Document document=new Document();
				PdfWriter.getInstance(document, new FileOutputStream(fileName));
				document.open();
			
				Paragraph para= new Paragraph(body);
				Paragraph paragraph=new Paragraph();
				document.add(para);
				 for (int i = 0; i < n; i++) {
				      paragraph.add(new Paragraph(" "));
				      document.add(paragraph);
				    }
				document.add(table);
				document.close();
				
				Output="Finished Successfully";
				
			}catch (Exception e) {
				IDataUtil.put( pipelineCursor_1, "Exception", e);
				
			}
			
		pipelineCursor.destroy();
		
		// pipeline
		
		IDataUtil.put( pipelineCursor_1, "Output", Output);
		pipelineCursor_1.destroy();
		
		
			
			
		// --- <<IS-END>> ---

                
	}
}


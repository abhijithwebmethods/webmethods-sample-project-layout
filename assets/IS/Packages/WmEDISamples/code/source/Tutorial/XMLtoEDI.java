package Tutorial;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.lang.*;
import java.util.*;
// --- <<IS-END-IMPORTS>> ---

public final class XMLtoEDI

{
	// ---( internal utility methods )---

	final static XMLtoEDI _instance = new XMLtoEDI();

	static XMLtoEDI _newInstance() { return new XMLtoEDI(); }

	static XMLtoEDI _cast(Object o) { return (XMLtoEDI)o; }

	// ---( server methods )---



    public static final Values XMLdateConversionToDateTime (Values in)
    {
        Values out = in;
		// --- <<IS-START(XMLdateConversionToDateTime)>> ---
		// @subtype unknown
		// [i] field:0:required XMLDate
		// [i] field:0:required yearDigit
		// [o] field:0:required date
		// [o] field:0:required time
		String XMLDate = in.getString("XMLDate");
		String date = null, time = null;
		int yearDigit = 4;
		
		if (in.getString("yearDigit") != null)
			yearDigit = Integer.parseInt(in.getString("yearDigit"));
		
		if (yearDigit == 2){
			date = XMLDate.substring(2,8);
			time = XMLDate.substring(9,11) + XMLDate.substring(12,14);
		}
		else {
			date = XMLDate.substring(0,8);
			time = XMLDate.substring(9,11) + XMLDate.substring(12,14);
		}
		
		out.put("date", date);
		out.put("time", time);
		// --- <<IS-END>> ---
        return out;
                
	}


    public static final Values appendSegment (Values in)
    {
        Values out = in;
		// --- <<IS-START(appendSegment)>> ---
		// @subtype unknown
		// @sigtype java 3.0
		// [i] record:0:required record
		// [i] record:1:required recordList
		// [o] record:1:required recordList
		Values rec = in.getValues("record");
		if (rec == null) 
			return out.copyFrom(Service.throwError("Missing required parameter: {record}"));
		Values[] dest = in.getValuesArray("recordList");
		if (dest == null)
			dest = new Values[0];
		Values[] src = new Values[1];
		src[0] = rec;
		Values tmp[] = new Values[dest.length + src.length];
		System.arraycopy(dest,0,tmp,0,dest.length);
		System.arraycopy(src,0,tmp,dest.length,src.length);
		out.put("recordList",tmp);
		// --- <<IS-END>> ---
        return out;
                
	}


    public static final Values conditionalTruncate (Values in)
    {
        Values out = in;
		// --- <<IS-START(conditionalTruncate)>> ---
		// @subtype unknown
		// [i] field:0:required inString
		// [i] field:0:required truncateLength
		// [o] field:0:required outString
		/*
		
		This service takes a string(inString) and the truncated length(truncateLength) as inputs.  
		If the length of inString is greater than truncated length, truncation occurs.
		Otherwise, the inString is preserved.
		
		*/
		
			String inString = in.getString("inString");
			int truncateLength = Integer.parseInt(in.getString("truncateLength"));
			String outString = null;
		
			if (inString.length() > truncateLength)
				outString = inString.substring(0,truncateLength);
			else
				outString = inString;
		
			out.put("outString", outString);
		// --- <<IS-END>> ---
        return out;
                
	}


    public static final Values replaceControlChar (Values in)
    {
        Values out = in;
		// --- <<IS-START(replaceControlChar)>> ---
		// @subtype unknown
		// [i] field:0:required inString
		// [i] field:0:required replaceString
		// [o] field:0:required outString
		String edidata = in.getString("inString");
		String replaceString = in.getString("replaceString");
		
		boolean tokens = false;
		String newEDIData = "";
		
		StringTokenizer st = new StringTokenizer(edidata, "\t\n\r\f");
		
		while (st.hasMoreTokens())
		{
			tokens = true;
			newEDIData = newEDIData + st.nextToken() + replaceString;
		}
		
		if (tokens == true) edidata = newEDIData;
		
		out.put("outString", edidata);
		// --- <<IS-END>> ---
        return out;
                
	}
}


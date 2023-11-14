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

public final class EDItoXML

{
	// ---( internal utility methods )---

	final static EDItoXML _instance = new EDItoXML();

	static EDItoXML _newInstance() { return new EDItoXML(); }

	static EDItoXML _cast(Object o) { return (EDItoXML)o; }

	// ---( server methods )---



    public static final Values dateParse (Values in)
    {
        Values out = in;
		// --- <<IS-START(dateParse)>> ---
		// @subtype unknown
		// @sigtype java 3.0
		// [i] field:0:required date
		// [o] field:0:required newYear
		// [o] field:0:required newMonth
		// [o] field:0:required newDay
		// [o] field:0:required newHour
		// [o] field:0:required newMinute
		// [o] field:0:required newSecond
		// [o] field:0:required status
		int dateLength = 0;
		String newYear = null, newMonth = null, newDay = null;
		String newHour = null, newMinute = null, newSecond = null;
		
		String inputDate = in.getString("date");
		 
		out.put("status", "OK");
		
		dateLength = inputDate.length();
		
		if (dateLength == 6) {
			newYear = "20" + inputDate.substring(0,2);
			newMonth = inputDate.substring(2,4);
			newDay = inputDate.substring(4,6);
		}
		else {
			if (dateLength == 8) {
				newYear = inputDate.substring(0,4);
				newMonth = inputDate.substring(4,6);
				newDay = inputDate.substring(6,8);
			}
			else
				out.put("status", "bad_date");
		}
		
		TimeZone tz = TimeZone.getTimeZone("EST");
		Calendar cal = Calendar.getInstance(tz);
		
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		if (hour < 10)
			newHour = "0" + Integer.toString(hour);
		else
			newHour = Integer.toString(hour);
		
		if (minute < 10)
			newMinute = "0" + Integer.toString(minute);
		else
			newMinute = Integer.toString(minute);
		
		if (second < 10)
			newSecond = "0" + Integer.toString(second);
		else
			newSecond = Integer.toString(second);
		
		out.put("newYear", newYear);
		out.put("newMonth", newMonth);
		out.put("newDay", newDay);
		out.put("newHour", newHour);
		out.put("newMinute", newMinute);
		out.put("newSecond", newSecond);
		// --- <<IS-END>> ---
        return out;
                
	}
}


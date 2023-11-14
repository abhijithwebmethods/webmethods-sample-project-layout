package wm.b2b.editn.sample;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class sender

{
	// ---( internal utility methods )---

	final static sender _instance = new sender();

	static sender _newInstance() { return new sender(); }

	static sender _cast(Object o) { return (sender)o; }

	// ---( server methods )---




	public static final void getErrors (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getErrors)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required results
	IDataHashCursor cur = pipeline.getHashCursor();
 
	try
	{
		if (cur.first ("results"))
		{
			java.util.Vector results = (java.util.Vector) cur.getValue();
			if (results != null)
			{
				java.util.Vector toTell = new java.util.Vector(); 
				for (java.util.Enumeration en = results.elements(); en.hasMoreElements(); )
				{
					IData result = (IData) en.nextElement();
					String msg = (String) ValuesEmulator.get (result, "BriefMessage");
					toTell.addElement (msg);
				}
				String[] retval = new String[toTell.size()];
				toTell.copyInto (retval);
				cur.setValue (retval);
			}
		}
	}
	finally
	{
		cur.destroy();
	}
	
		// --- <<IS-END>> ---

                
	}
}


package wm.b2b.editn.eancom;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class util

{
	// ---( internal utility methods )---

	final static util _instance = new util();

	static util _newInstance() { return new util(); }

	static util _cast(Object o) { return (util)o; }

	// ---( server methods )---




	public static final void bytesToBytesList (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(bytesToBytesList)>> ---
		// @sigtype java 3.5
		// [i] object:0:required bytes
		// [i] object:0:optional otherBytesList
		// [i] object:0:optional otherBytes
		// [o] object:1:required bytesList
		Object o1 = ValuesEmulator.get(pipeline, "bytes");
		if (o1 == null || !(o1 instanceof byte [])){
			throw new ServiceException("Only bytes data types are expected.");
		}
		
		Object o2 = ValuesEmulator.get(pipeline, "otherBytesList");
		Object o3 = ValuesEmulator.get(pipeline, "otherBytes");
		
		byte [][] other;
		if (o2 == null) {
			if (o3 == null) {
				other = null;
			} else {
				other = new byte[1][];
				other[0] = (byte []) o3;
			}
		} else {
			try {
				other = (byte [][]) o2;
			} catch (ClassCastException  e) {
				throw new ServiceException("ClassCastException: " + e.toString());
			}
		}
		
		byte [] first = (byte []) o1;
		
		int otherLength = other == null? 0:other.length;
		byte [][] newByteList = new byte[1+otherLength][];
		
		newByteList[0] = new byte[first.length];
		System.arraycopy(first, 0, newByteList[0], 0, first.length);
		
		for (int i=0; i<otherLength; i++) {
			newByteList[i+1] = new byte[other[i].length];
			System.arraycopy(other[i], 0, newByteList[i+1], 0, other[i].length);
		}
		
		ValuesEmulator.put(pipeline, "bytesList", newByteList);
		//ValuesEmulator.put(pipeline, "bytesListLen", newByteList.length);
		// --- <<IS-END>> ---

                
	}
}


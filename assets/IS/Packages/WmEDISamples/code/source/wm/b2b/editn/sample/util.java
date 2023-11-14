package wm.b2b.editn.sample;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.edi.base.EDILog;
import wm.b2b.editn.EDIDocTypeCommon;
import com.wm.app.tn.db.BizDocTypeStore;
import com.wm.app.tn.profile.LookupStore;
import com.wm.app.tn.profile.ProfileStore;
// --- <<IS-END-IMPORTS>> ---

public final class util

{
	// ---( internal utility methods )---

	final static util _instance = new util();

	static util _newInstance() { return new util(); }

	static util _cast(Object o) { return (util)o; }

	// ---( server methods )---




	public static final void checkSetup (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(checkSetup)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] field:0:required setupProperly {"true","false"}
		// [o] field:0:optional profilesOkay {"true","false"}
		// [o] field:0:optional docsOkay {"true","false"}
		// [o] field:0:optional scriptsOkay {"true","false"}
			IDataCursor cur = pipeline.getCursor();
		
			try
			{
				Integer duns = LookupStore.getExternalIDType ("DUNS");
				int dunsID = -1;
				if (duns != null)
				{
					dunsID = duns.intValue();
				}
				else
				{	// "Cannot find ID type for external id 'DUNS'"
					throw new Exception (EDIDocTypeCommon.formatMessage ("402", null));
				}
				boolean correct = true;
		
				// Check Profiles
				ProfileStore profileStore = ProfileStore.getProfileStore();
				String sender = profileStore.getInternalID ( "112223333", dunsID );
				String receiver = profileStore.getInternalID ( "445556666", dunsID );
				if (sender == null || receiver == null)
				{
					correct = false;
					if (cur.first ("profilesOkay"))
					{
						cur.setValue ("false");
					}
					else
					{
						cur.insertAfter ("profilesOkay", "false");
					}
				}
		
				// Check BizDocs
				if ((BizDocTypeStore.getByName ( "X12 Envelope", false, false) == null) ||
					(BizDocTypeStore.getByName ( "X12 4010 850", false, false) == null) ||
					(BizDocTypeStore.getByName ( "X12 4010 855", false, false) == null) ||
					(BizDocTypeStore.getByName ( "EDI Sample Envelope", false, false) == null) ||
					(BizDocTypeStore.getByName ( "EDI for TN Demo PO", false, false) == null))
				{
					correct = false;
					if (cur.first ("docsOkay"))
					{
						cur.setValue ("false");
					}
					else
					{
						cur.insertAfter ("docsOkay", "false");
					}
		
				}
		
				// Check Conversation Scripts
		
		//  Removed pending receipt of PRT API's
				boolean foundAll = true;
		//		ConversationScriptList scriptList = ConversationStore.getScripts (false);
		//		boolean foundAll = false;
		//		if (scriptList != null)
		//		{
		//			foundAll = 	findScript (scriptList, "EDI Buyer 850-855") &&
		//						findScript (scriptList, "Create and Send EDI Document") &&
		//						findScript (scriptList, "EDI Seller 850-855") &&
		//						findScript (scriptList, "Receive and Process EDI Document");
		//		}
		
				if (!foundAll)
				{
					correct = false;
					if (cur.first ("scriptsOkay"))
					{
						cur.setValue ("false");
					}
					else
					{
						cur.insertAfter ("scriptsOkay", "false");
					}
		
				}
		
				if (cur.first ("setupProperly"))
				{
					cur.setValue (String.valueOf (correct));
				}
				else
				{
					cur.insertAfter("setupProperly", String.valueOf (correct));
				}
			}
			catch (Exception e)
			{
				throw new ServiceException (e.toString());
			}
			finally
			{
				if (cur != null)
				{
					cur.destroy();
				}
			}
			
		// --- <<IS-END>> ---

                
	}



	public static final void enable (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(enable)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		
		ValuesEmulator.put (pipeline, "$wmEDIForceSwitch", "true");
		// --- <<IS-END>> ---

                
	}



	public static final void getLastDocuments (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getLastDocuments)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required parameters
		// [i] record:0:required documents
		// [i] field:0:required getContent
		// [i] field:1:required lastEvents
		// [o] field:0:required recordCount
		// [o] record:1:optional events
		// [o] - field:0:required eventName
		IDataCursor cur = pipeline.getCursor();
		IDataCursor pCur = null,
							 dCur = null,
							 tempCur = null,
							 paramCur = null;
		
		IData parameters = null,
				documents = null;
		String getContent = "false"; //default to not retrieving the content for performance reasons.
		
		String[] docNames = null;
		
		try {
			if (cur.first ("parameters")) parameters = (IData) cur.getValue ();
			if (cur.first ("documents")) documents = (IData) cur.getValue();
			if (cur.first ("getContent")) getContent = (String) cur.getValue();
		
			if (parameters == null || documents == null) {
				// "parameters and documents cannot be null"
				
				//Log added
				EDILog.logError(EDILog.FAC_EDITN, 404, null);
				throw new ServiceException (EDIDocTypeCommon.formatMessage ("404", null));
			}
		
			pCur = parameters.getCursor ();
			if (pCur.first ("lastEvents")) docNames = (String[]) pCur.getValue ();
			if (docNames == null) {
				throw new ServiceException ("lastEvents not found");
			}
			IData param = IDataFactory.create();
			paramCur = param.getCursor();
			dCur = documents.getCursor();
			if (docNames.length > 0) {
				IData[] docs = new IData[docNames.length];
				for (int i = 0; i < docs.length; i ++) {
					IData data = IDataFactory.create();
					tempCur = data.getCursor();
					if (dCur.first (docNames[i])) {
						String docID = (String) dCur.getValue();
						paramCur.last ();
						paramCur.insertAfter ("internalId", docID);
						paramCur.insertAfter ("getContent", "true");
						Service.doInvoke ("wm.tn.doc", "view", param);
						if (paramCur.first ("internalId")) paramCur.delete();
						if (paramCur.first ("getContent")) paramCur.delete();
						if (paramCur.first ("bizdoc")) {
							tempCur.last();
							tempCur.insertAfter ("bizdoc", paramCur.getValue());
							tempCur.insertAfter ("eventName", docNames[i]);
							docs[i] = data;
							paramCur.delete();
						}
					} else {
						// "Unable to find id for event " + docNames[i]
						//Log added
						EDILog.logError(EDILog.FAC_EDITN, 406, new String [] {docNames[i]});
						throw new ServiceException (EDIDocTypeCommon.formatMessage ("406", new String [] {docNames[i]}));
					}
					tempCur.destroy();
				}
				if(cur.first("events"))
					cur.setValue(docs);
				else
					cur.insertAfter ("events", docs);
			}
			if(cur.first("recordCount"))
					cur.setValue(String.valueOf (docNames.length));
			else
					cur.insertAfter ("recordCount", String.valueOf (docNames.length));
		
		
		} catch (Exception e) {
			// "Error getting Last Document " + e.toString()
			//Log added
			EDILog.logError(EDILog.FAC_EDITN, 408, new String [] {e.toString()});
			throw new ServiceException (EDIDocTypeCommon.formatMessage ("408", new String [] {e.toString()}));
		} finally {
			if (cur != null) cur.destroy();
			if (pCur != null) pCur.destroy();
			if (dCur != null) dCur.destroy();
			if (tempCur != null) dCur.destroy();
			if (paramCur != null) dCur.destroy();
		}
			
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	
		static Object toNotify = new Object();
		static boolean notified = false, waiting = false;
	
	//XXX: PRT
	//	public static boolean findScript (ConversationScriptList scriptList, String scriptName)
	//		throws Exception
	//	{
	//		int[] results = scriptList.find (scriptName, null, null);
	//		if (results != null && results.length >= 1)
	//		{
	//			return true;
	//		}
	//		else
	//		{
	//			return false;
	//		}
	//	}
		
	// --- <<IS-END-SHARED>> ---
}


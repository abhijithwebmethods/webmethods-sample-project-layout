package wm.b2b.editn.sample;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.*;
import com.wm.app.tn.profile.*;
import com.wm.app.tn.route.*;
import com.wm.app.tn.db.BizDocTypeStore;
import com.wm.app.tn.doc.BizDocType;
import com.wm.util.coder.IDataXMLCoder;
import wm.b2b.editn.EDIDocTypeCommon;
// --- <<IS-END-IMPORTS>> ---

public final class setup

{
	// ---( internal utility methods )---

	final static setup _instance = new setup();

	static setup _newInstance() { return new setup(); }

	static setup _cast(Object o) { return (setup)o; }

	// ---( server methods )---




	public static final void setupProfile (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(setupProfile)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required CorporationName
		// [i] field:0:required DUNS
		// [i] field:0:required host
		// [i] field:0:required user
		// [i] field:0:required port
		// [i] field:0:required url
		// [i] field:0:required password
		// [o] field:0:required internalID
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		try {
		 
		
		String corpName = null, duns = null, host = null,
				user = null, port = null, url = null, password = null;
		
		if ( pipelineCursor.first( "CorporationName" ) ){
			corpName = (String) pipelineCursor.getValue();
		}
		if ( pipelineCursor.first( "DUNS" ) ){
			duns = (String) pipelineCursor.getValue();
		}
		if ( pipelineCursor.first( "host" ) ){
			host = (String) pipelineCursor.getValue();
		}
		if ( pipelineCursor.first( "user" ) ){
			user = (String) pipelineCursor.getValue();
		}
		if ( pipelineCursor.first( "port" ) ){
			port = (String) pipelineCursor.getValue();
		}
		if ( pipelineCursor.first( "url" ) ){
			url = (String) pipelineCursor.getValue();
		}
		if ( pipelineCursor.first( "password" ) ){
			password = (String) pipelineCursor.getValue();
		}
		
			Integer LOOKUP_DUNS = LookupStore.getExternalIDType ("DUNS");
			int DUNS_ID = -1;
			if (LOOKUP_DUNS != null){
				DUNS_ID = LOOKUP_DUNS.intValue();
			}
			else{
				// "Cannot find ID type for external id 'DUNS'"
				throw new Exception (EDIDocTypeCommon.formatMessage ("502", null));
			}
		
			ProfileStore profileStore = ProfileStore.getProfileStore();
			String internalID = profileStore.getInternalID ( duns, DUNS_ID );
			Profile profile = null;
			if (internalID != null){
				profile = profileStore.getProfile (internalID);
			}
			if (profile == null){
				profile = new Profile();
				Corporation corp = new Corporation();
				corp.setCorporationName(corpName);
				corp.setPartnerType(Constants.PARTNER_TYPE_SERVER);
				corp.setStatus(Constants.PARTNER_STATUS_ACTIVE);
				corp.setSelf(false);
				profile.setCorporation (corp);
		
				ID extID = new ID();
				extID.setIDType(DUNS_ID);
				extID.setExternalID(duns);
				profile.addID(extID);
		
				Vector dests = new Vector();
		
				Destination dest = newDestination ("http", host, port, url, false, user, password);
		
				dests.addElement(dest);
				profile.setDestinations(dests);
		
				profileStore.addProfile (profile);
			} else {
				Vector dest = profile.getDestinationVector();
				Destination found = null;
				if (dest != null) {
					for (Enumeration e = dest.elements(); e.hasMoreElements(); ) {
						Destination d = (Destination) e.nextElement();
						if (d.isHTTP() && !d.isPrimary()) {
							found = d;
							break;
						}
					}
				}
				if (found == null) {
					dest = new Vector();
					found = newDestination ("http", host, port, url, false, user, password);
					dest.addElement (found);
					profileStore.addDestinations (dest, internalID);
				}
			}
			ValuesEmulator.put(pipeline, "internalID", profileStore.getInternalID ( duns, DUNS_ID ));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException (e.toString());
		}
		finally {
			if (pipelineCursor != null) {
				pipelineCursor.destroy();
			}
		}
			
		// --- <<IS-END>> ---

                
	}



	public static final void setupXMLBizDocTypes (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(setupXMLBizDocTypes)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		
		
		
		try
		{
			IDataXMLCoder coder = new IDataXMLCoder ();
			IData info = coder.readFromFile (new java.io.File ("packages//WmEDIforTN//config//SampleBizDocTypes.xml"));
		
			IData types = (IData) ValuesEmulator.get(info, "types");
		
			IDataCursor cur = types.getCursor();
		
			if (cur.first())
			{
				do
				{
					BizDocType search = BizDocTypeStore.getByName (cur.getKey(), true, false);
					boolean isDeleted = search != null && search.isDeleted();
					if (search == null)
					{
						BizDocType d = (BizDocType) cur.getValue();
						ValuesEmulator.put (pipeline, cur.getKey(), d);
						BizDocTypeStore.insert (d, null);
					}
					else if (isDeleted)
					{
						BizDocType d = (BizDocType) cur.getValue();
						BizDocTypeStore.update (d);
					}
				} while (cur.next());
			}
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new ServiceException (e.toString());
		}
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	
	
	public static Destination newDestination (String protocol, String host, String port,
												String url,  boolean primary,
												String user, String password)
	{
		Destination dest = new Destination();
		dest.setProtocol(protocol);
		dest.setHost(host);
		dest.setPort(port);
		dest.setLocation(url);
		dest.setPrimary(false);
		dest.setUser(user);
		dest.setPassword(password);
		return dest;
	}
		
	// --- <<IS-END-SHARED>> ---
}


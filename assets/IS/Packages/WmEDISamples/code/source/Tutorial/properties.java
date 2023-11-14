package Tutorial;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.io.*;
import java.util.*;
import com.wm.app.b2b.server.*;
// --- <<IS-END-IMPORTS>> ---

public final class properties

{
	// ---( internal utility methods )---

	final static properties _instance = new properties();

	static properties _newInstance() { return new properties(); }

	static properties _cast(Object o) { return (properties)o; }

	// ---( server methods )---



    public static final Values getProperties (Values in)
    {
        Values out = in;
		// --- <<IS-START(getProperties)>> ---
		// @subtype unknown
		// @sigtype java 3.0
		// [i] field:0:required B2B_config_file
		// [i] field:1:required properties
		// [o] field:1:required values
    
    // in 
    String[] properties_list = (String[])in.get( "properties" );
    String configFile = in.getString( "B2B_config_file" );

	if (configFile != null) 
       B2B_config_file = configFile;

    if (properties_list != null)
    {
      // out
      String[] values = new String[properties_list.length];
    
      if (!B2B_config_file.equals(propertiesFileLoaded))
        loadProperties();

      for (int i=0; i < properties_list.length; i++)
        values[i] = properties.getProperty(properties_list[i]);

      out.put( "values", values );
    }
		// --- <<IS-END>> ---
        return out;
                
	}


    public static final Values sampleInit (Values in)
    {
        Values out = in;
		// --- <<IS-START(sampleInit)>> ---
		// @subtype unknown
		// @sigtype java 3.0
		
		// set ACLs
		String svcs [] = {
			"Tutorial.EDItoXML",
		       	"Tutorial.FlatFile",
			"Tutorial.properties",
			"Tutorial.Records",
			"Tutorial.XMLtoEDI",
			"sampleServices",
			"sampleServices:Iterator810",
			"sampleServices:UNEDIFACTtoValues",
			"sampleServices:X12toValues"
		};
		for (int i = 0; i<svcs.length; i++) {
			ACLManager.setBrowseAclGroup(svcs[i], "Internal");
			ACLManager.setReadAclGroup(svcs[i], "Internal");
			ACLManager.setWriteAclGroup(svcs[i], "Internal");
			ACLManager.setAclGroup(svcs[i], "Developers");
		}
		// --- <<IS-END>> ---
        return out;
                
	}

	// --- <<IS-START-SHARED>> ---
	private static String B2B_config_file = "properties";
	private static Properties properties = null;
	private static String propertiesFileLoaded = null;
	
	static final Values loadProperties()
	{
		
	    String configFile =  "packages" + File.separator + "WmEDIsamples" 
							 + File.separator + "pub"
						     + File.separator + B2B_config_file;
	
		//System.out.println("______________________________________________________________________");
	    //System.out.println("wm.b2b.edi.sample.loadProperties: configFile="+configFile);
	
	    try {
	        FileInputStream configFileInputStream = new FileInputStream( configFile );
	        properties = new Properties();
	        properties.load( configFileInputStream );
	        propertiesFileLoaded = new String(B2B_config_file);
	        //System.out.println("______________________________________________________________________");
	        //System.out.println("sample.loadProperties");
	        //System.out.println(properties);
	        //System.out.println("______________________________________________________________________");
	    } catch ( FileNotFoundException e ) {
	        System.err.println( "loadProperties error: Cannot find the config file: " + configFile );
			return Service.throwError("Error finding "+ configFile + " property file: "+e);
	    } catch ( IOException e ) {
	        System.err.println( "loadProperties error: Cannot read the config file: " + configFile );
			return Service.throwError("Error reading "+ configFile + " property file: "+e);
	    }
	
	    return null;
	}
		
	// --- <<IS-END-SHARED>> ---
}


<html>
   <head>
      <meta http-equiv="Pragma" content="no-cache">
      <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
      <meta http-equiv="Expires" content="-1">
      <title>Setup</title>
      <link rel="stylesheet" type="text/css" href="/WmRoot/webMethods.css">
      <script src="/WmRoot/webMethods.js"></script>
		<script src="/WmRoot/common-menu.js"></script>
		<script src="/WmRoot/csrf-guard.js"></script>			
      <style>
         p {font-size: 13px;}
      </style>
   </head>
   <body onLoad="setNavigation('sample-setup.dsp');">
   
      <table WIDTH="100%">
         <tr>
            <td class="breadcrumb" colspan=3> Menu &gt; Setup</td>
         </tr>
         <tr>
            <td width="10"><IMG border="0" src="images/blank.gif" width="10" height="10"></td>
            <td width="10"><IMG border="0" src="images/blank.gif" width="10" height="10"></td>
            <td width="10"><IMG border="0" src="images/blank.gif" width="10" height="10"></td>
         </tr>
         <table class="tableView" width="100%">
            <tr>
               <td class="heading" colspan="4">Setup</td>
            </tr>
            <tr>
            <TR>
               <TD class="rowdata" colspan=3>
                  <p>The setup process will create the following items. If you are running the EDI Module EDIINT demo too, run the EDIINT demo first, then run this setup.</p>
                  <P>
                     After running this setup process you must import four process models into the webMethods Modeler. The models are located in the directory
                     <em>ServerDirectory/packages/WmEDIsamples/config/Models</em>. After importing these models, use the webMethods Modeler to generate process models. See the
                     <i>webMethods Modeler User's Guide</i> for help with these procedures.
                  </P>
               </TD>
            </TR>
            </tr>
						<FORM NAME="install" METHOD="POST" ACTION="sample-dosetup.dsp" target="">
            <tr>
							<td valign="top" width="20%">
               <table class="tableView" width="98%">
                  <TR>
                     <td class="subheading" colspan=2>Document Types</TD>
                  </TR>
                  <TR>
                     <TD class="evenrow">1</TD>
                     <TD class="evenrowdata-l">X12 4010 850</TD>
                  </TR>
                  <TR>
                     <TD class="oddrow">2</TD>
                     <TD class="oddrowdata-l">X12 4010 855</TD>
                  </TR>
                  <TR>
                     <TD class="evenrow">3</TD>
                     <TD class="evenrowdata-l">EDI for TN Sample PO</TD>
                  </TR>
                  <TR>
                     <TD class="oddrow">4</TD>
                     <TD class="oddrowdata-l">EDI Sample Envelope</TD>
                  </TR>
               </table>
						 </td>
						 <td valign="top" width="40%">
							 <table class="tableView" width="99%">
                  <TR>
                     <td class="subheading" colspan=2>Sender Profile</TD>
                  </TR>
                  <TR>
                     <TD class="evenrow">Corporation Name</TD>
                     <TD class="evenrowdata-l">SENDER</TD>
										 <input TYPE="HIDDEN" NAME="SenderCorporateName" VALUE="SENDER">
                  </TR>
                  <TR>
                     <TD class="oddrow">External ID (DUNS)</TD>
                     <TD class="oddrowdata-l">112223333</TD>
										 <input TYPE="HIDDEN" NAME="SenderDuns" VALUE="112223333">
                  </TR>
									<TR>
                     <TD class="oddrow">Host</TD>
                     <TD class="oddrowdata-l"><input type="text" name="SenderHost" value="localhost"></TD>
                  </TR>
                  <TR>
                     <TD class="oddrow">Port</TD>
                     <TD class="oddrowdata-l"><input type="text" name="SenderPort" value="5555"></TD>
                  </TR>
									<TR>
                     <TD class="oddrow">Location</TD>
                     <TD class="oddrowdata-l">/invoke/wm.b2b.editn.sample.util:receive</TD>
                  </TR>
									<TR>
										 <TD class="oddrow">User Name</TD>
										 <TD class="oddrowdata-l"><input type="text" name="SenderUserName" value="Administrator"></TD>
									</TR>
									<TR>
										 <TD class="oddrow">Password</TD>
										 <TD class="oddrowdata-l"><input type="password" name="SenderPassword" value="manage"></TD>
									</TR>
                  <!--<tr>
                    <td class="evenrow">Certificate</td>
                    <td class="evenrow-l">packages/WmEDISamples/pub/demo/Cert/Partner1Cert.der</td>
                  </tr>
                  <tr>
                    <td class="oddrow">Private Key</td>
                    <td class="oddrow-l">packages/WmEDISamples/pub/demo/Cert/Partner1PrivateKey.der</td>
                  </tr>-->
               </table>
						 </td>
						 <td valign="top" width="40%">
							 <table class="tableView" width="99%">
                  <TR>
                     <td class="subheading" colspan=2>Receiver Profile</TD>
                  </TR>
									<TR>
                     <TD class="evenrow">Corporation Name</TD>
                     <TD class="evenrowdata-l">RECEIVER</TD>
										 <input TYPE="HIDDEN" NAME="ReceiverCorporateName" VALUE="RECEIVER">
                  </TR>
                  <TR>
                     <TD class="oddrow">External ID (DUNS)</TD>
                     <TD class="oddrowdata-l">445556666</TD>
										 <input TYPE="HIDDEN" NAME="ReceiverDuns" VALUE="445556666">
                  </TR>
                  <TR>
                     <TD class="oddrow">Host</TD>
                     <TD class="oddrowdata-l"><input type="text" name="ReceiverHost" value="localhost"></TD>
                  </TR>
                  <TR>
                     <TD class="oddrow">Port</TD>
                     <TD class="oddrowdata-l"><input type="text" name="ReceiverPort" value="5555"></TD>
                  </TR>
									<TR>
                     <TD class="oddrow">Location</TD>
                     <TD class="oddrowdata-l">/invoke/wm.b2b.editn.sample.util:receive</TD>
                  </TR>
									<TR>
										 <TD class="oddrow">User Name</TD>
										 <TD class="oddrowdata-l"><input type="text" name="ReceiverUserName" value="Administrator"></TD>
									</TR>
									<TR>
										 <TD class="oddrow">Password</TD>
										 <TD class="oddrowdata-l"><input type="password" name="ReceiverPassword" value="manage"></TD>
									</TR>
                  <!--<tr>
                    <td class="evenrow">Certificate</td>
                    <td class="evenrow-l">packages/WmEDISamples/pub/demo/Cert/Partner2Cert.der</td>
                  </tr>
                  <tr>
                    <td class="oddrow">Private Key</td>
                    <td class="oddrow-l">packages/WmEDISamples/pub/demo/Cert/Partner2PrivateKey.der</td>
                  </tr>-->
               </table>
						 </td>
            </tr>
						<tr>
							<td colspan=2 class="action"><INPUT type="submit" name="submit" value="Setup"></td>
						</tr>
						</form>
						
         </table>
		 
      </table>
   </body>
</html>

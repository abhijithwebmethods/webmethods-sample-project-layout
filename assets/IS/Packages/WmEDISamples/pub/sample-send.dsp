<html>

<head>
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
	<meta http-equiv="Expires" content="-1">
	<title>Send Order</title>
	<link rel="stylesheet" type="text/css" href="/WmRoot/webMethods.css">
	<script src="/WmRoot/webMethods.js"></script>
	<style>
		p {
			font-size: 13px;
		}
	</style>
</head>

<body onLoad="setNavigation('sample-send.dsp');">

	<table  width=100%>
		<tr><td class="breadcrumb" colspan=3> Menu &gt; Send Purchase Order</td></tr>
		<tr>
			<td width="10"><IMG border="0" src="images/blank.gif" width="10" height="10"></td>
			<td width="10"><IMG border="0" src="images/blank.gif" width="10" height="10"></td>
			<td width="10"><IMG border="0" src="images/blank.gif" width="10" height="10"></td>
		</tr>
		<table class="tableView" width="50%">
			<tr><td class="heading" colspan="4">Send</td></tr>
			<tr>
					
						%invoke wm.b2b.editn.sample.util:checkSetup% 
							%ifvar setupProperly equals('true')%
							<TD class="rowdata" colspan=3>
							<font size="-1">The group control number and purchase order number must be specified in order to start a conversation. Please enter
									this information and press &quot;send&quot; to start the example.</font>
									</td>
									
								<FORM NAME="SEND" ACTION="sample-dosend.dsp" METHOD="POST">
								<tr>
								<td>
									<TABLE class="tableView" width="100%">
										<TR>
											<td COLSPAN="2" CLASS="subheading">SEND MESSAGE</td>
										</TR>
										<TR>
											<TD CLASS="evenrow">Sender</TD>
											<TD CLASS="evenrowdata-l">Company: 'SENDER' DUNS:112223333</TD>
											<INPUT TYPE="HIDDEN" NAME="SenderID" VALUE="112223333">
										</TR>
										<TR>
											<TD CLASS="evenrow">Receiver</TD>
											<TD CLASS="evenrowdata-l">Company: 'RECEIVER' DUNS:445556666</TD>
											<INPUT TYPE="HIDDEN" NAME="ReceiverID" VALUE="445556666">
										</TR>
										<TR>
											<TD CLASS="evenrow">Group Control Number</TD>
											<TD CLASS="evenrowdata-l">
												<INPUT TYPE="text" NAME="ControlNumber" VALUE="897654">
											</TD>
										</TR>
										<TR>
											<TD CLASS="evenrow">Purchase Order Number</TD>
											<TD CLASS="evenrowdata-l">
												<INPUT TYPE="TEXT" NAME="DocumentID" VALUE="123456">
											</TD>
										</TR>
									</TABLE>
									</td>
									</tr>
									
								
									<TR>
										<TD CLASS="action" COLSPAN="2">
											<INPUT TYPE="SUBMIT" VALUE="Send">
										</TD>
									</TR>
								</FORM>
							%else%
								<TR>
									<TD class="message" colspan="2">Your sample is not setup correctly.</td>
								</tr>
								
							%ifvar scriptsOkay equals('false')%
								<table class="tableView" width="100%">
									<tr>
										<td class="heading" colspan="4"> Note !</td>
									</tr>
									<TR>
										<TD class="rowdata" colspan=3>
											<P> Please use Business Integrator to import the process models contained in the directory:
												<EM>ServerDirectory/packages/WmEDIforTN/config/Models</EM>. After doing so, use webMethods Business Integrator to generate
												the business processes. See the
												<i>Business Integrator User's Guide</i> and the
												<i>Trading Networks Implementation System Guide</i> for help with these procedures.</P>
											<P> Reload this page after generating the business processes using webMethods Business Integrator. </P>
										</TD>
									</TR>
								</table>
							%endif% 
						%ifvar docsOkay equals('false')%
							<TR>
								<TD class="message" colspan="2">Please run the setup again.</td>
							</tr>
						%else% 
							%ifvar profilesOkay equals('false')%
								<TR>
									<TD class="message" colspan="2"> Please run the setup again.</td>
								</tr>
						%endif% 
					%endif% 
				%endinvoke%
				</tr>
		</table>
	</table>
</body>

</html>
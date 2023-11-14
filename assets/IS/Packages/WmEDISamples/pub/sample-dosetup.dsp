<html>

<head>
	 <meta http-equiv="Pragma" content="no-cache">
	 <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
	 <meta http-equiv="Expires" content="-1">
	 <title>Sample Setup</title>
	 <link rel="stylesheet" type="text/css" href="/WmRoot/webMethods.css">
	 <script src="/WmRoot/webMethods.js"></script>
	 <style>
			p {font-size: 13px;}
	 </style>
</head>
	<body onLoad="setNavigation('sample-dosetup.dsp');">
		<TABLE WIDTH="100%">
			<TR><TD class="breadcrumb" colspan=3> Menu &gt; Sample Setup </TD></TR>
			<TD colspan="2">
				</TD>
			<tr>
				<td>
        <br>
				%invoke wm.b2b.editn.sample.setup:setupSample%
						%invoke wm.b2b.editn.sample.util:checkSetup%
							%ifvar setupProperly equals('true')%
							
								<TR><TD class="message" colspan="2">The profiles and document types needed for the sample have been installed. Now you can send the Purchase order</TD></TR>
								<table class="tableView" width="50%">
							  	<tr><td class="heading" colspan="4"> Note !</td></tr>
							    <TR>
							       <TD class="rowdata" colspan=3>
							         <p>You must still import four process models into the webMethods Modeler.  The models are located in the directory
							         <em>ServerDirectory/packages/WmEDIsamples/config/Models</em>.  After importing these models, use the webMethods
											Modeler to generate process models.  See the <i>webMethods Modeler User's Guide</i> for help with these procedures. </p>
							       </TD>
							    </TR>
								</table>
							%else%
							%ifvar scriptsOkay equals('false')%
									<table class="tableView" width="100%">
											<tr><td class="heading" colspan="4"> Note !</td></tr>
											<TR>
												<TD class="rowdata" colspan=3>
													<p>Please use webMethods Modeler to import the process models contained in the
					                                         Integration Server directory under <font face="Courier">/packages/WmEDIsamples/config/Models</font>.  After doing so, use Modeler to generate the
					                                         business process.  See the <i>Business Integrator User's Guide</i> for details.</p>
												</TD>
											</TR>
									</table>
							%endif%
							%ifvar docsOkay equals('false')%
								<TR><TD class="message" colspan="2">Please run the setup <A HREF="setup.dsp">again</A>.  </TD></tr>
							%else%
								%ifvar profilesOkay equals('false')%
									<TR><TD class="message" colspan="2"> Please run the setup <A HREF="setup.dsp">again</A>.</td></tr>
							%endif%
						%endif%
					%endif%
				%endinvoke%
		%onerror%
			<TR><TD class="message" colspan="2">An error occured during setup: %value error%, Message: %value errorMessage% </td></tr>
		%endinvoke%
	</td>
</tr>
</table>
</body>

</html>

<html>

<head>
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
	<meta http-equiv="Expires" content="-1">
	<title>Sample Monitor</title>
	<link rel="stylesheet" type="text/css" href="/WmRoot/webMethods.css">
	<script src="/WmRoot/webMethods.js"></script>
	<style>
		p {
			font-size: 13px;
		}
	</style>
</head>
<body onLoad="setNavigation('sample-dosend.dsp');">
	<TABLE WIDTH="100%">
		<tr><td class="breadcrumb" colspan=3> Menu &gt; Sample Monitor</td></tr>
		<tr>
			<td width="10"><IMG border="0" src="images/blank.gif" width="10" height="10"></td>
			<td width="10"><IMG border="0" src="images/blank.gif" width="10" height="10"></td>
			<td width="10"><IMG border="0" src="images/blank.gif" width="10" height="10"></td>
		</tr>
		<tr>
				<br>%invoke wm.b2b.editn.sample.sender:start%

					<TD class="message" colspan="3">The sample has been started. Use the webMethods Monitor to track the conversations.</td><tr>
					<table class="tableView" width="50%">
						<tr><td class="heading" colspan="4"> Note !</td></tr>
							<TR>
								<TD class="rowdata" colspan=3>
									<P> It may take a few moments for all of the conversations to be created. Please be patient.</P>
								</TD>
							</TR>
					</table>
					%onerror%
					
					<table class="tableView" width="100%">
        <tr>
          <td class="heading" colspan="4">ERROR</td>
        </tr>
		<tr>
		<td nowrap class="evenrow">Error value</td>
		<td nowrap class="oddcol">%value error%</td>
		</tr>
		<tr>
		<td nowrap class="evenrow">Error message</td>
		<td nowrap class="oddcol">%value errorMessage%</td>
		</tr>
	%endinvoke%
		</tr>
	</table>
	
</body>
</html>

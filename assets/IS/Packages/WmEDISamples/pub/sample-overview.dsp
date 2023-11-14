<html>

<head>
  <meta http-equiv="Pragma" content="no-cache">
  <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
  <meta http-equiv="Expires" content="-1">
  <title>Overview</title>
  <link rel="stylesheet" type="text/css" href="/WmRoot/webMethods.css">
  <script src="/WmRoot/webMethods.js"></script>
  <style>
    p {font-size: 13px;}
  </style>
</head>

<body onLoad="setNavigation('sample-overview.dsp');">
<table WIDTH="100%">
    <tr>
      <td class="breadcrumb" colspan=3> Menu &gt; Overview</td>
    </tr>
    <tr>
      <td width="10"><IMG border="0" src="images/blank.gif" width="10" height="10"></td>
      <td width="10"><IMG border="0" src="images/blank.gif" width="10" height="10"></td>
      <td width="10"><IMG border="0" src="images/blank.gif" width="10" height="10"></td>
    </tr>
    <tr>
    <td valign="top" colspan=3>
      <table class="tableView" width="100%">
        <tr>
          <td class="heading" colspan="4">Overview</td>
        </tr>
        <tr>
          <TR>
            <TD class="rowdata" colspan=3>
              <p> This sample shows an example of how to use the webMethods Modeler to create business processes that manipulate EDI documents.
                <p>In this sample, an XML Purchase Order document is posted to the Trading Network. This document triggers a business process. The process model that defines the business process converts the document into an EDI 850 purchase order and transmits
                  the EDI 850 purchase order to the appropriate trading partner.</p>
                <p>The following picture illustrates sender-side EDI business process:<img src="demo/CreateConversation.jpg" border=0></p>
                <p>In the first level (transaction set level) of business process, the sender forms an 850 from an XML document, sends the 850 and wait for an 855 in response. The receiver receives the 850 and sends the 855 back to the sender, which the sender
                  translates and sends to a back-end system.</p>
                <p>The sample is configured to run on a single server. Therefore, you will see both the sender and receiver side processes. A total of four processes are created each time you run the sample.</p>
                <p>To continue on demo, click the <strong>SetUp</strong> from navigation menu, fill the details or leave as default and click setup. It will configured the profiles and document types needed for demo.</p>
                <p>On successful setup, click the <strong>Send</strong> from navigation menu, fill the details or leave as default and click Send</p>
              </TD>
          </TR>
        </tr>
    </table>
  </td>
  </tr>
  </table>
</body>

</html>

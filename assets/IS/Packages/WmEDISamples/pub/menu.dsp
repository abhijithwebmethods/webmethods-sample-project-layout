<html>
	<head>
		<meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Expires" content="-1">
		<link rel="stylesheet" type="text/css" href="/WmRoot/webMethods.css">
		<script src="/WmRoot/common-menu.js"></script>
		<script src="/WmRoot/csrf-guard.js"></script>
		<script type="text/javascript">
			var selected = null;
			var menuInit = false;
			function menuSelect(object, id) {
			  selected = menuext.select(object, id, selected);
			}
			function menuMouseOver(object, id) {
			  menuext.mouseOver(object, id, selected);
			}
			function menuMouseOut(object, id) {
			  menuext.mouseOut(object, id, selected);
			}
			function initMenu(firstImage) {
			    menuInit = true;
			    return true;
			}
		</script>
	</head>
	<body  class="menu" onload="initMenu('')">
		<table class="menuTable" width="100%" cellspacing="0" cellpadding="0" border="0">
			<!-- For Configuration -->
	%scope param(expanded='true') param(text='Menu')%
		%include ../../WmRoot/pub/menu-section.dsp%
	%endscope%

	%scope param(section='Menu') param(url='sample-overview.dsp')%
		%include ../../WmRoot/pub/menu-subelement-top.dsp%
Overview
		%include ../../WmRoot/pub/menu-subelement-bottom.dsp%
	%endscope%

	%scope param(section='Menu') param(url='sample-setup.dsp')%
		%include ../../WmRoot/pub/menu-subelement-top.dsp%
		SetUp
		%include ../../WmRoot/pub/menu-subelement-bottom.dsp%
	%endscope%

	%scope param(section='Menu') param(url='sample-send.dsp')%
		%include ../../WmRoot/pub/menu-subelement-top.dsp%
		Send
		%include ../../WmRoot/pub/menu-subelement-bottom.dsp%
	%endscope%
		</table>
		<script>menuSelect('', 'sample-overview.dsp')</script>
	</BODY>
</HTML>

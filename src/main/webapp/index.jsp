<%@ taglib uri="/WEB-INF/tld/static.tld" prefix="sc"%>
<html>
	<head>
		<title>nginx_concat_module的Java开发环境</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<sc:cssFile value="jquery.ui.dialog.css"/>
		<sc:cssFile value="common.css"/>
		<jsp:include page="styles.jsp"></jsp:include>
		<sc:jsFile value="jquery.js"/>
		<sc:jsFile value="core.js"/>
		<sc:jsFile value="jquery.ui.js"/>
		<sc:jsFile value="validator.js"/>
		<sc:out/>
	</head>
	<body>
		<div>
			<h2>nginx_concat_module的Java开发环境</h2>
			<div>请修改SpringBeans.xml中的autoConcat属性后，<br/>再查看生成的html源代码</div>
		</div>
		<jsp:include page="scripts.jsp"></jsp:include>
		<sc:out/>
	</body>
</html>

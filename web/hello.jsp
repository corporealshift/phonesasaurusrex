<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<title>Hello</title>

<body>
<h1>Hello world</h1>

<p>Just testing a basic Struts2 application</p>

<p>Today is <s:date name="today" format="yyyy-MM-dd"/></p>
<s:if test="name != null">
    <p>You passed in ${name} as a name</p>
</s:if>
</body>
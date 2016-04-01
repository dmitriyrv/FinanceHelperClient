<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>

</head>

<body>
<form:form action="addUser" method="POST">
    	<p>First Name: <form:input path="firstName" /></p>
        <p>Last Name: <form:input path="lastName" /></p>
        <p>E-Mail: <form:input path="email" /></p>
        <p>Password: <form:input path="password" /></p>
        <p><input type="submit" value="Submit" /></p>
    </form:form>

</body>
</html>
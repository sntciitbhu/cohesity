    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<html>
<head>
<link href="<c:url value="/resources/css/navtable.css" />" rel="stylesheet">
</head>
<body background="${pageContext.request.contextPath}/resources/images/back2.jpg">
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<ul>
			  <li class="left"><a class="active" href="/dbms_project/welcome/">Home</a></li>
			  <li class="right"><a href="javascript:formSubmit()"> Logout</a></li>
			</ul>
		</c:if>
		<div class="loginBox">
	<h1>Buying Transactions List</h1>
	<table id="tab">
	<tr><th>Id</th><th>Provider Name</th><th>Total Bill</th><th>Date</th><th>Update in Stock</th></tr>
    <c:forEach var="w" items="${list}"> 
    <tr>
    <td>${w.transaction_ID }</td>
    <td>${map.get(w.provider_id)}</td>
    <td>${w.total_Bill}</td>
    <td>${w.date}</td>
    <td><a href="/dbms_project/branch/transtock/${w.transaction_ID}">Update</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a class="link" href="/dbms_project/branch/savebuy/">New Order</a>
    </div>
    </body>
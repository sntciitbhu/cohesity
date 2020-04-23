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
	<h1>Selling Transactions List</h1>
	<table id="tab">
	<tr><th>Id</th><th>Customer Name</th><th>Doctor Name</th><th>Total Bill</th><th>Date</th><th>Number Of Products</th><th>Bill</th></tr>
    <c:forEach var="w" items="${list}"> 
    <tr>
    <td>${w.transaction_ID }</td>
    <td>${custmap.get(w.customer_id)}</td>
    <td>${docmap.get(w.getDoctor_ID())}</td>
    <td>${w.total_Bill}</td>
    <td>${w.date}</td>
    <td>${w.product_no}</td>
    <td><a href="/dbms_project/branch/bill/${w.transaction_ID}">Bill</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a class="link" href="/dbms_project/branch/checkcust">New Sale</a>
    </div>
    </body>
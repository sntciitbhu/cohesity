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
	<h1>Payments to Doctors</h1>
	<table id="tab">
	<tr><th>Id</th><th>Doctor Name</th><th>Total Transactions</th><th>Total Bill</th><th>IFSC Code</th><th>Account Number</th></tr>
    <c:forEach var="prov" items="${list}"> 
    <tr>
    <td>${prov.doctor_ID}</td>
    <td>${prov.name}</td>
    <td>${cntmap.get(prov.doctor_ID)}</td>
    <td>${totalmap.get(prov.doctor_ID)}</td>
    <td>${map.get(prov.bank_detail_id).getIFSC_Code()}</td>
    <td>${map.get(prov.bank_detail_id).getAccount_No()}</td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    </div>
    </body>
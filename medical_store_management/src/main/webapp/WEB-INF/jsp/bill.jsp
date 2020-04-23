    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

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
	<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
	<h1>Swastik Medical Store</h1>
	<table id="tab">
	<tr>
    <td>
    ${ms} Branch
    </td>
    </tr>
    <tr>
    <td>
    Customer Name:${cust}
    </td>
    </tr>
    <tr>
    <td>
    Doctor: ${doc}
    </td>
    </tr>
    <tr><th>Product Name</th><th>Quantity</th><th>Total Price</th></tr>
    <c:forEach var="s" items="${sold}"> 
    <tr>
    <td>${namemap.get(s.product_ID)}</td>
    <td>${s.quantity}</td>
    <td>${pricemap.get(s.product_ID)}</td>
    </tr>
    </c:forEach>
    <tr>
    <td>
    Total Bill: ${totalbill}
    </td>
    </tr>
    </table>
    </div>
    </body>
    
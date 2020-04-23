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
	<h1>Product In Stock List</h1>
	<table id="tab">
	<tr><th>Product Id</th><th>Product Name</th><th>Quantity</th><th>Batch No.</th><th>Expiry Date</th></tr>
    <c:forEach var="w" items="${list}"> 
    <tr>
    <td>${w.product_ID}</td>
    <td>${map.get(w.product_ID)}</td>
    <td>${w.quantity}</td>
    <td>${w.batch_No}</td>
    <td>${w.expiry_Date}</td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a class="link" href="/dbms_project/branch/addstock">Add more Products In Stock</a>
    <a class="link" href="/dbms_project/branch/viewstockcom">View Combined Stock</a>
    
    <c:if test = "${c == 1}">
    <form:form method="post" action="/dbms_project/branch/expirestock">
    <input class="link" type="submit" value="Delete Expire Stock" />
    </form:form>
     </c:if>
     </div>
     </body>
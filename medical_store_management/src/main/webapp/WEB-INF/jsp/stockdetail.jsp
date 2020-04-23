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
		<h1>Give details of Products to add in stock</h1>
       <form:form method="post" action="/dbms_project/branch/stockdetail">  
      	<table id="tab">  
         <tr><th>Products</th><th>Quantity</th><th>Expiry Date</th><th>Batch Number</th></tr>  
          <c:forEach var="pro" items="${list}">
          <tr>
          		<td>${pro.name}</td> 
          		<input type="hidden" name="id" id="id" value="${pro.product_ID}">
          		 <c:if test = "${c == 1}">
          		<td><input name="quantity${pro.product_ID}" id="quantity${pro.product_ID}" value="${map.get(pro.product_ID)}" placeholder="Quantity" required="true" type="number" readonly></td>
          		</c:if>
          		<c:if test = "${c == 0}">
          		<td><input name="quantity${pro.product_ID}" id="quantity${pro.product_ID}" value="${map.get(pro.product_ID)}" placeholder="Quantity" required="true" type="number" ></td>
          		</c:if>
          		<td><input name="exp${pro.product_ID}" id="exp${pro.product_ID}" type="date" required="true"></td>
          		<td><input name="bat${pro.product_ID}" id="bat${pro.product_ID}" placeholder="Batch No." required="true"></td>
          		
   
         </tr>
         </c:forEach>
        </table>
        <input class="link" type="submit" value="Save" />  
       </form:form>  
</div>
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
		<h1>Give details of Products to Sell</h1>
       <form:form method="post" action="/dbms_project/branch/selldetail">  
      	<table id="tab">
      	 <tr><th>Index No.</th><th>Product</th><th>Quantity</th></tr>   
          <input type="hidden" name="tid" id="tid" value="${key}"/>  	
          		<c:forEach var="n" begin="1" end="${quant}">
          		<tr>
          		<td>${n}:</td>
          		<input type="hidden" name="index" id="index" value="${n}">
          		<td><select name="pid${n}" id="pid${n}" required="true">
          		<c:forEach var="pro" items="${list}">
          		<option value="${pro.product_ID}">${pro.name}</option>
          		</c:forEach>
          		</select></td>
          		<td><input name="q${n}" id="q${n}" placeholder="quantity" required="true" type="number"></td>
          		</tr>
          		</c:forEach>
        </table>
        <input class="link" type="submit" value="Save" />  
       </form:form>  
</div>
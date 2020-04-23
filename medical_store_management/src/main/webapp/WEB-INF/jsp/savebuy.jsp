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
		<h1>New Buying Transaction</h1>
       <form:form method="post" action="/dbms_project/branch/savebuy">  
      	<table id="tab">
      	<form:hidden path="date"/>
      	<form:hidden path="ms_id"/>
      	 <tr>  
          <td>Provider :</td>  
          <td><form:select path="provider_id" required="true">
          		<c:forEach var="prov" items="${list}">
          		<form:option value="${prov.provider_ID}">${prov.provider_Name}</form:option>
          		</c:forEach>
          	</form:select>
          </td>
         </tr>
        </table>  
        <input class="link" type="submit" value="Submit" />
       </form:form>  
</div>
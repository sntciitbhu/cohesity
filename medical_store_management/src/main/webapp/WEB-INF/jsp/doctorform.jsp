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
		<h1>Add New Doctor</h1>
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
       <form:form method="post" action="/dbms_project/doctor/save">  
      	<table id="tab">  
         <tr>  
          <td>Clinic Name : </td> 
          <td><form:input path="clinic_Name" required="true" /></td>
         </tr>  
         <tr>  
          <td>Name :</td>  
          <td><form:input path="name" required="true"/></td>
         </tr>
         <tr>  
          <td>Major Location :</td>  
          <td><form:input path="major_Location" required="true"/></td>
         </tr>
         <tr>  
          <td>Contact Number :</td>  
          <td><form:input path="contact_No" required="true" pattern="[789][0-9]{9}" maxlength="10"/></td>
         </tr>
         <tr>  
          <td>Commision per recommendation:</td>  
          <td><form:input path="commision_per__recommendation" required="true" type="number"/></td>
         </tr> 
        </table>  
        <input class="link" type="submit" value="Save" />
       </form:form>  
</div>
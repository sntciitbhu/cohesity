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
		<h1>Add New Product</h1>
       <form:form method="post" action="/dbms_project/product/save">  
      	<table id="tab">
      	<tr>  
          <td>Product Name : </td> 
          <td><form:input path="name"  /></td>
         </tr>  
         <tr>  
          <td>M.R.P per unit : </td> 
          <td><form:input path="MRP_per_unit"  required="true" type="number"/></td>
         </tr>  
         <tr>  
          <td>Company Name :</td>  
          <td><form:input path="company_Name" required="true"/></td>
         </tr> 
      	<tr>
          <td>Category :</td>  
          <td><form:select path="category_id" required="true" >
          		<c:forEach var="cat" items="${list}">
          		<form:option value="${cat.category_Id}">${cat.category_Name}</form:option>
          		</c:forEach>
          	</form:select>
          </td>
         </tr> 
        </table>  
        <input class="link" type="submit" value="Save" />
       </form:form>  
       </div>

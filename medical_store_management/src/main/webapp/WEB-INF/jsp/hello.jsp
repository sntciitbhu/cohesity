<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="<c:url value="/resources/css/navtable.css" />" rel="stylesheet">
</head>
<body background="${pageContext.request.contextPath}/resources/images/back2.jpg">

	<sec:authorize access="hasRole('ROLE_HEAD')">
		<!-- For login user -->
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
			  <li class="left"><a href="#">Welcome Head ${pageContext.request.userPrincipal.name}</a></li>
			  <li class="right"><a href="javascript:formSubmit()"> Logout</a></li>
			</ul>
		</c:if>
		<div class="loginBox">
		<table id="tab">
		  <tr>
		  <th>Options</th>
		  </tr>
		  <tr>
		  <td><a href="/dbms_project/branch/addstock">Add In Stock</a></td>
		  </tr>
		  <tr>
		  <td><a href="/dbms_project/branch/viewstock">View Stock</a></td>
		  </tr>
		  <tr>
		  <td><a href="/dbms_project/branch/checkcust">New Sale</a></td>
		  </tr>
		  <tr>
		  <td><a href="/dbms_project/branch/savebuy">New Order</a></td>
		  </tr>
		  <tr>
		  <td><a href="/dbms_project/branch/buytrans">Previous Orders</a></td>
		  </tr>
		  <tr>
		  <td><a href="/dbms_project/branch/selltrans">Sales</a></td>
		  </tr>
		  <tr>
		  <td><a href="/dbms_project/branch/expirestock">Expired Stock</a></td>
		  </tr>
		</table>
		</div>


	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_WORK')">
		<!-- For login user -->
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
			  <li class="left"><a href="#">Welcome ${pageContext.request.userPrincipal.name}</a></li>
			  <li class="right"><a href="javascript:formSubmit()"> Logout</a></li>
			</ul>
		</c:if>
		<div class="loginBox">
		<table id="tab">
		  <tr>
		  <th>Options</th>
		  </tr>
		  <tr>
		  <td><a href="/dbms_project/branch/addstock">Add In Stock</a></td>
		  </tr>
		  <tr>
		  <td><a href="/dbms_project/branch/viewstock">View Stock</a></td>
		  </tr>
		  <tr>
		  <td><a href="/dbms_project/branch/checkcust">New Sale</a></td>
		  </tr>
		  <tr>
		  <td><a href="/dbms_project/branch/selltrans">Sales</a></td>
		  </tr>
		  <tr>
		  <td><a href="/dbms_project/branch/expirestock">Expired Stock</a></td>
		  </tr>
		</table>
		</div>


	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<!-- For login user -->
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
			  <li class="left"><a href="#">Welcome Admin ${pageContext.request.userPrincipal.name}</a></li>
			  <li class="right"><a href="javascript:formSubmit()"> Logout</a></li>
			</ul>
		</c:if>
		<div class="loginBox">
		<table id="tab">
		  <tr>
		  <th>Options</th>
		  <th>View</th>
		  <th>Add</th>
		  </tr>
		  <tr>
		  	<td>Medical Store Branches</td>
		  	<td><a href="/dbms_project/msb/viewmsb">View</a></td>
		  	<td><a href="/dbms_project/msb/msbform">Add</a></td>
		  </tr>
		  <tr>
		  	<td>Workers</td>
		  	<td><a href="/dbms_project/worker/viewworker">View</a></td>
		  	<td><a href="/dbms_project/worker/workerform">Add</a></td>
		  </tr>
		  <tr>
		  	<td>Providers</td>
		  	<td><a href="/dbms_project/provider/viewprovider">View</a></td>
		  	<td><a href="/dbms_project/provider/providerform">Add</a></td>
		  </tr>
		  <tr>
		  	<td>Categories</td>
		  	<td><a href="/dbms_project/category/viewcategory">View</a></td>
		  	<td><a href="/dbms_project/category/categoryform">Add</a></td>
		  </tr>
		  <tr>
		  	<td>Products</td>
		  	<td><a href="/dbms_project/product/viewproduct">View</a></td>
		  	<td><a href="/dbms_project/product/productform">Add</a></td>
		  </tr>
		  <tr>
		  	<td>Doctors</td>
		  	<td><a href="/dbms_project/doctor/viewdoctor">View</a></td>
		  	<td><a href="/dbms_project/doctor/doctorform">Add</a></td>
		  </tr>
		  <tr>
		  	<td>Customers</td>
		  	<td><a href="/dbms_project/customer/viewcustomer">View</a></td>
		  	<td><a href="/dbms_project/customer/customerform">Add</a></td>
		  </tr>
		  <tr>
		  	<td>Transactions</td>
		  	<td><a href="/dbms_project/admin/transdate">View</a></td>
		  	<td></td>
		  </tr>
		</table>
		</div>

	</sec:authorize>
</body>
</html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
        <h3>Covid19 India Summary</h3>
        <table class ="table">
        <thead>
        <tr>
            <th>Name</th>
            <th>Active Cases</th>
            <th>Cured</th>
            <th>Deaths</th>
            <th>Total Cases</th>
         </tr>
        </thead>
        <tbody>
        <tr>
           <td>India</td>
           <td>${summary.active}</td>
           <td>${summary.cured}</td>
           <td>${summary.death}</td>
           <td>${summary.total}</td>

       </tr>
        <c:forEach var="state" items="${states}">
            <tr>
              <td>${state.name}</td>
              <td>${state.active}</td>
               <td>${state.cured}</td>
               <td>${state.death}</td>
               <td>${state.total}</td>
             </tr>
        </c:forEach>
           </tbody>
           </table>
    </c:if>
  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="${contextPath}/resources/js/bootstrap.min.js"></script></body>
</html>
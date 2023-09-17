<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>Applications</title>
        <style type="text/css">
        		table,th,td{
        			border: 1px solid black;
        			border-collapse: collapse;
        			padding:8px;
        			text-align: application;
        		}
        </style>
    </head>

    <body>
        <jsp:include page="header.jsp" ></jsp:include>
        <c:if test="${error==true || success==true}">
            ${message}
        </c:if>
        <h2>Applications</h2>
        <table>
            <thead>
                <tr>
                    <th>Application ID</th>
                    <th>Applied For</th>
                    <th>Pet Age (Months)</th>
                    <th>Pet Gender</th>
                    <th>Pet Category</th>
                    <th>Pet Breed</th>
                    <th>Pet Owner</th>
                    <th>Application Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${applications}" var="application">
                <tr>
                    <td>${application.applicationId}</td>
                    <td>${application.petAnimal.petName}</td>
                    <td>${application.petAnimal.petAge}</td>
                    <td>${application.petAnimal.petGender}</td>
                    <td>${application.petAnimal.petCategory}</td>
                    <td>${application.petAnimal.petBreed}</td>
                    <td>${application.petAnimal.petOwner.ownerName}</td>
                    <td>${application.applicationDate}</td>
                </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="8">${message}</td>
                </tr>
            </tfoot>
        </table>
    </body>
</html>
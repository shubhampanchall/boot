<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>Pet :: ${pet.petName}</title>
        <style type="text/css">
        		table,th,td{
        			border: 1px solid black;
        			border-collapse: collapse;
        			padding:8px;
        			text-align: center;
        		}
        </style>
    </head>

    <body>
        <jsp:include page="header.jsp" ></jsp:include>
        <h2>Pet Information</h2>
        <c:if test="${error} eq true">
            <h3>${error}</h3>
        </c:if>
        <table>
    		<thead>
    			<tr>
    				<th colspan="2"><h2>${pet.petName}</h2></th>
    			</tr>
    		</thead>
    		<tbody>
    			<tr>
    				<th>ID</td>
    				<td>${pet.petId}</td>
                </tr>
                <tr>
                    <th>Age</td>
                    <td>${pet.petAge} Months</td>
                </tr>
                <tr>
                    <th>Gender</td>
                    <td>${pet.petGender}</td>
                </tr>
                <tr>
                    <th>Category</td>
                    <td>${pet.petCategory}</td>
                </tr>
                <tr>
                    <th>Breed</td>
                    <td>${pet.petBreed}</td>
                </tr>
                <tr>
                    <th>Status</td>
                    <td>${pet.petStatus==true?"AVAILABLE":"ADOPTED"}</td>
                </tr>
    		</tbody>
    	</table>
    </body>
</html>
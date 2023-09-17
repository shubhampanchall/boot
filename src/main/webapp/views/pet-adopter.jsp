<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>Adopter :: ${adopter.adopterName}</title>
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
        <h2>Adopter Information</h2>
        <c:if test="${error} eq true">
            <h3>${error}</h3>
        </c:if>
        <table>
    		<thead>
    			<tr>
    				<th colspan="2"><h2>${adopter.adopterName}</h2></th>
    			</tr>
    		</thead>
    		<tbody>
    			<tr>
    				<th>ID</td>
    				<td>${adopter.adopterId}</td>
                </tr>
                <tr>
                    <th>Mobile</td>
                    <td>${adopter.adopterMobile}</td>
                </tr>
                <tr>
                    <th>Email</td>
                    <td>${adopter.adopterEmail}</td>
                </tr>
                <tr>
                    <th>Address</td>
                    <td>${adopter.adopterAddress}</td>
                </tr>
    		</tbody>
    	</table>
    </body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Add Pets</title>
	<style type="text/css">
        td{
            border: 1px solid black;
            border-collapse: collapse;
            padding:24px;
            text-align: center;
        }
		.formdiv{
			padding: 8px;
			border: 1px solid black;
			display: inline-block;
			margin-top: 24px;
		}

		.input{
			width: 300px;
			padding: 8px;
		}
	</style>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
    <h2>Pets</h2>
    <c:if test="${error==true || success==true}">
        ${message}
    </c:if>
	<div class="formdiv">
		<form action="add" method="POST">
			<table>
				<thead>
					<tr>
						<th colspan="2"><h3>Add a New Pet</h3></th>
					</tr>
				</thead>
				<tbody>
					<tr>
                        <td>
                            <label for="pet_name">Pet Name</label>
                        </td>
                        <td>
                            <input type="text" name="pet_name" id="pet_name" class="input">
                        </td>
                    </tr>
                    <tr>
						<td>
							<label for="pet_category">Paid Category</label>
						</td>
						<td>
							 <select id="pet_category" name="pet_category" class="input" style="padding:0px">
                                <c:forEach items="${pet_category}" var="pet_category">
                                    <option value="${pet_category}">
                                        ${pet_category}
                                    </option>
                                </c:forEach>
                            </select>
						</td>
					</tr>
					<tr>
                        <td>
                            <label for="pet_age">Pet Age</label>
                        </td>
                        <td>
                            <input type="number" name="pet_age" id="pet_age" class="input">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label for="pet_gender">Pet Gender</label>
                        </td>
                        <td>
                        	<label for="pet_gender_male">Male</label>
                            <input type="radio" name="pet_gender" id="pet_gender_male" value="Male">
                        	<label for="pet_gender_female">Female</label>
                            <input type="radio" name="pet_gender" id="pet_gender_female" value="Female">
                        </td>
                    </tr>

					<tr>
                        <td>
                            <label for="pet_breed">Pet Breed</label>
                        </td>
                        <td>
                            <input type="text" name="pet_breed" id="pet_breed" class="input">
                        </td>
                    </tr>
					<tr>
						<td colspan="2"><button type="submit">Submit</button></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>
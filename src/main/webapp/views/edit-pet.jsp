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
	<title>Edit Pet :: ${pet.petName}</title>
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
			height: 20px;
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
		<form action="/owner/pets/edit" method="POST">
			<table>
				<thead>
					<tr>
						<th colspan="2"><h3>Edit Pet</h3></th>
					</tr>
				</thead>
				<tbody>
					<tr>
                        <td>
                            <label for="pet_name">Pet Name</label>
                        </td>
                        <td>
                            <input type="hidden" value="${pet.petId}" name = "pet_id">
                            <input type="text" value="${pet.petName}" name = "pet_name" class="input">
                        </td>
                    </tr>

                    <tr>
						<td>
							<label for="pet_category">Pet Category</label>
						</td>
						<td>
							<select id="pet_category" name="pet_category" class="input" style="padding:0px">
                                <c:forEach items="${pet_category}" var="pet_category">
                                    <option value="${pet_category}" <c:if test="${pet_category == pet.petCategory}">selected</c:if>>
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
                            <input type="number" id="pet_age" class="input" name="pet_age" value="${pet.petAge}">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label for="pet_gender">Pet Gender</label>
                        </td>
                        <td>
                            <label for="pet_gender_male">Male</label>
                            <input type="radio" id="pet_gender_male" name="pet_gender" value="Male" ${pet.petGender=="Male"?"checked":""}>
                            <label for="pet_gender_female">Female</label>
                            <input type="radio" id="pet_gender_female" name="pet_gender" value="Female" ${pet.petGender=="Female"?"checked":""}>
                        </td>
                    </tr>

					<tr>
                        <td>
                            <label for="pet_breed">Pet Breed</label>
                        </td>
                        <td>
                           <input type="text" id="pet_breed" class="input" name="pet_breed" value="${pet.petBreed}">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label for="pet_status">Pet Status</label>
                        </td>
                        <td>
                            <label for="pet_status_available">AVAILABLE</label>
                            <input type="radio" id="pet_status_available" name="pet_status" value="true" ${pet.petStatus=="true"?"checked":""}>
                            <label for="pet_status_adopted">ADOPTED</label>
                            <input type="radio" id="pet_status_adopted" name="pet_status" value="false" ${pet.petStatus=="false"?"checked":""}>
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
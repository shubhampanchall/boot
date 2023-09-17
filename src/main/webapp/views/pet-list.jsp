<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>Pets</title>
        <style type="text/css">
        		table,th,td{
        			border: 1px solid black;
        			border-collapse: collapse;
        			padding:8px;
        			text-align: pet;
        		}
        </style>
    </head>

    <body>
        <jsp:include page="header.jsp" ></jsp:include>
        <c:if test="${error==true || success==true}">
            ${message}
        </c:if>
        <h2>Pets</h2>
        <table>
            <thead>
                <tr>
                    <th colspan="9">
                        <form action="/adopter/pets/search">
                            <select id="pet_category" name="pet_category" class="input" style="padding:0px">
                                <option value="">SELECT CATEGORY</option>
                                <c:forEach items="${pet_category}" var="pet_category">
                                    <option value="${pet_category}">
                                        ${pet_category}
                                    </option>
                                </c:forEach>
                            </select>
                            <select id="pet_gender" name="pet_gender" class="input" style="padding:0px">
                                <option value="">SELECT GENDER</option>
                                <c:forEach items="${pet_gender}" var="pet_gender">
                                    <option value="${pet_gender}">
                                        ${pet_gender}
                                    </option>
                                </c:forEach>
                            </select>
                            <input type="text" name="pet_breed" placeholder="Breed">
                            <input type="submit" value="Search">
                        </form>
                    </th>
                </tr>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Age (Months)</th>
                    <th>Gender</th>
                    <th>Category</th>
                    <th>Breed</th>
                    <th>Owner</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${pets}" var="pet">
                <tr>
                    <td>${pet.petId}</td>
                    <td>${pet.petName}</td>
                    <td>${pet.petAge}</td>
                    <td>${pet.petGender}</td>
                    <td>${pet.petCategory}</td>
                    <td>${pet.petBreed}</td>
                    <td>${pet.petOwner.ownerName}</td>
                    <td>${pet.petStatus==true?"AVAILABLE":"ADOPTED"}</td>
                    <td>
                        <a href="/adopter/pets/${pet.petId}"><button>View</button></a>
                        <form action="/adopter/pets/apply">
                            <input type="hidden" value="${pet.petId}" name="pet_id">
                            <button type="submit" ${pet.petStatus==false?"disabled":""}>Apply to Adopt</button>
                        </form>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="9">${message}</td>
                </tr>
            </tfoot>
        </table>
    </body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: Victor
  Date: 29.07.2017
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<table class="table">
<thead>
<tr>
    <th>Type</th>
    <th>Image</th>
    <th>Name</th>
    <th>Brand</th>
    <th>Size</th>
    <th>Gender</th>
    <th>Price</th>
    <th>Action</th>

</tr>
</thead>
<tbody>
<c:forEach var="shirt" items="${shirts}">
    <tr>
        <td>${shirt.getType().getType()}</td>
        <td><c:if test="${shirt.pathImage==null}"> <img src="resources/default/no_image.png" style="width: 75px; height: auto;"></c:if>
            <c:if test="${shirt.pathImage!=null}"> <img src="${shirt.pathImage}" style="width: 75px; height: auto;"></td></c:if>
        <td>${shirt.getShirtName()}</td>
        <td>${shirt.getBrand().getBrandName()}</td>
        <td>${shirt.getSize()}</td>
        <td>${shirt.getGender().getGenderName()}</td>
        <td>${shirt.getPrice()}</td>

        <sec:authorize access="hasAuthority('ROLE_ADMIN')">
        <td><a href="/deleteShirt/${shirt.id}}">Delete</a> </td>
        </sec:authorize>
        <td><a href="/buyShirt/${shirt.id}">Buy</a> </td>
    </tr>

</c:forEach>
</tbody>
</table>
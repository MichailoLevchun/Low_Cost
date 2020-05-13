<%--
  Created by IntelliJ IDEA.
  User: Victor
  Date: 04.08.2017
  Time: 1:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<form:form method="post" action="/newShirt?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">

    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Name</label>
        <div class="col-sm-10">
            <input name="name" type="text" class="form-control" id="name" required="required">
        </div>
    </div>


    <div class="form-group">
        <label for="price" class="col-sm-2 control-label">Price</label>
        <div class="col-sm-10">
            <input name="price" type="number" class="form-control" id="price" required min="1">
        </div>
    </div>
    <div class="form-group">
        <label for="price" class="col-sm-2 control-label">Size</label>
        <div class="col-sm-10">
            <input name="size" type="number" class="form-control" id="size" required min="1">
        </div>
    </div>

<div class="form-group">
    <label for="brand" class="col-sm-2 control-label">Brand</label>
    <div class="col-sm-10">
        <select name="brand" required class="form-control" style="width: 200px">
            <option value="">Choose please</option>
            <c:forEach var="brand" items="${brands}">
                <option value="${brand.id}">${brand.getBrandName()}</option>
            </c:forEach>
        </select>
    </div>
</div>
<div class="form-group">
    <label for="brand" class="col-sm-2 control-label">Type</label>
    <div class="col-sm-10">
        <select name="type" required class="form-control" style="width: 200px">
            <option value="">Choose please</option>
            <c:forEach var="type" items="${shirt_types}">
                <option value="${type.id}">${type.getType()}
                </option>
            </c:forEach>
        </select>
    </div>
</div>
<div class="form-group">
    <label for="brand" class="col-sm-2 control-label">Gender</label>
    <div class="col-sm-10">
        <select name="gender" required class="form-control" style="width: 200px">
            <option value="">Choose please</option>
            <c:forEach var="gender" items="${genders}">
                <option value="${gender.id}">${gender.getGenderName()}</option>
            </c:forEach>
        </select>
    </div>
</div>
    <div class="form-group">
        <input type="file" class="form-control btn btn-default" name="image" required>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-success">Save</button>
        </div>
    </div>

</form:form>
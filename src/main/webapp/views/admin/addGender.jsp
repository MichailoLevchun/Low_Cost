<%--
  Created by IntelliJ IDEA.
  User: Victor
  Date: 04.08.2017
  Time: 2:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="row">
    <div class="col-md-6">
        <div class="content-box-large">
            <div class="panel-heading">
                <div class="panel-title">Add new Shirt Type</div>
            </div>
            <div class="panel-body">
                <form:form action="/newGender" method="post" >
                    <div class="form-group">
                        <input  type="text" class="form-control" name="name" placeholder="Please enter Brand name" required>
                    </div>
                    <button type="submit" class="btn btn-success">Add Gender</button>
                </form:form>
            </div>
        </div>
    </div>
</div>
<div class="col-md-6">
    <div class="content-box-large">
        <div class="panel-heading">
            <div class="panel-title">Gender List</div>
        </div>
        <div class="panel-body">
            <table class="table">
                <thead>
                <tr>
                    <th>Brand Name</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="gender" items="${genders}">
                    <tr>
                        <td>${gender.getGenderName()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
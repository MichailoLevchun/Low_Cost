<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>


<div class="container">

    <div class="panel">
        <sf:form modelAttribute="brand" method="post">
            <div style="display: flex; justify-content: space-around ">

                <div class="form-group">
                    <label class="sr-only" for="exampleInputEmail3">Email address</label>
                    <sf:input path="brandName" type="text" class="form-control" id="exampleInputEmail3"
                              placeholder="ingredient name"/>
                </div>

                <div class="form-group">
                    <button class="btn btn-default">save brand</button>
                </div>
            </div>
        </sf:form>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>ingredient name</th>
                <th>delete</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="ingredient" items="${brand.content}">
                <tr>
                    <td>
                            ${brand.brandName}
                    </td>
                    <td>
                        <a href="deleteIngredient/${ingredient.id}">delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%--<a href="/ingredient?page=${ingredients.number}&size=${ingredients.size}">previous</a>--%>
<%--<a href="/ingredient?page=${ingredients.number+ 2}&size=${ingredients.size}">next</a>--%>
<div style="display: flex; justify-content: center;text-align: center">

    <div class="col-md-12 col-xs-12">
        <div class="row">
            <div class="col-md-2 col-xs-6">
                <div class="dropdown">
                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort <span
                            class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <custom:sort innerHtml="Name asc" paramValue="ingredientName"/>
                        <custom:sort innerHtml="Name desc" paramValue="ingredientName,desc"/>
                    </ul>
                </div>
            </div>
            <div class="col-md-8 col-xs-12 text-center">
                <custom:pageable page="${ingredients}" cell="<li></li>" container="<ul class='pagination'></ul>"/>
            </div>
            <div class="col-md-2 col-xs-6">
                <custom:size posibleSizes="1,2,5,10" size="${ingredients.size}"/>
            </div>
        </div>
    </div>
</div>



input type="hidden" name="csrf_name"
value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />

<script>$('#savebrand').click(function () {

    var brand = {
        name: $('#brandName').val()
    };
    $.ajax({
        url : '/brand?'+ $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method : 'POST',
        contentType: 'application/json; charset=UTF-8',
        dataType:'json',
        data: JSON.stringify(shirt),
        success: function (res) {

        }

    })
})</script>
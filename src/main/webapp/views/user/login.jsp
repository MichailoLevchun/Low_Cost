<%--
  Created by IntelliJ IDEA.
  User: Victor
  Date: 31.07.2017
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form:form action="/login" method="post">
    <center>
    <div class="form-group" style="width: 200px; margin-top: 100px">
        <label for="email">Account name</label>
        <input type="text" class="form-control" id="email" placeholder="Введите email" name="username">



        <label for="pass">Password</label>
        <input type="password" class="form-control" id="pass" placeholder="Пароль" name="password">
    </div>
    <button type="submit" class="btn btn-success">Login</button>
        <span><p>Haven`t got account yet? <a  href="/register" style="color: khaki">Register</a></p></span>
    </center>
</form:form>

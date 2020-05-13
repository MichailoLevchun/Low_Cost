<%--
  Created by IntelliJ IDEA.
  User: Victor
  Date: 04.08.2017
  Time: 2:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<center>
<div class="sign-in-page">

        <!-- create a new account -->
        <div class="col-md-6 col-sm-6 create-new-account">
            <h4 class="checkout-subtitle">Create a new account</h4>
            <p class="text title-tag-line">Create your new account.</p>
            <form:form  action="/register"  method="post">
                <div class="form-group">
                    <label class="info-title" for="exampleInputEmail">Email Address <span>*</span></label>
                    <input name="email" type="email" class="form-control unicase-form-control text-input" id="exampleInputEmail" placeholder="Your Email"/>
                    <span>${emailException}</span>
                </div>
                <div class="form-group">
                    <label class="info-title" for="exampleInputName">Name <span>*</span></label>
                    <input  name="name" type="text" class="form-control unicase-form-control text-input" id="exampleInputName" placeholder="Your Login Name"/>
                    <span>${usernameException}</span>
                </div>
                <div class="form-group">
                    <label class="info-title" for="new-password">Password (At least 6 characters) <span>*</span></label>
                    <input name="password"  type="password"   class="form-control unicase-form-control text-input" id="new-password"/>
                    <span>${passwordException}</span>
                </div>
                <div class="form-group">
                    <label class="info-title" for="confirm-password">Confirm Password <span>*</span></label>
                    <input  name="confirmPass" class="form-control unicase-form-control text-input" id="confirm-password">
                    <span id="confirmMessage" class="confirmMessage"></span>
                </div>
                <button type="submit" id="submit-btn" class="btn-upper btn btn-primary checkout-page-button" >Sign Up</button>
            </form:form>
        </div>

</div>
</center>
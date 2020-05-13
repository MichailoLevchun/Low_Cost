<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!--Google -Fonts-->
<link href='https://fonts.googleapis.com/css?family=Sintony:400,700&subset=latin-ext' rel='stylesheet' type='text/css'>

<!--Font-awsome-->
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<div class="body-wrap">
    <div class="container">
        <nav class="navbar navbar-inverse" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/">LOW COST SHIRT SHOP</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">

                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Shirts <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/allShirtList">All</a> </li>
                                <c:forEach var="type" items="${shirt_types}">
                                    <li><a href="shirts/${type.id}">${type.getType()}</a></li>
                                </c:forEach>
                            </ul>
                        </li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <sec:authorize access="!isAuthenticated()">
                        <li><a href="/login">Login</a></li>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                            <li><a href="/account">Account</a></li>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                            <li><form:form action="/logout" method="post">
                                <button class="btn-log-out">LogOut</button>
                            </form:form>
                            </li>
                        </sec:authorize>
                        <sec:authorize access="hasAuthority('ROLE_ADMIN')">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/addShirt">Add Shirt</a></li>
                                <li><a href="/addShirtType">Add Shit Type</a></li>
                                <li><a href="/addBrand">Add Brand</a></li>
                                <li><a href="/addGender">Add Gender</a></li>
                            </ul>
                        </li>
                        </sec:authorize>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container-fluid -->
        </nav>
    </div>
</div>











<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<style>
    body {
        font-family: 'PT Sans', sans-serif;
        font-size: 13px;
        font-weight: 400;
        color: #4f5d6e;
        position: relative;
        background: rgb(26, 49, 95);
        background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, rgba(26, 49, 95, 1)), color-stop(10%, rgba(26, 49, 95, 1)), color-stop(24%, rgba(29, 108, 141, 1)), color-stop(37%, rgba(41, 136, 151, 1)), color-stop(77%, rgba(39, 45, 100, 1)), color-stop(90%, rgba(26, 49, 95, 1)), color-stop(100%, rgba(26, 49, 95, 1)));
        filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#1a315f', endColorstr='#1a315f', GradientType=0);
    }

    .body-wrap {
        /*min-height: 700px;*/
    }

    .body-wrap {
        position: relative;
        z-index: 0;
    }

    .body-wrap:before,
    .body-wrap:after {
        content: '';
        position: absolute;
        top: 0;
        left: 0;
        right: 0;
        z-index: -1;
        height: 260px;
        background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, rgba(26, 49, 95, 1)), color-stop(100%, rgba(26, 49, 95, 0)));
        background: linear-gradient(to bottom, rgba(26, 49, 95, 1) 0%, rgba(26, 49, 95, 0) 100%);
        filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#1a315f', endColorstr='#001a315f', GradientType=0);
    }

    .body-wrap:after {
        top: auto;
        bottom: 0;
        background: linear-gradient(to bottom, rgba(26, 49, 95, 0) 0%, rgba(26, 49, 95, 1) 100%);
        filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#001a315f', endColorstr='#1a315f', GradientType=0);
    }

    nav {
        margin-top: 60px;
        box-shadow: 5px 4px 5px #000;
    }


</style>

<script>
    $('ul.nav li.dropdown').hover(function() {
        $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeIn(500);
    }, function() {
        $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeOut(500);
    });


</script>
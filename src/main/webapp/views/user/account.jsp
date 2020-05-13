<%--
  Created by IntelliJ IDEA.
  User: Victor
  Date: 25.08.2017
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2 class="main-heading2 page-title">Shopping Cart</h2>
<div class="shopping-cart">

    <div class="shopping-cart-table">
        <div class="table-responsive">
            <h2>Your cart</h2>
            <table class="table">
                <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Brand</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Date</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach var="order" items="${orders}">
                    <c:forEach var="commodity" items="${order.getShirts()}">
                        <tr>
                            <td>${order.id}</td>
                            <td>${commodity.brand.getBrandName()}</td>
                            <td><a href="/details/${commodity.id}"> ${commodity.shirtName}</a></td>
                            <td>${commodity.price}</td>
                            <td>${order.date}</td>

                        </tr>
                    </c:forEach>
                    <tr>
                        <c:if test="${order.isOpen()}">
                            <td><a href="/buy/${order.id}">buy</a></td>
                        </c:if>
                        <td>
                            Status: <c:if test="${order.isOpen()}"> Open</c:if>
                            <c:if test="${order.isOpen()==false}"> Close </c:if>
                        </td>
                        <td>
                            <i class="fa fa-times" aria-hidden="true"></i> <a href="/deleteOrder/${order.id}">delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

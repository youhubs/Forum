<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" import="java.util.*" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="header clearfix">
    <div class="w">
        <h1 class="logo"><a href="#">YouHubs</a></h1>
        <ul class="left-nav">
            <li class="current-nav"><a href="#">Home</a></li>
            <li><a href="#">Topics</a></li>
            <li><a href="#">Posts</a></li>
            <li><a href="#">News</a></li>
        </ul>

        <ul class="right-nav">
            <c:choose>
                <c:when test="${sessionScope.uid != null}">
                    <li class="login2 relative">
                        <a href="toMyProfile.do" id="profile"><img src="${sessionScope.headUrl}"></a>
                        <ul id="down-menu">
                            <li><a href="toMyProfile.do">Profile</a></li>
                            <li><a href="logout.do">LogOut</a></li>
                        </ul>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="login">
                        <a href="toLogin.do">Login</a>
                        <a href="toLogin.do">/</a>
                        <a href="toLogin.do#register">SignUp</a>
                    </li>
                </c:otherwise>
            </c:choose>

                <li>
                    <a href="#"><span class="glyphicon glyphicon-search"></span></a>
                </li>
                <li><input type="text"></li>
        </ul>
    </div>
</div>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header id="top" class="fixed_nav">
    <div id="logo" class="lf">
        <img class="animated jello" src="../images/header/logo.png" alt="logo"/>
    </div>
    <div id="top_input" class="lf">
        <input style="width:350px" id="input" type="text" placeholder="请输入您要搜索的内容"/>
        <a href="search.html" class="rt"><img id="search" src="../images/header/search.png" alt="搜索"/></a>
    </div>
    
    <div class="rt">
        <ul class="lf">
            <li><a href="${pageContext.request.contextPath}/user/showPassword.do">${sessionScope.user.username}</a></li>
            <li><a href="favorites.html" title="我的收藏"><img class="care" src="../images/header/care.png" alt=""/></a><b>|</b></li>
            <li><a href="orders.html" title="我的订单"><img class="order" src="../images/header/order.png" alt=""/></a><b>|</b></li>
            <li><a href="${pageContext.request.contextPath}/cart/showCart.do" title="我的购物车"><img class="shopcar" src="../images/header/shop_car.png" alt=""/></a><b>|</b></li>
            <li><a href="help.html">帮助</a><b>|</b></li>
            <li>
              <c:if test="${user==null}">
                 <a href="${pageContext.request.contextPath}/user/showLogin.do">登录</a>
              </c:if>
              <c:if test="${user!=null }">
                  <a href="${pageContext.request.contextPath}/user/exit.do">退出</a>
              </c:if>
            </li>
        </ul>
    </div>
</header>
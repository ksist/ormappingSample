<%-- 
    Document   : bookOrderList
    Created on : 2015/09/13, 14:13:52
    Author     : kasai
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script language="JavaScript"> 
            function customerSelect(){
                document.customerForm.submit(); 
            }
        </script>
        <title>注文履歴一覧</title>
    </head>
    <body>
        <h1>注文履歴一覧</h1>
        <form name="customerForm" action="bookOrderList">
        注文者
        <select name="customerIndex" onchange="customerSelect()">
            <c:forEach items="${customers}" var="customer" varStatus="status">
                <c:choose>
                    <c:when test="${id == status.index}">
                        <option value="${status.index}" selected="true">
                    </c:when>
                    <c:otherwise>
                        <option value="${status.index}">
                    </c:otherwise>
                </c:choose>
                <c:out value="${customer}" /></option>
            </c:forEach>
        </select>
        </form>
        <table border="1">
            <tr>
                <th></th>
                <th>注文ID</th>
                <th>注文日時</th>
                <th>注文個数</th>
            </tr>
                <c:forEach items="${orderList}" var="order" >
                    <tr>
                        <td>
                            <a href="./bookOrderDetail?id=${order.id}" >確認</a>
                        </td>
                        <td>
                            <c:out value="${order.id}" />
                        </td>
                        <td>
                            <fmt:formatDate value="${order.orderDate}" type="date" dateStyle="medium"/>
                        </td>
                        <td>
                            <c:out value="${order.items.size()}" />
                        </td>
                    </tr>
                </c:forEach>
        </table>
        <a href="./" >メニューに戻る</a>
    </body>
</html>

<%-- 
    Document   : bookOrderList
    Created on : 2015/09/13, 14:13:52
    Author     : kasai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>注文履歴一覧</title>
    </head>
    <body>
        <h1>注文履歴一覧</h1>
        注文者
        <select name="customerName">
            <c:forEach items="${customers}" var="customer">
                <c:choose>
                    <c:when test="${id == customer}">
                        <option value="${customer}" selected="true">
                    </c:when>
                    <c:otherwise>
                        <option value="${customer}">
                    </c:otherwise>
                </c:choose>
                <c:out value="${customer}" /></option>
            </c:forEach>
        </select>
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
                            <a href="" >確認</a>
                        </td>
                        <td>
                            <c:out value="${order.id}" />
                        </td>
                        <td>
                            <c:out value="${order.shippingDate}" />
                        </td>
                        <td>
                            <c:out value="" />
                        </td>
                    </tr>
                </c:forEach>
        </table>
        <a href="./" >メニューに戻る</a>
    </body>
</html>

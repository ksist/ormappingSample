<%-- 
    Document   : bookOrderFinish
    Created on : 2015/09/12, 14:57:43
    Author     : kasai
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>書籍注文完了</title>
    </head>
    <body>
        <h1>書籍注文完了</h1>
        <div>ご注文ありがとうございました。</div>
        <div>
            <table>
                <tr>
                    <td>注文ID：</td>
                    <td>${order.id}</td>
                </tr>
                <tr>
                    <td>注文者：</td>
                    <td>${order.customerName}</td>
                </tr>
                <tr>
                    <td>注文日時：</td>
                    <td><fmt:formatDate value="${order.orderDate}" type="both" dateStyle="medium" /></td>
                </tr>
            </table>
        </div>
        <div>
            注文リスト
            <table border="1">
                <tr>
                    <th>
                        書籍名
                    </th>
                    <th>
                        発送予定日
                    </th>
                </tr>
                <c:forEach items="${order.items}" var="item">
                    <tr>
                        <td>
                            <c:out value="${item.book.bookName}" />
                        </td>
                        <td>
                            <fmt:formatDate value="${item.shippingDate}" type="date" dateStyle="medium"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <a href="./" >メニューに戻る</a>
    </body>
</html>

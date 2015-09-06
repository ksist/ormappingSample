<%-- 
    Document   : bookOrder
    Created on : 2015/09/06, 13:42:53
    Author     : kasai
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>書籍注文ページ</title>
    </head>
    <body>
        <h1>書籍注文ページ</h1>
        <form action="bookOrder" method="POST">
            注文者
            <input type="text" name="customerName" />
            <p>注文リスト</p>
            <table border="1">
                <tr>
                    <th></th>
                    <th>注文する書籍</th>
                </tr>
                <c:forEach items="${bookList}" var="id" varStatus="loop">
                    <tr>
                        <td><input type="submit" value="削除" /></td>
                        <td>
                            <select name="bookList[${loop.index}]">
                                <c:forEach items="${books}" var="book">
                                    <c:choose>
                                        <c:when test="${id == book.id}">
                                            <option value="${book.id}" selected="true"><c:out value="${book.bookName}" /></option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${book.id}"><c:out value="${book.bookName}" /></option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td><input type="submit" value="追加" /></td>
                    <td>
                        <select name="bookList[${loop.count}]">
                            <c:forEach items="${books}" var="book">
                                <option value="${book.id}"><c:out value="${book.bookName}" /></option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
            <input type="submit" value="注文する" /><br>
        </form>
        <a href="./" >メニューに戻る</a>
    </body>
</html>

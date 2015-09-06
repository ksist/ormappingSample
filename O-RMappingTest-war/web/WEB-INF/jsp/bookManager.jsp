<%-- 
    Document   : BookManager
    Created on : 2015/09/05, 12:00:46
    Author     : kasai
--%>

<%@page import="ksist.ormapping.sample.entity.Book"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>書籍管理</title>
    </head>
    <body>
        <h1>書籍管理</h1>
        <table border="1">
            <tr>
            <th></th>
            <th>ID</th>
            <th>種別</th>
            <th>書籍名</th>
            <th>在庫数</th>
            </tr>
            <c:forEach items="${books}" var="book">
                <tr>
                <td>
                    <a href="">編集</a>
                    <form action="deleteBook" method="POST">
                        <input type="submit" value="削除" />
                        <input type="hidden" name="bookId" value="${book.id}" />
                    </form>
                </td>
                <td><c:out value="${book.id}" /></td>
                <td>
                    <%
                        Book test = (Book) pageContext.getAttribute("book");
                    %>
                    <%= test.getType() %>
                </td>
                <td><c:out value="${book.bookName}" /></td>
                <td><c:out value="${book.stockCount}" /></td>
                </tr>
            </c:forEach>
            <tr>
            <form action="addBook" method="POST">
                <td><input type="submit" value="追加" /></td>
                <td></td>
                <td>
                    <input type="radio" name="bookType" value="japanese" checked="checked"/>和書<br>
                    <input type="radio" name="bookType" value="foreign" />洋書
                </td>
                <td><input type="text" name="bookName" /></td>
                <td><input type="text" name="stockCount" /></td>
            </form>
            </tr>
        </table>
        <a href="./" >メニューに戻る</a>
    </body>
</html>

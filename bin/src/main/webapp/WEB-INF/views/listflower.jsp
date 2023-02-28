<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List Flower</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css"
        rel="stylesheet" type="text/css" />
</head>
<body>
    <div class="container">
        <h2>List Flower</h2>
        <div id="add_new_user">
            <c:url var="homeUrl" value="/home" />
            <a id="add" href="${homeUrl}" class="btn btn-success">Home</a>
        </div>
        <div></div>

        <!-- Table to display the user list from the mongo database -->
        <table id="users_table" class="table">
            <thead>
                <tr align="center">
                    <th>Id</th>
                    <th>Name</th>
                    <th colspan="2"></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${flowers}" var="flower">
                    <tr align="center" textcolor="red">
                        <td><c:out value="${flower.flowerid}" /></td>
                        <td><c:out value="${flower.name}" /></td>
                        <td><c:url var="editUrl" value="/flower/edit/${flower.flowerid}" /><a
                            id="update" href="${editUrl}" class="btn btn-warning">Update</a>
                        </td>
                        <td><c:url var="deleteUrl" value="/flower/delete/${flower.flowerid}" /><a
                            id="delete" href="${deleteUrl}" class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>

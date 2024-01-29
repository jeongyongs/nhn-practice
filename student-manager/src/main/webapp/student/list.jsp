<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://nhnacademy.com/cfmt" prefix="cfmt" %>

<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>학생 리스트</title>
    <style>
        table {
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid gray;
        }
    </style>
</head>
<body>
<div id="container">
    <h1>학생 리스트</h1>
    <p><a href="/student/register">학생(등록)</a></p>
    <table>
        <caption>학생 리스트</caption>
        <thead>
        <tr>
            <th>아이디</th>
            <th>이 름</th>
            <th>성 별</th>
            <th>나 이</th>
            <th>cmd</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="student" items="${studentList}">
            <tr>
                <td><a href="/student/view?id=${student.id}">${student.id}</a></td>
                <td>${student.name}</td>
                <td>${student.gender}</td>
                <td>${student.age}</td>
                <td>${cfmt:formatDate(student.createdAt, 'yyyy-MM-dd HH:mm:ss')}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
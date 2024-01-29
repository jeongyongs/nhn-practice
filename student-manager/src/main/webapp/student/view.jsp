<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://nhnacademy.com/cfmt" prefix="cfmt" %>

<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>학생 상세정보</title>
    <style>
        table {
            border-collapse: collapse;
        }

        td {
            border: 1px solid gray;
        }
    </style>
</head>
<body>
<div id="container">
    <table>
        <tbody>
        <tr>
            <td>아이디</td>
            <td>${studentDetail.id}</td>
        </tr>
        <tr>
            <td>이 름</td>
            <td>${studentDetail.name}</td>
        </tr>
        <tr>
            <td>성 별</td>
            <td>${studentDetail.gender}</td>
        </tr>
        <tr>
            <td>나 이</td>
            <td>${studentDetail.age}</td>
        </tr>
        <tr>
            <td>등록일</td>
            <td>${cfmt:formatDate(studentDetail.createdAt, "YYYY-MM-dd hh:mm:ss") }</td>
        </tr>
        </tbody>
    </table>
    <span><a href="/student/list">리스트</a></span>
    <span><a href="#">수정</a></span>
    <input type="submit" value="삭제"/>
</div>
</body>
</html>
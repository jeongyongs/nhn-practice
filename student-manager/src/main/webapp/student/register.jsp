<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>학생 등록</title>
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
    <form action="/student/register" method="post">
        <table>
            <tbody>
            <tr>
                <td>아이디</td>
                <td><input type="text" name="id" id="id"></td>
            </tr>
            <tr>
                <td>이 름</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>성 별</td>
                <td>
                    <input type="radio" name="gender" value="male" checked>남
                    <input type="radio" name="gender" value="female">여
                </td>
            </tr>
            <tr>
                <td>나 이</td>
                <td><input type="number" name="age" id="age"></td>
            </tr>
            </tbody>
        </table>
        <button type="submit">등 록</button>
    </form>
</div>
</body>
</html>
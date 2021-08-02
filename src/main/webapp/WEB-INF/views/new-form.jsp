<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>

<!-- 상대경로 사용, [현재 URL이 속한 계층 경로 + /save] -->
<form action="save" method="post">  <!-- action="save" 는 상대 경로임 8080/servlet-mvc/member/save로 이동함 -->
                                    <!-- action="/save" 는 절대 경로임 8080/save로 이동함 -->
  username: <input type="text" name="username" />
  age: <input type="text" name="age" />
  <button type="submit">전송</button>
</form>

</body>
</html>
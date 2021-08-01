<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%    //자바코드를 넣는 공간

  //MemberSaveServlet에 있던 코드와 동일함
  //request, response는 그대로 사용 가능 -> jsp도 결국엔 servlet으로 변환되서 사용됨
  MemberRepository memberRepository  = MemberRepository.getInstance();

  System.out.println("MemberSaveServlet.service");
  String username = request.getParameter("username");
  int age = Integer.parseInt(request.getParameter("age"));


  Member member = new Member(username, age);
  memberRepository.save(member);

%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

성공

<ul>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>

<a href="/index.html">메인</a>
</body>
</html>

<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="java.util.List" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  //MemberListServlet에 있는 코드
  MemberRepository memberRepository = MemberRepository.getInstance();
  List<Member> members = memberRepository.findAll();
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Members</title>
</head>
<body>

<a href="/index.html">메인</a>

<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>

    <tbody>
    <%
      for(Member member: members){
        out.write("   <tr>\n");
        out.write("     <td>" + member.getId() + "</td>\n");
        out.write("     <td>" + member.getUsername() + "</td>\n");
        out.write("     <td>" + member.getAge() + "</td>\n");
        out.write("   </tr>\n");
      }
    %>
    </tbody>
</table>

</body>
</html>

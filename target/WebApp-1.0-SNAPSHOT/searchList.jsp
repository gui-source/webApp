<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Searching</title>
</head>
<body>
<jsp:include page="/header.jsp"/>

<div class="main">
<%
    String keyword = (String) request.getAttribute("keyword");
    List<String> res = (List<String>) request.getAttribute("res");
    List<String> resLinks = (List<String>) request.getAttribute("resLinks");

%>
<h2>Search Result for "<%=keyword%>"</h2>
<%
    int si = res.size();
        if (si !=0){
%>
    <ul>
    <%
        for (int i = 0; i < si; i ++ )
        {
            String label = res.get(i);
            String link = resLinks.get(i);
    %>
        <li><a href="<%=link%>"> <%=label%> </a></li>
    <%
        }
    %>
    </ul>
<%
    } else {
%>
      <p>Nothing found</p>
<%
    }
%>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
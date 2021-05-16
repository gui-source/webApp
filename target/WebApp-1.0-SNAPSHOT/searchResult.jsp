<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="uk.ac.ucl.model.Model" %>
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
    %>
  <h2>Search Result for "<%=keyword%>"</h2>
  <%
    List<String> lists = (ArrayList<String>) request.getAttribute("result");
    if (lists.size() !=0)
    {
    %>
    <ul>
      <%
        for (String list : lists)
        {
            String href = "displayList.html?fileName=" + list;
      %>
        <li><a href="<%=href%>"> <%=Model.extractListName(list)%> </a></li>
     <% }
    } else
    {%>
      <p>Nothing found</p>
  <%}%>
  </ul>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
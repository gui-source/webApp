<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.Model" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Displaying all lists</title>
</head>
<body>
<jsp:include page="/header.jsp"/>

<div class="main">
    <%
        List<String> items = (List<String>) request.getAttribute("stringItems");
        String action = "addList.html";
    %>
  <h2>Lists:</h2>
  <ul>
    <%
        String href;
        for (String item : items)
        {
            String noTxtItem = item.substring(0, item.length()-4);
            href = "displayList.html?fileName="+item;
    %>
    <li><a href="<%=href%>"><%=noTxtItem%></a>
    </li>
    <% } %>
  </ul>
</div>
<div>
    <p>
    <form method="POST" action="<%=action%>">
        <label for="newList">Add a list: </label>
        <input type="text" id="newList" name="newList" value="">
        <input type="submit" value="Save name"/>
    </form>

</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>

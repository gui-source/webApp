<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.Model" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Displaying a list</title>
</head>
<body>
<jsp:include page="/header.jsp"/>

<div class="main">
    <%
        List<String> items = (List<String>) request.getAttribute("stringItems");
        String fileName= request.getParameter("fileName");
    %>
    <h2>List name: <%=Model.extractListName(fileName)%></h2>
    <h2>Reference to this list: <%="displayList.html?fileName="+fileName%></h2>
  <h2>Contents:</h2>
  <ul>
    <%
        String href;
        String addItem = "addItem.html?fileName="+fileName;
        String deleteUrl = "deleteList.html?fileName="+fileName;
        int index = 0;
        for (String item : items)
        {
            String noTxtItem = item;
            // might want to impose restriction on labels - they must have at least length 1 and not fully whitespace
            if (noTxtItem.length() == 0){
                noTxtItem = "-";
            }
            href = "item.html?fileName="+fileName+"&itemLabel="+item+"&index="+index;
            index ++;
    %>
    <li><a href="<%=href%>"><%=noTxtItem%></a>
    </li>
    <% } %>
  </ul>
</div>
<div>
    <p>
        <a href=<%=addItem%>>Add an Item</a>
    </p>
    <p>
        <a href="<%=deleteUrl%>">Delete this list</a>
    </p>
    <p>
        <a href="displayAllLists.html">Back to lists</a>
    </p>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>

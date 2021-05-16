<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.Model" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>Displaying an item</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
    <%
        String fileName = (String) request.getAttribute("fileName");
    %>
    <h2>
        From list: <%=Model.extractListName(fileName)%>
    </h2>
    <%
        int index =  (Integer) request.getAttribute("index");
        String label = (String) request.getAttribute("itemLabel");
        String contents = (String) request.getAttribute("itemContents");
        boolean isLink = false;
        if (contents.contains("http://") || contents.contains("https://") || contents.contains(".html")){
            isLink = true;
        }
        Boolean edit = (Boolean)request.getAttribute("edit");
    %>
    <h2>
        Label: <%=label%>
    </h2>
    <%if (isLink){%>
    <p>
        Content: <a href = "<%=contents%>"><%=contents%></a>
    </p>
    <%} else {%>
    <p>
        Contents: <%=contents%>
    </p>
    <%}%>
</div>
<div class="edit">
    <%
        String params = "fileName=" + fileName + "&itemLabel=" + label+"&index="+index;
        String editLink = "editItem.html?" + params;
        String listLink = "displayList.html?"+params;
        String deleteLink = "deleteItem.html?" + params;
    %>
    <% if (edit){%>
    <p>
        <a href="<%=editLink%>">edit item</a>
    </p>
    <p>
        <a href="<%=deleteLink%>">delete item</a>
    </p>
    <p>
        <a href="<%=listLink%>">back to list</a>
    </p>
    <%}%>

</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>

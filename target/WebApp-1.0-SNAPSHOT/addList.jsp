<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>Editing an item</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
    <%
        int index = (Integer) request.getAttribute("index");
        String label = (String) request.getAttribute("itemLabel");
        String contents = (String) request.getAttribute("itemContent");
        String fileName = request.getParameter("fileName");
        String listUrl = "/displayList.html?fileName="+fileName;
        String action = "/editItem.html?fileName="+fileName+"&index="+index;
    %>
    <form method="POST" action="<%=action%>">
        <label for="newLabel">Label: </label>
        <input type="text" id="newLabel" name="newLabel" value="<%=label%>">
        <label for="newContent">Content: </label>
        <input type="text" id="newContent" name="newContent" value="<%=contents%>">
        <input type="submit" value="Save changes"/>
    </form>
</div>
<div>
    <%
        action = "item.html?fileName="+fileName+"&index="+index;
    %>
    <p>
        <a href=<%=action%>>Back to item</a>
    </p>
</div>
<div class="return">

    <p>
        <a href=<%=listUrl%>>Back to original list</a>
    </p>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>

<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>Editing an item</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<%
    List<String> files = (List<String>) request.getAttribute("files");
    int fileNum = files.size();
%>
<div class="main">
    <form method="POST" action="<%="searchList.html?fileNum="+fileNum%>">
        <input type="checkbox" id = "checkAll" name="checkAll" value="true">
        <label for="checkAll">Look for all</label><br>
        <%
            for (int i = 0; i < fileNum; i ++){
                String file = "file" + i;
                String fileName = files.get(i);
        %>
            <input type="checkbox" id="<%=file%>" name="<%=file%>" value="<%=fileName%>">
            <label for="<%=file%>"><%=fileName%></label><br>
        <%
            }
        %>
        <input type="text" id="keyword" name="keyword" value="">
        <label for="keyword">Search for this:</label>
        <input type="submit" value="Search!"/>
    </form>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>

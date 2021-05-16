
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>Displaying a list</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="Main">
<%
    boolean deleted = (boolean) request.getAttribute("deleted");
    if (deleted){
%>
    <p>
        List has been successfully deleted.
    </p>
<%
    }else {
%>
    <p>
        List was not able to be deleted.
    </p>
<%
    }
%>
<p>
    <a href="displayList.html?fileName=_lists.txt">Back to lists</a>
</p>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>

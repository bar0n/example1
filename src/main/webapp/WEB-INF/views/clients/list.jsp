<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Clients</title>
</head>
    <body>
    <b> <h1>Clients</h1></b>

    <c:if test="${not empty clients}">
        <table border="1">
        <thead>
            <tr>
                <th>id</th>
                <th>First name</th>
                <th>Last name</th>
            </tr>
        </thead>
            <tbody>
                <c:forEach var="client" items="${clients}">
                    <tr>
                        <td> <a href="clients/${client.id}"><button>${client.id}</button></a>  </td>
                        <td>${client.firstName}</td>
                        <td>${client.lastName}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </c:if>
        <a href="/clients/debts">clients debts</a>
       </body>
</html>


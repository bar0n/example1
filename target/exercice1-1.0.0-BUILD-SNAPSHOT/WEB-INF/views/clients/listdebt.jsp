<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
                <th>Debt</th>
            </tr>
        </thead>
            <tbody>
                <c:forEach var="client" items="${clients}">
                    <tr>
                        <td> <a href="clients/${client.id}"><button>${client.id}</button></a>  </td>
                        <td>${client.firstName}</td>
                        <td>${client.lastName}</td>
                        <td>${mapdebt.get(client)}</td>
                    </tr>
                </c:forEach>
                <form  method="post" action="/generatedoc">
                    <tr>
                       <td><form:label path="templates">Templates:</form:label></td>
                        <td>
                        <select id="templateselect" name="template">
                             <c:forEach var="template" items="${templates}">
                               <option value="${template.name}">${template.name}</option>
                             </c:forEach>
                        </select>
                        </td>
                    </tr>
                    <tr>  <td colspan="4"><input type="submit" value="Generate" /></td> </tr>
                </form>
            </tbody>

        </table>
        </c:if>
        </body>
</html>


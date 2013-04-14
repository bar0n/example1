<%--
  Created by IntelliJ IDEA.
  User: bar0n
  Date: 13.04.13
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="UTF-8" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Photo </title>

    <script language="JavaScript">
        function Validate() {
            var image = document.getElementById("image").value;
            if (image != '') {
                var checkimg = image.toLowerCase();
                if (!checkimg.match(/(\.jpg|\.png|\.JPG|\.PNG|\.jpeg|\.JPEG)$/)) {
                    alert("Please enter  Image  File Extensions .jpg,.png,.jpeg");
                    document.getElementById("image").focus();
                    return false;
                } else{
                    document.getElementById("photoPath").value = image;
                }
            }
            return true;
        }

        function inputFile(){
            var image = document.getElementById("image").value;
            document.getElementById("name").value = image;
        }


    </script>

</head>
<body>
<spring:url value="/photo" var="clientPhotoUrl"/>
<spring:url value="/edit/${client.id}" var="saveUrl"/>

<b><h1>Photo details</h1></b>
<form:form modelAttribute="client" method="post"
           enctype="multipart/form-data" onSubmit="return Validate();" action="${saveUrl}" >

    <table>

        <tr hidden="true">
            <td><form:label path="id">Id:</form:label></td>
            <td><form:input path="id" disabled="true" /></td>
        </tr>

        <tr>
            <td><form:label path="firstName">First Name:</form:label></td>
            <td><form:input path="firstName"/></td>
        </tr>

        <tr>
            <td><form:label path="lastName">Last Name</form:label></td>
            <td><form:input path="lastName"/></td>
        </tr>

        <c:if test="${not empty client.photoPath}">
            <tr>
                <td>Photo</td>
                <td><img src="${clientPhotoUrl}/${client.id}"/></td>
            </tr>
        </c:if>


        <tr>
            <td> File <br/>
            </td>
            <td>
                <input type="text" name="name" id = "name" hidden="true" />
                <input name="file" id="image" type="file" onChange="inputFile();"/>
            </td>
        </tr>
        <tr>
            <td><br/>
            </td>
            <td><input type="submit"  value="Upload"/></td>
        </tr>
    </table>

</form:form>

</body>
</html>
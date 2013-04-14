<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Clients details</title>
</head>
    <body>
    <spring:url value="/show" var="clientPhotodetailsUrl"/>
    <b> <h1>Clients details</h1></b>

    <table border="1">
        <tr>
            <td>First name </td>
            <td>${clientDetail.client.firstName}</td>
        </tr>
        <tr>
            <td>Last name</td>
            <td>${clientDetail.client.lastName}</td>
        </tr>
        <tr>
            <td>tel_type</td>
            <td>${clientDetail.tel_type}</td>
        </tr>
        <tr>
            <td>tel number</td>
            <td>${clientDetail.tel_number}</td>
        </tr>
        <tr>
            <td>email</td>
            <td>${clientDetail.email}</td>
        </tr>
        <tr>
            <td>CITY</td>
            <td>${clientDetail.city}</td>
        </tr>
        <tr>
            <td>edrpo</td>
            <td>${clientDetail.edrpo}</td>
        </tr>
        <tr>
            <td>inn</td>
            <td>${clientDetail.inn}</td>
        </tr>
        <tr>
            <td>comments</td>
            <td>${clientDetail.comments}</td>
        </tr>

        <tr>
            <td>Photo</td>
            <td><a href="${clientPhotodetailsUrl}/${clientDetail.client.id}"> photo </a> </td>
        </tr>
    </table>

       </body>
</html>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Stored Data</title>
</head>
<body>
    <h2>Stored Data</h2>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Address</th>
            <th>Email ID</th>
            <th>Mobile Number</th>
        </tr>
        <%
            String name = (String) session.getAttribute("name");
            String address = (String) session.getAttribute("address");
            String emailid = (String) session.getAttribute("emailid");
            String mobilenumber = (String) session.getAttribute("mobilenumber");

            if (name != null) {
        %>
        <tr>
            <td><%= name %></td>
            <td><%= address %></td>
            <td><%= emailid %></td>
            <td><%= mobilenumber %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>

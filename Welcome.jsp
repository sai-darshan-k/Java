<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat, jakarta.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
    <%
        HttpSession mySession = request.getSession(false);

        // Check if the user is logged in
        if (mySession != null && mySession.getAttribute("username") != null) {
            String username = (String) mySession.getAttribute("username");
            Date login_time = (Date) mySession.getAttribute("login_time");

            // Format the login time using SimpleDateFormat
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedLoginTime = sdf.format(login_time);

            // Display user information
    %>
            <h2>Welcome, <%= username %></h2>
            <p>Login Time: <%= formattedLoginTime %></p>
            
            <!-- Display the user's profile picture -->
            <img src="ProfilePictureServlet" alt="Profile Picture">
            
            <!-- Add your content for the welcome page here -->
            <a href="logout.jsp">Logout</a>
    <%
        } else {
            // Redirect to login page if the user is not logged in
            response.sendRedirect("index.html"); // Change to the appropriate page
        }
    %>
</body>
</html>
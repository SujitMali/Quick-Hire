<%@ page import="com.byteBusters.model.ServiceProvider" %>
<%@ page import="com.byteBusters.model.User" %>
<%@ page import="com.byteBusters.controller.UserController" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Searched Provider</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap">
    <style>
        body {
            font-family: 'Poppins';
            background-color: #f4f4f4;
            text-align: center;
            margin-top: 50px;
        }
        header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 20px;
            background-color: #333;
            color: #fff;
            border-radius: 10px;
        }
        header h1 {
            margin: 0;
            font-size: 24px;
        }
        .user-buttons {
            display: flex;
        }
        .user-buttons button {
            background-color: #42f248;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-left: 10px;
        }
        .dashboard-buttons {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-top: 50px;
        }
        .dashboard-buttons button {
            width: 200px;
            margin: 10px;
            padding: 15px;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            font-size: 16px;
            font-weight: bold;
            text-transform: uppercase;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #333;
            color: white;
        }
    </style>
</head>

<body>
    <header>
        <h1>QuickHire</h1>
        <div class="user-buttons">
            <a href="fromAppprovedToDashboard" class="user-buttons"><button>Dashboard</button></a>
        </div>
    </header>

    <div>
        <h2>Service Providers</h2>
        <table>
            <thead>
                <tr>
                    <th>Contact</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Area</th>
                    <th>Open Time</th>
                    <th>Close Time</th>
                    <th>Booking</th>
                </tr>
             
            </thead>
            <tbody>
            	
                <% List<ServiceProvider> spList = (List<ServiceProvider>) request.getAttribute("searchedProviders"); %>
                <% for (ServiceProvider provider : spList) { %>
                    <tr>
                        <td><%= provider.getContact() %></td>
                        <td><%= provider.getName() %></td>
                        <td><%= provider.getAge() %></td>
                        <td><%= provider.getArea() %></td>
                        <td><%= provider.getOpenTime() %></td>
                        <td><%= provider.getCloseTime() %></td>
 						<td>
			                <!-- Add your button here -->
			                <form action="bookService" method="post">
			                    
			                    <!-- Include other fields like date and time -->
			                    
			                    <input type="hidden" name="serviceProviderName" value="<%= provider.getName() %>">
    							<input type="hidden" name="serviceProviderContact" value="<%= provider.getContact() %>">
			                    <input type="text" placeholder = "Date(YYYY-MM-DD)" name="bookingDate">
			                    <input type="text" placeholder = "Time(HH-MM)" name="bookingTime">
			                    <button type="submit">Book Service</button>
			                </form>
           			  </td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>

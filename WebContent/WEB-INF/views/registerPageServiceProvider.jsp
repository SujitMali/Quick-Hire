<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 	<meta charset="UTF-8">
 	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>registerPageServiceProvider</title>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
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

        form {
            width: 400px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(20, 1, 1, 0.1);
        }

        form h2 {
            color: #333;
            font-size: 20px;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 8px;
            text-align: left;
        }

        input, select {
            width: calc(100% - 16px);
            padding: 8px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }

        button.login-button {
            background-color: #4caf50;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button.login-button:hover {
            background-color: #358339;
        }

        #register-link,
        .user-buttons button {
            display: block;
            margin-top: 15px;
            color: #3498db;
            text-decoration: none;
        }
    </style>
   
</head>
<body>
    <header>
        <h1>QuickHire</h1>
        <div class="user-buttons">
            <a href="adminLoginmap" class="user-buttons"><button>Admin</button></a>
            <a href="providerToUser" class="user-buttons"><button>User</button></a>
        </div>
    </header>

    <form action="afterServiceProviderRegisterSubmit" method="post">
        <h2>Service Provider Registration</h2>

        <label for="contact">Contact Number:</label>
        <input type="tel" id="contact" name="contact" required>
        
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        
         <label for="Age">Age:</label>
        <input type="text" id="Age" name="Age" required>
        
         <label for="Address">Address:</label>
        <input type="text" id="Address" name="Address" required>
        
         <label for="pincode">pincode:</label>
        <input type="text" id="pincode" name="pincode" required>
       
        <label for="area">Area:</label>
        <input type="text" id="area" name="area" required>

        <label for="city">City:</label>
        <input type="text" id="city" name="city" required>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        
       

        <label for="cateogry">Category:</label>
        <select id="cateogry" name="cateogry" required>
            <option value="Trades">Trades</option>
            <option value="Home Services">Home Services</option>
        </select>

        <label for="serviceType">Service Type:</label>
        <select id="serviceType" name="serviceType" required>
            <option value="Plumber">Plumber</option>
            <option value="Electrician">Electrician</option>
            <option value="Carpenter">Carpenter</option>
            <option value="Painter">Painter</option>
            <option value="Handyman">Handyman</option>
            <option value="Landscaper">Landscaper</option>
            <option value="HVAC Technician">HVAC Technician</option>
            <option value="Roofing Contractor">Roofing Contractor</option>
            <option value="Mason">Mason</option>
            <option value="Locksmith">Locksmith</option>
        </select>

        <label for="openTime">Open Time:</label>
        <input type="time" id="openTime" name="openTime" placeholder="hh:mm" required>

        <label for="closeTime">Close Time:</label>
        <input type="time" id="closeTime" name="closeTime" placeholder="hh:mm" required>


        <button type="submit" class="login-button">Register</button>
    </form>

    <a href="providerRegisterToLogin" id="register-link">Already Registered? Login</a>
</body>
</html>

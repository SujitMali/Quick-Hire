<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Services</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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

        .dashboard-form {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-top: 50px;
        }

        .dashboard-form select,
        .dashboard-form input[type="text"] {
            width: 300px;
            margin: 10px;
            padding: 15px;
            border: none;
            border-radius: 8px;
            font-size: 16px;
        }

        .dashboard-form button {
            width: 150px;
            margin: 10px;
            padding: 15px;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            font-size: 16px;
            font-weight: bold;
            text-transform: uppercase;
            background-color: #3498db;
            color: #fff;
        }

        /* Different colors for buttons */
        .btn-book-order { background-color: #3498db; color: #fff; }
        .btn-own-pending { background-color: #2ecc71; color: #fff; }
        .btn-own-approved { background-color: #e74c3c; color: #fff; }
        .btn-own-disapproved { background-color: #f39c12; color: #fff; }
    </style>
</head>

<body>
    <header>
        <h1>QuickHire</h1>
        <div class="user-buttons">
            <a href="userLogout" class="user-buttons"><button>Logout</button></a>
        </div>
    </header>

    <form class="dashboard-form" action="showSearchedProviders" method="get">
        <select name="serviceType">
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
        <input type="text" name="city" placeholder="Enter City">
        <button type="submit">Search</button>
    </form>
    
    
    

</body>

</html>

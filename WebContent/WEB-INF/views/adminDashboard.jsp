<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>	
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<title>Admin Dashboard</title>
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

        .btn-view-pending { background-color: #3498db; color: #fff; }
        .btn-view-approved { background-color: #2ecc71; color: #fff; }
        .btn-view-disapproved { background-color: #e74c3c; color: #fff; }
    </style>
    
</head>
<body>
 <header>
        <h1>QuickHire</h1>
        <div class="user-buttons">
            <a href="adminLoginmap" class="user-buttons"><button>Logout</button></a>
           
        </div>
    </header>

    <div class="dashboard-buttons">
    	<a href="adminViewPendingProviders">
   			 <button type="submit" class="btn-view-pending">Pending Service Provider</button>
		</a>
		
		<a href="adminViewApprovedProviders">
        	<button type ="submit" class="btn-view-approved">Approved Service Provider</button>
        </a>
        
        <a href="adminViewDisapprovedProviders">
        	<button type = "submit" class="btn-view-disapproved">Disapproved Service Providers</button>
        </a>
    </div>
</body>
</html>
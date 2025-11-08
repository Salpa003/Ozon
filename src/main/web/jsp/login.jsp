
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<center>
    Sing in <br/>
    <form action="login" method="post">
        <label> Login :
            <input type="text" name="login"  required value="${login}" ><br/>
        </label>
        <label> Password :
            <input type="text" name="password"  required  value="${password}"><br/>
        </label>
        <label>
            <input type="submit" value="SEND" >
        </label>
   <h1 style="color: red">${errorMessage}</h1>
    </form>
    <br/><br/>
    <a href="reg"><button>registration</button></a>
</center>
</body>
</html>

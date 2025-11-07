<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="reg" method="post">
    <label> Login :
        <input type="text" name="login"  required ><br/>
    </label>
    <label> Name :
        <input type="password" name="password"  required ><br/>
    </label>
    <label>
        <input type="submit" value="SEND" >
    </label>
</form>
<form action="login" method="post">
    Имя: <input type="text" name="username" required><br><br>
    Пароль: <input type="password" name="password" required><br><br>
    <input type="submit" value="Войти">
</form>
</body>
</html>

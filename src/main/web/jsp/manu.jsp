<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body {
            margin: 0;
            background: lightblue;
            height: 100vh;
        }
        .panel {
            position: fixed;
            bottom: 0;
            width: 100%;
            height: 60px;
            background: #0066cc;
            display: flex;
            justify-content: space-around;
            align-items: center;
        }

        .panel a {
            padding: 10px 16px;
            background: white; /* фон кнопки */
            color: #0066cc; /* цвет текста */
            text-decoration: none; /* убрать подчёркивание */
            font-weight: bold;
            /* Прямоугольник: без скругления */
            border-radius: 0;
            /* Граница, если нужно (опционально) */
            border: 1px solid #ccc;
        }

        .panel a:hover {
            background: #f0f0f0; /* чуть другой фон при наведении */
        }
    </style>
</head>
<body>
<div class="panel">
    <a href="/home">
        <button>🏠</button>
    </a>
    <a href="/profile">
        <button>🔍</button>
    </a>
    <a href="/amount">
        <button>₽</button>
    </a>
    <a href="/orders">
        <button>🛒</button>
    </a>
    <a href="/profile">
        <button>🙍🏻‍♂️</button>
    </a>
</div>
</body>
</html>

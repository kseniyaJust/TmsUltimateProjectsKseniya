<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Заявка сохранена</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="success-card">
    <h2 class="text-success mb-4">Заявка успешно сохранена!</h2>

    <div class="text-start mb-4">
        <p><strong>Заголовок:</strong> <%= request.getAttribute("title") %>
        </p>
        <p><strong>Категория:</strong>
            <%
                String cat = (String) request.getAttribute("category");
                if ("technical".equals(cat)) out.print("Техническая");
                else if ("support".equals(cat)) out.print("Поддержка");
                else out.print("Другое");
            %>
        </p>
        <p><strong>Заявитель:</strong> <%= request.getAttribute("requesterName") %>
        </p>
        <p><strong>Описание:</strong> <%= request.getAttribute("description") %>
        </p>
    </div>

    <div class="mt-4">
        <a href="save-request.jsp" class="btn btn-primary">Новая заявка</a>
    </div>
</div>
</body>
</html>
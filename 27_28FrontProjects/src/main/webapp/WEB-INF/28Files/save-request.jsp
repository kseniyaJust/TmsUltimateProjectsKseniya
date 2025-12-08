<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Создание заявки</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="style.css">
</head>
<body>
<div class="form-card">
    <h2 class="text-center mb-4">Создание заявки</h2>

    <% String error = (String) request.getAttribute("error");
        if (error != null) { %>
    <div class="alert alert-danger"><%= error %></div>
    <% } %>

    <form action="/27_28FrontProjects/servletSave" method="post">
        <div class="mb-3">
            <label class="form-label">Заголовок</label>
            <input type="text" class="form-control" name="title"
                   value="<%= request.getParameter("title") != null ? request.getParameter("title") : "" %>">
        </div>

        <div class="mb-3">
            <label class="form-label">Описание</label>
            <textarea class="form-control" name="description" rows="3"><%= request.getParameter("description") != null ? request.getParameter("description") : "" %></textarea>
        </div>

        <div class="mb-3">
            <label class="form-label">Категория</label>
            <select class="form-select" name="category">
                <option value="">Выберите категорию</option>
                <option value="technical" <%= "technical".equals(request.getParameter("category")) ? "selected" : "" %>>Техническая</option>
                <option value="support" <%= "support".equals(request.getParameter("category")) ? "selected" : "" %>>Поддержка</option>
                <option value="other" <%= "other".equals(request.getParameter("category")) ? "selected" : "" %>>Другое</option>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Заявитель</label>
            <input type="text" class="form-control" name="requesterName"
                   value="<%= request.getParameter("requesterName") != null ? request.getParameter("requesterName") : "" %>">
        </div>

            <button type="submit" class="btn btn-primary">Отправить</button>
    </form>
</div>
</body>
</html>
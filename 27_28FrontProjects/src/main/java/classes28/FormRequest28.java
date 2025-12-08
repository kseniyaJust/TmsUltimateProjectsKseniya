package classes28;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servletSave")
public class FormRequest28 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String category = request.getParameter("category");
        String requesterName = request.getParameter("requesterName");

        String error = null;

        if (title == null || title.trim().isEmpty()) {
            error = "Заголовок обязателен";
        } else if (description == null || description.trim().isEmpty()) {
            error = "Описание обязательно";
        } else if (category == null || category.trim().isEmpty()) {
            error = "Выберите категорию";
        } else if (requesterName == null || requesterName.trim().isEmpty()) {
            error = "Укажите имя заявителя";
        }

        if (error != null) {
            request.setAttribute("error", error);
            request.getRequestDispatcher("/WEB-INF/28Files/save-request.jsp").forward(request, response);
        } else {
            request.setAttribute("title", title);
            request.setAttribute("description", description);
            request.setAttribute("category", category);
            request.setAttribute("requesterName", requesterName);

            request.getRequestDispatcher("/WEB-INF/28Files/succedForm.jsp").forward(request, response);
        }
    }
}
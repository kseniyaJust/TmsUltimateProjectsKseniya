package Lesson24.timeServlets;/* 24
* Создать приложение, которое при переходе на следующие урлы будет выдавать
результат:
/minsk - время в Минске
/washington - время в Вашингтоне
/beijing - время в Пекин
* */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/minsk")
public class MinskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        ZonedDateTime time = ZonedDateTime.now(ZoneId.of("Europe/Minsk"));
        String formattedTime = time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z"));
        Writer writer = resp.getWriter();

        writer.write(formattedTime);
        writer.close();
    }


}

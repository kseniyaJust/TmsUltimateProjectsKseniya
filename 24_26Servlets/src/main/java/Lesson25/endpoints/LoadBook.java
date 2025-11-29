package Lesson25.endpoints;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;

@WebServlet("/books/load-book")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 10)
public class LoadBook extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            IOException {
        try {
            Part filePart = request.getPart("file");
            String name = filePart.getSubmittedFileName();
            filePart.write("D:\\justProjects\\TMS_Projects\\24_26Servlets\\25FilesServer\\" + name);
            response.getWriter().print("The file uploaded successfully :)");
        } catch (Exception e) {
            response.getWriter().print("Something wrong :( " + e.getMessage());
        }
    }
}

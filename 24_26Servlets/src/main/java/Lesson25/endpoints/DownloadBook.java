package Lesson25.endpoints;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@WebServlet("/books/book")
public class DownloadBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("filename");

        if (fileName == null || fileName.isEmpty()) {
            showBookListPage(resp);
            return;
        }

        fileName = Paths.get(fileName).getFileName().toString();
        File bookFile = new File("D:\\justProjects\\TMS_Projects\\24_26Servlets\\25FilesServer\\" + fileName);

        if (!bookFile.exists() || !bookFile.isFile()) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Book not found: " + fileName);
            return;
        }

        String mimeType = getServletContext().getMimeType(bookFile.getName());
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }

        resp.setContentType(mimeType);
        resp.setContentLength((int) bookFile.length());
        resp.setHeader("Content-Disposition",
                "attachment; filename=\"" + bookFile.getName() + "\"");

        try (InputStream in = new FileInputStream(bookFile);
             OutputStream out = resp.getOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            out.flush();
        }
    }
    private void showBookListPage(HttpServletResponse response) throws IOException {
                serveHtmlFile(response, "downloadBook.html");
    }
    private void serveHtmlFile(HttpServletResponse response, String fileName)
            throws IOException {

        String htmlContent = readHtmlFile(fileName);
        response.getWriter().write(htmlContent);
    }
    private String readHtmlFile(String fileName) throws IOException {
        String filePath = getServletContext().getRealPath("/") + fileName;
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

}

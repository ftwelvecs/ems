package kz.f12.school.api;

import kz.f12.school.model.dto.UserDTO;
import kz.f12.school.service.UserService;
import kz.f12.school.utils.Mapper;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

// * - означает любое значение
// примеры: "/user/test", "/user/test/43", "/user" и т.д.
@WebServlet("/user/*")
public class UserServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    // TODO: продебажить метод несколько раз (минимум 10)
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Берем путь URL в качестве строки
        String path = req.getPathInfo();

        // если путь не пустой
        if (path != null) {
            // определяем весь пусть начиная со звездочки
            String[] params = path.split("/");

            // определяем в соответствии с именем пути дальнейшую логику действии
            if ("findById".equals(params[1])) { // ищем по конкретному id
                int userId = Integer.parseInt(params[2]);
                UserDTO userDTO = userService.findById(userId);
                JSONObject jsonObject = new JSONObject(userDTO);

                // указываем возвращаемый тип как json
                resp.setContentType("application/json");

                PrintWriter printWriter = resp.getWriter();
                printWriter.write(jsonObject.toString());
                printWriter.flush();
            } else if ("getAll".equals(params[1])) { // берем всех
                List<UserDTO> userDTOList = userService.getAll();
                JSONArray jsonArray = new JSONArray(userDTOList);

                // указываем возвращаемый тип как json
                resp.setContentType("application/json");

                PrintWriter printWriter = resp.getWriter();
                printWriter.write(jsonArray.toString());
                printWriter.flush();
            } else {
                printDefaultMessage(resp);
            }
        } else {
            printDefaultMessage(resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();

        if (path != null) {
            String[] params = path.split("/");

            if ("create".equals(params[1])) {
                StringBuilder body = new StringBuilder();
                BufferedReader reader = req.getReader();
                String part = "";

                while (part != null) {
                    part = reader.readLine();
                    if (part != null) body.append(part);
                }

                JSONObject jsonObject = new JSONObject(body.toString());

                UserDTO userDTO = Mapper.toUserDTO(jsonObject);
                userService.create(userDTO);
            } else {
                printDefaultMessage(resp);
            }
        } else {
            printDefaultMessage(resp);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();

        if (path != null) {
            String[] params = path.split("/");

            if ("update".equals(params[1])) {
                StringBuilder body = new StringBuilder();
                BufferedReader reader = req.getReader();
                String part = "";

                while (part != null) {
                    part = reader.readLine();
                    if (part != null) body.append(part);
                }

                JSONObject jsonObject = new JSONObject(body);

                UserDTO userDTO = Mapper.toUserDTO(jsonObject);
                userService.update(userDTO);
            } else {
                printDefaultMessage(resp);
            }
        } else {
            printDefaultMessage(resp);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();

        if (path != null) {
            String[] params = path.split("/");

            if ("delete".equals(params[1])) {
                StringBuilder body = new StringBuilder();
                BufferedReader reader = req.getReader();
                String part = "";

                while (part != null) {
                    part = reader.readLine();
                    if (part != null) body.append(part);
                }

                JSONObject jsonObject = new JSONObject(body);

                UserDTO userDTO = Mapper.toUserDTO(jsonObject);
                userService.delete(userDTO);
            } else {
                printDefaultMessage(resp);
            }
        } else {
            printDefaultMessage(resp);
        }
    }

    // печатаем сообщение по умолчанию
    private void printDefaultMessage(HttpServletResponse resp) throws IOException {
        // указываем возвращаемый тип как html
        resp.setContentType("text/html");

        PrintWriter printWriter = resp.getWriter();
        printWriter.write("<h1>Hello from UserServlet</h1>");
        printWriter.flush();
    }
}
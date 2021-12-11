package kz.f12.school.api;

import kz.f12.school.model.dto.DepartmentDTO;
import kz.f12.school.service.DepartmentService;
import kz.f12.school.utils.HttpUtils;
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

@WebServlet("/department/*")
public class DepartmentServlet extends HttpServlet {

    private DepartmentService departmentService = new DepartmentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Берем путь URL в качестве строки
        String path = req.getPathInfo();

        // если путь не пустой
        if (path != null) {
            // определяем весь пусть начиная со звездочки
            String[] params = path.split("/");

            // определяем в соответствии с именем пути дальнейшую логику действии
            if ("findById".equals(params[1])) { // ищем по конкретному id
                int departmentId = Integer.parseInt(params[2]);
                DepartmentDTO departmentDTO = departmentService.findById(departmentId);
                JSONObject jsonObject = new JSONObject(departmentDTO);

                // указываем возвращаемый тип как json
                resp.setContentType("application/json");

                PrintWriter printWriter = resp.getWriter();
                printWriter.write(jsonObject.toString());
                printWriter.flush();
            } else if ("getAll".equals(params[1])) { // берем всех
                List<DepartmentDTO> departmentDTOList = departmentService.getAll();
                JSONArray jsonArray = new JSONArray(departmentDTOList);

                // указываем возвращаемый тип как json
                resp.setContentType("application/json; charset=UTF-8");
                resp.setCharacterEncoding("UTF-8");
                HttpUtils.addAllowHeaders(resp);

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

                DepartmentDTO departmentDTO = Mapper.toDepartmentDTO(jsonObject);
                departmentService.create(departmentDTO);
                // указываем возвращаемый тип как json
                resp.setContentType("application/json; charset=UTF-8");
                resp.setCharacterEncoding("UTF-8");
                HttpUtils.addAllowHeaders(resp);
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

                JSONObject jsonObject = new JSONObject(body.toString());

                DepartmentDTO departmentDTO = Mapper.toDepartmentDTO(jsonObject);
                departmentService.update(departmentDTO);
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

                JSONObject jsonObject = new JSONObject(body.toString());

                DepartmentDTO departmentDTO = Mapper.toDepartmentDTO(jsonObject);
                departmentService.delete(departmentDTO);
            } else {
                printDefaultMessage(resp);
            }
        } else {
            printDefaultMessage(resp);
        }
    }

    // Проверочный метод для клиентов
    // сообщает им что сервер работает и готов принимать запросы
    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doOptions(req, resp);
        HttpUtils.addAllowHeaders(resp);
    }

    // печатаем сообщение по умолчанию
    private void printDefaultMessage(HttpServletResponse resp) throws IOException {
        // указываем возвращаемый тип как html
        resp.setContentType("text/html");

        PrintWriter printWriter = resp.getWriter();
        printWriter.write("<h1>Hello from DepartmentServlet</h1>");
        printWriter.flush();
    }
}

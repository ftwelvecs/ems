package kz.f12.school.api.user;

import kz.f12.school.model.dto.UserDTO;
import kz.f12.school.service.UserService;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/findById/*")
public class UserServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] params = req.getPathInfo().split("/");
        int userId = Integer.parseInt(params[1]);
        UserDTO userDTO = userService.findById(userId);
        JSONObject jsonObject = new JSONObject(userDTO);

        resp.setContentType("application/json");

        PrintWriter printWriter = resp.getWriter();
        printWriter.write(jsonObject.toString());
        printWriter.flush();
    }
}

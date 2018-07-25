package Servelet;

import DAO.DAOFactory;
import DAO.UserDAO;
import DAO.impl.UserDAOImpl;
import entity.UserEntity;
import org.apache.tomcat.jni.User;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();

        String username = request.getParameter("Username");
        String password = request.getParameter("Password");
        String confirmPassword = request.getParameter("ConfirmPassword");

        UserDAO userDAO = DAOFactory.getmInstance().getUserDAO(HibernateUtil.getSession());

        if(username == null || username.length() == 0){
            printWriter.print(getErrorAlertMsg("用户名不能为空"));
        }
        else {
            List userList = userDAO.queryInfo("username", username);

            if(userList != null && !userList.isEmpty()){
                printWriter.print(getErrorAlertMsg("用户名已存在"));
            }
        }
        if(password == null || password.length() == 0){
            printWriter.print(getErrorAlertMsg("密码不能为空"));
        }
        else if(!password.equals(confirmPassword)) printWriter.print(getErrorAlertMsg("两次输入密码不一致"));

        UserEntity user = new UserEntity();
        user.setId(10000 + (int)(Math.random() * 10000));
        user.setUsername(username);
        user.setPassword(password);

        String result = userDAO.insertUser(user);
        printWriter.print(getSuccessMsg(result));

        HibernateUtil.closeSession();
    }
    private String getErrorAlertMsg(String msg){
        return "<script language='javascript'>alert('" + msg + "');window.location.href='JSP/register.jsp;</script>";
    }
    private String getSuccessMsg(String msg){
        //其实应该跳到主界面，但是还没写
        return "<script language='javascript'>alert('" + msg + "');window.location.href='JSP/index.jsp;</script>";
    }
}

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
        String confirmPassword = request.getParameter("confirmPassword");
        String email = request.getParameter("email");
        String QQ = request.getParameter("QQ");
        String phone = request.getParameter("phone");

        UserDAO userDAO = DAOFactory.getmInstance().getUserDAO(HibernateUtil.getSession());

        if(username == null || username.length() == 0){
            printWriter.print(getErrorAlertMsg("用户名不能为空"));
        }
        else {
            List userList = userDAO.queryInfo("name", username);

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
        user.setEmail(email);
        user.setMessNum(0);
        user.setName(username);
        user.setPwd(password);
        user.setQq(QQ);
        user.setPhone(phone);

        String result = userDAO.insertUser(user);
        printWriter.print(getSuccessMsg(result));

        HibernateUtil.closeSession();
    }
    private String getErrorAlertMsg(String msg){
        return "<script language='javascript'>alert('" + msg + "');window.location.href='JSP/register.jsp';</script>";
    }
    private String getSuccessMsg(String msg){
        return "<script language='javascript'>alert('" + msg + "');window.location.href='JSP/login.jsp';</script>";
    }
}

package Servelet;

import DAO.DAOFactory;
import DAO.UserDAO;
import entity.UserEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();

        String username = request.getParameter("Username");
        String password = request.getParameter("Password");

        UserDAO userDAO = DAOFactory.getmInstance().getUserDAO(HibernateUtil.getSession());

        if(username == null || username.length() == 0){
            printWriter.print(getErrorAlertMsg("用户名不能为空"));
        }
        else {
            List userList = userDAO.queryInfo("Username", username);
            if(userList != null && !userList.isEmpty()){
                userList = userDAO.queryInfo("Password", password);
                if(userList != null && !userList.isEmpty()){
                    printWriter.print("登录成功");
                    printWriter.print(getSuccessMsg("将跳转至首页"));
                    return;
                }
                else printWriter.print(getErrorAlertMsg("密码错误"));
            }
            HibernateUtil.closeSession();
            printWriter.print(getErrorAlertMsg("用户名错误"));
        }
    }

    private String getErrorAlertMsg(String msg){
        return "<script language='javascript'>alert('" + msg + "');widow.location.href='JSP/login.jsp';</script>";
    }
    private String getSuccessMsg(String msg){
        return "<script language='javascript'>alert('" + msg + "');window.location.href='JSP/login.jsp';</script>";
    }
}

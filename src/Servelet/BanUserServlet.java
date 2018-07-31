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

@WebServlet("/BanUserServlet")
public class BanUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();

        UserDAO userDAO = DAOFactory.getmInstance().getUserDAO(HibernateUtil.getSession());

        int userId = Integer.parseInt(request.getParameter("banID"));

        UserEntity userEntity = userDAO.queryInfo("id", userId).get(0);
        userEntity.setPwd("isBanned");
        String result = userDAO.updateUser(userEntity);
        System.out.println(result);
        request.getSession().removeAttribute("doManage");
        request.getSession().removeAttribute("userFind");
        printWriter.print(doJump());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        this.doPost(request, response);
    }

    private String doJump(){
        return "<script language='javascript'>window.location.href='JSP/userInfo.jsp';</script>";
    }
    }

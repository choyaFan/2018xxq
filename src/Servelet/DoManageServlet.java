package Servelet;

import DAO.DAOFactory;
import DAO.GoodsDAO;
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
import java.util.List;

@WebServlet("/DoManageServlet")
public class DoManageServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();

        UserDAO userDAO = DAOFactory.getmInstance().getUserDAO(HibernateUtil.getSession());
        GoodsDAO goodsDAO = DAOFactory.getmInstance().getGoodsDAO(HibernateUtil.getSession());

        UserEntity userEntity = (UserEntity)request.getSession().getAttribute("USER");

        if(userEntity.getId() > 5){
            printWriter.print(getErrorAlertMsg("您不是管理员"));
        }

        else{
            try {
                int doManage = (int)request.getSession().getAttribute("doManage");
                System.out.println(doManage);
                if(doManage == 1){
                    //管理用户
                    String userName = request.getParameter("userNameToBan");
                    List<UserEntity> userList = userDAO.queryInfo("name", userName);
                    UserEntity user = userList.get(0);
                    request.getSession().setAttribute("userFind", user);
                    printWriter.print(doJump());
                }
                else if(doManage == 2){

                }
                else {
                    printWriter.print(getErrorAlertMsg("选项错误"));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        this.doPost(request, response);
    }

    private String getErrorAlertMsg(String msg){
        return "<script language='javascript'>alert('" + msg + "');window.location.href='JSP/login.jsp';</script>";
    }

    private String doJump(){
        return "<script language='javascript'>window.location.href='JSP/userInfo.jsp';</script>";
    }
    }

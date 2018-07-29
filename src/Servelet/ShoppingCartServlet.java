package Servelet;

import DAO.DAOFactory;
import DAO.GoodsDAO;
import DAO.ShoppingcartDAO;
import DAO.UserDAO;
import entity.GoodsEntity;
import entity.ShoppingcartEntity;
import entity.UserEntity;
import org.dom4j.datatype.DatatypeAttribute;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ShoppingCartServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();

        UserEntity user = (UserEntity)request.getSession().getAttribute("USER");
        int userID = user.getId();


        ShoppingcartDAO shoppingcartDAO = DAOFactory.getmInstance().getShoppingcartDAO(HibernateUtil.getSession());
        GoodsDAO goodsDAO = DAOFactory.getmInstance().getGoodsDAO(HibernateUtil.getSession());


        if(userID == 0){
            printWriter.print(getErrorAlertMsg("用户信息获取失败"));
        }
        else{
            try{
                List<ShoppingcartEntity> cartList = shoppingcartDAO.queryShoppingcart("userId", userID);
                for(ShoppingcartEntity shoppingcartEntity : cartList) {
                    int goodsID = shoppingcartEntity.getGoodsId();
                    List<GoodsEntity> goodsList = goodsDAO.FindGoods("id", goodsID);
                    request.getSession().setAttribute("goodsList", goodsList);
                    request.getRequestDispatcher("JSP/userInfo.jsp").forward(request, response);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private String getErrorAlertMsg(String msg){
        return "<script language='javascript'>alert('" + msg + "');window.location.href='login.jsp';</script>";
    }
}

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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet("/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();

        UserEntity userEntity = (UserEntity)request.getSession().getAttribute("USER");


        ShoppingcartDAO shoppingcartDAO = DAOFactory.getmInstance().getShoppingcartDAO(HibernateUtil.getSession());
        GoodsDAO goodsDAO = DAOFactory.getmInstance().getGoodsDAO(HibernateUtil.getSession());

        if(userEntity.getName() == null || userEntity.getName().length() == 0){
            printWriter.print(getErrorAlertMsg("用户信息获取失败"));
        }
        else{
            try{
                List<ShoppingcartEntity> cartList = shoppingcartDAO.queryShoppingcart("userId", userEntity.getId());
                int countPage = (cartList.size() % 3 == 0 ? (cartList.size() / 3) : (cartList.size() / 3 + 1));
                int currPage = Integer.parseInt(request.getParameter("currPage"));
                System.out.println(countPage);
                request.getSession().setAttribute("countPage", countPage);
                request.getSession().setAttribute("currPage", currPage);
                for(int i = 1;i <= cartList.size();i++) {
                    ShoppingcartEntity shoppingcartEntity = cartList.get(i-1);
                    int goodsID = shoppingcartEntity.getGoodsId();
                    List<GoodsEntity> goodsList = goodsDAO.FindGoods("id", goodsID);
                    GoodsEntity goodsEntity = goodsList.get(0);
                    request.getSession().setAttribute("goodsEntity" + Integer.toString(i), goodsEntity);
                }
                printWriter.print(DoJump());
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

    private String DoJump(){
        return "<script language='javascript'>window.location.href='JSP/shoppingCart.jsp';</script>";
    }
}

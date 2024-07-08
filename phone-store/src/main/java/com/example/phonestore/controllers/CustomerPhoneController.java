package com.example.phonestore.controllers;
import com.example.phonestore.models.Phone;
import com.example.phonestore.services.IPhoneService;
import com.example.phonestore.services.impl.PhoneService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerPhoneController", value = "/phoneCustomer")
public class CustomerPhoneController extends HttpServlet {
    private IPhoneService phoneService = new PhoneService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "infor":
                getPhoneInfo(req, resp);
                break;
            case "iphone":
                showIphoneProduct(req,resp);
                break;
            case "samsung":
                showSamSungProduct(req,resp);
            default:
                List<Phone> phones = phoneService.findAll();
                req.setAttribute("phones", phones);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/phoneCustomer/home.jsp");
                dispatcher.forward(req, resp);
                break;
        }
    }

    private void showSamSungProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Phone> phones = phoneService.findByManufacturer("SamSung");
        req.setAttribute("phones", phones);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/phoneCustomer/search.jsp");
        dispatcher.forward(req, resp);
    }

    private void showIphoneProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Phone> phones = phoneService.findByManufacturer("Apple");
        req.setAttribute("phones", phones);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/phoneCustomer/search.jsp");
        dispatcher.forward(req, resp);
    }

    private void getPhoneInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Phone phone = phoneService.findById(id);
        if (phone == null) {
            req.setAttribute("message", "Không tìm thấy sản phẩm");
        } else {
            req.setAttribute("phone", phone);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/phoneCustomer/phoneInfor.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                searchPhone(req, resp);
                break;
        }
    }

    private void searchPhone(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");
        List<Phone> phones = phoneService.findByName(search);
        req.setAttribute("phones", phones);
        req.getRequestDispatcher("/phoneCustomer/search.jsp").forward(req, resp);
    }
}

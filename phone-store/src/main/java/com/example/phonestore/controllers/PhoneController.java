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

@WebServlet(name = "PhoneController", value = "/phone")
public class PhoneController extends HttpServlet {
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
            case "create":
                showCreateForm(req, resp);
                break;
            default:
                List<Phone> phones = phoneService.findAll();
                req.setAttribute("phones", phones);
                req.getRequestDispatcher("/phoneAdmin/list.jsp").forward(req, resp);
                break;
        }
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/phoneAdmin/createAD.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
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
            case "create":
                createPhone(req, resp);
                break;
        }
    }

    private void createPhone(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String img = req.getParameter("img");
        String manufacture = req.getParameter("manufacture");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        float size = Float.parseFloat(req.getParameter("size"));
        String color = req.getParameter("color");
        int ram = Integer.parseInt(req.getParameter("ram"));
        int batery = Integer.parseInt(req.getParameter("batery"));

        if (name != null && img != null && manufacture != null && price > 0 && quantity > 0 && size > 0 && color != null && ram > 0 && batery > 0) {
            Phone phone = new Phone(0, name, img, manufacture, price, quantity, size, color, ram, batery);
            phoneService.savePhone(phone);
            resp.sendRedirect(req.getContextPath() + "/phone");
        } else {
            req.setAttribute("message", "Thông tin không hợp lệ. Vui lòng điền đầy đủ các trường.");
            req.getRequestDispatcher("/phoneAdmin/createAD.jsp").forward(req, resp);
        }
    }
}

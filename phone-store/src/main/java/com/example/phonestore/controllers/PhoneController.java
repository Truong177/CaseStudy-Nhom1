package com.example.phonestore.controllers;

import com.example.phonestore.models.Phone;
import com.example.phonestore.services.IPhoneService;
import com.example.phonestore.services.impl.PhoneService;

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
            default:
                List<Phone> phones = phoneService.findAll();
                req.setAttribute("phones", phones);
                req.getRequestDispatcher("/phone/list.jsp").forward(req, resp);
                break;
        }
    }
}

package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "message", value = "/message")
public class MessageServlet extends HttpServlet {
    private List<String> leaveMessage = new ArrayList<>();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String username = req.getParameter("username");
        leaveMessage.add(username);

        String message = req.getParameter("leaveMessage");
        leaveMessage.add(message+"\n");

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter writer = resp.getWriter();

        writer.println("<textarea rows=\"5\" cols=\"50\">");
        for(String messages:leaveMessage){
            writer.print(messages);
        }
        writer.println("</textarea>");

    }

    public void destroy() {
    }
}
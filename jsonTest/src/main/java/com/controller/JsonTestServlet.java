package com.controller;

import com.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author radio
 * @create 2021-02-20 4:25 PM
 */
public class JsonTestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student stu1 = new Student(333,"张三","男");
        Student stu2 = new Student(222,"李四","男");
        System.out.println("1111");
        //{"stu1":{"id":"?","name":"?","sex":"?"},"stu2":{"id":"?","name":"?","sex":"?"}}
        String str="{\"stu1\":{\"id\":\""+stu1.getId()
                +"\",\"name\":\""+stu1.getName()+"\",\"sex\":\""+stu1.getSex()
                +"\"},\"stu2\":{\"id\":\""+stu2.getId()+"\",\"name\":\""+stu2.getName()
                +"\",\"sex\":\""+stu2.getSex()+"\"}}";
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(str);
        out.close();
    }
}

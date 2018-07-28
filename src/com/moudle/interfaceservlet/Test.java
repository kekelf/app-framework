package com.moudle.interfaceservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/test")
public class Test  extends HttpServlet{
	 private String message;

	  public void init() throws ServletException
	  {
	      // 执行必需的初始化
	      message = "Hello World";
	  }

	  public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	  {
		  System.out.println("进入接口");
	      // 实际的逻辑是在这里
	      PrintWriter out = response.getWriter();
	      out.println("success");
	  }
	  
	  public void destroy()
	  {
	      // 什么也不做
	  }

}

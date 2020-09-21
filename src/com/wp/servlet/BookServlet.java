package com.wp.servlet;

import com.google.gson.Gson;
import com.wp.pojo.Book;
import com.wp.service.BookService;
import com.wp.service.impl.BookServiceImpl;
import com.wp.util.JsonData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet("/book.do")
public class BookServlet extends HttpServlet {
       private   BookService service=new BookServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String service = req.getParameter("service");
        try {
            BookServlet.class.getDeclaredMethod(service, HttpServletRequest.class, HttpServletResponse.class).invoke(this, req, resp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    public void allBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException , IOException {
        System.out.println("执行allBook成功");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        List<Book> infos = service.findAll();
        JsonData jsonData = new JsonData(0,"success",infos.size(),infos);
        Gson gson = new Gson();
        String json=gson.toJson(jsonData);
        PrintWriter writer = resp.getWriter();
        writer.write(json);
    }
    public void del(HttpServletRequest req, HttpServletResponse resp) throws ServletException , IOException {

        String bookId = req.getParameter("bookId");
        service.del(Integer.parseInt(bookId));
        PrintWriter writer = resp.getWriter();
        writer.write(1);
        System.out.println("删除成功");
    }
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException , IOException {
        String bookId = req.getParameter("bookId");
        String bookName = req.getParameter("bookName");
        String price = req.getParameter("price");
        String title = req.getParameter("title");
        String bookNote = req.getParameter("bookNote");
        String typeId = req.getParameter("typeId");
        Book book = null;
        if ("".equals(bookId)){
            book = new Book(bookName,Float.parseFloat(price),title,bookNote,Integer.parseInt(typeId));
        } else {
            book = new Book(Integer.parseInt(bookId),bookName,Float.parseFloat(price),title,bookNote,Integer.parseInt(typeId));
        }

        service.add(book);
    }

}

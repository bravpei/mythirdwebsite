package com.monn.star.servletapi;




import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

@WebServlet( "/filedownload")
public class BrowerDownloadFile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        System.out.println("进入fileDownLoad"+name);
/*        PrintWriter pw=resp.getWriter();
        pw.append("Hello "+name);
        pw.flush();*/
        String fileName="/home/liupei/Pictures/wallhaven-674407.jpg";
        String contentTYpe=getServletContext().getMimeType(fileName);
        String contentDispositon="attachment;filename=wallhaven-674407.jpg";
        FileInputStream fis = new FileInputStream(fileName);
        resp.setContentType(contentTYpe);
        resp.setHeader("Content-Disposition",contentDispositon);
        OutputStream os=resp.getOutputStream();
        int len=0;
        byte[] buffer=new byte[1024];
        while((len=fis.read(buffer))>0){
            os.write(buffer,0,len);
        }
        fis.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

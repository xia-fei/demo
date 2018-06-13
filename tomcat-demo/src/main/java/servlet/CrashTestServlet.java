package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author 夏飞
 */
public class CrashTestServlet extends javax.servlet.http.HttpServlet {


    private List<Double> dateList = new LinkedList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long size = Long.parseLong(req.getParameter("size"));
        for (int i = 0; i < size; i++) {
            dateList.add(new Random().nextDouble());
        }
        resp.getWriter().write(String.format("%11s:%d","dataList",dateList.size()));
        resp.getWriter().write("\n");
        resp.getWriter().write(String.format("%11s:%d","totalMemory",Runtime.getRuntime().totalMemory()));
        resp.getWriter().write("\n");
        resp.getWriter().write(String.format("%11s:%d","maxMemory",Runtime.getRuntime().maxMemory()));
        resp.getWriter().write("\n");
        resp.getWriter().write(String.format("%11s:%d","freeMemory",Runtime.getRuntime().freeMemory()));
        resp.getWriter().write("\n");
        resp.getWriter().flush();

    }
}

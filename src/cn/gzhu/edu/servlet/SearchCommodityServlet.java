package cn.gzhu.edu.servlet;

import cn.gzhu.edu.beans.Book;
import cn.gzhu.edu.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchCommodityServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Service service = new Service();
        List<Book> book_list = service.searchCommidity(req.getParameter("search_item"));
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for(Book book1:book_list){
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("b_id",book1.getB_id());
            data.put("b_name",book1.getB_name());
            data.put("b_photo_1",book1.getB_photo_1());
            data.put("b_photo_2",book1.getB_photo_2());
            data.put("b_describe",book1.getB_describe());
            data.put("b_oldprice",book1.getB_oldprice());
            data.put("b_newprice",book1.getB_newprice());
            data.put("b_isbn",book1.getB_ISBN());
            data.put("b_author",book1.getB_author());
            data.put("b_publish_company",book1.getB_publish_company());
            data.put("b_publish_time",book1.getB_publish_time());
            list.add(data);
        }
        try {
            ResponseJsonUtils.json(resp,list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

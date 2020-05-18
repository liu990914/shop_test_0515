package com.tjetc.servlet;

import com.tjetc.doman.Product;
import com.tjetc.service.ProductService;
import com.tjetc.service.impl.ProductServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet("/updateproduct.do")
public class UpdateProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(factory);
        List<FileItem> fileItems = null;
        try {
            fileItems = sfu.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        String pid  =fileItems.get(0).getString("utf-8");
        String pname = fileItems.get(1).getString("utf-8");
        String cid = fileItems.get(2).getString("utf-8");
        String market = fileItems.get(4).getString("utf-8");
        String shop  =fileItems.get(5).getString("utf-8");
        String pdesc = fileItems.get(6).getString("utf-8");
        FileItem fileItem = fileItems.get(3);
        String name = fileItem.getName();
        Product product = new Product();
        if(name==null||"".equals(name)){
            product.setPimage(null);
        }else{
            String oldname = fileItem.getName();
            if(oldname.indexOf(File.separator)>-1){
                oldname=oldname.substring(oldname.lastIndexOf(File.separator)+1);
            }
            String path = this.getServletContext().getRealPath("/")+
                    "products/1/";
            File  pathfile =  new File(path);
            if(!pathfile.isDirectory()){
                pathfile.mkdir();
            }
            String newName=UUID.randomUUID().toString()+"_"+oldname;
            File  savepath = new File(path,newName);
            try {
                fileItem.write(savepath);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String pimage ="products/1/"+newName;
            product.setPimage(pimage);
        }
        product.setPid(Integer.valueOf(pid));
        product.setPname(pname);
        product.setCid(cid);
        product.setMarket_price(Double.valueOf(market));
        product.setShop_price(Double.valueOf(shop));
        product.setPdesc(pdesc);
        System.out.println(product.toString());
        boolean update = productService.update(product);
        if(update){
            response.sendRedirect(request.getContextPath()+"/findproductbg.do");
        }else{
            response.sendRedirect(request.getContextPath()+"/findproductbg.do");
        }
    }
}

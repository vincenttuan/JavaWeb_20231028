package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/upload/product")
@MultipartConfig(
		location = "C:/upload",
		fileSizeThreshold = 1024 * 1024 * 2, // 2MB 以內會暫存在記憶體, 超過會暫存在虛擬記憶體
		maxFileSize = 1024 * 1024 * 10 // 最大檔案 size 10MB
)
public class UploadProductServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String productGroup = req.getParameter("productGroup");
		String productName = req.getParameter("productName");
		String productPrice = req.getParameter("productPrice");
		// 取得上傳文件
		Part filePart = req.getPart("productFile");
		
		// 顯示相關資料
		resp.getWriter().println("商品分類: " + productGroup);
		resp.getWriter().println("<p>");
		resp.getWriter().println("商品名稱: " + productName);
		resp.getWriter().println("<p>");
		resp.getWriter().println("商品價格: " + productPrice);
		resp.getWriter().println("<p>");
		resp.getWriter().println("圖片資訊: " + filePart.getHeader("content-disposition"));
		resp.getWriter().println("<p>");
		String fileName = getFileName(filePart);
		resp.getWriter().println("檔案名稱: " + fileName);
		
		// 儲存檔案
		filePart.write(fileName);
		resp.getWriter().println("<p>");
		resp.getWriter().println("存檔完成");
		
		
	}
	
	private String getFileName(final Part part) {
		
        final String partHeader = part.getHeader("content-disposition");
        // partHeader = form-data; name="productFile"; filename="椒麻雞飯$130.jpg"
        
        for (String content : partHeader.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}

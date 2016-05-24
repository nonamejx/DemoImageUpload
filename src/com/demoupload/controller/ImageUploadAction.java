package com.demoupload.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.demoupload.bean.Image;
import com.demoupload.service.ImageService;

/**
 * Servlet implementation class ImageUploadAction
 */
@WebServlet("/ImageUploadAction")
public class ImageUploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageUploadAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		ImageService imgService = new ImageService();
		Image img = null;
		
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		
		String description = "";
		String newFileName = "";
		
		if (ServletFileUpload.isMultipartContent(request)) {
			
			try {
				@SuppressWarnings("unchecked")
				List<FileItem> formItems = upload.parseRequest(request);
				
				for (FileItem item : formItems) {
					if (item.isFormField()) {
						String name = item.getFieldName();
						String value = new String(item.getString().getBytes("ISO-8859-1"),"UTF-8");
						
						switch (name) {
						case "description":
							description = value;
							break;
						}
						
					} else {
						String fileName = item.getName();
						System.out.println("FileName: " + fileName);
						
						if (fileName.isEmpty()) {
							
						} else {
							
							// tao duong dan
							String dirUpload = request.getServletContext().getRealPath("resources") + File.separator + "images";
							System.out.println(dirUpload);
							File dir = new File(dirUpload);
							if (!dir.exists()) {
								dir.mkdir();
							}
							
							// tao ten moi
							newFileName = "Demo-" + System.nanoTime() + "." + FilenameUtils.getExtension(fileName);
							
							// upload anh
							File file = new File(dirUpload + File.separator + newFileName);
							item.write(file);
							
							// xoa anh cu
							
						}
						
					}
				}
				
				// add vao database
				img = new Image(newFileName, description);
				System.out.println(img.toString());
				imgService.addImage(img);
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {
			response.getWriter().println("This Servlet only handles file upload request");
		}
		
		response.sendRedirect(request.getContextPath() + "/");
		
	}

}

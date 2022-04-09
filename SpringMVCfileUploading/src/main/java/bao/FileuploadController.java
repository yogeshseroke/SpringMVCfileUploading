package bao;
import java.io.*;

import javax.persistence.Entity;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Entity
public class FileuploadController {

	@RequestMapping("/uploadview")
	public ModelAndView uploadview()
	{
		return new ModelAndView();
	}
	@RequestMapping("/uploadlogic")
	public ModelAndView uploadLogic(@RequestParam CommonsMultipartFile file,  
	           HttpSession session) throws IOException
	{
		//ServletContext context = session.getServletContext();  
	    //String path = context.getRealPath("images");  
		String path= session.getServletContext().getRealPath("/")+"images";  
        String filename=file.getOriginalFilename();  
	   // String filename = file.getOriginalFilename();  
	  
	    System.out.println(path+" "+filename);        
	  
	    byte[] bytes = file.getBytes();  
	    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
	         new File(filename)));  
	    stream.write(bytes);  
	    stream.flush();  
	    stream.close();  
	           
	    return new ModelAndView("uploadform","filesuccess",filename);  
		
	}
	
}

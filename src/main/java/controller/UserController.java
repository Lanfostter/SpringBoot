package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import model.User;

@Controller
public class UserController {
	public static List<User> users = new ArrayList<User>();

	@RequestMapping("/hello")
	public String sayHello(ModelMap map) {
		map.addAttribute("msg", "Controller");
		return "hello";
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.GET)
	public String addController(HttpServletRequest request) {

		request.setAttribute("user", new User());
		return "adduser";
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public String addController(HttpServletRequest request, @ModelAttribute("user")  User user,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			request.setAttribute("user", new User());
			return "adduser";
		} else {
			users.add(user);
			return "redirect:/add-user";
		}
	}

	@RequestMapping("/list-user")
	public String listController(HttpServletRequest request) {
		request.setAttribute("users", users);
		return "list";
	}

	@RequestMapping(value = "/update-user", method = RequestMethod.GET)
	public String updateController(HttpServletRequest request) {
		request.setAttribute("newuser", new User());
		return "update";
	}

	@RequestMapping(value = "/update-user", method = RequestMethod.POST)
	public String updateController(HttpServletRequest request, @ModelAttribute("newuser") User user) {
		for (int i = 0; i < users.size(); i++) {
			if (user.getId() == users.get(i).getId()) {
				users.set(i, user);
			}
		}
		return "redirect:/list-user";
	}

	@RequestMapping(value = "/delete-user", method = RequestMethod.GET)
	public String deleteController(HttpServletRequest request) {
		request.setAttribute("deleteuser", new User());
		return "delete";
	}

	@RequestMapping(value = "/delete-user", method = RequestMethod.POST)
	public String deleteController(HttpServletRequest request, @ModelAttribute("deleteuser") User user) {
		for (int i = 0; i < users.size(); i++) {
			if (user.getId() == users.get(i).getId()) {
				users.remove(i);
			}
		}
		return "redirect:/list-user";
	}
	@RequestMapping(value = "/upload-file", method = RequestMethod.GET)
	public String upload(HttpServletRequest request) {
		return "upload";
	}
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(HttpServletRequest request, @RequestParam(name="file")MultipartFile file) {
		// lưu file xuống ổ cứng
		try {
		File newFile = new File("C:\\Users\\Tom\\Downloads\\" + file.getOriginalFilename());
		FileOutputStream fileOutputStream = new FileOutputStream(newFile);
		fileOutputStream.write(file.getBytes());
		fileOutputStream.close();
		}
		catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("file", file);
		return "viewFile";
	}
//	@RequestMapping(value = "/download-file", method = RequestMethod.GET)
//	public String download(HttpServletRequest request, HttpServletResponse response) {
//		String dataDirectory = ("C:\\Users\\Tom\\Downloads\\");
//		Path file = Paths.get(dataDirectory, "1.jpeg");
//		
//	}
}

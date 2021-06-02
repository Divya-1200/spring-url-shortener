package com.demo.url.controller;


import java.nio.charset.StandardCharsets;
//import antlr.collections.List;
import java.util.List;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import com.demo.url.mapper.UserMapper;
import com.demo.url.model.User;
import com.demo.url.model.UserUrl;
import com.google.common.hash.Hashing;


@Controller
@SessionAttributes("user")
public class HomeController {

 
    @Autowired
    StringRedisTemplate redisTemplate;
    
    @Autowired
	private UserMapper userMapper;

		
	@RequestMapping(value="/" , method = {RequestMethod.POST,RequestMethod.GET})
	public String home() {

		return "url";
	}
	
	@RequestMapping(value="/post" , method = {RequestMethod.POST,RequestMethod.GET})
	public String homeUrl(@RequestParam String urlName, Model model) {
//		System.out.println(urlName);
		UrlValidator urlValidator = new UrlValidator(
                new String[]{"http", "https"}
        );

        if (urlValidator.isValid(urlName)) {
            String id = Hashing.murmur3_32().hashString(urlName, StandardCharsets.UTF_8).toString();
            redisTemplate.opsForValue().set(id, urlName);
            String shorturl = "http://localhost:8081/"+id;
            model.addAttribute("msg", shorturl);
            return "url";
        }

        return "error";

	}
	
	@GetMapping("/{id}")
    public String getUrl(@PathVariable String id, Model model) {
        String url = redisTemplate.opsForValue().get(id);

        if (url == null) {
            return "error";
        }

        return "redirect:"+url;
    }
	
	@RequestMapping(value="/signup" , method = {RequestMethod.POST,RequestMethod.GET})
	public String enterRegister(User user) {

		return "register";
	}
	
	@RequestMapping(value="/signup/form" , method = {RequestMethod.POST, RequestMethod.GET})
	public String RegisterForm(@ModelAttribute("user")  User user, Model model) {
		System.out.println(user.getName());
		try {
			userMapper.insertUser(user.getName(), user.getPassword());
			
		}
		catch(Exception e){
			System.out.println(e);
			model.addAttribute("msg", "Username password already exists");
			return "error";
		}
		
		return "redirect:/my/page";

	}
	
	@RequestMapping(value="/login" , method = {RequestMethod.POST,RequestMethod.GET})
	public String enterLogin(User user) {

		return "login";
	} 
	
	@RequestMapping(value="/login/form" , method = {RequestMethod.POST, RequestMethod.GET})
	public String loginForm(@ModelAttribute("user")  User user, UserUrl userurl, Model model) {

		try {
			User output = userMapper.findByUser(user.getName(), user.getPassword());
			if(output != null) {
				return "redirect:/my/page";
			}
			
		}
		catch(Exception e){
			model.addAttribute("msg", "Incorrect username and password");
			return "error";
		}
		model.addAttribute("msg", "Incorrect username and password");
		return "error";
	}
	
	@RequestMapping(value="/my/page" , method = {RequestMethod.POST,RequestMethod.GET})
	public String userPage(@ModelAttribute("user") @SessionAttribute("user") User user, UserUrl userurl, ModelMap model) {
		
		try {
			List<UserUrl> inf = userMapper.findUrl(user.getName());
	        
	        
	        model.put("inf",inf);
	        return "urluser";
			
		}
		catch(Exception e) {
			return "urluser";
			
		}
		

		
	}
	
	@GetMapping("/logout")
	public String closeSession(@ModelAttribute("user") User user, WebRequest request, SessionStatus status) {
		
		status.setComplete();
	    request.removeAttribute("user", WebRequest.SCOPE_SESSION);
		return "redirect:/";
	}
	
	@RequestMapping(value="/user/post" , method = {RequestMethod.POST,RequestMethod.GET})
	public String userUrl(@ModelAttribute("user") @SessionAttribute("user") User user, UserUrl userurl,@RequestParam String urlName, ModelMap model) {

		UrlValidator urlValidator = new UrlValidator(
                new String[]{"http", "https"}
        );

        if (urlValidator.isValid(urlName)) {
            String id = Hashing.murmur3_32().hashString(urlName, StandardCharsets.UTF_8).toString();
            redisTemplate.opsForValue().set(id, urlName);
            String shorturl = "http://localhost:8081/"+id;
//            System.out.println(shorturl);
            
            String existing_url = userMapper.findurl(user.getName(), shorturl);
            
            if (existing_url == null) {
            	System.out.println("here");
            	userMapper.inserturl(user.getName(), shorturl, urlName);
            	
            }
            
            model.addAttribute("msg", shorturl);
//            List<UserUrl> inf = userMapper.findUrl(user.getName());
//            
//            
//            model.put("inf",inf);
            return "urluser";
        }

        return "error";

	}

	
	
		
}
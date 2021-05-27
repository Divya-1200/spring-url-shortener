package com.demo.url.controller;


import java.nio.charset.StandardCharsets;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.hash.Hashing;


@Controller
public class HomeController {

 
    @Autowired
    StringRedisTemplate redisTemplate;

		
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
		
}
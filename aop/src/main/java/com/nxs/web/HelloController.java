package com.nxs.web;


import org.springframework.web.bind.annotation.*;

/**
 * @author 57014
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }
}

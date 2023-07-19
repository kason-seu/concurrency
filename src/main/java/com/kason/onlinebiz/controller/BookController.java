package com.kason.onlinebiz.controller;
import com.kason.onlinebiz.result.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {


    @RequestMapping("/hehe")
    @ResponseBody
    public String hehe() {
        return "hehe";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse<String> hello() {

        return ApiResponse.success(
                "ok"

        );
    }
}

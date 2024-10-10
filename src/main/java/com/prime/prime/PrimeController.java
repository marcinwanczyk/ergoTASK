package com.prime.prime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrimeController {

    @GetMapping("/prime")
    public String prime() {
        return "index";
    }

}

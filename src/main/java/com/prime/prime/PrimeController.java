package com.prime.prime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class PrimeController {

    private final PrimeService primeService;

    public PrimeController(PrimeService primeService) {
        this.primeService = primeService;
    }

    @GetMapping("/")
    public String index(Model model){
        return "index";
    }

    @GetMapping("/prime")
    public String prime(@RequestParam int bound, Model model) {
        List <Integer> primeNumbers = primeService.checkPrime(bound);
        model.addAttribute("primeNumbers", primeNumbers);
        model.addAttribute("bound", bound);
        return "index";
    }

}

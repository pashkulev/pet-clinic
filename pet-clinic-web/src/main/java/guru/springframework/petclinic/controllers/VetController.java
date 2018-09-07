package guru.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VetController {

    @RequestMapping(value = {"/vets", "/vets/index", "/vets/index.html"}, method = RequestMethod.GET)
    public String listVets() {

        return "vets/index";
    }
}

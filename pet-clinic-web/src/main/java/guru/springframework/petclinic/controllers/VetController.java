package guru.springframework.petclinic.controllers;

import guru.springframework.petclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping(value = {"/vets", "/vets/index", "/vets/index.html", "/vets.html"}, method = RequestMethod.GET)
    public String listVets(Model model) {
        model.addAttribute("vets", this.vetService.findAll());
        return "vets/index";
    }
}

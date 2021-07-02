package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.InstitutionService;

import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final InstitutionService institutionService;

    @GetMapping("/dashboard")
    public String getDashboard(Model model) {
        return "admin/index";
    }

    @GetMapping("/institutions")
    public String getInstitutions(Model model) {
        List<Institution> all = institutionService.findAll();
        System.out.println(Arrays.toString(all.toArray()));
        model.addAttribute("institutions", all);
        return "admin/institutions";
    }

    @GetMapping("/institution/{id}")
    public String editInstitution(Model model, @PathVariable long id) {
        Institution institution = institutionService.findById(id);

        model.addAttribute("institution", institution);
        return "admin/editInstitution";
    }

    // TODO POST /admin/institution/edit

}

package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/donations")
@RequiredArgsConstructor
public class DonationController {

    private final DonationService donationService;
    private final CategoryService categoryService;
    private final InstitutionService institutionService;

    @GetMapping("/form")
    public String getForm(Model model) {
        Donation donation = new Donation();
        List<Category> categories = categoryService.findAll();
        List<Institution> institutions = institutionService.findAll();

        model.addAttribute("donation", donation);
        model.addAttribute("categories", categories);
        model.addAttribute("institutions", institutions);

        return "form";
    }

    @PostMapping("/donate")
    public String getDonation(@Valid Donation donation, BindingResult result) {

        if (result.hasErrors()) {
            return "form";
        }

        donationService.save(donation);

        return "form-confirmation";

    }

}

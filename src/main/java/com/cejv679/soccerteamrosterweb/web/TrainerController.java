package com.cejv679.soccerteamrosterweb.web;

import com.cejv679.soccerteamrosterweb.TrainerForm;
import java.util.Currency;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class TrainerController {
    
     List<String> countries = new LinkedList<>();
    Map<String, String> countryMap = new HashMap<>();

    public TrainerController() {
        initCountries();
    }
    
    

    @RequestMapping(value = "/createtrainer", method = GET)
    public String showRegistrationForm(Model model) {
        TrainerForm trainerForm = new TrainerForm();
        model.addAttribute(trainerForm);
        model.addAttribute("countries",countries);      
               
        return "createtrainerForm";
    }

    @RequestMapping(value = "/createtrainer", method = POST, params = "create")
    public String processRegistration(@Valid TrainerForm trainerForm, Errors errors, Model model) {
        if (errors.hasErrors()) {
            System.out.println(errors.getAllErrors().toString());
            model.addAttribute("countries",countries);      
            return "createtrainerForm";
        }
        model.addAttribute(trainerForm);
        Locale loc = new Locale("", countryMap.get(trainerForm.getCountryOfBirth()));
        Currency curr = Currency.getInstance(loc);
        model.addAttribute("currencySymbol", curr.getSymbol());       
        return "trainerdetails";
    }

    @RequestMapping(value = "/createtrainer", method = POST, params = {"cancel"})
    public String cancelRegistration(@Valid TrainerForm trainerForm, Errors errors, Model model) {
        return "redirect:/";
    }    
    

    private void initCountries() {
        String[] countryCodes = Locale.getISOCountries();

        for (String countryCode : countryCodes) {
            Locale loc = new Locale("", countryCode);
            countries.add(loc.getDisplayCountry(Locale.ENGLISH));
            countryMap.put(loc.getDisplayCountry(Locale.ENGLISH), countryCode);
        }
    }

}

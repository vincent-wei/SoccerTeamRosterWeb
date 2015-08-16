package com.cejv679.soccerteamrosterweb.web;

import com.cejv679.soccerteamrosterweb.PlayerForm;
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
public class PlayerController {
    
     List<String> countries = new LinkedList<>();
    Map<String, String> countryMap = new HashMap<>();

    public PlayerController() {
        initCountries();
    }
    
    

    @RequestMapping(value = "/createplayer", method = GET)
    public String showRegistrationForm(Model model) {
        PlayerForm playerForm = new PlayerForm();
        model.addAttribute(playerForm);
        model.addAttribute("countries",countries);      
               
        return "createplayerForm";
    }

    @RequestMapping(value = "/createplayer", method = POST, params = "create")
    public String processRegistration(@Valid PlayerForm playerForm, Errors errors, Model model) {
        if (errors.hasErrors()) {
            System.out.println(errors.getAllErrors().toString());
            model.addAttribute("countries",countries);      
            return "createplayerForm";
        }
        Locale loc = new Locale("", countryMap.get(playerForm.getCountryOfBirth()));
        Currency curr = Currency.getInstance(loc);
        model.addAttribute(playerForm);
        model.addAttribute("currencySymbol", curr.getSymbol());       
        return "playerdetails";
    }

    @RequestMapping(value = "/createplayer", method = POST, params = {"cancel"})
    public String cancelRegistration(@Valid PlayerForm playerForm, Errors errors, Model model) {
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

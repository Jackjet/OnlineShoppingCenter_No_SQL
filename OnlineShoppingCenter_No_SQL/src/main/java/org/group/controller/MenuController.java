package org.group.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lincolnz9511 on 16-11-20.
 */

@Controller
public class MenuController {
    @ModelAttribute(value = "subject")
    public Subject subject() {
        return SecurityUtils.getSubject();
    }

    @RequestMapping(value={"/menu/{city}"})
    public String MenuTemplate(@PathVariable("city") String city, Model model) {
        String city1 = "Beijing";
        String city2 = "Shanghai";
        String city3 = "Guangzhou";
        String curCity = city;


        model.addAttribute("curCity", curCity);

        String commodity_Guangzhou[] = {"Rice rolls", "Porridge", "Chicken wings", "Hamburg", "French fries", "Coffee"};
        String commodity_Guangzhou_pic[] = {"RiceRolls.jpg", "Porridge.jpg", "ChickenWings.jpg", "Hamburg.jpg", "FrenchFries.jpg", "Coffee.jpg"};
        String price_Guangzhou[] = {"¥12", "¥10", "¥12", "¥23", "¥11", "¥20"};
        String commodity_Shanghai[] = {"Dumplings", "Treasures rice", "Hairy crabs", "Fried bun", "Rice balls", "Tea"};
        String commodity_Shanghai_pic[] = {"Dumplings.jpg", "TreasuresRice.jpg", "HairyCrabs.jpg", "FriedBun.jpg", "RiceBalls.jpg", "Tea.jpg"};
        String price_Shanghai[] = {"¥20", "¥15", "¥35", "¥18", "¥12", "¥10"};
        String commodity_Beijing[] = {"Roast duck", "Sugar haws", "Noodles", "Boiled mutton", "Caramel treats", "Plum syrup"};
        String commodity_Beijing_pic[] = {"RoastDuck.jpg", "SugarHaws.jpg", "Noodles.jpg", "BoiledMutton.jpg", "CaramelTreats.jpg", "PlumSyrup.jpg"};
        String price_Beijing[] = {"¥45", "¥7", "¥12", "¥60", "¥8", "¥8"};

        if (curCity.equals(city3)) {
            model.addAttribute("commodity1", commodity_Guangzhou[0]);
            model.addAttribute("commodity2", commodity_Guangzhou[1]);
            model.addAttribute("commodity3", commodity_Guangzhou[2]);
            model.addAttribute("commodity4", commodity_Guangzhou[3]);
            model.addAttribute("commodity5", commodity_Guangzhou[4]);
            model.addAttribute("commodity6", commodity_Guangzhou[5]);

            model.addAttribute("commodity1_pic", commodity_Guangzhou_pic[0]);
            model.addAttribute("commodity2_pic", commodity_Guangzhou_pic[1]);
            model.addAttribute("commodity3_pic", commodity_Guangzhou_pic[2]);
            model.addAttribute("commodity4_pic", commodity_Guangzhou_pic[3]);
            model.addAttribute("commodity5_pic", commodity_Guangzhou_pic[4]);
            model.addAttribute("commodity6_pic", commodity_Guangzhou_pic[5]);

            model.addAttribute("price1", price_Guangzhou[0]);
            model.addAttribute("price2", price_Guangzhou[1]);
            model.addAttribute("price3", price_Guangzhou[2]);
            model.addAttribute("price4", price_Guangzhou[3]);
            model.addAttribute("price5", price_Guangzhou[4]);
            model.addAttribute("price6", price_Guangzhou[5]);
        } else if (curCity.equals(city1)) {
            model.addAttribute("commodity1", commodity_Beijing[0]);
            model.addAttribute("commodity2", commodity_Beijing[1]);
            model.addAttribute("commodity3", commodity_Beijing[2]);
            model.addAttribute("commodity4", commodity_Beijing[3]);
            model.addAttribute("commodity5", commodity_Beijing[4]);
            model.addAttribute("commodity6", commodity_Beijing[5]);

            model.addAttribute("commodity1_pic", commodity_Beijing_pic[0]);
            model.addAttribute("commodity2_pic", commodity_Beijing_pic[1]);
            model.addAttribute("commodity3_pic", commodity_Beijing_pic[2]);
            model.addAttribute("commodity4_pic", commodity_Beijing_pic[3]);
            model.addAttribute("commodity5_pic", commodity_Beijing_pic[4]);
            model.addAttribute("commodity6_pic", commodity_Beijing_pic[5]);

            model.addAttribute("price1", price_Beijing[0]);
            model.addAttribute("price2", price_Beijing[1]);
            model.addAttribute("price3", price_Beijing[2]);
            model.addAttribute("price4", price_Beijing[3]);
            model.addAttribute("price5", price_Beijing[4]);
            model.addAttribute("price6", price_Beijing[5]);
        } else {
            model.addAttribute("commodity1", commodity_Shanghai[0]);
            model.addAttribute("commodity2", commodity_Shanghai[1]);
            model.addAttribute("commodity3", commodity_Shanghai[2]);
            model.addAttribute("commodity4", commodity_Shanghai[3]);
            model.addAttribute("commodity5", commodity_Shanghai[4]);
            model.addAttribute("commodity6", commodity_Shanghai[5]);

            model.addAttribute("commodity1_pic", commodity_Shanghai_pic[0]);
            model.addAttribute("commodity2_pic", commodity_Shanghai_pic[1]);
            model.addAttribute("commodity3_pic", commodity_Shanghai_pic[2]);
            model.addAttribute("commodity4_pic", commodity_Shanghai_pic[3]);
            model.addAttribute("commodity5_pic", commodity_Shanghai_pic[4]);
            model.addAttribute("commodity6_pic", commodity_Shanghai_pic[5]);

            model.addAttribute("price1", price_Shanghai[0]);
            model.addAttribute("price2", price_Shanghai[1]);
            model.addAttribute("price3", price_Shanghai[2]);
            model.addAttribute("price4", price_Shanghai[3]);
            model.addAttribute("price5", price_Shanghai[4]);
            model.addAttribute("price6", price_Shanghai[5]);
        }
        return "menu";
    }

}

package org.group.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lincolnz9511 on 16-11-20.
 */
@Controller
public class OrderController {
    @ModelAttribute(value = "subject")
    public Subject subject() {
        return SecurityUtils.getSubject();
    }

    @RequestMapping(value="/order/{city}")
    public String OrderDetailTemplate(@PathVariable("city")String city,
          @RequestParam("commodity1") int commodity1_amount, @RequestParam("commodity2") int commodity2_amount,
          @RequestParam("commodity3") int commodity3_amount, @RequestParam("commodity4") int commodity4_amount,
          @RequestParam("commodity5") int commodity5_amount, @RequestParam("commodity6") int commodity6_amount
            , Model model) {

        subject().getPrincipal().toString();
        double totalPay = 0;
        String city1 = "Beijing";
        String city2 = "Shanghai";
        String city3 = "Guangzhou";
        String curCity = city3;

        if (city != null) {
            curCity = city;
        }

        String commodity_Guangzhou[] = {"Rice rolls", "Porridge", "Chicken wings", "Hamburg", "French fries", "Coffee"};
        String price_Guangzhou[] = {"12", "10", "12", "23", "11", "20"};
        String commodity_Shanghai[] = {"Dumplings", "Treasures rice", "Hairy crabs", "Fried bun", "Rice balls", "Tea"};
        String price_Shanghai[] = {"20", "15", "35", "18", "12", "10"};
        String commodity_Beijing[] = {"Roast duck", "Sugar haws", "Noodles", "Boiled mutton", "Caramel treats", "Plum syrup"};
        String price_Beijing[] = {"45", "7", "12", "60", "8", "8"};

        model.addAttribute("amount1", Integer.toString(commodity1_amount));
        model.addAttribute("amount2", Integer.toString(commodity2_amount));
        model.addAttribute("amount3", Integer.toString(commodity3_amount));
        model.addAttribute("amount4", Integer.toString(commodity4_amount));
        model.addAttribute("amount5", Integer.toString(commodity5_amount));
        model.addAttribute("amount6", Integer.toString(commodity6_amount));


        if (curCity.equals(city3)) {
            model.addAttribute("commodity1", commodity_Guangzhou[0]);
            model.addAttribute("commodity2", commodity_Guangzhou[1]);
            model.addAttribute("commodity3", commodity_Guangzhou[2]);
            model.addAttribute("commodity4", commodity_Guangzhou[3]);
            model.addAttribute("commodity5", commodity_Guangzhou[4]);
            model.addAttribute("commodity6", commodity_Guangzhou[5]);
            totalPay = commodity1_amount*Integer.parseInt(price_Guangzhou[0])+commodity2_amount*Integer.parseInt(price_Guangzhou[1])+
                    commodity3_amount*Integer.parseInt(price_Guangzhou[2])+commodity4_amount*Integer.parseInt(price_Guangzhou[3])+
                    commodity5_amount*Integer.parseInt(price_Guangzhou[4])+commodity6_amount*Integer.parseInt(price_Guangzhou[5]);
        } else if (curCity.equals(city1)) {
            model.addAttribute("commodity1", commodity_Beijing[0]);
            model.addAttribute("commodity2", commodity_Beijing[1]);
            model.addAttribute("commodity3", commodity_Beijing[2]);
            model.addAttribute("commodity4", commodity_Beijing[3]);
            model.addAttribute("commodity5", commodity_Beijing[4]);
            model.addAttribute("commodity6", commodity_Beijing[5]);
            totalPay = commodity1_amount*Integer.parseInt(price_Beijing[0])+commodity2_amount*Integer.parseInt(price_Beijing[1])+
                    commodity3_amount*Integer.parseInt(price_Beijing[2])+commodity4_amount*Integer.parseInt(price_Beijing[3])+
                    commodity5_amount*Integer.parseInt(price_Beijing[4])+commodity6_amount*Integer.parseInt(price_Beijing[5]);
        } else {
            model.addAttribute("commodity1", commodity_Shanghai[0]);
            model.addAttribute("commodity2", commodity_Shanghai[1]);
            model.addAttribute("commodity3", commodity_Shanghai[2]);
            model.addAttribute("commodity4", commodity_Shanghai[3]);
            model.addAttribute("commodity5", commodity_Shanghai[4]);
            model.addAttribute("commodity6", commodity_Shanghai[5]);
            totalPay = commodity1_amount*Integer.parseInt(price_Shanghai[0])+commodity2_amount*Integer.parseInt(price_Shanghai[1])+
                    commodity3_amount*Integer.parseInt(price_Shanghai[2])+commodity4_amount*Integer.parseInt(price_Shanghai[3])+
                    commodity5_amount*Integer.parseInt(price_Shanghai[4])+commodity6_amount*Integer.parseInt(price_Shanghai[5]);
        }
        model.addAttribute("totalAmount", commodity1_amount+commodity2_amount+commodity3_amount+commodity4_amount+commodity5_amount+commodity6_amount);
        model.addAttribute("totalPay", totalPay);
        model.addAttribute("vip", "");
        return "order";
    }

}

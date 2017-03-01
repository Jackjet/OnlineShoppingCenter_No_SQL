package org.group.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lincolnz9511 on 16-11-20.
 */
@Controller
public class CuisineDetailController {

    public String convertPictureName(String cuisine) {
        String[] arr = cuisine.split(" ");
        String picName = "";
        for (int i = 0; i < arr.length; ++i) {
            String temp =  arr[i].toUpperCase();
            temp = temp.substring(0,1);
            picName += temp+arr[i].substring(1);
        }
        return picName;
    }

    @ModelAttribute(value = "subject")
    public Subject subject() {
        return SecurityUtils.getSubject();
    }

    @RequestMapping(value="/cuisine_detail")
    public String CuisineDetailTemplate(@RequestParam(value = "cuisine", required = true) String cuisine, Model model) {
        Map commondity_Detail = new HashMap<String, String>();
        Map commodity_Price = new HashMap<String, String>();

        /* 商品价格，详情*/
        commodity_Price.put("Rice rolls","¥12");
        commondity_Detail.put("Rice rolls", "Rice Rolls is a Chinese tradition food, which is made of rice and is produced by pouring rice milk into stream machine.");

        commodity_Price.put("Porridge","¥10");
        commondity_Detail.put("Porridge", "Porridge is a Chinese traditional food. The means to make porridge are that you can mix water and rice into one pot and boil about half an hour.");

        commodity_Price.put("Chicken wings","¥12");
        commondity_Detail.put("Chicken wings", "Chicken wings is really delicious, there is no reason you should not order it!");

        commodity_Price.put("Hamburg","¥23");
        commondity_Detail.put("Hamburg", "Hamburg is man-made, and it contains fresh vegetables, meat and bread. Don't you dare omit it!");

        commodity_Price.put("French fries","¥11");
        commondity_Detail.put("French fries", "We use fresh potatoes to make French Fries, and we make save it's warm when it goes into your month.");

        commodity_Price.put("Coffee","¥20");
        commondity_Detail.put("Coffee", "Coffee in our store is fantastic. We use expensive coffee beans to boil, and it is one of the best items in our store.");

        commodity_Price.put("Dumplings","¥20");
        commondity_Detail.put("Dumplings", "They are made of delicious soup and fresh meat. It is an unforgettable experience to swallow them.");

        commodity_Price.put("Treasures rice","¥15");
        commondity_Detail.put("Treasures rice", "It is sweet and really healthy food. It is certainly good to your health.");

        commodity_Price.put("Hairy crabs","¥35");
        commondity_Detail.put("Hairy crabs", "We use fresh and alive to cook, which originated from Yangcheng Lake.");

        commodity_Price.put("Fried bun","¥18");
        commondity_Detail.put("Fried bun", "Fried buns is a meat bun which is fried and really religious.");

        commodity_Price.put("Rice balls","¥12");
        commondity_Detail.put("Rice balls", "They are made by rice balls and some other sweet material like red beans and longans.");

        commodity_Price.put("Tea","¥10");
        commondity_Detail.put("Tea", "We use high class tea leaves and fresh water to boil the tea. We save that it is worth trying!");

        commodity_Price.put("Roast duck","¥45");
        commondity_Detail.put("Roast duck", "Beijing Roast Duck is one of the most famous dishes in China, which is beyond description.");

        commodity_Price.put("Sugar haws","¥7");
        commondity_Detail.put("Sugar haws", "It is well-known dessert in China, which is favored by most people.");

        commodity_Price.put("Noodles","¥12");
        commondity_Detail.put("Noodles", "Noodles with soybean paste is famous for its fantastic taste. When you eat this meal, all you feel is fucking awesome.");

        commodity_Price.put("Boiled mutton","¥60");
        commondity_Detail.put("Boiled mutton", "Mutton in hot pot is very suitable for dinner when the temperature is getting low. It makes you feel warm and really good for your sexual health.");

        commodity_Price.put("Caramel treats","¥8");
        commondity_Detail.put("Caramel treats", "It is a cheap and delicious dessert.");

        commodity_Price.put("Plum syrup","¥8");
        commondity_Detail.put("Plum syrup", "Syrup of Plum is thirst-quenching and good for your throat.");

        model.addAttribute("commodity", cuisine);
        model.addAttribute("commodity_Detail", commondity_Detail.get(cuisine));
        String picNamePre = convertPictureName(cuisine);
        model.addAttribute("commodity_pic1", picNamePre+"1.jpg");
        model.addAttribute("commodity_pic2", picNamePre+"2.jpg");
        model.addAttribute("commodity_pic3", picNamePre+"3.jpg");
        model.addAttribute("commodity_Price", commodity_Price.get(cuisine));

        return "cuisine_detail";
    }

}

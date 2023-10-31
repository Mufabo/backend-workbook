package main.java.wad._02_08_item_database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemDatabaseController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("items", this.itemRepository.findAll());
        return "index";
    }

}
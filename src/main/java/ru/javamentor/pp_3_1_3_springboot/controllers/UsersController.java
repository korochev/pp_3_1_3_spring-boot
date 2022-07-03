package ru.javamentor.pp_3_1_3_springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.pp_3_1_3_springboot.models.User;
import ru.javamentor.pp_3_1_3_springboot.service.UserService;

@Controller
public class UsersController {

    private final UserService userSrv;

    @Autowired
    public UsersController(UserService userService) {
        this.userSrv = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userSrv.index());
        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("User", userSrv.show(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("User") User User) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("User") User User,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new";

        userSrv.save(User);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("User", userSrv.show(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("User") User User, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "edit";

        userSrv.save(User);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userSrv.delete(id);
        return "redirect:/";
    }
}

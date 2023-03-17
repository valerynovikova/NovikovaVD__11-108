package controller;

//rest-возвращает тело запроса, обычный-надо подклчать резоилдер,резоилдером распарсится в страничку

import dto.CreateUserRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    //cтраница должна открываться ток у авторизованного пользоателя,
    //на выходе получаем имя авторизованного пользователя ,авторизован как..
    @GetMapping("/home")
    public String home(HttpServletRequest httpServletRequest) {
        String currentPrincipalName = httpServletRequest.getUserPrincipal().getName();
        return "home";
    }
    //тоже самое с личным кабинетом

    @GetMapping("/personal")
    public String personal(HttpServletRequest httpServletRequest) {
        String currentPrincipalName = httpServletRequest.getUserPrincipal().getName();
        return "personal";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/sign_up")
    public String signUp(Model model) {
        model.addAttribute("user", new CreateUserRequestDto());
        return "sign_up";
    }
}

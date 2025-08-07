package io.github.rokloc.MessageBoardApp.controller;

import org.springframework.stereotype.Controller;                 // @Controllerアノテーション
import org.springframework.ui.Model;                              // テンプレートに値を渡す
import org.springframework.web.bind.annotation.*;        			// GETマッピングなど 
// 自作のサービスやエンティティ
import io.github.rokloc.MessageBoardApp.service.UserService;
import io.github.rokloc.MessageBoardApp.model.User;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // コンストラクタインジェクション
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ユーザー登録フォーム表示
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User()); // Thymeleafでフォームバインディングするために空のUserを渡す
        return "register"; // register.html（テンプレート）を返す
    }

    // フォームから送信されたデータを受け取って登録処理
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userService.registerUser(user);
        return "redirect:/login"; // 登録後はログインページへリダイレクト
    }
}




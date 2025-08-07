package io.github.rokloc.MessageBoardApp.service;

import io.github.rokloc.MessageBoardApp.model.User;
import io.github.rokloc.MessageBoardApp.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 新規ユーザーを登録する（パスワードはハッシュ化して保存）
    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // パスワードを安全にハッシュ化
        user.setRole("USER"); // デフォルトでロールは「USER」
        userRepository.save(user); // saveはJpaRepositoryのメソッドで自動提供されている
    }

    // ユーザー名でユーザーを検索（ログイン時に使用）
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}


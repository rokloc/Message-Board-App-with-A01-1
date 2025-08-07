package io.github.rokloc.MessageBoardApp.model;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
	//field
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // 自動採番の戦略（MySQLならIDENTITYが一般的）
	private int id;
	
	@Column(nullable = false, unique = true, length = 50)
	private String username;
	
	@Column(nullable = false, length = 255)
	private String password;
	
	@Column(nullable = true, length = 20)
	private String role;
	
	
	//getter
	public int getId() {
		return (this.id);
	}
	public String getUsername() {
		return (this.username);
	}
	public String getPassword() {
		return (this.password);
	}
	public String getRole() {
		return (this.role);
	}
	
	
	//setter
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	//コンストラクタ
	public User() {
		//JPAがつかうデフォルトコンストラクタ（必須）
	}
	public User(String username, String password, String role) {
		setUsername(username);
		setPassword(password);
		setRole(role);
	}
	
	
	
	
	
	
	
	
	
}

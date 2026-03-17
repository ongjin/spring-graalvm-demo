package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Native Image에서 JPA 프록시 문제를 피하기 위해
    // 모든 연관관계는 EAGER로 설정 (블로그 참고)
    // 현재 이 엔티티는 단순하지만, 연관관계 추가 시 참고용 주석

    protected User() {} // JPA 기본 생성자

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void updateName(String name) { this.name = name; }
    public void updateEmail(String email) { this.email = email; }
}

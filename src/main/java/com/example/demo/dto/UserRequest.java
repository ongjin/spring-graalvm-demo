package com.example.demo.dto;

// Record 타입은 Native Image와 궁합이 좋다
// Jackson이 리플렉션 없이 컴파일 타임에 처리 가능
public record UserRequest(String name, String email) {}

# Spring Boot GraalVM Native Image Demo

Spring Boot 3.5.11 + GraalVM 25 (JDK 25 LTS) 기반의 CRUD API 서버.
GraalVM Native Image 빌드를 적용해서 Lambda 콜드스타트를 8.2초 → 0.3초로 줄인 실험 프로젝트.

## 기술 스택

- Java 25 (JDK 25 LTS)
- Spring Boot 3.5.11
- Spring Data JPA + H2
- Spring Security (Basic Auth)
- GraalVM 25 Native Build Tools 0.10.6

## 실행

```bash
# JVM 모드
./gradlew bootRun

# 테스트
./gradlew test

# Native Image 빌드 (GraalVM 25 필요)
./gradlew nativeCompile

# Native 실행
./build/native/nativeCompile/demo-api
```

## API

| Method | Path | Description |
|--------|------|-------------|
| GET | /api/users | 전체 사용자 조회 |
| GET | /api/users/{id} | 사용자 단건 조회 |
| POST | /api/users | 사용자 생성 |
| PUT | /api/users/{id} | 사용자 수정 |
| DELETE | /api/users/{id} | 사용자 삭제 |

인증: Basic Auth (admin / admin)

## Native Image 관련 이슈

- JPA 프록시: Lazy → Eager 전환으로 해결
- Jackson 직렬화: Record 타입 DTO 사용
- 리플렉션 힌트: `@RegisterReflectionForBinding` + `reflect-config.json`
- 프록시 설정: `proxy-config.json`에 Repository 인터페이스 등록

벤치마크 결과는 [BENCHMARK.md](BENCHMARK.md) 참고.

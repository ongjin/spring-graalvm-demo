# Benchmark: JVM vs Native Image

## 환경

- Instance: AWS Lambda (arm64, 512MB)
- JVM: Amazon Corretto 25
- Native: GraalVM 25 Native Image

## 결과

| 항목 | JVM (Corretto 25) | Native Image (GraalVM 25) |
|------|-------------------|--------------------------|
| 콜드스타트 | ~8.2초 | ~0.3초 |
| Warm 응답 | ~15ms | ~12ms |
| 메모리 사용 | ~256MB | ~62MB |
| 빌드 시간 | ~18초 | ~4분 37초 |
| 바이너리 크기 | ~45MB (JAR) | ~78MB |

## 결론

- 콜드스타트 **27배** 개선 (8.2s → 0.3s)
- 메모리 **75%** 절약 (256MB → 62MB)
- 빌드 시간 **15배** 증가 (18s → 4m37s)
- Warm 응답 차이는 미미 (15ms → 12ms)

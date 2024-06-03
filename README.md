# Calmvas Server

Calmvas Server는 마사지와 웰니스에 초점을 맞춘 커뮤니티와 쇼핑 플랫폼입니다. 사용자는 다양한 부위(EYES, FACE, CHIN, CHEEK)에 대한 마사지 방법을 공유하고, 웰니스 제품을 구매할 수 있습니다.

## 주요 기능

- **마사지 게시판**: 사용자는 눈, 얼굴, 턱, 볼 등 다양한 부위별 마사지 방법을 공유하고 토론할 수 있습니다.
- **쇼핑**: 다양한 웰니스 제품을 쇼핑할 수 있는 기능을 제공합니다.
- **오늘의 문제**: 마사지 상식을 채울 수 있습니다

## 기술 스택

이 프로젝트는 다음 기술들을 사용하여 구축되었습니다:

- **Frontend**: Flutter
- **Backend**: Spring Server
- **Database**: MySQL
- **Monitoring**: Prometheus, Grafana
- **Containerization**: Docker, Docker Compose

## 시작하기
프로젝트를 로컬 라즈베리파이 서버에서 실행하기 위한 단계입니다.

### 전제 조건

- 라즈베리파이에 Docker 및 Docker Compose가 설치되어 있어야 합니다.
- 필요한 모든 이미지를 Docker Hub에서 사용할 수 있어야 합니다.

### 설치

1. 이 저장소를 클론합니다.

```bash
git clone [저장소 URL]
cd calmvas-server
```

2. Docker Compose를 사용하여 서비스를 시작합니다.

```bash
docker-compose up -d
```

이 명령은 필요한 모든 컨테이너를 라즈베리파이 서버에 배포하고 시작합니다. 배포가 완료되면, 웹 브라우저를 통해 서버에 접속할 수 있습니다.

## 사용법
Swagger-ui를 확인하면 됩니다
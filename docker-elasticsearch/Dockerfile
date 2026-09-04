FROM docker.elastic.co/elasticsearch/elasticsearch:9.4.5

# Nori 한글 형태소 분석기 플러그인 설치
# --batch: 설치 중 대화형 프롬프트 없이 진행 (CI/빌드 환경 필수)
RUN bin/elasticsearch-plugin install --batch analysis-nori

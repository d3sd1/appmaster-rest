
__

post-pipeline (en server):

  - docker-compose rm
  - export DOCKER_CLIENT_TIMEOUT=120
  - export COMPOSE_HTTP_TIMEOUT=120
  - docker-compose up --build  --force-recreate
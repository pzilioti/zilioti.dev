docker stop portfolio-server
docker rm portfolio-server
mvn clean install
docker build -t portfolio/server .
docker-compose up -d

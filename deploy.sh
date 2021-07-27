docker stop portfolio-server
docker rm portfolio-server
docker stop portfolio-db
docker rm portfolio-db
mvn clean install
docker build -t portfolio/db ./database
docker build -t portfolio/server .
docker-compose up -d

### Como Rodar seu Projeto

```
unset JAVA_HOME
cd ~/Desktop/seu-projeto/quarkus-reactive
chmod +x mvnw
./mvnw clean compile quarkus:dev \
  -Dquarkus.http.host=0.0.0.0 \
  -Dquarkus.http.port=8080
```

# Desafio Docket-Brasil - Projeto docket-cartorio - CRUD de Cartórios

# Sobre o projeto

Acesso do projeto na nuvem: https://docket-brasil-cartorio.herokuapp.com/home/index

Docket Brasil Cartório é uma aplicação full stack web, construída para o teste técnico para uma vaga na Docket-Brasil.

A aplicação consiste em cadastrar as informações básicas de um cartório, tais como: nome, endereço e o tipo de certidão que o pode ser emitida. Essas certidões são obtidas diretamente do consumo de uma API REST disponibilizada pela própria Docket no seguinte endpoint: https://docketdesafiobackend.herokuapp.com/api/v1/certidoes

O desenvolvimento consistiu em duas grandes frentes:

1- Desenvolvimento backend utilizando Spring Boot, JPA e Hibernate para acesso ao banco de dados.

2- Desenvolvimento frontend utilizando Thymeleaf e Bootstrap.

## Layout web
![Web 1](https://github.com/fSantosLima/assetsRepo/blob/main/web1.PNG)

![Web 2](https://github.com/fSantosLima/assetsRepo/blob/main/web2.PNG)

## Modelo conceitual
![Modelo Conceitual](https://github.com/fSantosLima/assetsRepo/blob/main/modelo_conceitual.PNG)

Abaixo segue as configurações do arquivo de propriedades do sistema. Neste arquivo, contém as configurações de acesso a base H2(desenvolvimento) e base Postgres(Produção). O mesmo se encontra configurado para acessar a base na nuvem(Heroku). Neste arquivo contém também o endpoint da API de certidões que a aplicação consome para relacionar aos cartórios.


#### application.properties
```
##CONFIGURA�OES DA BASE DE DADOS H2
#spring.datasource.url=jdbc:h2:mem:testdb
#spring.datasource.username=sa
#spring.datasource.password=
#spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
#spring.h2.console.enabled=true
#spring.h2.console.path=/h2-console
#spring.jpa.open-in-view=false
#spring.jpa.hibernate.ddl-auto=none

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true



##CONFIGS POSTGRES HEROKU
spring.datasource.url=jdbc:postgresql://ec2-3-86-169-29.compute-1.amazonaws.com:5432/dkmsvju4ue7ul
spring.datasource.username=bxmhjqlibalrxo
spring.datasource.password=aa7970f093488bf8b0bb494f1238f3ba307b0355e84dc3f94b0738b55adcd26c
spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults=false
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQL9Dialect
spring.jpa.hibernate.ddl-auto=create


##ENDPOINT API DOCKET DE CERTIDOES
certidoes.api.endpoint=https://docketdesafiobackend.herokuapp.com/api/v1/certidoes
```

# Tecnologias utilizadas
## Back end
- Java 8
- Spring Boot
- JPA / Hibernate
- H2DB (Ambiente de testes / desenvolvimento) / Postgres (Ambiente de produção)
- Maven
## Front end
- Thymeleaf
- Bootstrap
## Implantação em produção
- Heroku
- Banco de dados: Postgresql

# Como executar o projeto

Pré-requisitos: Java 8

```bash
# clonar repositório
git clone https://github.com/fSantosLima/docket-cartorio.git

# entrar na pasta do projeto 
cd docket-cartorio

# executar o projeto
./mvnw spring-boot:run

acessar a aplicação na seguinte url: http://localhost:8080/home/index
```

# Autor

Fernando Barros dos Santos de Lima

https://www.linkedin.com/in/fernando-santos-de-lima-8a2aa4209/

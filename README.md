# Teste Docket-Brasil - Projeto docket-cartorio - CRUD de Cartorios
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/neliocursos/exemplo-readme/blob/main/LICENSE) 

# Sobre o projeto

Acesso do projeto na nuvem: https://docket-brasil-cartorio.herokuapp.com/home/index

Docket Brasil Cartorio é uma aplicação full stack web construída para o teste prático para uma vaga na Docket-Brasil

A aplicação consiste em cadastrar as informações básicas de um cartório. Tais como: Nome, endereço e o tipo de certidão que o mesmo pode emitir. Estes tipos de certidões são obtidos diretamente do consumo de uma API REST disponibilizada pela própria Docket no seguinte endpoint: https://docketdesafiobackend.herokuapp.com/api/v1/certidoes

## Layout web
![Web 1](https://github.com/fSantosLima/assetsRepo/blob/main/web1.PNG)

![Web 2](https://github.com/fSantosLima/assetsRepo/blob/main/web2.PNG)

## Modelo conceitual
![Modelo Conceitual](https://github.com/fSantosLima/assetsRepo/blob/main/modelo_conceitual.PNG)

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- H2DB(Ambiente de testes / desenvolvimento) / Postgres(Ambiente de produção)
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
git clone 

# entrar na pasta do projeto 
cd 

# executar o projeto
./mvnw spring-boot:run
```

# Autor

Fernando Barros dos Santos de Lima

https://www.linkedin.com/in/fernando-santos-de-lima-8a2aa4209/

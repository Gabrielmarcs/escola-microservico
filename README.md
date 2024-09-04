# Microserviço de Disciplinas e Envio de E-mails
Este projeto é uma aplicação de microserviços desenvolvida com Spring Boot. O sistema permite o gerenciamento de disciplinas e inscrições em um ambiente escolar, além de enviar notificações por e-mail para os usuários.

## Tecnologias Utilizadas
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
- Java 17
- Spring Boot
- Spring Cloud OpenFeign
- Spring Data JPA:
- Spring Mail
- H2 Database
- Maven

## Estrutura do Projeto

O projeto está dividido em dois microserviços:

Serviço de Disciplina-projeto atual:
  Gerencia disciplinas e inscrições.
  Expõe endpoints para criar disciplinas e matricular alunos.

Serviço de Envio de E-mail - [aqui](https://github.com/Gabrielmarcs/envio-email-springboot) :
  Envia e-mails de confirmação e notificação.
  Expõe um endpoint para enviar e-mails via POST.

### Configuração do Ambiente
Pré-requisitos
  Java 17 ou superior
  Maven
  Banco de dados H2

### Configuração application.properties:
  ```bash
  spring.datasource.url=jdbc:h2:mem:testdb
  spring.datasource.driver-class-name=org.h2.Driver
  spring.datasource.username=sa
  spring.datasource.password=password
  spring.h2.console.enabled=true
  ```

### Inicializando o Projeto
1. Clone o Repositório:

 ```bash
 git clone https://github.com/Gabrielmarcs/escola-microservico.git
 cd escola-microservico
 ```
2. Compile e Execute
  ```bash
  ./mvnw spring-boot:run
  ```

### Endpoints do Serviço de Disciplina

  Criar Disciplina:

  POST /disciplinas

  Corpo da Requisição:


```json
{
  "maxAlunos": 30,
  "qtdeAlunosMatriculados": 0,
  "data": "2024-10-10",
  "nome": "Matemática",
  "descricao": "Curso de Matemática Básica"
}
```

Matricular Aluno:

POST /disciplinas/{idDisciplina}/matricular

Corpo da Requisição:

```json

{
  "nomeAluno": "João da Silva",
  "emailAluno": "joao@example.com"
}
```
### Contribuição

Contribuições são bem-vindas! Por favor, siga os seguintes passos:

    Fork o repositório.
    Crie uma branch para sua feature ou correção.
    Faça suas alterações e teste-as.
    Envie um pull request descrevendo suas mudanças.

### Licença
[![Licence](https://img.shields.io/github/license/Ileriayo/markdown-badges?style=for-the-badge)](./LICENSE)






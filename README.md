# Learn - Sistema de Plataforma de Ensino

[![Java](https://img.shields.io/badge/Java-21-red.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.1-green.svg)](https://spring.io/projects/spring-boot)
[![Build Status](https://img.shields.io/badge/build-passing-brightgreen.svg)]()

O Learn é um sistema com modelo de domínio complexo

## Visão Geral do Projeto

O sistema consiste em uma plataforma de ensino que mantém informações de cursos, suas turmas e alunos, bem como um fórum para perguntas e respostas sobre os conteúdos do curso. Os atores do sistema podem ser alunos e professores. Há também usuários administradores, que são os únicos autorizados a cadastrar cursos e turmas.

Um curso é composto de vários “recursos”, que são grupos de conteúdos. Estes recursos podem ser trilhas de aprendizado, bônus, links externos, e o próprio fórum de perguntas e respostas do curso. Cada recurso pode conter seções, e estas seções por sua vez é que vão conter as aulas, que podem ser conteúdos em vídeo e/ou texto, ou tarefas para serem entregues pelos alunos.

Uma tarefa pode ter um peso, uma data de entrega, um número de questões e a quantidade mínima de acertos necessários para ser aceita. Quando um aluno entrega a tarefa, esta fica aguardando pelo feedback do professor, e ela pode ser aceita ou rejeitada.

Cada nova turma do curso corresponde a uma oferta ou edição deste curso, que possui uma data de início e fim. Diferentes ofertas do mesmo curso podem ter pequenas variações no conteúdo, conforme a necessidade de customização para cada turma.


## Principais Características e Tecnologias

1. **Spring Boot 3.4.1**: Framework base para o desenvolvimento rápido de aplicações Java.
2. **Persistência de Dados**:
   - JPA/Hibernate para ORM
   - Banco de dados H2
3. **Desenvolvimento e Produtividade**:
   - Lombok para redução de boilerplate
   - MapStruct para mapeamento objeto-objeto
4. **Qualidade de Código**:
   - JaCoCo para cobertura de testes

## Modelo de Domínio
![Modelo de domínio](https://raw.githubusercontent.com/fabioallima/learn/refs/heads/main/src/main/resources/assets/modelo-conceitual.png)

## Requisitos de Sistema

- Java Development Kit (JDK) 21
- Maven 3.6+

## Relacionamentos JPA no Projeto Learn

### @ManyToOne
Usado quando muitas instâncias de uma entidade estão relacionadas a uma única instância de outra entidade.

* Exemplo na classe Offer:
```java
@ManyToOne
@JoinColumn(name = "course_id")
private Course course;
```

### @OneToMany
Inverso de @ManyToOne, usado quando uma entidade tem uma coleção de outras entidades.

* Exemplo na classe Course:
```java
@OneToMany(mappedBy = "course")
private List<Offer> offers = new ArrayList<>();
```

### @ManyToMany
Usado quando muitas instâncias de uma entidade podem estar relacionadas a muitas instâncias de outra entidade.

* Exemplo na classe Lesson:
```java
@ManyToMany
@JoinTable(name = "tb_lessons_done",
        joinColumns = @JoinColumn(name = "lesson_id"),
        inverseJoinColumns = {
                @JoinColumn(name = "user_id"),
                @JoinColumn(name = "offer_id")
        })
private Set<Enrollment> enrollmentsDone = new HashSet<>();
```

* Na classe Enrollment:
```java
@ManyToMany(mappedBy = "enrollmentsDone")
private Set<Lesson> lessonsDone = new HashSet<>();
```

## Como Executar o Projeto

```bash
# Clonar o repositório
git clone https://github.com/fabioallima/learn

# Entrar no diretório do projeto
cd dslist

# Construir o projeto
mvn clean install

# Executar os testes
mvn test

# Iniciar a aplicação
mvn spring-boot:run
```
## Como acessar o banco H2:
```text
# Com o projeto em execução, acesse:
http://localhost:8080/h2-console

* Apenas clique em conectar
* A cada execução do projeto o banco de dados é recriado usando o arquivo import.sql para popular as tabelas
```

## Autor

Fabio Almeida Lima

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Fabio%20Almeida%20Lima-blue.svg)](https://www.linkedin.com/in/fabio-alima/)


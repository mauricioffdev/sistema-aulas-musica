# 🎸 Sistema de Gestão para Escola de Música

Sistema desenvolvido para gerenciamento de alunos e controle financeiro de aulas de música.  
O projeto implementa um CRUD completo com relacionamento entre entidades e validação de regras de negócio.

## 🚀 Tecnologias Utilizadas

* **Back-end:** Java 17, Spring Boot 3
* **Banco de Dados:** MySQL, Spring Data JPA, Hibernate
* **Front-end:** Thymeleaf (Server-side rendering), Bootstrap 5
* **Ferramentas:** Maven, IntelliJ IDEA

## ⚙️ Funcionalidades

### 👥 Módulo de Alunos
* **Cadastro Completo:** Nome, Email, Telefone (com máscara/regex), Plano/Curso.
* **Validação de Dados:** O sistema impede cadastros com campos vazios ou formatos inválidos usando Bean Validation (`@NotBlank`, `@Pattern`).
* **Edição Inteligente:** Reutilização de formulário com verificação de IDs ocultos para update vs insert.
* **Exclusão Segura:** Confirmação via JavaScript antes de deletar registros.

### 💰 Módulo Financeiro
* **Registro de Pagamentos:** Lançamento de mensalidades vinculadas a alunos existentes.
* **Relacionamento One-to-Many:** Um aluno possui múltiplos pagamentos (JPA/Hibernate).
* **Visualização de Status:** Etiquetas (Badges) dinâmicas para status "PAGO" (Verde) ou "PENDENTE" (Amarelo).
* **Dropdown Dinâmico:** Seleção de alunos carregada diretamente do banco de dados na tela de pagamento.

## 📸 Como rodar o projeto

1.  Clone o repositório:
    ```bash
    git clone https://github.com/mauricioffdev/sistema-aulas-musica.git
    ```
2.  Configure o banco de dados MySQL no arquivo `application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/sistema_aulas
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    ```
3.  Execute o projeto via IntelliJ ou Maven:
    ```bash
    mvn spring-boot:run
    ```
4.  Acesse no navegador: `http://localhost:8080/alunos`

---
Desenvolvido por **Maurício Filho** - Professor de Guitarra e Desenvolvedor Java.
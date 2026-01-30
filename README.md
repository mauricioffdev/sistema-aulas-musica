# 🎸 Sistema de Gestão para Escola de Música

Sistema desenvolvido para gerenciamento de alunos e controle financeiro de aulas de música.  
O projeto implementa um CRUD completo com relacionamento entre entidades e validação de regras de negócio.

## 🚀 Tecnologias Utilizadas

* **Back-end:** Java 25, Spring Boot 3
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

---

## 🛠️ Configuração e Execução Local

### 1. Variáveis de Ambiente
Por questões de segurança, as credenciais sensíveis do banco de dados não estão fixas no código. Você precisará configurar a seguinte variável de ambiente no seu sistema operacional:

* **`DB_PASSWORD`**: Senha do seu banco de dados MySQL local.

> **Dica:** No Windows, configure em "Variáveis de Ambiente do Sistema". Lembre-se de reiniciar sua IDE após configurar para que ela reconheça a nova variável.

### 2. Clonagem e Banco de Dados
1.  Clone o repositório:
    ```bash
    git clone [https://github.com/mauricioffdev/sistema-aulas-musica.git](https://github.com/mauricioffdev/sistema-aulas-musica.git)
    ```
2.  O projeto utiliza o arquivo `src/main/resources/application.properties` configurado para ler a senha via variável de ambiente:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/sistema_aulas
    spring.datasource.username=root
    spring.datasource.password=${DB_PASSWORD}
    ```

### 3. Execução
Execute o projeto via IntelliJ ou através do Maven no terminal:
```bash
  mvn spring-boot:run
```  

4. Acesso
Após o projeto iniciar, acesse no navegador: http://localhost:8080/alunos

Desenvolvido por Maurício Filho Professor de Guitarra e Estudante de Análise e Desenvolvimento de Sistemas.
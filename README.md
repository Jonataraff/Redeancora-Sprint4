# Rede Âncora - Sistema de Gestão

Este é um sistema desenvolvido em Java com Spring Boot para gestão de clientes, mecânicos, veículos e peças em uma oficina.

## ⚙️ Tecnologias Utilizadas

- Java 21
- Spring Boot 3.4.5
- Thymeleaf
- Maven
- Banco de Dados Oracle
- HTML/CSS/Bootstrap

## 📁 Estrutura do Projeto

- `model`: Contém as entidades do sistema, como `Cliente`, `Mecanico`, `Peca`, `Veiculo`, `Usuario`.
- `repository`: Interfaces para acesso ao banco de dados usando Spring Data JPA.
- `service`: Camada de lógica de negócio.
- `controller`: Camada de controle que responde às requisições da aplicação.
- `config`: Configurações do Spring Security e beans.


## 📦 Dependências Principais

Veja o `pom.xml` para uma lista completa, incluindo:

- `spring-boot-starter-web`
- `spring-boot-starter-security`
- `spring-boot-starter-thymeleaf`
- `spring-boot-starter-data-jpa`
- `ojdbc8` (para Oracle DB)

## 🔧 Como Executar

1. Configure sua conexão com o banco Oracle no `application.properties`.
2. Execute o projeto via `mvn spring-boot:run` ou pela IDE (IntelliJ/Eclipse).
3. Acesse `http://localhost:8080` no navegador.

## 🧪 Testes

Inclui lógica de login e redirecionamento com tratamento de falhas.

## 📄 Licença

Projeto acadêmico com fins educativos.

---

Desenvolvido para a disciplina de Desenvolvimento Java - FIAP.


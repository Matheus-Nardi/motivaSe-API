
# Motiva-se API

Um projeto que visa valorizar o papel da motivação para um maior desempenho pessoal e profissional.

Em dias dificeis, que estamos desmotivados , frases inspiradoras podem mudar nossa perspectiva frente a uma situação e nos ajuda a seguir em frente.
## Rodando Localmente 🛠️

Para instalar o projeto, siga os passos abaixo:

### Pré-requisitos

- Java JDK (versão 21 ou superior)
- Maven (versão 3.9.7 ou superior)

### Passos

1. Clone o repositório:

   ```sh
   git clone https://github.com/Matheus-Nardi/motivaSe-API.git
   ```

2. Entre no diretório do repositório:

   ```sh
   cd motivaSe-API
   ```

3. Baixe as dependências:

   ```sh
   mvn clean install
   ```

4. Rode a aplicação localmente:

   ```sh
   mvn spring-boot:run   
   ```

## Desfrute da aplicação completa 
Com o backend rodando localmente agora voce pode acessar o front da aplicação em: [Frontend](https://github.com/Matheus-Nardi/motivaSe-front/blob/main/README.md)

## Stack Utilizada 🖥️

**Back-end:** Java, Spring, Maven

**Banco de Dados:** H2

**Testes das Rotas da API:** Insomnia

## Estrutura de Pastas 📂 

```
/main 
    /src
        /controller          # Controle das rotas HTTP
        /dto                 # Responsável por modelar Responses e Requests
        /model               # Responsável por modelar as entidades
        /repository          # Responsável pelo acesso ao banco de dados
        /service             # Responsável pelo intermédio entre repository e controller
        /resources           # Responsável pelas propriedades da aplicação e recursos do banco
```

---

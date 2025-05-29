
# SkinPro API

API REST para gerenciamento de itens de jogos (skins e outros itens) desenvolvida com Spring Boot.

## 📋 Sobre o Projeto

O SkinPro é uma API que permite o gerenciamento de jogos e seus respectivos itens (skins, armas, etc.), incluindo upload de imagens para Azure Blob Storage.

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.4.5**
- **Spring Data JPA**
- **MySQL**
- **Azure Blob Storage**
- **Maven**

## 📦 Dependências Principais

- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- Spring Boot Starter Validation
- MySQL Connector
- Azure Storage Blob

## 🛠️ Configuração

### Banco de Dados
```properties
spring.datasource.url=jdbc:mysql://[HOST]:[PORT]/[DATABASE]
spring.datasource.username=[USERNAME]
spring.datasource.password=[PASSWORD]
```

### Azure Blob Storage
```properties
azure.storage.connection-string=[CONNECTION_STRING]
azure.storage.container-name=[CONTAINER_NAME]
```

### Upload de Arquivos
```properties
spring.servlet.multipart.max-file-size=2MB
spring.servlet.multipart.max-request-size=5MB
```

## 📚 Endpoints Principais

### Jogos
- `GET /jogo/list` - Listar todos os jogos
- `POST /jogo/create` - Criar novo jogo
- `PUT /jogo/update/{id}` - Atualizar jogo
- `DELETE /jogo/delete/{id}` - Excluir jogo

### Itens
- `GET /item/list` - Listar todos os itens
- `POST /item/create` - Criar novo item
- `PUT /item/update/{id}` - Atualizar item
- `DELETE /item/delete/{id}` - Excluir item

## 🗂️ Estrutura do Projeto

```
src/main/java/com/api/skinpro/
├── config/          # Configurações (Azure, CORS)
├── controller/      # Controllers REST
├── dto/            # Data Transfer Objects
├── entity/         # Entidades JPA
├── enums/          # Enumerações (Categoria, Raridade)
├── exception/      # Tratamento de exceções
├── repository/     # Repositórios JPA
├── service/        # Lógica de negócio
└── util/           # Utilitários
```

## 📖 Documentação da API

A documentação completa da API está disponível em:
[https://tm2uead3pd.apidog.io](https://tm2uead3pd.apidog.io)

## 🏃‍♂️ Como Executar

1. Clone o repositório
2. Configure as variáveis de ambiente
3. Execute o comando:
```bash
./mvnw spring-boot:run
```

## 📄 Licença

Este projeto está sob a licença Apache 2.0.

## 🔧 Pré-requisitos

- Java 21 ou superior
- Maven 3.6+
- MySQL 8.0+
- Conta Azure com Blob Storage configurado

## ⚙️ Instalação

1. **Clone o repositório:**
```bash
git clone [URL_DO_REPOSITORIO]
cd skinpro
```

2. **Configure o banco de dados MySQL:**
```sql
CREATE DATABASE skinpro;
```

3. **Configure as variáveis de ambiente no `application.properties`:**
```properties
# Database
spring.datasource.url=jdbc:mysql://localhost:3306/skinpro
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update

# Azure Blob Storage
azure.storage.connection-string=sua_connection_string
azure.storage.container-name=skinpro-images

# File Upload
spring.servlet.multipart.max-file-size=2MB
spring.servlet.multipart.max-request-size=5MB
```

## 🎯 Funcionalidades

### Gerenciamento de Jogos
- ✅ Criar jogos com upload de logo e imagem de fundo
- ✅ Listar todos os jogos cadastrados
- ✅ Atualizar informações e imagens dos jogos
- ✅ Excluir jogos do sistema

### Gerenciamento de Itens
- ✅ Criar itens associados a jogos específicos
- ✅ Categorizar itens (Skin, Arma, Acessório, etc.)
- ✅ Definir raridade dos itens (Comum, Raro, Épico, Lendário)
- ✅ Upload de imagens para itens
- ✅ Operações CRUD completas

### Características Técnicas
- 🔄 Transações gerenciadas com Spring
- 🖼️ Upload de imagens para Azure Blob Storage
- ✅ Validação de dados com Bean Validation
- 🛡️ Tratamento de exceções customizado
- 📋 DTOs para transferência de dados

## 📝 Exemplos de Uso

### Criar um Jogo
```bash
curl -X POST http://localhost:8080/jogo/create \
    -F "nome=Counter-Strike 2" \
    -F "logo=@logo.png" \
    -F "bg=@background.jpg"
```

### Listar Jogos
```bash
curl -X GET http://localhost:8080/jogo/list
```

### Criar um Item
```bash
curl -X POST http://localhost:8080/item/create \
    -F "jogoId=1" \
    -F "nome=AK-47 Redline" \
    -F "descricao=Skin clássica para AK-47" \
    -F "categoria=SKIN" \
    -F "raridade=RARO" \
    -F "img=@item.png"
```

## 🗄️ Modelo de Dados

### Jogo
- `id` (Long) - Identificador único
- `nome` (String) - Nome do jogo (máx. 50 caracteres)
- `imgLogoUrl` (String) - URL da logo
- `imgBackgroundUrl` (String) - URL da imagem de fundo

### Item
- `id` (Long) - Identificador único
- `jogoId` (Long) - Referência ao jogo
- `nome` (String) - Nome do item (máx. 50 caracteres)
- `descricao` (String) - Descrição (máx. 500 caracteres)
- `imgUrl` (String) - URL da imagem
- `categoria` (Enum) - Categoria do item
- `raridade` (Enum) - Raridade do item

## 🚨 Tratamento de Erros

A API retorna respostas padronizadas para diferentes cenários:

- **200 OK** - Operação realizada com sucesso
- **400 Bad Request** - Dados inválidos ou ausentes
- **404 Not Found** - Recurso não encontrado
- **500 Internal Server Error** - Erro interno do servidor

## 🤝 Contribuição

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## Suporte

Para dúvidas ou suporte, consulte a [documentação da API](https://tm2uead3pd.apidog.io) ou abra uma issue no repositório.

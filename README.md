
# Documentação da API To-Do List

### Cria uma nova task

```http
  POST /task/add
```
Endpoint para criação de uma nova task
### Cabeçalho
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `api_key` | `string` | **Obrigatório**. A chave do usuário |

### Corpo da requisição
| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `title`      | `string` | **Obrigatório**. Título da task |
| `description`      | `string` | **Opcional**. Descrição da task |
| `date`      | `string` | **Obrigatório**. Data no formato ISO 8601 (yyyy-MM-ddTHH:mm) |
| `duration`      | `string` | **Obrigatório**. Duração no formato ISO 8601 (ex: PT1H para 1 hora) |

#### Exemplo de requisição
```
POST /task/add

Content-Type: application/json
Authorization: Bearer <sua_api_key>

{
  "title": "Reunião com equipe",
  "description": "Discutir roadmap do projeto",
  "date": "2024-09-25T09:44:00",
  "duration": "PT1H"
}
```

### Deleta uma task
```http
  DELETE /task/delete/{id}
```
Endpoint para deletar uma task através do seu id

### Cabeçalho
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `api_key` | `string` | **Obrigatório**. A chave do usuário |
| `id` | `string` | **Obrigatório**. O id da tarefa que deseja deletar |

#### Exemplo de requisição
```
DELETE /task/delete/3a5a4047-3bf9-4b91-8a36-afad6e6b5364

Authorization: Bearer <sua_api_key>
```
### Retorna todos as tasks do usuário

```http
  GET /task/find/all
```
Endpoint para retornar todas as tasks do usuário

### Cabeçalho

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `api_key`      | `string` | **Obrigatório**. A chave do usuário |

#### Exemplo de requisição
```
GET /task/find/all

Authorization: Bearer <sua_api_key>
```
#### Exemplo de resposta
```
[
  {
    "id": "3a5a4047-3bf9-4b91-8a36-afad6e6b5364",
    "title": "Task title",
    "description": "Task description",
    "date": "2024-09-25T09:44:00",
    "duration": "PT5M"
  },
  {
    "id": "7b2f9b6d-8df3-4c1a-ae4b-7a8f12a6336e",
    "title": "Segunda task",
    "description": "Descrição da segunda task",
    "date": "2024-09-26T10:00:00",
    "duration": "PT30M"
  }
]
```

### Busca tasks por título
```http
  GET /task/find
```
Busca tasks por substring no título, sem distinção de maiúsculas ou minúsculas.

### Cabeçalho

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `api_key`      | `string` | **Obrigatório**. A chave do usuário |
| `title`      | `string` | **Obrigatório**. Substring do título da tarefa que você deseja buscar |

#### Exemplo de requisição
```
GET /task/find?title=task

Authorization: Bearer <sua_api_key>
```
#### Exemplo de resposta
```
[
  {
    "id": "3a5a4047-3bf9-4b91-8a36-afad6e6b5364",
    "title": "Task title",
    "description": "Task description",
    "date": "2024-09-25T09:44:00",
    "duration": "PT5M"
  }
]
```
### Editar task
```http
  PUT /task/edit/{id}
```
Este endpoint permite que você edite os detalhes de uma tarefa existente identificada pelo seu id.
### Cabeçalho

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `api_key`      | `string` | **Obrigatório**. A chave do usuário |
| `id`      | `string` | **Obrigatório**. Id da task |

### Corpo da requisição
| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `title`      | `string` | **Opcional**. Título da task |
| `description`      | `string` | **Opcional**. Descrição da task |
| `date`      | `string` | **Opcional**. Data no formato ISO 8601 (yyyy-MM-ddTHH:mm) |
| `duration`      | `string` | **Opcional**. Duração no formato ISO 8601 (ex: PT1H para 1 hora) |

#### Exemplo de requisição
```
PUT /task/edit/3a5a4047-3bf9-4b91-8a36-afad6e6b5364
Authorization: Bearer <sua_api_key>
Content-Type: application/json

{
  "title": "Tarefa Atualizada",
  "description": "Descrição atualizada da tarefa",
  "date": "2024-09-30T10:00:00",
  "duration": "PT1H"
}

```
#### Exemplo de resposta
- Sucesso (200 Ok)
```
HTTP/1.1 200 OK
Content-Type: application/json

{
  "id": "3a5a4047-3bf9-4b91-8a36-afad6e6b5364",
  "title": "Tarefa Atualizada",
  "description": "Descrição atualizada da tarefa",
  "date": "2024-09-30T10:00:00",
  "duration": "PT1H"
}
```
- Erro (404 Not Found)
```
HTTP/1.1 404 Not Found
Content-Type: text/plain;charset=UTF-8

Tarefa não encontrada com o id: 3a5a4047-3bf9-4b91-8a36-afad6e6b5364
```
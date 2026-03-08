# Ordemflow
API REST para gerenciamento de pedidos de fast-food inspirada em sistemas utilizados
por redes como Burger King e McDonald's.

O sistema permite que clientes realizem pedidos, funcionários gerenciem o status dos pedidos
e administradores controlem produtos e categorias do cardápio.

Este projeto foi desenvolvido com foco em boas práticas de arquitetura backend,
incluindo autenticação, autorização e regras de negócio realistas.

## Stack
- Maven
- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- JWT autenthication
- Mysql
- Docker

## Tipos de funcionarios
O sistema possui três níveis de acesso:

CUSTOMER

- Visualizar cardápio

- Criar pedidos

- Acompanhar pedidos

EMPLOYEE

- Visualizar pedidos

- Atualizar status dos pedidos

ADMIN

- Gerenciar produtos

- Gerenciar categorias

- Gerenciar usuários

## Endpoints
Autenticação

POST /auth/register
POST /auth/login

Produtos

GET /products
GET /products/{id}

POST /products
PUT /products/{id}
DELETE /products/{id}

Categorias

GET /categories
POST /categories

POST /orders
GET /orders/my-orders
GET /orders/{id}

PUT /orders/{id}/status

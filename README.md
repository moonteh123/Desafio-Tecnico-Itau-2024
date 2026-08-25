# Desafio-Tecnico-Itau-2024
Projeto desenvolvido como parte do Desafio Técnico Itaú – Java10x, com o objetivo de implementar uma API REST para gerenciamento de transações e cálculo de estatísticas em tempo real, seguindo rigorosamente as regras propostas.



 # 🧠 Regras Gerais do Desafio
API REST
Apenas JSON (request/response)
Sem banco de dados
Sem cache externo
Armazenamento apenas em memória
Seguir exatamente os nomes dos endpoints
Seguir exatamente os nomes dos campos
API pública para avaliação

#📂 Modelagem Básica
DTO de Transação
valor: Double
dataHora: OffsetDateTime
DTO de Estatística
count: Long
sum: Double
avg: Double
min: Double
max: Double

#🚀 Endpoints
POST /transacao
Endpoint responsável por receber e validar uma transação.

Request
{
  "valor": 123.45,
  "dataHora": "2020-08-07T12:34:56.789-03:00"
}
Validações
valor deve estar presente
dataHora deve estar presente
valor maior ou igual a zero
dataHora não pode estar no futuro
dataHora pode ser qualquer momento no passado
Respostas
201 Created – Transação válida
422 Unprocessable Entity – Regra de negócio inválida
400 Bad Request – JSON inválido ou malformado
DELETE /transacao
Remove todas as transações armazenadas em memória.

Resposta
200 OK (sem corpo)
GET /estatistica
Retorna estatísticas calculadas considerando apenas as transações dos últimos 60 segundos.

Response
{
  "count": 10,
  "sum": 1234.56,
  "avg": 123.456,
  "min": 12.34,
  "max": 123.56
}
Caso não existam transações nos últimos 60 segundos, todos os valores devem ser retornados como zero.

🧪 Testes
Testes unitários de validação de transações
Testes de cálculo das estatísticas
Testes de controller
Testes de cenários de erro

⭐ Extras (Diferenciais)
Testes automatizados
Dockerfile ❌
Logs de criação, erro e cálculo ✅
Healthcheck ❌
Observabilidade
Swagger / OpenAPI ✅
Configuração do tempo da estatística

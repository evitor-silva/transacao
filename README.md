# Link do projeto Docker
https://hub.docker.com/r/vitoresbr/transacao-build

```cmd
docker pull vitoresbr/transacao-build:1.0 
docker-compose up
```


# Projeto transacao


#### Receber Transações: `POST /transacao`

Este é o endpoint que irá receber as Transações. Cada transação consiste de um `valor` e uma `dataHora` de quando ela aconteceu:

```json
{
    "valor": 123.45,
    "dataHora": "2020-08-07T12:34:56.789-03:00"
}
```

Os campos no JSON acima significam o seguinte:

| Campo      | Significado                                                   | Obrigatório |
|------------|---------------------------------------------------------------|--------------|
| `valor`    | **Valor em decimal com ponto flutuante** da transação         | Sim          |
| `dataHora` | **Data/Hora no padrão ISO 8601** em que a transação aconteceu | Sim          |

#### Limpar Transações: `DELETE /transacao`

Este endpoint simplesmente **apaga todos os dados de transações** que estejam armazenados.

Como resposta, espera-se que este endpoint responda com:

- `200 OK` sem nenhum corpo
  - Todas as informações foram apagadas com sucesso

#### Calcular Estatísticas: `GET /estatistica`

Deve retornar estatísticas das transações que **aconteceram nos últimos 60 segundos (1 minuto)**. As estatísticas que devem ser calculadas são:

```json
{
    "count": 10,
    "sum": 1234.56,
    "avg": 123.456,
    "min": 12.34,
    "max": 123.56
}
```

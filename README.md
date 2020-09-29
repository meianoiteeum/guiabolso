# Tarefas Guiabolso

- [ ] criar um dockerfile.
- [x] dado um conjunto de dados, formado por um id de usuário, um ano e um mês, deve-se retornar uma lista de transações.
- [ ] a lista de transações deve ter quantidade variável entre os meses.
- [x] o id de usuário é um número inteiro de 1.000 a 100.000.000.
- [x] cada transação deve ter uma descrição aleatória legível no formato string.
- [x] essa descrição aleatória legível deve ser legível por humanos, isso significa que YhCekEr13RH não é válido, enquanto chaconapotalo pocanoçale é válido.
- [x] caso o conjunto de transações tenha duas ou mais transações com a mesma descrição, data e valor, todas, menos uma, devem ter duplicated true.
- [ ]  ao iterar 12 meses em um mesmo ano, no mínimo 3 meses devem ter uma transação duplicada.
- [x] cada descrição deve ter no mínimo 10 caracteres.
- [x] cada descrição não pode superar 60 caracteres.
- [ ] cada transação deve ter um valor aleatório.
- [x] o valor da transação deve ser representado por um número inteiro.
- [x] o valor da transação deverá ter seus 2 últimos dígitos representando os centavos.
- [x] um valor de 8989 representa, portanto, R$ 89,89.
- [ ] o valor da transação deve estar entre -9.999.999 e 9.999.999, inclusive.
- [ ] cada transação deve ter o timestamp de uma data aleatória em formato long.
- [ ] a data aleatória deve estar dentro do range de ano e mês dados.
- [ ] dado dois conjuntos de dados iguais, as respostas devem ser as mesmas (pelo menos durante o dia que estivermos brincando).
- [x] utilize os status HTTP para representar os casos de excessão nas validações.
- [x] além do status, deve ser respondido o motivo do erro.

- [x] Contrato
``` sh
[GET] /<id>/transacoes/<ano>/<mes>

Content-type: application/json

[
  {
     "descricao": "string(10, 120)"
     "data": "long(timestamp)"
     "valor": "integer(-9.999.999, 9.999.999)"
     "duplicated": "boolean"
  }  
]
```
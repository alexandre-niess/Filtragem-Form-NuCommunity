# NuCommunity Gift Eligibility Checker

Este projeto é um algoritmo em Java que faz requisições GET para verificar se os usuários preenchem os requisitos para receber um brinde da NuCommunity.

## Descrição

Este programa lê uma lista de nomes de usuários de um arquivo de texto, faz requisições para a API da NuCommunity e verifica se os usuários atendem aos critérios especificados para receber um brinde. Ele gera um relatório com os resultados, indicando se o usuário foi aprovado ou eliminado.

## Funcionalidades

- **Leitura de Arquivo**: Lê os nomes de usuários a partir de um arquivo `dados.txt`.
- **Requisições HTTP**: Faz requisições GET para a API da NuCommunity para obter dados dos usuários.
- **Processamento de Dados**: Analisa os dados retornados pela API para verificar a elegibilidade.
- **Geração de Relatórios**: Escreve os resultados em arquivos `output.txt` (usuários aprovados e eliminados) e `erros.txt` (erros encontrados durante o processamento).

## Pré-requisitos

- Java 8 ou superior

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/nucommunity-gift-eligibility-checker.git
   cd nucommunity-gift-eligibility-checker
   ```

2. Certifique-se de que o arquivo `dados.txt` está presente no diretório do projeto. Este arquivo deve conter uma lista de nomes de usuários, um por linha.

3. Compile e execute o programa:
   ```bash
   javac Users.java
   java Users
   ```

4. Verifique os arquivos `output.txt` e `erros.txt` para os resultados.

## Estrutura do Código

- `main(String[] args)`: Ponto de entrada do programa. Lê os nomes de usuários do arquivo `dados.txt` e chama a função `pegaDados` para cada usuário.
- `pegaDados(String User)`: Faz uma requisição GET para a API da NuCommunity, processa os dados retornados e escreve o resultado nos arquivos de saída.
- `formataLeitura(String str)`: Formata a string de tempo de leitura.
- `formataString(String str)`: Formata a string de data de criação da conta.

## Exemplo de Arquivo `dados.txt`

```
user1
user2
user3
...
```

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.

## Contato

Para mais informações, acesse [meu site](https://alexandre-niess.github.io/SitePortifolio/).

---

# MyMovieList

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

## Descrição

*MyMovieList* é um aplicativo desenvolvido em Java com uso do MySQL, projetado para ajudar os entusiastas de filmes a manterem suas listas de filmes assistidos ou que desejam assistir organizadas. Com este aplicativo, você pode cadastrar informações detalhadas sobre os filmes, marcar como assistidos, favoritos e avaliá-los.

## Funcionalidades

- *Cadastro de Filmes:* Adicione informações como nome do filme, gênero, diretor e ano de lançamento.
- *Marcação de Filmes:* Marque filmes como assistidos ou não assistidos e como favoritos ou não favoritos.
- *Avaliação:* Avalie os filmes em até 5 estrelas.
- *Organização e Filtro:* Organize sua lista de filmes, aplique filtros e realize buscas para encontrar rapidamente os filmes desejados.

## Tecnologias Utilizadas

- *Java:* Linguagem de programação principal utilizada para o desenvolvimento do aplicativo.
- *MySQL:* Banco de dados utilizado para armazenar as informações dos filmes.

## Estrutura do Projeto


/MovieTracker
│
├── /src
│   ├── Main.java
│   ├── Movie.java
│   ├── MovieDAO.java
│   ├── MovieService.java
│   └── ...
│
├── /resources
│   └── database.sql
│
└── README.md


## Como Executar o Projeto

1. *Clone o Repositório:*

   bash
   git clone https://github.com/seu-usuario/MovieTracker.git
   

2. *Configure o Banco de Dados:*

   - Crie um banco de dados MySQL e execute o script database.sql localizado na pasta /resources para criar as tabelas necessárias.

3. *Compile e Execute o Projeto:*

   - Use sua IDE de preferência ou compile e execute o projeto manualmente:

     bash
     javac -cp .:/path/to/mysql-connector-java.jar src/Main.java
     java -cp .:/path/to/mysql-connector-java.jar src/Main
     

## Contribuições

Sinta-se à vontade para contribuir com o projeto. Para isso:

1. Faça um fork do repositório.
2. Crie uma branch para sua feature (git checkout -b feature/nova-feature).
3. Commit suas alterações (git commit -am 'Adiciona nova feature').
4. Faça um push para a branch (git push origin feature/nova-feature).
5. Abra um Pull Request.

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## Contato

- *Nome:* Pedro dos Santos Assunção
- *Email:* pedro251502@gmail.com
- *GitHub:* [dsapedro]([https://github.com/seu-usuario](https://github.com/dsapedro))
- *Nome:* Sarah Maressa Marques Silva
- *Email:* sarah.marquessilva74@gmail.com
- *GitHub:* SarahMaressa
- *Nome:* Kaique Icaro Higino da Silva
- *Email:* kaiqueicaro32@gmail.com
- *GitHub:* SlenderXs

---

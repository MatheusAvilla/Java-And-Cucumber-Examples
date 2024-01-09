Feature: Exemplo simples com Step Argument

  Scenario: Exemplo simples com uma Data Table
    Given Que minha livraria foi inicializada vazia
    And A seguinte tabela de livros:
      | Title   | Number of Pages   | Topic     | Year of Publication | Authors |
      | BookOne | 42                | COMPUTING | 2024                | Matheus |
      | BookTwo | 400               | SCI_FI    | 2023                | Avilla  |
    When Eu procurar pelo livro com titulo "BookOne" e topico COMPUTING
    Then Eu encontro o livro "BookOne"
    When Eu procurar pelo livro com titulo "BookTwo" e topico SCI_FI
    Then Eu encontro o livro "BookTwo"

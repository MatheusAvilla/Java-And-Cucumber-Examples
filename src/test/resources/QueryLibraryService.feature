Feature: Consultando livros na LibraryService

  Background:
    Given Que a LibraryService foi inicializada
    And O total de livros e 10

  Scenario: Consultar a LibraryService para encontrar um livro específico com base no título
    When Eu consultar a LibraryService pelo livro "Effective Java"
    Then E "true" que consigo encontrar o livro

  Scenario: Consultar a LibraryService pelo topico mais famoso
    When Eu consultar a LibraryService pelo topico mais famoso
    Then E "true" que consigo encontrar o topico mais famoso
    Then Eu obtenho "COMPUTING" que e o topico mais famoso
    But Nao encontro o topico SCI_FI
    And Nao encontro o topico FINANCE
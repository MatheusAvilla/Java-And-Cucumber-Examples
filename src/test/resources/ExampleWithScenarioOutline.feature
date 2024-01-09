Feature: Consultando livros na LibraryService

  Background:
    Given Que a LibraryService foi inicializada
    And O total de livros e 10

#  Scenario: Consultar um livro dado seu titulo e topico
#    When Eu consultar a LibraryService pelo livro "Effective Java" e topico COMPUTING
#    Then Eu encontro o livro "Effective Java"
#
#  Scenario: Consultar um livro dado seu titulo e topico
#    When Eu consultar a LibraryService pelo livro "Design Patterns" e topico COMPUTING
#    Then Eu encontro o livro "Design Patterns"
#
#  Scenario: Consultar um livro dado seu titulo e topico
#    When Eu consultar a LibraryService pelo livro "Dune" e topico SCI_FI
#    Then Eu encontro o livro "Dune"
#
#  Scenario: Consultar um livro dado seu titulo e topico
#    When Eu consultar a LibraryService pelo livro "One Hundred Years Of Solitude" e topico NOVEL
#    Then Eu encontro o livro "One Hundred Years Of Solitude"

  Scenario Outline: Consultar um livro dado seu titulo e topico
    When Eu consultar a LibraryService pelo livro <title> e topico <topic>
    Then Eu encontro o livro <title>
    Examples: Titulo do livro e topico
      | title                           | topic     |
      | "Effective Java"                | COMPUTING |
      | "Design Patterns"               | COMPUTING |
      | "Dune"                          | SCI_FI    |
      | "One Hundred Years Of Solitude" | NOVEL     |
package com.example.cucumber;

import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class BasicStepDefinitions {

    private LibraryService library;
    private Book book;
    private Optional<Topic> mostPopularTopic;

    @Given("Que a LibraryService foi inicializada")
    public void queALibraryServiceFoiInicializada() {
        this.library = TestContext.INSTANCE.getLibraryService(true);
    }

    @Given("Que minha livraria foi inicializada vazia")
    public void queMinhaLivrariaFoiInicializadaVazia() {
        library = TestContext.INSTANCE.getLibraryService(false);
    }

    @When("Eu consultar a LibraryService pelo livro {string}")
    public void euConsultarALibraryServicePeloLivro(String bookTitle) {
        book = library.getBookWithTitle(bookTitle);
    }

    @Then("E {string} que consigo encontrar o livro")
    public void eQueConsigoEncontrarOLivro(String isTrueStr) {
        Boolean isTrue = Boolean.valueOf(isTrueStr);
        if (isTrue) {
            Assert.assertNotNull(book);
        } else {
            Assert.assertNull(book);
        }
    }

    @When("Eu consultar a LibraryService pelo topico mais famoso")
    public void euConsultarALibraryServicePeloTopicoMaisFamoso() {
        mostPopularTopic = library.mostPopularTopic();
    }

    @Then("E {string} que consigo encontrar o topico mais famoso")
    public void eQueConsigoEncontrarOTopicoMaisFamoso(String isTrueStr) {
        Boolean isTrue = Boolean.valueOf(isTrueStr);
        if (isTrue) {
            Assert.assertNotNull(mostPopularTopic);
        } else {
            Assert.assertNull(mostPopularTopic);
        }
    }

    @Then("Eu obtenho {string} que e o topico mais famoso")
    public void euObtenhoQueEOTopicoMaisFamoso(String computingTopic) {
        mostPopularTopic.ifPresent(topic -> Assert.assertEquals(computingTopic, topic.name()));
    }

    @And("O total de livros e {int}")
    public void oTotalDeLivrosE(int booksTotal) {
        assertThat(library.bookCount(), is(equalTo(booksTotal)));
    }

    @But("Nao encontro o topico {}")
    public void naoEncontroOTopicoEspecificado(Topic topic) {
        assertThat(library.bookCount(), is(not(equalTo(topic))));
    }

    @When("Eu consultar a LibraryService pelo livro {string} e topico {}")
    public void euConsultarALibraryServicePeloLivroETopicoEspecificado(String title, Topic topic) {
        book = library.getBookWithTitle(title);
        Assert.assertNotNull(book);
        assertThat(book.getTopic(), is(equalTo(topic)));
    }

    @Then("Eu encontro o livro {string}")
    public void euEncontroOLivro(String title) {
        assertThat(book.getTitle(), is(equalTo(title)));
    }

    @When("Eu procurar pelo livro com titulo {string} e topico {}")
    public void euProcurarPeloLivroComTituloETopico(String title, Topic topic) {
        book = library.getBookWithTitle(title);
        Assert.assertNotNull(book);
        assertThat(book.getTopic(), is(equalTo(topic)));
    }
}

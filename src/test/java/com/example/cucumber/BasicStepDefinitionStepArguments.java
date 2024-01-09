package com.example.cucumber;

import com.example.cucumber.Book;
import com.example.cucumber.LibraryService;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;

import java.time.Year;
import java.util.List;
import java.util.Map;

public class BasicStepDefinitionStepArguments {

    private LibraryService library;

    @DataTableType
    public Book bookDefinition(Map<String, String> entry) {
        return new Book(
                entry.get("Title").trim(),
                Integer.parseInt(entry.get("Number of Pages").trim()),
                Topic.valueOf(entry.get("Topic").trim()),
                Year.parse(entry.get("Year of Publication").trim()),
                entry.get("Authors").trim()
        );
    }

    @And("A seguinte tabela de livros:")
    public void aSeguinteTabelaDeLivros(List<Book> books) {
        library = TestContext.INSTANCE.getLibraryService(false);
        books.forEach(b -> library.add(b));
    }
}

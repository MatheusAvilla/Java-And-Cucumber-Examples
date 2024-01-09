package com.example.cucumber;

public final class TestContext {
    public static final TestContext INSTANCE = new TestContext();

    private LibraryService libraryService;

    public LibraryService getLibraryService(boolean preload) {
        if (libraryService == null) {
            this.libraryService = LibraryService.getService(preload);
        }
        return libraryService;
    }
}

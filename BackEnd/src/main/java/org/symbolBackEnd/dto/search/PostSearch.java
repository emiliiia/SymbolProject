package org.symbolBackEnd.dto.search;
/*
  @author emilia
  @project SymbolProject
  @class PostSearch
  @version 1.0.0
  @since 09.09.2023 - 14:42
*/

public class PostSearch {
    private String search;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return "PostSearch{" +
                "search='" + search + '\'' +
                '}';
    }
}

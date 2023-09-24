package org.symbolBackEnd.dto.search;
/*
  @author emilia
  @project SymbolProject
  @class SearchDTO
  @version 1.0.0
  @since 09.09.2023 - 14:43
*/

import org.symbolBackEnd.enums.SortDirection;


public class SearchDTO<T> {
    private String sortField;
    private SortDirection sortDirection;

    private Integer page;
    private Integer pageSize;
    private T searchPattern;

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public SortDirection getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(SortDirection sortDirection) {
        this.sortDirection = sortDirection;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public T getSearchPattern() {
        return searchPattern;
    }

    public void setSearchPattern(T searchPattern) {
        this.searchPattern = searchPattern;
    }

    @Override
    public String toString() {
        return "SearchDTO{" +
                "sortField='" + sortField + '\'' +
                ", sortDirection=" + sortDirection +
                ", page=" + page +
                ", pageSize=" + pageSize +
                ", searchPattern=" + searchPattern.toString() +
                '}';
    }
}

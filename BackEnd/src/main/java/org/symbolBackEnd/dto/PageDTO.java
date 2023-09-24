package org.symbolBackEnd.dto;
/*
  @author emilia
  @project SymbolProject
  @class PageDTO
  @version 1.0.0
  @since 09.09.2023 - 14:41
*/

import java.util.List;

public class PageDTO<T> {
    List<T> content;
    Long totalItem;

    public Long getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Long totalItem) {
        this.totalItem = totalItem;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}

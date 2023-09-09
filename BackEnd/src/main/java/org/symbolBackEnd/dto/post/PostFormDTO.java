package org.symbolBackEnd.dto.post;
/*
  @author emilia
  @project SymbolProject
  @class PostFormDTO
  @version 1.0.0
  @since 09.09.2023 - 12:03
*/

public class PostFormDTO {
    private String title;
    private String foreword;
    private String content;

    public PostFormDTO() {
    }

    public PostFormDTO(String title, String foreword, String content) {
        this.title = title;
        this.foreword = foreword;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getForeword() {
        return foreword;
    }

    public void setForeword(String foreword) {
        this.foreword = foreword;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PostFormDTO{" +
                "title='" + title + '\'' +
                ", foreword='" + foreword + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

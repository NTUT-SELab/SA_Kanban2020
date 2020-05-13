package ddd.kanban.adapter.controller;

import java.io.Serializable;

public class JsonBoard implements Serializable {

    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer() ;
        sb.append("") ;
        sb.append("title:"+title) ;
        sb.append("description:"+description) ;
        sb.append("") ;
        return sb.toString() ;
    }
}

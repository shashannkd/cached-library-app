package com.shashannkd.libraryapp.entity;



public record BookRequest( String name,String author,String category,String publisher,long edition) {
    @Override
    public String name() {
        return name;
    }

    @Override
    public String author() {
        return author;
    }

    @Override
    public String category() {
        return category;
    }

    @Override
    public String publisher() {
        return publisher;
    }

    @Override
    public long edition() {
        return edition;
    }

    @Override
    public String toString() {
        return "BookRequest{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", publisher='" + publisher + '\'' +
                ", edition=" + edition +
                '}';
    }


}

package com.nhnacademy.library;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private int maxSize;
    private List<String> bookList;

    public Library(int maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException("음수로는 도서관을 생성할 수 없습니다.");
        }
        this.maxSize = maxSize;
        bookList = new ArrayList<>();
    }

    public void add(String bookName) {
        if (getTotalBookCount() >= maxSize) {
            throw new IllegalArgumentException("도서관 최대 용량을 초과해 책을 추가할 수 없습니다.");
        }
        if (find(bookName)) {
            throw new IllegalArgumentException("도서관에 같은 이름의 책이 존재합니다.");
        }
        bookList.add(bookName);
    }

    public int getTotalBookCount() {
        return bookList.size();
    }

    public boolean find(String bookName) {
        return bookList.contains(bookName);
    }

    public void delete(String bookName) {
        if (!find(bookName)) {
            throw new IllegalArgumentException("도서관에 존재하지 않는 책은 삭제할 수 없습니다.");
        }
        bookList.remove(bookName);
    }
}

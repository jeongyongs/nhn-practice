package com.nhnacademy.library;

public class LibraryMain {
    private static final String NEGATIVE_LIBRARY_MESSAGE = "음수로는 도서관을 생성할 수 없습니다.";
    private static final String ADD_MORE_THAN_MAX_MESSAGE = "도서관 최대 용량을 초과해 책을 추가할 수 없습니다.";
    private static final String ADD_DUPLICATE_BOOK_MESSAGE = "도서관에 같은 이름의 책이 존재합니다.";
    private static final String DELETE_NOT_EXIST_BOOK_MESSAGE = "도서관에 존재하지 않는 책은 삭제할 수 없습니다.";

    public static void main(String[] args) {
        음수로_생성하면_예외를_던짐();
        현재_도서의_개수를_반환();
        최대_크기_이상_도서를_추가하면_예외를_던짐();
        도서를_중복_추가하면_예외를_던짐();
        도서의_존재_여부를_확인();
        존재하지_않은_도서를_삭제하면_예외를_던짐();
    }

    private static void 음수로_생성하면_예외를_던짐() {
        try {
            new Library(-1);
            assert false;
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals(NEGATIVE_LIBRARY_MESSAGE);
        }
    }

    private static void 현재_도서의_개수를_반환() {
        Library library = new Library(5);

        library.add("해리포터");
        library.add("어린왕자");
        library.add("샬롯의 거미줄");

        assert 3 == library.getTotalBookCount();
    }

    private static void 최대_크기_이상_도서를_추가하면_예외를_던짐() {
        Library oneLibrary = new Library(1);

        oneLibrary.add("자바의 정석");

        try {
            oneLibrary.add("모두의 리눅스");
            assert false;
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals(ADD_MORE_THAN_MAX_MESSAGE);
        }
    }

    private static void 도서를_중복_추가하면_예외를_던짐() {
        Library library = new Library(5);

        library.add("백설공주");

        try {
            library.add("백설공주");
            assert false;
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals(ADD_DUPLICATE_BOOK_MESSAGE);
        }
    }

    private static void 도서의_존재_여부를_확인() {
        Library library = new Library(5);

        library.add("어린왕자");

        assert library.find("어린왕자");
        assert !library.find("엄지공주");
    }

    private static void 존재하지_않은_도서를_삭제하면_예외를_던짐() {
        Library library = new Library(5);

        library.add("백설공주");
        library.delete("백설공주");

        try {
            library.delete("흥부와 놀부");
            assert false;
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals(DELETE_NOT_EXIST_BOOK_MESSAGE);
        }
    }
}

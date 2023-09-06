package com.nhnacademy.library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class LibraryTest {

    private static final String NEGATIVE_LIBRARY_MESSAGE = "음수로는 도서관을 생성할 수 없습니다.";
    private static final String ADD_MORE_THAN_MAX_MESSAGE = "도서관 최대 용량을 초과해 책을 추가할 수 없습니다.";
    private static final String ADD_DUPLICATE_BOOK_MESSAGE = "도서관에 같은 이름의 책이 존재합니다.";
    private static final String DELETE_NOT_EXIST_BOOK_MESSAGE = "도서관에 존재하지 않는 책은 삭제할 수 없습니다.";

    @DisplayName("음수로 생성하면 예외를 던짐")
    @Test
    void 음수로_생성하면_예외를_던짐() {
        // given
        int maxSize = -1;

        // when
        Executable executable = () -> new Library(maxSize);

        // then
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, executable);
        assertEquals(NEGATIVE_LIBRARY_MESSAGE, exception.getMessage());
    }

    @DisplayName("현재 도서의 개수를 반환")
    @Test
    void 현재_도서의_개수를_반환() {
        // given
        Library library = new Library(5);
        library.add("해리포터");
        library.add("어린왕자");
        library.add("샬롯의 거미줄");

        // when
        int actual = library.getTotalBookCount();

        // then
        assertEquals(3, actual);
    }

    @DisplayName("최대 크기 이상 도서를 추가하면 예외를 던짐")
    @Test
    void 최대_크기_이상_도서를_추가하면_예외를_던짐() {
        // given
        Library library = new Library(1);
        library.add("자바의 정석");

        // when
        Executable executable = () -> library.add("모두의 리눅스");

        // then
        IllegalArgumentException exeption =
                assertThrows(IllegalArgumentException.class, executable);
        assertEquals(ADD_MORE_THAN_MAX_MESSAGE, exeption.getMessage());
    }

    @DisplayName("도서를 중복 추가하면 예외를 던짐")
    @Test
    void 도서를_중복_추가하면_예외를_던짐() {
        // given
        Library library = new Library(5);
        library.add("백설공주");

        // when
        Executable executable = () -> library.add("백설공주");

        // then
        IllegalArgumentException exeption =
                assertThrows(IllegalArgumentException.class, executable);
        assertEquals(ADD_DUPLICATE_BOOK_MESSAGE, exeption.getMessage());
    }

    @DisplayName("도서의 존재 여부를 확인")
    @Test
    void 도서의_존재_여부를_확인() {
        // given
        Library library = new Library(5);
        library.add("어린왕자");

        // when
        boolean actual1 = library.find("어린왕자");
        boolean actual2 = library.find("엄지공주");

        // then
        assertTrue(actual1);
        assertFalse(actual2);
    }

    @DisplayName("존재하지 않은 도서를 삭제하면 예외를 던짐")
    @Test
    void 존재하지_않은_도서를_삭제하면_예외를_던짐() {
        // given
        Library library = new Library(5);
        library.add("백설공주");
        library.delete("백설공주");

        // when
        Executable executable = () -> library.delete("백설공주");

        // then
        IllegalArgumentException exeption =
                assertThrows(IllegalArgumentException.class, executable);
        assertEquals(DELETE_NOT_EXIST_BOOK_MESSAGE, exeption.getMessage());
    }
}

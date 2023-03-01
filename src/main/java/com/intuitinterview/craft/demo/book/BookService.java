package com.intuitinterview.craft.demo.book;

import com.intuitinterview.craft.demo.appuser.AppUser;
import com.intuitinterview.craft.demo.appuser.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookService implements IBookService {

    private BookRepository bookRepository;
    private AppUserRepository appUserRepository;

    @Override
    public List<BookResponse> fetchBooks() {
       List<BookEntity> bookEntity = bookRepository.findAll();

        return bookEntity.stream()
                .map(bookEntity1 ->
                        BookResponse.builder().author(bookEntity1.getAuthor())
                             .id(String.valueOf(bookEntity1.getBookId()))
                            .isbn(bookEntity1.getIsbn())
                            .ownerId(String.valueOf(bookEntity1.getOwnerId()))
                            .author(bookEntity1.getAuthor())
                                .title(bookEntity1.getTitle())
                            .publisher(bookEntity1.getPublisher())
                            .build()

                ).collect(Collectors.toList());

    }

    @Override
    public String addBook(BookRequest bookRequest) {
        AppUser user =  appUserRepository.findById(Long.valueOf(bookRequest.getOwnerId())).isPresent() ?
                appUserRepository.findById(Long.valueOf(bookRequest.getOwnerId())).get() : null;


        if (user!=null && user.isEnabled()) {
            BookEntity bookEntity = BookEntity.builder()
                    .title(bookRequest.getTitle())
                    .author(bookRequest.getAuthor())
                    .isbn(bookRequest.getIsbn())
                    .publisher(bookRequest.getPublisher())
                    .ownerId(bookRequest.getOwnerId())
                    .build();

            bookRepository.save(bookEntity);

            return "{\n" +
                    "    \"response\" : \"SUCCESS\"\n" +
                    "}";

        }
        return "{\n" +
                "    \"response\" : \"USER NOT VERIFIED\"\n" +
                "}";

    }
}

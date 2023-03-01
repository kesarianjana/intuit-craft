package com.intuitinterview.craft.demo.book;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
@AllArgsConstructor
public class BookController {


    private BookService bookService;

    private IBorrowService iBorrowService;

    private IExchangeBookService iExchangeBookService;

    @GetMapping(value = "/fetchBooks", produces = "application/json")
    public List<BookResponse> getBooks() {
     return bookService.fetchBooks();
    }

    @PostMapping(value = "/addBook", consumes = "application/json", produces = "application/json")
    public String addBook(@RequestBody BookRequest bookRequest) {
        return bookService.addBook(bookRequest);
    }

    @PostMapping(value = "/borrowBook", consumes = "application/json", produces = "application/json")
    public ResponseEntity<BorrowResponse> borrowBook(@RequestBody BorrowRequest borrowRequest) {
        return ResponseEntity.ok().body(iBorrowService.saveBorrowRequest(borrowRequest));
    }

    @PostMapping(value = "/exchange-book", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ExchangeResponse> exchangeBook(@RequestBody ExchangeRequest exchangeRequest) {
        return ResponseEntity.ok().body(iExchangeBookService.create(exchangeRequest));
    }

    @PutMapping(value = "/confirm-exchange/{exchangeId}", produces = "application/json")
    public ResponseEntity<SuccessResponse> confirm(@PathVariable String exchangeId) {
        return ResponseEntity.ok().body(iExchangeBookService.confirm(exchangeId));

    }


}

package com.intuitinterview.craft.demo.book;

import com.intuitinterview.craft.demo.appuser.AppUser;
import com.intuitinterview.craft.demo.appuser.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BorrowService implements IBorrowService {

    private BookRepository bookRepository;

    private BorrowRepository borrowRepository;

    private AppUserRepository appUserRepository;

    @Override
    public List<BorrowResponse> fetchBorrowsOfUser(String id) {
        List<BorrowEntity> borrowEntities = borrowRepository.findByBorrowerId(id);

        return borrowEntities.stream().map(borrowEntity ->
                BorrowResponse.builder()
                .borrowDate(borrowEntity.getBorrowDate())
                .bookId(borrowEntity.getBookId())
                .dueDate(borrowEntity.getDueDate())
                .borrowDate(borrowEntity.getBorrowDate())
                .lenderId(borrowEntity.getLenderId())
                .borrowerId(borrowEntity.getBorrowerId())
                .isSuccessful(borrowEntity.isSuccessful()).build()).collect(Collectors.toList());

    }

    @Override
    public BorrowResponse saveBorrowRequest(BorrowRequest borrowRequest) {
        BookEntity bookEntity = bookRepository.findById(Long.valueOf(borrowRequest.getBookId())).isPresent() ?
                bookRepository.findById(Long.valueOf(borrowRequest.getBookId())).get() : null;


        if (bookEntity != null && bookEntity.getBookId() !=null) {
            BorrowEntity borrowEntity = BorrowEntity.builder()
                    .borrowDate(LocalDateTime.now())
                    .dueDate(LocalDateTime.now().plusDays(6))
                    .bookId(borrowRequest.getBookId())
                    .borrowerId(borrowRequest.getBorrowerId())
                    .lenderId(bookEntity.getOwnerId())
                    .isSuccessful(true)
                    .build();

            borrowRepository.save(borrowEntity);
            appUserRepository.updateRewardPoints(Long.valueOf(borrowEntity.getLenderId()));


            return BorrowResponse.builder().
                    dueDate(LocalDateTime.now().plusDays(6))
                    .isSuccessful(true).build();
        }

        else throw new IllegalArgumentException("The Book doesn't exist!");

    }
}

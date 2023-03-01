package com.intuitinterview.craft.demo.book;


import java.util.List;

public interface IBorrowService {
    List<BorrowResponse> fetchBorrowsOfUser(String id);
    BorrowResponse saveBorrowRequest(BorrowRequest borrowRequest);
}

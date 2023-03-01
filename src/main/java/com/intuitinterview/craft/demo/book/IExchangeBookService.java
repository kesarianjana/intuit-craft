package com.intuitinterview.craft.demo.book;

public interface IExchangeBookService {
     ExchangeResponse create(ExchangeRequest exchangeRequest);
     SuccessResponse confirm(String exchangeId);
}

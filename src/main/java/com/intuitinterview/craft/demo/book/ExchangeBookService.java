package com.intuitinterview.craft.demo.book;

import com.intuitinterview.craft.demo.appuser.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ExchangeBookService implements IExchangeBookService{

    private final ExchangeBookRepository exchangeBookRepository;

    private final AppUserRepository appUserRepository;

    @Override
    public ExchangeResponse create(ExchangeRequest exchangeRequest) {
        ExchangeBookEntity exchangeBookEntity = ExchangeBookEntity.builder()
                .bookId(exchangeRequest.getBookId())
              .user1(exchangeRequest.getUser1_id())
                .user2(exchangeRequest.getUser2_id())
                .exchangeDate(LocalDateTime.now())
                .dueDate(LocalDateTime.now().plusDays(6)).build();
        ExchangeBookEntity exchangeBookEntity1 = exchangeBookRepository.save(exchangeBookEntity);
        return ExchangeResponse.builder()
                .dueDate(LocalDateTime.now().plusDays(7))
                .id(String.valueOf(exchangeBookEntity1.getId()))
                .build();
    }

    @Override
    public SuccessResponse confirm(String exchangeId) {
        ExchangeBookEntity exchangeBookEntity =
                exchangeBookRepository.findById(Long.valueOf(exchangeId))
                        .orElseGet(() -> ExchangeBookEntity.builder().build());

        if(exchangeBookEntity != null && exchangeBookEntity.getId()!=null) {
            appUserRepository.updateRewardPoints(Long.valueOf(exchangeBookEntity.getUser1()));
            appUserRepository.updateRewardPoints(Long.valueOf(exchangeBookEntity.getUser2()));
            exchangeBookRepository.updateSuccess(Long.valueOf(exchangeId));
            return SuccessResponse.builder().message("Successfully updated!").build();
        }
        else return SuccessResponse.builder().message("Unable to update points!").build();
    }

}

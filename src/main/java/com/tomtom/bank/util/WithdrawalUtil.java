package com.tomtom.bank.util;

import com.tomtom.bank.dto.WithdrawalDto;
import com.tomtom.bank.dto.WithdrawalWrapperDto;

public class WithdrawalUtil {
    public static WithdrawalDto convertWithdrawalToWithdrawalDto(final WithdrawalWrapperDto dto) {
        final WithdrawalDto withdrawalDto = new WithdrawalDto();
        withdrawalDto.setAmount(dto.getWithdrawal().getAmount());
        return withdrawalDto;
    }
}

package com.tomtom.bank.util;

import com.tomtom.bank.dto.DepositDto;
import com.tomtom.bank.dto.DepositWrapperDto;

public class DepositUtil {
    public static DepositDto convertDepositWrapperToDepositDto(final DepositWrapperDto depositWrapperDto) {
        final DepositDto depositDto = new DepositDto();
        depositDto.setAmount(depositWrapperDto.getDeposit().getAmount());
        return depositDto;
    }
}

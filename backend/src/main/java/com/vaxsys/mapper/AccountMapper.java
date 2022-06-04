package com.vaxsys.mapper;

import com.vaxsys.dto.AccountDto;
import com.vaxsys.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountDto map(Account source);

    List<AccountDto> map(List<Account> source);
}

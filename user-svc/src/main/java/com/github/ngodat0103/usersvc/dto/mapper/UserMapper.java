package com.github.ngodat0103.usersvc.dto.mapper;

import com.github.ngodat0103.usersvc.dto.account.AccountDto;
import com.github.ngodat0103.usersvc.persistence.document.Account;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
  AccountDto toDto(Account account);

  Account toDocument(AccountDto dto);
}

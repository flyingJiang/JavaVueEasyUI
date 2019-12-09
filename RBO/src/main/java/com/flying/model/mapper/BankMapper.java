package com.flying.model.mapper;

import java.util.List;

import com.flying.model.entity.Bank;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BankMapper {
    List<Bank> selectAll();
}

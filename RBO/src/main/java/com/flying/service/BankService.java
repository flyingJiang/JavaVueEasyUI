package com.flying.service;


import java.util.List;

import com.flying.model.entity.Bank;
import com.github.pagehelper.PageInfo;

public interface BankService {
    List<Bank> getBankList();
    PageInfo<Bank> getBankList(int page, int size);

}

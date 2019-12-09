package com.flying.service.impl;

import java.util.List;

import com.flying.model.entity.Bank;
import com.flying.model.mapper.BankMapper;
import com.flying.service.BankService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService {

    private static final Logger LOOGER = LoggerFactory.getLogger(BankServiceImpl.class);

    @Autowired
    private BankMapper bankMapper;

    @Override
    public List<Bank> getBankList() {
        LOOGER.info("Default, and find info");
        return bankMapper.selectAll();
    }

    @Override
    public PageInfo<Bank> getBankList(int page, int size) {
        LOOGER.info("PageHelper, and find info");
        PageHelper.startPage(page, size);
        List<Bank> list = bankMapper.selectAll();
        PageInfo<Bank> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}

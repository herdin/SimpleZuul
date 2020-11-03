package com.harm.service;

import com.harm.constant.Constants;
import com.harm.entity.Account;
import com.harm.repository.AccountRepository;
import com.harm.repository.CardServiceRepository;
import com.harm.vo.CardServiceRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CardServiceService {
    Logger logger = LoggerFactory.getLogger(CardServiceService.class);

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CardServiceRepository cardServiceRepository;

    @Transactional
    public boolean update(CardServiceRequest cardServiceVo) {
        Account account = accountRepository.findByEmail(cardServiceVo.getEmail());
        if(account == null) return false;
        if(!Constants.CARD_SERVICE.TYPE.checkType(cardServiceVo.getCardServiceType())) return false;

        Constants.CARD_SERVICE.ACTION action = Constants.CARD_SERVICE.ACTION.convert(cardServiceVo.getCardServiceAction());
        action.updateService(account, Constants.CARD_SERVICE.TYPE.convert(cardServiceVo.getCardServiceType()));

        return true;
    }
}

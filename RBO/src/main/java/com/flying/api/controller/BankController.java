package com.flying.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.flying.common.entity.HSHttpCodeEnum;
import com.flying.common.entity.HSResult;
import com.flying.model.entity.Bank;
import com.flying.service.BankService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Configuration
@RequestMapping(value = "/bank")
public class BankController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankController.class);
    final Integer INTE = 1;

    @Autowired
    private BankService bankService;

    @RequestMapping("/banklist")
    public String index(){
        return "/banklist";
    }

    /**
     * 查询列表信息
     *
     * @param searchcondition 查询条件
     * @param searchcontent   查询内容
     * @param page            页数
     * @param rows            每页记录数
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> list(
//            @RequestParam(value = "searchcondition", required = false) String searchcondition,
//                                    @RequestParam(value = "searchcontent", required = false) String searchcontent,
                                    @RequestParam(value = "page", required = false) Integer page,
                                    @RequestParam(value = "rows", required = false) Integer rows) {

        if (null == page || INTE > page) page = 1;
        if (null == rows || INTE > rows) rows = 10;
        Map<String, Object> resultMap = new HashMap();
        PageInfo<Bank> pageInfo = bankService.getBankList(page, rows);
        resultMap.put("total", pageInfo.getTotal());
        resultMap.put("rows", pageInfo.getList());
        resultMap.put("success", true);

        return resultMap;
    }
    @GetMapping("/getBankList")
    public List<Bank> getBankList(){
        LOGGER.info("getBankList controller");
        return bankService.getBankList();

    }

    @GetMapping("/findBankList")
    @ResponseBody
    public HSResult findBankList(HttpServletRequest request, Integer page, Integer size){
        if (null == page || INTE > page) page = 1;
        if (null == size || INTE > size) size = 10;
        HSResult result = new HSResult();
        try {
            result.setData(bankService.getBankList(page, size));
            result.setMsg(HSHttpCodeEnum.CODE_200.getName());
            result.setStatus(HSHttpCodeEnum.CODE_200.getValue());
        }catch (Exception e){
            LOGGER.info(e.getMessage());
            result.setMsg(HSHttpCodeEnum.CODE_500.getName());
            result.setStatus(HSHttpCodeEnum.CODE_500.getValue());
        }
        return result;
    }
}

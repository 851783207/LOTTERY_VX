package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.dao.CardMapper;
import com.tencent.wxcloudrun.dao.LotteryMapper;
import com.tencent.wxcloudrun.model.Card;
import com.tencent.wxcloudrun.model.ResultVO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/lottery")
public class LotteryController {
    @Resource
    private LotteryMapper lotteryMapper;
    @Resource
    private CardMapper cardMapper;
    @PostMapping("/lottery")
    @Transactional(rollbackFor = Exception.class)
    public ResultVO lottery1(String name, String id){
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("姓名不能为空");
        }
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("奖品不能为空");
        }

        Card card = cardMapper.select(id);
        if (card == null) {
            throw new RuntimeException("卡片不存在");
        }

        int rows = cardMapper.changeStatus(id);
        if (rows == 0) {
            throw new RuntimeException("该卡片已被翻过，请选择其他卡片");
        }

        try {
            lotteryMapper.insert(name.trim(), card.getName());
        } catch (Exception e) {
            throw new RuntimeException("你已经翻过牌了，别来找茬");
        }

        return ResultVO.success("恭喜抽中" + card.getName());
    }


    @GetMapping("/getCard")
    public List<Card> getCard() {
        return cardMapper.getAll();
    }
}

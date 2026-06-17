package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.dao.CardMapper;
import com.tencent.wxcloudrun.dao.LotteryMapper;
import com.tencent.wxcloudrun.model.Lottery_en;
import com.tencent.wxcloudrun.model.Card;
import com.tencent.wxcloudrun.model.ResultVO;
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
    public ResultVO lottery1(String name, String id){
        // 校验状态
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("姓名不能为空");
        }
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("奖品不能为空");
        }

        Lottery_en existingLottery = lotteryMapper.select(name);

        if (existingLottery != null) {
            throw new RuntimeException("用户已存在");
        }
        Card card = cardMapper.select(id);

        lotteryMapper.insert(name.trim(), card.getName());
        // 修改卡片状态
        cardMapper.changeStatus(id);
        return ResultVO.success("恭喜抽中"+card.getName());
    }

    @GetMapping("/getCard")
    public List<Card> getCard() {
        List<Card> cardList = cardMapper.getAll();
        return cardList;
    }
}

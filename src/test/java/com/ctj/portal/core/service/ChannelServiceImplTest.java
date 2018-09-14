package com.ctj.portal.core.service;

import com.ctj.portal.core.po.Channel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChannelServiceImplTest {
    @Autowired
    private IChannelService channelService;

    @Test
    public void add() {
        Channel channel = new Channel();
        channel.setName("yfy");
        channelService.add(channel);
    }
}
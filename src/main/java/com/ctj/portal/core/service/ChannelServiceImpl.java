package com.ctj.portal.core.service;

import com.ctj.portal.core.dao.IChannelDao;
import com.ctj.portal.core.po.Channel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("channelService")
public class ChannelServiceImpl implements IChannelService {
    @Resource
    private IChannelDao channelDao;

    @Override
    public void add(Channel channel) {
        channelDao.save(channel);
    }
}

package com.example.demo.module.service.impl;

import com.example.demo.module.entity.EcMessage;
import com.example.demo.module.mapper.EcMessageMapper;
import com.example.demo.module.service.IEcMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 消息表 服务实现类
 * </p>
 *
 * @author gyg
 * @since 2021-11-10
 */
@Service
public class EcMessageServiceImpl extends ServiceImpl<EcMessageMapper, EcMessage> implements IEcMessageService {

}

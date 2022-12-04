package com.example.demo.service.Impl;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.EcMessage;
import com.example.demo.entity.container.Alert;
import com.example.demo.mapper.EcMessageMapper;
import com.example.demo.service.IEcMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
/**
 * <p>
 * 消息表 服务实现类
 * </p>
 *
 * @author gyg
 * @since 2021-11-10
 */
@Service
@Slf4j
public class EcMessageServiceImpl extends ServiceImpl<EcMessageMapper, EcMessage> implements IEcMessageService {


    @Autowired
    EcMessageMapper  messageMapper ;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void  insertMessage(String text){

        String jsonStr = text.replace("\"", "@")
                .replace("'", "\"")
                .replace("@", "'");
        System.out.println(jsonStr);
        log.info("处理后的消息字符串为  {}",jsonStr);

        JSONObject jsonObject = JSON.parseObject(jsonStr);
        String alertsStr = jsonObject.getString("alerts");
        if (!StringUtils.isEmpty(alertsStr)){
            // 把字符串转换成集合
            List<Alert> alertList = JSONObject.parseArray(alertsStr, Alert.class);

            // 执行入库，因为要校验数据是否重复，所以需要一条一条插入

            if (!CollectionUtils.isEmpty(alertList)){
                for (Alert alert : alertList){
                    EcMessage  message = new  EcMessage();
                    message.setId(1L);
                    message.setPod(alert.getLabels().getPod());
                    message.setTitle(alert.getAnnotations().getSummary());
                    message.setAlertname(alert.getLabels().getAlertname());
                    message.setSeverity(alert.getLabels().getSeverity());
                    // TODO  定义枚举
                    message.setSender("Promethus");
                    message.setStatus(0);
                    message.setSendTime(LocalDateTime.now());
                    message.setEndsAt(strToLocalDateTime(alert.getEndsAt()));
                    message.setStartsAt(strToLocalDateTime(alert.getStartsAt()));
                    message.setDeleted(0);
                    message.setType(0);
                    message.setCreateAt(LocalDateTime.now());
                    message.setUpdateAt(LocalDateTime.now());
                    // 校验
                    Integer countByTimeAndTitle = messageMapper.getCountByTimeAndTitle(message.getPod(),message.getTitle(),message.getStartsAt(),message.getEndsAt());
                    if (null != countByTimeAndTitle && countByTimeAndTitle == 0 ){
                        // 插入
                        boolean save = save(message);
                        log.info("insert ec_message result {}",save);
                    }else{
                        log.info("数据已存在 ,不插入 ec_message  ");
                    }
                }
            }

        }

    }

    @Override
    public Page<EcMessage> getPageMessage(Integer pageNum , Integer pageSize) {
        Page<EcMessage> messagePage = new Page<>(pageNum,pageSize);
        LambdaQueryWrapper<EcMessage> wrapper = new LambdaQueryWrapper<>();
        // TODO  默认全部，未读，已读

        wrapper.orderByDesc(EcMessage::getUpdateAt);


        messageMapper.selectPage(messagePage,wrapper);
        messagePage.getRecords().stream().forEach(e -> e.setTitle((e.getTitle().length()>=70?e.getTitle().substring(0,70).concat("......"):e.getTitle())));
        return messagePage;
    }

    @Override
    public EcMessage getMessageDetail(Long id) {
        return messageMapper.selectById(id);
    }

    @Override
    public void chooseOperate(List<Long> idList, String operate) {
        // TODO 定义枚举

        // TODO 数据权限 IAM

        List<EcMessage> ecMessages = messageMapper.selectBatchIds(idList);
        if (!CollectionUtils.isEmpty(ecMessages)){
            for (EcMessage ecMessage : ecMessages){
                // TODO
                ecMessage.setUpdateBy(1L);
                ecMessage.setUpdateAt(LocalDateTime.now());
                if ("delete".equals(operate)){
                    ecMessage.setDeleted(1);
                }else{
                    // 默认 marked
                    ecMessage.setStatus(1);
                } }
            boolean flag = updateBatchById(ecMessages);
            log.info("message module batch {}  result {}",operate,flag);
        }


    }

    @Override
    public void allOperate(String operate) {

        // TODO 获取数据权限
        chooseOperate(null ,operate);

    }


    private LocalDateTime strToLocalDateTime(String timeStr){


        String replace = timeStr.replace("T", " ").replace("Z", "");
        String substring = replace.substring(0, 19);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       return  LocalDateTime.parse(substring, dateTimeFormatter);
    }

}

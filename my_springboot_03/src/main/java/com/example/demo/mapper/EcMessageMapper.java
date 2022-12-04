package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.EcMessage;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

/**
 * <p>
 * 消息表 Mapper 接口
 * </p>
 *
 * @author gyg
 * @since 2021-11-10
 */
public interface EcMessageMapper extends BaseMapper<EcMessage> {

    Integer getCountByTimeAndTitle(@Param("pod") String  pod,
                                   @Param("title") String  title,
                                   @Param("startsAt") LocalDateTime startsAt,
                                   @Param("endsAt") LocalDateTime  endsAt
                                   );

}

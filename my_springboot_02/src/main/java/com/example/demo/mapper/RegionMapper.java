package com.example.demo.mapper;

import com.example.demo.entity.Region;
import java.util.List;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-01-14 14:42
 **/
//@Repository  用MapperScan 代替每个mapper接口上面的  Repository
public interface RegionMapper {
    List<Region> list();
}

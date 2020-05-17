package com.louis.common.page;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 分页请求
 * @author huangjiabao
 * @data 2020/5/17/0017
 * @time 12:31:20
 */
@Data
public class PageRequest {

    /**
     * 当前页码
     */
    private  int pageNum=1;

    /**
     * 每页展示量
     */
    private int pageSize =10;

    private Map<String,Object> params = new HashMap<>();
}

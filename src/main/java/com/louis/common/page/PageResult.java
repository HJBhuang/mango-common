package com.louis.common.page;

import lombok.Data;

import java.util.List;

/**
 * 分页结果
 * @author huangjiabao
 * @data 2020/5/17/0017
 * @time 12:33:55
 */
@Data
public class PageResult {
    /**
     * 当前页码
     */
    private  int pageNum;

    /**
     * 每页展示量
     */
    private int pageSize;

    /**
     * 记录总数
     */
    private Long totalSize;

    /**
     * 页码总数
     */
    private  int totalPages;

    /**
     * 分页数据
     */
    private List<?> content;
}

package com.louis.common.page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.louis.common.utils.ReflectionUtils;

import java.util.List;

/**
 * 分页查询助手
 * @author huangjiabao
 * @data 2020/5/17/0017
 * @time 13:10:05
 */
public class MybatisPageHelper {
    public static final String findPage ="findPage";

    /**
     * 分页查询，约定查询方法名为‘findPage’
     * @param pageRequest  分页请求
     * @param mapper Dao对象，MyBatis的mapper
     * @return
     */
    public static PageResult findPage(PageRequest pageRequest,Object mapper){
        return findPage(pageRequest,mapper,findPage);
    }

    public static PageResult findPage(PageRequest pageRequest,Object mapper,String  queryMethodName,Object... args){
        //设置分页
         int pageNum = pageRequest.getPageNum();
         int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        Object result = ReflectionUtils.invoke(mapper,queryMethodName,args);
        return getPageResult(pageRequest,new PageInfo<>((List)result));
    }

    private  static  PageResult getPageResult(PageRequest pageRequest,PageInfo<?>  pageInfo){
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setContent(pageInfo.getList());
        return pageResult;

    }
}


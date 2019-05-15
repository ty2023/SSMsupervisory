package com.yj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yj.dao.IBaseMapper;
import com.yj.entity.Page;
import com.yj.entity.Student;
import com.yj.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 29029
 * @Version 1.0
 * @User 29029
 * @Time 19:54
 */
@Service
public abstract class BaseServiceImpl<T> implements IBaseService<T> {

    public BaseServiceImpl() {
    }

    protected abstract IBaseMapper<T> getBaseDao();

    @Override
    public PageInfo<T> getPage(Page<T> page, T t) {
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<T> pageHelp = this.getBaseDao().getList(t);
        return new PageInfo(pageHelp);
    }

    @Override
    public Integer doDelete(Integer id) {
        return getBaseDao().doDelete(id);
    }

    @Override
    public T getById(Integer id) {
        return getBaseDao().getById(id);
    }

    @Override
    public Integer doUpdate(T t) {
        return getBaseDao().doUpdate(t);
    }
}

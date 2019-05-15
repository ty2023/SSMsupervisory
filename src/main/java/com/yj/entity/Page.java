package com.yj.entity;

import lombok.Data;

import java.util.List;

/**
 * @author 29029
 */
@Data
public class Page<T> {
    private Integer currentPage = 1;

    private Integer pageSize = 10;

    private Integer totalPage;

    private Integer totalCount;

    private List<T> list;
}

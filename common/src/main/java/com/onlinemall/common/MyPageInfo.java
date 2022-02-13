package com.onlinemall.common;

import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MyPageInfo<T> {
    /**
     * 当前页
     */
    private Integer page;
    /**
     * 每页数量
     */
    private Integer pageSize;
    /**
     * 总页数
     */
    private Integer totalPages;
    /**
     * 总条数
     */
    private Long totalNumber;
    /**
     * 是否为首页
     */
    private Boolean first;
    /**
     * 是否为尾页
     */
    private Boolean last;
    /**
     * 上一页
     */
    private Integer prePage;
    /**
     * 下一页
     */
    private Integer nextPage;
    /**
     * 当前页数据
     */
    private List<T> content;

    public MyPageInfo(List<T> list) {
        PageInfo<T> info = new PageInfo<>(list);
        this.totalNumber = info.getTotal();
        this.totalPages = info.getPages();
        this.page = info.getPageNum();
        this.pageSize = info.getPageSize();
        this.prePage = info.getPrePage();
        this.nextPage = info.getNextPage();
        this.first = info.isIsFirstPage();
        this.last = info.isIsLastPage();
        this.content = list;
    }
}

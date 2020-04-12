package com.j.openproject.core;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

/**
 * @author Joyuce
 * @Type SearchBuilder
 * @Desc es 搜索语句构造器
 * @date 2019年11月16日
 * @Version V1.0
 */
public class SearchBuilder {

    private NativeSearchQueryBuilder searchBuilder;

    public SearchBuilder() {
        this.searchBuilder = new NativeSearchQueryBuilder();
    }

    public SearchBuilder(NativeSearchQueryBuilder queryBuilder) {
        this.searchBuilder = queryBuilder;
    }

    /**
     * 构造查询条件
     *
     * @return
     */
    public NativeSearchQuery build() {
        return searchBuilder.build();
    }

    /**
     * 设置分页参数
     *
     * @param page
     * @param size
     * @return
     */
    public SearchBuilder setPage(int page, int size) {
        searchBuilder.withPageable(PageRequest.of(page, size));
        return this;
    }

    /**
     * 设置排序
     *
     * @param param     参数
     * @param paramType 参数类型
     * @param isDesc    是否倒序排序
     * @return
     */
    public SearchBuilder setSort(String param, String paramType, boolean isDesc) {
        searchBuilder.withSort(
                SortBuilders.fieldSort(param).order(isDesc ? SortOrder.DESC : SortOrder.ASC).unmappedType(paramType));
        return this;
    }

    /**
     * 设置查询
     *
     * @param queryBuilder
     * @return
     */
    public SearchBuilder setQuery(QueryBuilder queryBuilder){
        searchBuilder.withQuery(queryBuilder);
        return this;
    }

    /**
     * 设置过滤器
     *
     * @param filterBuilder
     * @return
     */
    public SearchBuilder setFilter(QueryBuilder filterBuilder){
        searchBuilder.withFilter(filterBuilder);
        return this;
    }

}

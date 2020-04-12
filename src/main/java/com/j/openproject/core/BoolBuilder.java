package com.j.openproject.core;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

/**
 * @author Joyuce
 * @Type BoolBuilder
 * @Desc 布尔查询构造器
 * @date 2019年11月16日
 * @Version V1.0
 */
public class BoolBuilder {

    private BoolQueryBuilder boolQueryBuilder;

    public BoolBuilder() {
        boolQueryBuilder = QueryBuilders.boolQuery();
    }

    public BoolQueryBuilder getQuery(){
        return boolQueryBuilder;
    }

    /**
     * 组合查询 and 与
     * 查询的结果必须匹配查询条件，并计算score
     *
     * @param queryBuilder
     * @return
     */
    public BoolBuilder must(QueryBuilder queryBuilder) {
        boolQueryBuilder.must(queryBuilder);
        return this;
    }

    /**
     * 组合查询 not 非
     * 查询结果必须不符合查询条件
     *
     * @param queryBuilder
     * @return
     */
    public BoolBuilder mustNot(QueryBuilder queryBuilder) {
        boolQueryBuilder.mustNot(queryBuilder);
        return this;
    }

    /**
     * 组合查询 or 或 (在一个Bool查询中，如果没有must或者filter，有一个或者多个should子句，
     * 那么只要满足一个就可以返回。minimum_should_match参数定义了至少满足几个子句)
     *
     * @param queryBuilder
     * @return
     */
    public BoolBuilder should(QueryBuilder queryBuilder) {
        boolQueryBuilder.should(queryBuilder);
        return this;
    }

    /**
     * 最小should 匹配
     *
     * @param minimumShouldMatch
     * @return
     */
    public BoolBuilder minimumShouldMatch(int minimumShouldMatch) {
        boolQueryBuilder.minimumShouldMatch(minimumShouldMatch);
        return this;
    }
    /**
     * 查询的结果必须匹配查询条件，和must不同不会计算score
     *
     * @param queryBuilder
     * @return
     */
    public BoolBuilder filter(QueryBuilder queryBuilder) {
        boolQueryBuilder.filter(queryBuilder);
        return this;
    }
}

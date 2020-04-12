package com.j.openproject.core;

import org.elasticsearch.index.query.*;

/**
 * @author Joyuce
 * @Type Query
 * @Desc 查询构造器
 * @date 2020年01月11日
 * @Version V1.0
 */
public class Query {

    /**
     * 布尔查询
     *
     * @return
     */
    public static BoolBuilder boolQuery() {
        return new BoolBuilder();
    }

    /**
     * 查询的是倒排索引中确切的term
     * 查询条件不分词
     *
     * @param name
     * @param value
     * @return
     */
    public static TermQueryBuilder termQuery(String name, Object value) {
        return QueryBuilders.termQuery(name, value);
    }

    /**
     * 查询的是倒排索引中确切的term
     * 查询条件不分词        类似  in
     *
     * @param name
     * @param values
     * @return
     */
    public static TermsQueryBuilder termsQuery(String name, Object... values) {
        return QueryBuilders.termsQuery(name, values);
    }

    /**
     * 会对查询输入进行分词操作，然后在查询
     *
     * @param name
     * @param text 分词再查询
     * @return
     */
    public static MatchQueryBuilder matchQuery(String name, Object text) {
        return QueryBuilders.matchQuery(name, text);
    }

    /**
     * 通配符查询 支持 ? 单个字符 *多个 性能极差
     *
     * @param name
     * @param query
     * @return
     */
    public static WildcardQueryBuilder wildcardQuery(String name, String query) {
        return QueryBuilders.wildcardQuery(name, query);
    }

}

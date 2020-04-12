package com.j.openproject.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.j.openproject.core.BoolBuilder;
import com.j.openproject.core.Query;
import com.j.openproject.core.SearchBuilder;
import com.j.openproject.demo.entity.EsSample;
import com.j.openproject.demo.repository.EsSampleRepository;

/**
 * @author Joyuce
 * @Type DemoService
 * @Desc
 * @date 2019年11月15日
 * @Version V1.0
 */
@Component
public class DemoService {

    @Autowired
    private EsSampleRepository esSampleRepository;

    public void test(){
        // 构建查询条件
        SearchBuilder searchBuilder = new SearchBuilder();
        // 添加布尔查询
        BoolBuilder bool = new BoolBuilder();
        bool.must(Query.termQuery("1", 1L));
        //子布尔查询
        BoolBuilder subBool = new BoolBuilder();

        subBool.should(Query.boolQuery().should(Query.wildcardQuery("1", "*" + 1 + "*"))
                .should(Query.matchQuery("1", 1)).getQuery());

        subBool.should(Query.matchQuery("1", 1));

        subBool.should(Query.boolQuery().should(Query.wildcardQuery("1", "*" + 1 + "*"))
                .should(Query.matchQuery("1", 1)).getQuery());

        bool.must(subBool.getQuery());

        BoolBuilder boolQuery = Query.boolQuery();

        boolQuery.should(Query.boolQuery().must(Query.termsQuery("1", "1L"))
                .mustNot(Query.termQuery("1", 1L)).getQuery());
        boolQuery.should(Query.boolQuery().must(Query.termsQuery("1", "1L"))
                .must(Query.termQuery("1", 1L)).getQuery());
        bool.must(boolQuery.getQuery());
        searchBuilder.setQuery(bool.getQuery());
        searchBuilder.setSort("id","int",true);
        // 搜索，获取结果
        Page<EsSample> dtoPage = esSampleRepository.search(searchBuilder.build());
    }





}

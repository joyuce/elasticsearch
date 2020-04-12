package com.j.openproject.demo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.j.openproject.demo.entity.EsSample;

/**
 * @author joyuce
 * @Type ESSampleDTO
 * @Desc es对象 crud接口
 * @date 2019年08月05日
 * @Version V1.0
 */
public interface EsSampleRepository extends ElasticsearchRepository<EsSample, Integer> {


}

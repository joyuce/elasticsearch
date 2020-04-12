package com.j.openproject.demo.init;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;

import com.j.openproject.demo.entity.EsSample;

import lombok.extern.slf4j.Slf4j;

/**
 * @author shenxiaodong
 * @Type InitSystemConfig
 * @Desc 系统初始化后的操作
 * @date 2019年09月10日
 * @Version V1.0
 */
@Slf4j
@Component
@Order(value = 0)
public class InitSystemConfig implements CommandLineRunner, EnvironmentAware {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Value("${es.cleanIndex:false}")
    private String cleanIndex;

    /**
     * 在服务启动后执行，会在@Bean实例化之后执行，故如果@Bean需要依赖这里的话会出问题
     *
     * @param args
     */
    @Override
    public void run(String... args) {
        //删除旧索引
        deleteEsIndex();
        //建立索引
        createIndex();
        //同步数据
        synData();
    }

    /**
     * 删除es索引
     */
    private void deleteEsIndex() {
        if (isClean()) {
            //删除es索引
            elasticsearchTemplate.deleteIndex(EsSample.class);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {

            }
        }
    }

    /**
     * 创建索引并建立映射关系
     */
    private void createIndex() {
        elasticsearchTemplate.createIndex(EsSample.class);
        elasticsearchTemplate.putMapping(EsSample.class);
    }

    /**
     * 同步数据
     */
    private void synData() {
        if (isClean()) {
            //todo 开始全量同步数据
        }
    }

    /**
     * 在SystemConfigDao实例化之后、@Bean实例化之前执行常用于读取数据库配置以供其它bean
     * 使用environment对象可以获取配置文件的配置，也可以把配置设置到该对象中
     *
     * @param environment
     */
    @Override
    public void setEnvironment(Environment environment) {

    }

    /**
     * 是否需要改动索引
     *
     * @return
     */
    private boolean isClean() {
        if (StringUtils.isNotBlank(cleanIndex) && "true".equalsIgnoreCase(cleanIndex)) {
            return true;
        }
        return false;
    }
}

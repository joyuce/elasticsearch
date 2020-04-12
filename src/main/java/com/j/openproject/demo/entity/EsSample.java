package com.j.openproject.demo.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Data;

/**
 * @author joyuce
 * @Type ESFileDTO
 * @Desc es 实体映射
 * @date 2019年08月05日
 * @Version V1.0
 */
@Document(indexName = "sample", type = "sample", createIndex = false)
@Data
public class EsSample implements Serializable {

    @Id
    private Integer sample1;

    @Field(type = FieldType.Integer)
    private Integer sample2;

    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String sample3;

    @Field(type = FieldType.Long)
    private Long sample4;

    @Field(index = false, type = FieldType.Date)
    private Date sample5;

    @Field(index = false, type = FieldType.Double)
    private Double sample6;

}

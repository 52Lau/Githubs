package com.lau.githubs.elasticsearch.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
//indexName代表所以名称,type代表表名称
@Document(indexName = "github_search_repo", type = "searchrepo")
public class SearchRepo {
    //id
    @Id
    private Integer id;

    //作者
    @Field(index=false)
    private String author;

    //名称
    @Field(index=false)
    private String name;

    //描述
    @Field(index=false)
    private String description;

    //readme
    @Field(index=false)
    private String readme;

}

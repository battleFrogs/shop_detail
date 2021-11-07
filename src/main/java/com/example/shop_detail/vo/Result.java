package com.example.shop_detail.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class Result {


    @JsonProperty("total")
    private Integer total;
    @JsonProperty("rows")
    private List<RowsDTO> rows;

    @NoArgsConstructor
    @Data
    public static class RowsDTO {
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("age")
        private Integer age;
    }
}

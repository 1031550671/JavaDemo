package com.example.aop_pj.unit;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@Data
public class BaseEntity {
    @TableId(
            value = "id",
            type = IdType.ASSIGN_UUID
    )
    private String id;
    @TableField(
            value = "created_by",
            fill = FieldFill.INSERT
    )
    private String createdBy;
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    @TableField(
            value = "created_date",
            fill = FieldFill.INSERT
    )
    private Instant createdDate;
    @TableField(
            value = "last_modified_by",
            fill = FieldFill.INSERT_UPDATE
    )
    private String lastModifiedBy;
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    @TableField(
            value = "last_modified_date",
            fill = FieldFill.INSERT_UPDATE
    )
    private Instant lastModifiedDate;
    @TableLogic
    @TableField("deleted")
    private Boolean deleted;




}

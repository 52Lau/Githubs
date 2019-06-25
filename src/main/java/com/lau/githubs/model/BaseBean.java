package com.lau.githubs.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Transient;
import java.io.Serializable;

@Data
public class BaseBean implements Serializable {
    private static final long serialVersionUID = -6698071844748923919L;
    // 分页用
    @Transient private Integer firstrecord;
    @Transient private Integer lastrecord;
    @Transient private Integer finalmax;
    @Transient private Integer isCheck;
    @Transient private Object[] ids;

}

package com.imooc.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Component
@DynamicUpdate
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;

    private Date createTime;

    private Date updateTime;

}

package com.imooc.service;

import com.imooc.dataobject.SellerInfo;

public interface SellerService {
    SellerInfo findSellerInfoByOpenid(String openid);

    SellerInfo findSellerInfoByUsernameAndPassword(String username, String password);
}

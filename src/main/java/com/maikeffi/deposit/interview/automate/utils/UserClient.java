package com.maikeffi.deposit.interview.automate.utils;

import com.maikeffi.deposit.interview.automate.model.User;
import feign.RequestLine;

import java.util.List;

public interface UserClient {

    @RequestLine("GET /user/all/json")
    List<User> findAll();

    @RequestLine("DELETE /user/all")
    void  deleteAll();
}

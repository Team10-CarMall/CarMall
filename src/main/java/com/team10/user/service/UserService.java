package com.team10.user.service;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/07/00007 1:00:23
 */
public interface UserService {
    boolean addUser(String username, String password);

    String getUserId(String userName);
}

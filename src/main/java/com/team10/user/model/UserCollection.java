package com.team10.user.model;

import lombok.Data;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/10/00010 13:36:43
 */
@Data
public class UserCollection {
	private String userId;
	private String goodsId;
	private String createTime;
	private String editTime;
	private String version;
}

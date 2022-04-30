package com.deloitte.jenkinsstudy.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.deloitte.jenkinsstudy.entity.po.UserinfoPO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户信息vo
 *
 * @author Administrator
 * @date 2022/04/30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserinfoVO {

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 姓名
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 年龄
     */
    @TableField(value = "age")
    private Integer age;

    /**
     * 转换为用户信息po
     *
     * @param item 项目
     * @return {@link UserinfoPO}
     */
    public static UserinfoPO convertToUserinfoPo(UserinfoVO item) {
        return UserinfoPO.builder()
                .id(item.getId())
                .name(item.getName())
                .age(item.getAge())
                .build();
    }
}

package com.ming.dao.entity;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 角色和菜单关联表(SysRoleMenu)表实体类
 *
 * @author makejava
 * @since 2022-10-05 19:52:31
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_role_menu")
public class SysRoleMenu  {
    //角色ID@TableId
    private Long roleId;
    //菜单ID@TableId
    private Long menuId;


}

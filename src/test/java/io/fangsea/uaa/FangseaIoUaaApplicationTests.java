package io.fangsea.uaa;

import io.fangsea.uaa.domain.entity.*;
import io.fangsea.uaa.domain.mapper.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static io.fangsea.uaa.constant.Constant.STATE_NORMAL;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FangseaIoUaaApplicationTests {
    @Resource
    private UserGroupMapper userGroupMapper;
    @Resource
    private UserGroupMapMapper userGroupMapMapper;
    @Resource
    private UserRolesMapper userRolesMapper;
    @Resource
    private UserRoleMapMapper userRoleMapMapper;
    @Resource
    private UserPermissionsMapper userPermissionsMapper;
    @Resource
    private UserPartPermissionsMapper userPartPermissionsMapper;
    @Resource
    private UserRoleAuthMapper userRoleAuthMapper;

    @Test
    public void insertUserGroup() {
        UserGroup userGroup = new UserGroup();
        userGroup.setGroupName("测试组");
        userGroup.setCreatorId(11);
        userGroup.setState(Byte.valueOf("1"));
        userGroup.setUpdateTime(123456);
        userGroup.setCreateTime(123456);
        userGroupMapper.insert(userGroup);
    }

    /**
     * 描述: 用户加入组中
     */
    @Test
    public void insertUserGroupMap() {
        UserGroupMap userGroupMap = new UserGroupMap();
        userGroupMap.setGroupId(1);//测试组
        userGroupMap.setUserId(15);
        userGroupMap.setCreateTime(123456);
        userGroupMap.setUpdateTime(123456);
        userGroupMap.setState(STATE_NORMAL);
        userGroupMapMapper.insert(userGroupMap);
    }

    @Test
    public void insertUserRoles(){
        UserRoles userRoles = new UserRoles();
        userRoles.setCreateTime(123456);
        userRoles.setRoleName("权限处理角色");
        userRoles.setRoleDesc("管理角色配置");
        userRolesMapper.insert(userRoles);
    }

    @Test
    public void insertUserRoleMap(){
        UserRoleMap userRoleMap = new UserRoleMap();
        userRoleMap.setCreateTime(123456);
        userRoleMap.setUpdateTime(123456);
        userRoleMap.setGroupId(1);
        userRoleMap.setRoleId(1);
        userRoleMap.setStatus(STATE_NORMAL);
        userRoleMapMapper.insert(userRoleMap);
    }

    /***
     * 描述: 添加资源信息(访问接口--路径名称)
     * @date 2019/5/8 13:46
     */
    @Test
    public void insertUserPermissions(){
        UserPermissions userPermissions = new UserPermissions();
        userPermissions.setAccessUri("/oauth/token");
        userPermissions.setPemName("授权认证");
        userPermissions.setPemDesc("授权认证获取token");
        byte actionType = 1;
        userPermissions.setActionType(actionType);
        userPermissions.setState(STATE_NORMAL);
        userPermissions.setCreateTime(123456);
        userPermissions.setUpdateTime(123466);
        userPermissionsMapper.insert(userPermissions);
    }

    @Test
    public void insertUserPartPermissions(){
        UserPartPermissions userPartPermissions = new UserPartPermissions();
        userPartPermissions.setCreateTime(123456);
        userPartPermissions.setId(1);
        userPartPermissionsMapper.insert(userPartPermissions);
    }
    @Test
    public void insertUserRoleAuth(){
        UserRoleAuth userRoleAuth = new UserRoleAuth();
        userRoleAuth.setAuthDesc("测试授权");
        //授权人--系统
        userRoleAuth.setAuthorId(0);
        userRoleAuth.setCreateTime(123456);
        userRoleAuth.setPemId(1);
        userRoleAuth.setRoleId(1);
        userRoleAuth.setStatus(STATE_NORMAL);
        userRoleAuth.setUpdateTime(123456);
        userRoleAuthMapper.insert(userRoleAuth);
    }
    /**根据用户查询具有的权限*/
    @Test
    public void queryUserRoleAuth(){
        List<UserRoleAuth> result = userRoleAuthMapper.selectByUserId(15);
        System.out.println(result.get(0).getAuthDesc());
    }

}

package io.fangsea.uaa.service.impl;

import io.fangsea.uaa.domain.entity.UserPartPermissions;
import io.fangsea.uaa.domain.entity.UserPermissions;
import io.fangsea.uaa.domain.entity.UserRoleAuth;
import io.fangsea.uaa.domain.mapper.UserPartPermissionsMapper;
import io.fangsea.uaa.domain.mapper.UserPermissionsMapper;
import io.fangsea.uaa.domain.mapper.UserRoleAuthMapper;
import io.fangsea.uaa.service.PermissionsService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 描述:
 *
 * @author turningOwei
 * @date 2019-05-08 13:11
 */
@Service
public class PermissionsServiceImpl implements PermissionsService {
    @Resource
    private UserPermissionsMapper userPermissionsMapper;
    @Resource
    private UserPartPermissionsMapper userPartPermissionsMapper;
    @Resource
    private UserRoleAuthMapper userRoleAuthMapper;

    /***
     * 描述:
     * 1.局部权限表有权限,角色没有权限--用户无权限
     * 2.局部权限表没有权限,角色没有权限--用户有权限
     * 3.局部权限表有权限,角色有权限--用户有权限
     *
     * @params
     * @return
     * @date 2019/5/8 16:09
     */
    @Override
    public boolean hasRole(String userIdStr, String accessUri) {
        //TODO userIdStr不为空
        Integer userId = Integer.parseInt(userIdStr);
        List<UserRoleAuth> userRoleAuthUserList = userRoleAuthMapper.selectByUserId(userId);
        List<Integer> pemIdList = userRoleAuthUserList.stream().map(UserRoleAuth::getPemId).collect(Collectors.toList());
        //查询权限id
        List<UserPermissions> userPermissionsList = userPermissionsMapper.selectByAccessUri(accessUri);
        if (CollectionUtils.isEmpty(userPermissionsList)
                || userPermissionsList.size() > 1) {

        } else {
            Integer pemId = userPermissionsList.get(0).getId();
            UserPartPermissions userPartPermissions = userPartPermissionsMapper.selectById(pemId);
            if (hasPartPermissions(userPartPermissions)
                    && hasNotRoleAuthList(pemIdList,pemId)) {
                return false;
            }
            if (hasNotPartPermissions(userPartPermissions)
                    && hasNotRoleAuthList(pemIdList,pemId)) {
                return true;
            }
            if (hasPartPermissions(userPartPermissions)
                    && hasRoleAuthList(pemIdList,pemId)) {
                return true;
            }
        }
        return false;
    }
    /**
     * 描述: 局部权限表有权限
     */
    private boolean hasPartPermissions(UserPartPermissions userPartPermissions) {
        return userPartPermissions != null;
    }
    /**
     * 描述: 局部权限表没有权限
     */
    private boolean hasNotPartPermissions(UserPartPermissions userPartPermissions) {
        return userPartPermissions == null;
    }
    /**
     * 描述: 角色没有权限
     */
    private boolean hasNotRoleAuthList(List<Integer> pemIdList, Integer pemId) {
        return !hasRoleAuthList(pemIdList,pemId);
    }
    /**
     * 描述: 角色有权限
     */
    private boolean hasRoleAuthList(List<Integer> pemIdList, Integer pemId) {
        if (CollectionUtils.isEmpty(pemIdList)) {
            return false;
        }
        return pemIdList.contains(pemId);
    }
}
package io.fangsea.uaa.service;

/**
 * 描述:
 *
 * @author turningOwei
 * @date 2019-05-08 13:10
 */
public interface PermissionsService {
    boolean hasRole(String userIdStr, String accessUri);
}

package com.escr.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.escr.auth.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * The interface Menu mapper.
 *
 * @author psikun
 * @description MenuMapper
 * @date 2023 /04/14/ 17:46
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * Select permissions by userId list.
     *
     * @param userId the user id
     * @return the list
     */
    List<String> selectPermissionsByUserId(Long userId);
}

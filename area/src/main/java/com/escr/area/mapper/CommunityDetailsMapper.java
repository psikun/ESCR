package com.escr.area.mapper;

import com.escr.area.entity.CommunityDetails;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
* @author psikun
* @description 针对表【ams_community_details】的数据库操作Mapper
* @createDate 2023-05-06 19:26:33
* @Entity com.escr.area.entity.CommunityDetails
*/
public interface CommunityDetailsMapper extends BaseMapper<CommunityDetails> {


    @Select("select * from escr_area.ams_community_details where id=(select community_id from escr_auth.ums_user where username = #{username})")
    CommunityDetails getCommunityByUsername(String username);
}





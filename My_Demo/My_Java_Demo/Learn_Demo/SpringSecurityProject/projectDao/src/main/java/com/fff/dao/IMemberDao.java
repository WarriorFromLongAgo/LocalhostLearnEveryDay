package com.fff.dao;

import com.fff.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @PackageName：com.fff.dao
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/11 17:24
 */
public interface IMemberDao {

    @Select("SELECT * FROM member WHERE memberId = #{memberId}")
    public Member findMemberByIdDao(Integer memberId);
}

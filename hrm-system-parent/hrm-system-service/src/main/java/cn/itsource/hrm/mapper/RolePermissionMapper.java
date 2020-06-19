package cn.itsource.hrm.mapper;

import cn.itsource.hrm.domain.RolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ranmin
 * @since 2020-06-19
 */
@Component
public interface RolePermissionMapper extends BaseMapper<RolePermission> {

    void insertBatch(@Param ( "id" ) Long id,@Param ( "permissionIds" ) List<Long> permissionIds);

}

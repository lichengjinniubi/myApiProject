package api.mybatis.mapper;

import api.bean.mysql.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from tbl_user where id = #{id}")
    User findById(Integer id);


    @Insert("insert into tbl_user (id, name, tel) values (#{id}, #{name}, #{tel})")
    void insertData(int id, String name, int tel);
}

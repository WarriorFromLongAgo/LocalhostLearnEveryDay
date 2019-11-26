package com.fff.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @PackageName：com.fff.domain
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/20 20:44
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable {

    private Integer deptId;

    private String deptName;
    //    来自哪个数据库，因为微服务框架可以一个服务对应一个框架。
//    同一个信息被存储到不同的数据库，
    private String db_source;

//    public Dept() {
//    }
//
//    public Dept(Integer deptId, String deptName, String db_source) {
//        this.deptId = deptId;
//        this.deptName = deptName;
//        this.db_source = db_source;
//    }
//
//    @Override
//    public String toString() {
//        return "Dept{" +
//                "deptId=" + deptId +
//                ", deptName='" + deptName + '\'' +
//                ", db_source='" + db_source + '\'' +
//                '}';
//    }
//
//    public Integer getDeptId() {
//        return deptId;
//    }
//
//    public void setDeptId(Integer deptId) {
//        this.deptId = deptId;
//    }
//
//    public String getDeptName() {
//        return deptName;
//    }
//
//    public void setDeptName(String deptName) {
//        this.deptName = deptName;
//    }
//
//    public String getDb_source() {
//        return db_source;
//    }
//
//    public void setDb_source(String db_source) {
//        this.db_source = db_source;
//    }
}

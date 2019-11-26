package com.feijm.producthomework;

import com.feijm.jdbcutil.jdbcUtilDruid;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class JdbcDruidDeal {
    private static JdbcTemplate jdbcTemplate = null;

    static {
        jdbcTemplate = new JdbcTemplate(jdbcUtilDruid.getDataSource());
    }

    /**
     * @-----cdoing：utf-8-----
     * @Author :feijm
     * @Project :改变价格
     * @Time :2019年8月23日19:08:24
     * @version :1.0.0
     * @修改原因 :无
     * @more info   ：输入产品对应的cid，进行价格的调整
     * @more info   ：输入需要增加或者减少的价格，进行价格的调整
     * @more info   ：
     */
    public void changePrice(String cid, int price) {
        Connection connection = null;
        try {
            //  获得连接
            connection = jdbcUtilDruid.getConnection();
            //  开启事务
            connection.setAutoCommit(false);
            //  sql语句的提交
            String sql = "UPDATE product1 SET productPrice = productPrice + ? WHERE productCid = ?";
            int update = jdbcTemplate.update(sql, new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement preparedStatement) throws SQLException {
                    preparedStatement.setInt(1, price);
                    preparedStatement.setString(2, cid);
                }
            });
            //  事务提交
            connection.commit();

            //  事务结果的处理
            System.out.print("修改商品id = " + cid);
            System.out.print("，价格修改 = " + price);
            System.out.print("，修改了 " + update + " 行");
            boolean flag = update > 0;
            if (flag) {
                System.out.println("，修改结果 = 成功 ");
            } else {
                System.out.println("，修改结果 = 失败 ");
            }

        } catch (SQLException e) {
            try {
                System.out.println("账务回滚，修改失败 ");
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }

    }
//    public void changePrice(String cid) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        try {
//            //  调用德鲁伊连接池 工具类，获得connection连接
//            connection = jdbcUtilDruid.getConnection();
//            String sql = "UPDATE product1 SET price = price + 500 WHERE cid = ?";
//            //  开展事务
//            connection.setAutoCommit(false);
//            //  preparedStatement进行预加载，
//            preparedStatement = connection.prepareStatement(sql);
//            //  设置对应索引位置
//            preparedStatement.setString(1, cid);
//            //  执行sql语句
//            int count = preparedStatement.executeUpdate();
//            //  事务提交
//            connection.commit();
//            //  事务结果的处理
//            System.out.println("修改了 " + count + " 行");
//            boolean flag = count > 0;
//            System.out.println("修改结果 = " + flag);
//
//            connection.close();
//        } catch (SQLException e) {
//            try {
//                //  如果有问题，进行事务的回滚
//                connection.rollback();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//            e.printStackTrace();
//        } finally {
//
//        }
//
//    }


    /**
     * @-----cdoing：utf-8-----
     * @Author :   feijm
     * @Project :   查找价格区间的产品
     * @Time :  2019年8月23日19:46:44
     * @version :1.0.0
     * @修改原因 :无
     * @more info   ：根据输入的低价格和高价格，返回该区间的所有产品
     * @more info   ：
     * @more info   ：
     */

    @SuppressWarnings("all")
    public void findIntervalPrice(int lowPrice, int highPrice) {
        String sql = "SELECT * FROM product WHERE price BETWEEN ? AND ?";

//        List<Product> productList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class), lowPrice, highPrice);
//        List<Product> productList = jdbcTemplate.query(sql, new Object[]{lowPrice, highPrice}, new BeanPropertyRowMapper<Product>(Product.class));
        List<Product> productList = jdbcTemplate.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, lowPrice);
                preparedStatement.setInt(2, highPrice);
            }
        }, new BeanPropertyRowMapper<Product>(Product.class));
        for (Product product : productList) {
            System.out.println(product);
        }
    }
    //org.springframework.jdbc.IncorrectResultSetColumnCountException：列数不正确：预期1，实际5
//    String product = jdbcTemplate.queryForObject(sql, new Object[]{lowPrice, highPrice}, String.class);
//        System.out.println(product);

    /**
     * @-----cdoing：utf-8-----
     * @Author :   feijm
     * @Project :   查找对应flag状态的产品
     * @Time :  2019年8月23日20:18:28
     * @version :1.0.0
     * @修改原因 :无
     * @more info   ：根据输入的flag，返回该状态的的所有产品
     * @more info   ：flag = 0 为 未上架
     * @more info   ：flag = 1 为 已上架
     */
    @SuppressWarnings("all")
    public void findToFlag(Integer flag) {
        if (flag != 0 || flag != 1) {
            System.out.println("输入的flag有错误，不是0也不是1，无法查找 ");
            return;
        }
        String sql = "SELECT * FROM product WHERE flag = ? ";

        List<Product> productList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class), flag);

        for (Product product : productList) {
            System.out.println(product);
        }
    }

    /**
     * @-----cdoing：utf-8-----
     * @Author :   feijm
     * @Project :   模糊查找商品名字中含有某些关键字的商品
     * @Time :  2019年8月23日20:23:28
     * @version :1.0.0
     * @修改原因 :无
     * @more info   ：根据输入的string，模糊查找所有的商品名字
     * @more info   ：
     * @more info   ：
     */
    @SuppressWarnings("all")
    public void findToKeyword(String productName) {
        String sql = "SELECT * FROM product WHERE pname LIKE ?";
        String str = "%" + productName + "%";
        System.out.println(str);
        List<Product> productList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class), str);

        for (Product product : productList) {
            System.out.println(product);
        }
    }

    /**
     * @-----cdoing：utf-8-----
     * @Author :   feijm
     * @Project :   查找对应cid的产品
     * @Time :  2019年8月23日20:12:38
     * @version :1.0.0
     * @修改原因 :无
     * @more info   ：根据输入的cid，返回该cid的所有产品
     * @more info   ：
     * @more info   ：
     */
    @SuppressWarnings("all")
    public void findToCid(String cid) {
        String sql = "SELECT * FROM product WHERE cid = ? ";

        List<Product> productList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class), cid);

        for (Product product : productList) {
            System.out.println(product);
        }
    }

    /**
     * @-----cdoing：utf-8-----
     * @Author :   feijm
     * @Project :   根据输入的长度，查找对应长度的商品名称
     * @Time :  2019年8月23日20:23:28
     * @version :1.0.0
     * @修改原因 :无
     * @more info   ：根据输入的length，模糊查找所有的商品名字为，length的商品信息
     * @more info   ：
     * @more info   ：
     */
    @SuppressWarnings("all")
    public void findToLength(Integer length) {
        //  根据长度，输出一个对应长度的 下划线，用于下面的模糊查找
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer i = 0; i < length; i++) {
            stringBuilder.append("_");
        }

        String sql = "SELECT * FROM product WHERE pname LIKE ?";

        List<Product> productList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class),
                new String(stringBuilder));

        for (Product product : productList) {
            System.out.println(product);
        }
    }

    /**
     * @-----cdoing：utf-8-----
     * @Author :   feijm
     * @Project :   根据输入的状态，返回对应的产品数量
     * @Time :  2019年8月23日20:42:51
     * @version :1.0.0
     * @修改原因 :无
     * @more info   ：根据输入的状态，返回对应的产品数量
     * @more info   ：
     * @more info   ：
     */
    public int findFlagReturnInt(int flag) {
        if (flag != 0 && flag != 1) {
            System.out.println("输入的flag有错误，不是0也不是1，无法查找 ");
            return 0;
        }
        String sql = "SELECT COUNT(pid) FROM product WHERE flag = ?";
//        以下有两种返回的方式
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{flag}, Integer.class);
        Integer count1 = jdbcTemplate.queryForObject(sql, Integer.class, flag);

        if (flag == 1) {
            System.out.print("已上架状态");
        } else {
            System.out.print("未上架状态");
        }
        System.out.println("，对应状态的产品有 " + count + " 种");

        return count;
    }
//    User user=jdbcTemplate.queryForObject(string, new RowMapper<User>(){
//        @Override
//        public User mapRow(ResultSet arg0, int arg1) throws SQLException {
//            User user=new User();
//            user.setName(arg0.getString("name"));
//            user.setPassword(arg0.getString("password"));
//            return user;
//        }
//    });

    /**
     * @-----cdoing：utf-8-----
     * @Author :   feijm
     * @Project :   根据输入的对象，分解插入到数据库里面
     * @Time :  2019年8月23日20:42:51
     * @version :1.0.0
     * @修改原因 :无
     * @more info   ：据输入的对象，分解插入到数据库里面
     * @more info   ：
     * @more info   ：
     */
    public void insertProduct(Product product) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = jdbcUtilDruid.getConnection();
            connection.setAutoCommit(false);

            String sql = "INSERT INTO product1 (pname, price, flag, cid) VALUES (?, ?, ?, ?)";
            int update = jdbcTemplate.update(sql, new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement preparedStatement) throws SQLException {
                    preparedStatement.setString(1, product.getPname());
                    preparedStatement.setInt(2, product.getPrice());
                    preparedStatement.setInt(3, product.getFlag());
                    preparedStatement.setString(4, product.getCid());
                }
            });
            //  事务提交
            connection.commit();

            boolean flag = update > 0;
            if (flag) {
                System.out.println("插入成功 ");
            } else {
                System.out.println("插入失败 ");
            }
        } catch (SQLException e) {
            try {
                System.out.println("账务回滚，插入失败 ");
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    /**
     * @-----cdoing：utf-8-----
     * @Author :   feijm
     * @Project :   查询未上架中商品中价格大于上架商品价格的商品
     * @Time :  2019年8月23日20:42:51
     * @version :1.0.0
     * @修改原因 :无
     * @more info   ：查询未上架中商品中价格大于上架商品价格的商品
     * @more info   ：
     * @more info   ：
     */
    public void tempTen() {
        String sql = "SELECT DISTINCT p1.* FROM product p1, product p2 WHERE" +
                " p1.flag = 0 AND p2.flag = 1 AND p1.price > p2.price ";

        List<Product> productList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class));

        for (Product product : productList) {
            System.out.println(product);
        }
    }

    /**
     * @-----cdoing：utf-8-----
     * @Author :   feijm
     * @Project :   查询所有商品按价格的降序存到一个List集合里面
     * @Time :  2019年8月23日20:42:51
     * @version :1.0.0
     * @修改原因 :无
     * @more info   ：查询所有商品按价格的降序存到一个List集合里面
     * @more info   ：
     * @more info   ：
     */
    public void productDesc() {
        String sql = "SELECT * FROM product ORDER BY price DESC";

        List<Product> productList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class));

        for (Product product : productList) {
            System.out.println(product);
        }
    }
}

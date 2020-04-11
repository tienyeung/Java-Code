package cn.base.jdbc;
import cn.base.practice.Emp;
import cn.base.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Practice1 {
    public static void main(String[] args) {
        List<Emp> list = new Practice1().findAll();
        System.out.println(list);
        System.out.println(list.size());
    }
    /**
     * 查询所有emp对象
     * @return emp对象的列表
     */
    public List<Emp> findAll(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Emp> list = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = " select * from emp ";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            Emp emp = null;
            list = new ArrayList<>();
            while(rs.next()){
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");

                emp = new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                list.add(emp);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(stmt,conn,rs);
        }

        return null;
    }
}

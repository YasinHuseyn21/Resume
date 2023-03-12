/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.inter.AbstractDao;
import dao.inter.EmploymentHistoryDaoInter;
import entity.EmploymentHistory;
import entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yasin
 */
public class EmploymentHistoryDaoImpl extends AbstractDao implements EmploymentHistoryDaoInter {
    public EmploymentHistory getEmploymentHistory(ResultSet rs) throws Exception {

        int userId = rs.getInt("user_id");
        String header=rs.getString("header");
        Date beginDate=rs.getDate("begin_date");
        Date endDate=rs.getDate("end_date");
        String jobDescription = rs.getString("job_description");


        return new EmploymentHistory(null,beginDate,endDate,jobDescription,header,new User(userId));


    }

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {
        List<EmploymentHistory> result = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("SELECT" +
                    "\t* " +
                    "FROM" +
                    "\temployment " +
                    "WHERE" +
                    "\tuser_id =?");
            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                EmploymentHistory u = getEmploymentHistory(rs);
                result.add(u);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;


    }
}

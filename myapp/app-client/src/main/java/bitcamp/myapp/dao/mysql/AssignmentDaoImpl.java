package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.DaoException;
import bitcamp.myapp.vo.Assignment;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AssignmentDaoImpl implements AssignmentDao {

  Connection con;

  public AssignmentDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(Assignment assignment) {
    try {
      Statement stmt = con.createStatement();

      String query = String.format(
        "insert into assignments(title,content,deadline) values('%s','%s','%s')",
        assignment.getTitle(), assignment.getContent(), assignment.getDeadline());
      stmt.executeUpdate(query);
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();

      String query = String.format(
        "delete from Assignments where=%d",
        no);
      return stmt.executeUpdate(query);
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public List<Assignment> findAll() {
    try {
      Statement stmt = con.createStatement();

      String query = String.format(
        "select * from Assignments"
      );
      ResultSet rs = stmt.executeQuery(query);
      List<Assignment> arr = new ArrayList<>();
      while (rs.next()) {
        Assignment assignment = new Assignment();
        assignment.setTitle(rs.getString("title"));
        assignment.setContent(rs.getString("content"));
        assignment.setDeadline(rs.getDate("deadline"));
        arr.add(assignment);
      }
      return arr;
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public Assignment findBy(int no) {
    try {
      Statement stmt = con.createStatement();

      String query = String.format(
        "select * from Assignments where = assignment_no=%d", no
      );
      ResultSet rs = stmt.executeQuery(query);
      rs.next();
      Assignment assignment = new Assignment();
      assignment.setTitle(rs.getString("title"));
      assignment.setContent(rs.getString("content"));
      assignment.setDeadline(rs.getDate("deadline"));
      return assignment;
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int update(Assignment assignment) {
    try {
      Statement stmt = con.createStatement();

      String query = String.format(
        "update boards set title='%d', content='%d' where = assignment_no=%s",
        assignment.getTitle(), assignment.getContent(), assignment.getNo());
      return stmt.executeUpdate(query);
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }
}

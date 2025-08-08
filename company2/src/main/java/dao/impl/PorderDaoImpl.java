package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PorderDao;
import model.Porder;
import util.DbConnection;

public class PorderDaoImpl implements PorderDao{

	public static void main(String[] args) {
	Porder p=new PorderDaoImpl().selectById(5);
	
	
	new PorderDaoImpl().delete(p);
		
	}
	private static Connection conn=DbConnection.getDb();
	@Override
	public void add(Porder porder) {
		String Sql="insert into porder(name,black,latte,mocha) values(?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(Sql);
			ps.setString(1,porder.getName());
			ps.setInt(2,porder.getBlack());
			ps.setInt(3,porder.getLatte());
			ps.setInt(4,porder.getMocha());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Porder> selectAll() {
		String sql="select * from porder";
		List<Porder> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Porder p=new Porder();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setBlack(rs.getInt("black"));
				p.setLatte(rs.getInt("latte"));
				p.setMocha(rs.getInt("mocha"));
				
				l.add(p);
			
			
			}
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return l;
	}

	@Override
	public Porder selectById(int id) {
		String sql="select * from porder where id=?";
		Porder p=null;
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				p=new Porder();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setBlack(rs.getInt("black"));
				p.setLatte(rs.getInt("latte"));
				p.setMocha(rs.getInt("mocha"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return p;
	}

	@Override
	public void update(Porder porder) {
		String sql="update porder set lcd=?,ram=?,mouse=? where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, porder.getBlack());
			ps.setInt(2, porder.getLatte());
			ps.setInt(3, porder.getMocha());
			ps.setInt(4, porder.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(Porder porder) {
		String sql="delete from porder where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, porder.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

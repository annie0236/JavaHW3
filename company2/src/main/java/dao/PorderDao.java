package dao;

import java.util.List;

import model.Porder;

//sql語法
public interface PorderDao {
	//create
	void add(Porder porder);
	
	//read
	List<Porder> selectAll();
	Porder selectById(int id);
	
	//update
	void update(Porder porder);
	
	//delete
	void delete(Porder porder);

}

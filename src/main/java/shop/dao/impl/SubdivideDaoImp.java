package shop.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shop.bean.Subdivide;
import shop.dao.SubdivideDao;
import shop.dao.impl.jparepository.SubdivideRepository;

@Repository("subdivideDao")
public class SubdivideDaoImp implements SubdivideDao {

	@Autowired
	private SubdivideRepository sr;

	public SubdivideDaoImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Subdivide selectById(String uuid) {
		// TODO Auto-generated method stub
		return sr.findByUuid(uuid);
	}

	@Override
	public void insertSubdivide(Subdivide subdivide) {
		// TODO Auto-generated method stub
		sr.save(subdivide);
	}

	@Override
	public void updateSubdivide(Subdivide subdivide) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSubdivide(String uuid) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Subdivide> findAll() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}

}

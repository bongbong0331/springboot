package com.demo.qlrm.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Repository;

import com.demo.qlrm.dto.res.EmployeesDTO;
import com.demo.qlrm.dto.res.NameSearchDTO;

// Interface extends JpaRepository<T, ID> 상속을 받으면 무조건 Entity(model)로 받아야 하기 때문에
// DTO 맵핑 하기가 힘들다. 그래서 직접 Repository 를 구성하자.
@Repository
public class EmployeeRepository {

	// 준비물
	// 1. EntityManager
	private final EntityManager entityManager;
	
	public EmployeeRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
		
	}
	
	// 기능 설계
	public EmployeesDTO getOldEmployeesAgeInfo() {
		
		// 어노테이션 기반이 아닌 직접 생성해 보자. native query 로
		// Connection 객체
		// Statement 객체
		// ResultSet
		// String 으로 뿌리거나 --> object() rs.getString("emp_no"); rs.getInt("age");
		
		String strQuery = " SELECT "
								+ "  *, TIMESTAMPDIFF(YEAR, birth_date, NOW()) AS age "
								+ " FROM "
								+ " employees "
								+ " WHERE "
								+ " emp_no = 10001 ";
		// Query 객체를 사용합니다.
		Query nativeQuery = entityManager.createNativeQuery(strQuery);
		
		// QLRM 사용
		// import org.qlrm.mapper.JpaResultMapper;
		JpaResultMapper mapper = new JpaResultMapper();
		// 하지만
		EmployeesDTO dto = mapper.uniqueResult(nativeQuery, EmployeesDTO.class);
		// [  mapper.list(nativeQuery, EmployeesDTO.class); 형이 다르면 변환 해줘야함 패스 ]
		
		//--------------------------------------------------------
		// Query 객체를 이용하여 구문 실행하고 결과 집합을 받아 보자.
//		System.out.println(nativeQuery.getSingleResult());
//		System.out.println(nativeQuery.getResultList());
		// 형 변환 처리 후
		// 사이즈가 얼마 일까?
//		List<Object[]> resultList = nativeQuery.getResultList();
//		System.out.println(resultList.size()); // 사이즈가 1개 확인
//		Object[] objs = resultList.get(0);
		
//		System.out.println(objs.length); // 사이즈 확인
		// 결과 집합 7개 확인하고 값을 출력할 수 있다.
//		System.out.println(objs[0]);
//		System.out.println(objs[1]);
//		System.out.println(objs[2]);
//		System.out.println(objs[3]);
//		System.out.println(objs[4]);
//		System.out.println(objs[5]);
//		System.out.println(objs[6]);
		
		
//		// dto 로 변환 하기
//		EmployeesDTO dto = new EmployeesDTO(objs);
//		
//		System.out.println(dto);
		
		
		
		return mapper.uniqueResult(nativeQuery, EmployeesDTO.class);
	}
	
	
	public List<NameSearchDTO> getKyoichiInfo() {
		String kyoQuery = " SELECT "
								+ "   *, COUNT(first_name) AS x_name "
								+ " FROM "
								+ "    employees AS e "
								+ " GROUP BY first_name "
								+ " HAVING first_name = 'kyoichi'  ";

		Query nativekQuery = entityManager.createNativeQuery(kyoQuery);
		
		
		
		JpaResultMapper mapper = new JpaResultMapper();
		
		List<NameSearchDTO>  dto = mapper.list(nativekQuery, NameSearchDTO.class);
		
		
		return dto;
	}
	
	
	
	public NameSearchDTO getKyoichiInfo2() {
		String kyoQuery = " SELECT "
				+ "   *, COUNT(first_name) AS x_name "
				+ " FROM "
				+ "    employees AS e "
				+ " GROUP BY first_name "
				+ " HAVING first_name = 'kyoichi'  ";
		
				Query nativeQuery = entityManager.createNativeQuery(kyoQuery);
				
				List<Object[]> resultList = nativeQuery.getResultList();
				Object[] objs = resultList.get(0);
				
				NameSearchDTO dto = new NameSearchDTO(objs);
				
				return dto;
	}
	
	
	
}

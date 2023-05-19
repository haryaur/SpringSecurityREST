package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Request;

public interface RequestRepository extends JpaRepository<Request, Integer>{
	
	@Query(value = "select *\r\n"
			+ "from request a  \r\n"
			+ "inner join approval b on a.request_approval_id = b.approval_id \r\n"
			+ "inner join items c on a.request_item_id = c.type_id \r\n"
			+ "inner join users d on a.request_user_id = d.user_id \r\n"
			+ "inner join branch_location e on d.user_branch_id = e.branch_id "
			+ "WHERE b.branch_manager = ?1", nativeQuery = true)
	public List<Request> findByBranchManager(String branchManager);
	
	@Query(value = "select *\r\n"
			+ "from request a  \r\n"
			+ "inner join approval b on a.request_approval_id = b.approval_id \r\n"
			+ "inner join items c on a.request_item_id = c.type_id \r\n"
			+ "inner join users d on a.request_user_id = d.user_id \r\n"
			+ "inner join branch_location e on d.user_branch_id = e.branch_id "
			+ "WHERE b.branch_approval_status='Pending' AND b.head_officeamanager = ?1", nativeQuery = true)
	public List<Request> findByHeadOfficeManager(String headOfficeManager);

	@Query("SELECT r FROM Request r WHERE r.requestId = ?1")
	public Request findById(int requestId);
	
	@Query(value = "select * \r\n"
			+ "from request a  \r\n"
			+ "left join approval b on a.request_approval_id = b.approval_id \r\n"
			+ "left join items c on a.request_item_id = c.type_id \r\n"
			+ "left join users d on a.request_user_id = d.user_id \r\n"
			+ "left join branch_location e on d.user_branch_id = e.branch_id "
			+ "WHERE d.user_id = ?1", nativeQuery = true)
	public List<Request> findAllUser(int userId);
	
	
	@Query(value = "select * \r\n"
			+ "from request a  \r\n"
			+ "left join approval b on a.request_approval_id = b.approval_id \r\n"
			+ "left join items c on a.request_item_id = c.type_id \r\n"
			+ "left join users d on a.request_user_id = d.user_id \r\n"
			+ "left join branch_location e on d.user_branch_id = e.branch_id "
			+ "WHERE b.status='Approved' and d.user_id = ?1", nativeQuery = true)
	public List<Request> findApprovedUser(int userId);
	
	@Query(value = "select * \r\n"
			+ "from request a  \r\n"
			+ "left join approval b on a.request_approval_id = b.approval_id \r\n"
			+ "left join items c on a.request_item_id = c.type_id \r\n"
			+ "left join users d on a.request_user_id = d.user_id \r\n"
			+ "left join branch_location e on d.user_branch_id = e.branch_id "
			+ "WHERE b.status='Rejected' and d.user_id = ?1", nativeQuery = true)
	public List<Request> findRejectedUser(int userId);
	
	
	@Query(value = "select * \r\n"
			+ "from request a  \r\n"
			+ "left join approval b on a.request_approval_id = b.approval_id \r\n"
			+ "left join items c on a.request_item_id = c.type_id \r\n"
			+ "left join users d on a.request_user_id = d.user_id \r\n"
			+ "left join branch_location e on d.user_branch_id = e.branch_id "
			+ "WHERE b.status='Pending' and d.user_id = ?1", nativeQuery = true)
	public List<Request> findPendingUser(int userId);
	
	@Query(value = "select * \r\n"
			+ "from request a  \r\n"
			+ "left join approval b on a.request_approval_id = b.approval_id \r\n"
			+ "left join items c on a.request_item_id = c.type_id \r\n"
			+ "left join users d on a.request_user_id = d.user_id \r\n"
			+ "left join branch_location e on d.user_branch_id = e.branch_id "
			+ "and b.branch_manager = ?1", nativeQuery = true)
	public List<Request> findAllManager(String firstName);
	
	@Query(value = "select * \r\n"
			+ "from request a  \r\n"
			+ "left join approval b on a.request_approval_id = b.approval_id \r\n"
			+ "left join items c on a.request_item_id = c.type_id \r\n"
			+ "left join users d on a.request_user_id = d.user_id \r\n"
			+ "left join branch_location e on d.user_branch_id = e.branch_id "
			+ "WHERE b.branch_approval_status='Pending' "
			+ "and b.branch_manager = ?1", nativeQuery = true)
	public List<Request> findPendingManager(String firstName);
	
	@Query(value = "select * \r\n"
			+ "from request a  \r\n"
			+ "left join approval b on a.request_approval_id = b.approval_id \r\n"
			+ "left join items c on a.request_item_id = c.type_id \r\n"
			+ "left join users d on a.request_user_id = d.user_id \r\n"
			+ "left join branch_location e on d.user_branch_id = e.branch_id "
			+ "WHERE b.branch_approval_status='Rejected' "
			+ "and b.branch_manager = ?1", nativeQuery = true)
	public List<Request> findRejectedManager(String firstName);
	
	@Query(value = "select * \r\n"
			+ "from request a  \r\n"
			+ "left join approval b on a.request_approval_id = b.approval_id \r\n"
			+ "left join items c on a.request_item_id = c.type_id \r\n"
			+ "left join users d on a.request_user_id = d.user_id \r\n"
			+ "left join branch_location e on d.user_branch_id = e.branch_id "
			+ "WHERE b.branch_approval_status='Approved' "
			+ "and b.branch_manager = ?1", nativeQuery = true)
	public List<Request> findApprovedManager(String firstName);
	
	@Query(value = "select * \r\n"
			+ "from request a  \r\n"
			+ "left join approval b on a.request_approval_id = b.approval_id \r\n"
			+ "left join items c on a.request_item_id = c.type_id \r\n"
			+ "left join users d on a.request_user_id = d.user_id \r\n"
			+ "left join branch_location e on d.user_branch_id = e.branch_id "
			+ "WHERE b.head_office_manager = ?1", nativeQuery = true)
	public List<Request> findAllHeadOffice(String firstName);
	
	@Query(value = "select * \r\n"
			+ "from request a  \r\n"
			+ "left join approval b on a.request_approval_id = b.approval_id \r\n"
			+ "left join items c on a.request_item_id = c.type_id \r\n"
			+ "left join users d on a.request_user_id = d.user_id \r\n"
			+ "left join branch_location e on d.user_branch_id = e.branch_id "
			+ "WHERE b.head_office_approval_status='Pending' "
			+ "and b.head_office_manager = ?1", nativeQuery = true)
	public List<Request> findPendingHeadOffice(String firstName);
	
	@Query(value = "select * \r\n"
			+ "from request a  \r\n"
			+ "left join approval b on a.request_approval_id = b.approval_id \r\n"
			+ "left join items c on a.request_item_id = c.type_id \r\n"
			+ "left join users d on a.request_user_id = d.user_id \r\n"
			+ "left join branch_location e on d.user_branch_id = e.branch_id "
			+ "WHERE b.head_office_approval_status='Approved' "
			+ "and b.head_office_manager = ?1", nativeQuery = true)
	public List<Request> findApprovedHeadOffice(String firstName);
	
	@Query(value = "select * \r\n"
			+ "from request a  \r\n"
			+ "left join approval b on a.request_approval_id = b.approval_id \r\n"
			+ "left join items c on a.request_item_id = c.type_id \r\n"
			+ "left join users d on a.request_user_id = d.user_id \r\n"
			+ "left join branch_location e on d.user_branch_id = e.branch_id "
			+ "WHERE b.head_office_approval_status='Rejected' "
			+ "and b.head_office_manager = ?1", nativeQuery = true)
	public List<Request> findRejectedHeadOffice(String firstName);
}

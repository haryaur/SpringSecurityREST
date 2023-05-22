package com.example.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Request;

public interface RequestCountRepository extends JpaRepository<Request, Integer>{
	
	
	@Query(value = "select COUNT(*) \r\n"
			+ "from request a  \r\n"
			+ "left join approval b on a.request_approval_id = b.approval_id \r\n"
			+ "left join items c on a.request_item_id = c.type_id \r\n"
			+ "left join users d on a.request_user_id = d.user_id \r\n"
			+ "left join branch_location e on d.user_branch_id = e.branch_id "
			+ "WHERE d.user_id = ?1", nativeQuery = true)
	public int findCountAllUser(int userId);
	
	@Query(value = "select COUNT(*) \r\n"
			+ "from request a  \r\n"
			+ "left join approval b on a.request_approval_id = b.approval_id \r\n"
			+ "left join items c on a.request_item_id = c.type_id \r\n"
			+ "left join users d on a.request_user_id = d.user_id \r\n"
			+ "left join branch_location e on d.user_branch_id = e.branch_id "
			+ "WHERE b.status='Approved' and d.user_id = ?1", nativeQuery = true)
	public int findCountApprovedUser(int userId);
	
	@Query(value = "select COUNT(*) \r\n"
			+ "from request a  \r\n"
			+ "left join approval b on a.request_approval_id = b.approval_id \r\n"
			+ "left join items c on a.request_item_id = c.type_id \r\n"
			+ "left join users d on a.request_user_id = d.user_id \r\n"
			+ "left join branch_location e on d.user_branch_id = e.branch_id "
			+ "WHERE b.status='Rejected' and d.user_id = ?1", nativeQuery = true)
	public int findCountRejectedUser(int userId);
	
	
	@Query(value = "select COUNT(*) \r\n"
			+ "from request a  \r\n"
			+ "left join approval b on a.request_approval_id = b.approval_id \r\n"
			+ "left join items c on a.request_item_id = c.type_id \r\n"
			+ "left join users d on a.request_user_id = d.user_id \r\n"
			+ "left join branch_location e on d.user_branch_id = e.branch_id "
			+ "WHERE b.status='Pending' and d.user_id = ?1", nativeQuery = true)
	public int findCountPendingUser(int userId);
	
	@Query(value = "select COUNT(*) \r\n"
			+ "from request a  \r\n"
			+ "left join approval b on a.request_approval_id = b.approval_id \r\n"
			+ "left join items c on a.request_item_id = c.type_id \r\n"
			+ "left join users d on a.request_user_id = d.user_id \r\n"
			+ "left join branch_location e on d.user_branch_id = e.branch_id "
			+ "and b.branch_manager = ?1", nativeQuery = true)
	public int findCountAllManager(String firstName);
	
	@Query(value = "select COUNT(*) \r\n"
			+ "from request a  \r\n"
			+ "left join approval b on a.request_approval_id = b.approval_id \r\n"
			+ "left join items c on a.request_item_id = c.type_id \r\n"
			+ "left join users d on a.request_user_id = d.user_id \r\n"
			+ "left join branch_location e on d.user_branch_id = e.branch_id "
			+ "WHERE b.branch_approval_status='Pending' "
			+ "and b.branch_manager = ?1", nativeQuery = true)
	public int findCountPendingManager(String firstName);
	
	@Query(value = "select COUNT(*) \r\n"
			+ "from request a  \r\n"
			+ "left join approval b on a.request_approval_id = b.approval_id \r\n"
			+ "left join items c on a.request_item_id = c.type_id \r\n"
			+ "left join users d on a.request_user_id = d.user_id \r\n"
			+ "left join branch_location e on d.user_branch_id = e.branch_id "
			+ "WHERE b.branch_approval_status='Rejected' "
			+ "and b.branch_manager = ?1", nativeQuery = true)
	public int findCountRejectedManager(String firstName);
	
	@Query(value = "select COUNT(*) \r\n"
			+ "from request a  \r\n"
			+ "left join approval b on a.request_approval_id = b.approval_id \r\n"
			+ "left join items c on a.request_item_id = c.type_id \r\n"
			+ "left join users d on a.request_user_id = d.user_id \r\n"
			+ "left join branch_location e on d.user_branch_id = e.branch_id "
			+ "WHERE b.branch_approval_status='Approved' "
			+ "and b.branch_manager = ?1", nativeQuery = true)
	public int findCountApprovedManager(String firstName);
	
	@Query(value = "select COUNT(*) \r\n"
			+ "from request a  \r\n"
			+ "left join approval b on a.request_approval_id = b.approval_id \r\n"
			+ "left join items c on a.request_item_id = c.type_id \r\n"
			+ "left join users d on a.request_user_id = d.user_id \r\n"
			+ "left join branch_location e on d.user_branch_id = e.branch_id "
			+ "WHERE b.head_office_manager = ?1", nativeQuery = true)
	public int findCountAllHeadOffice(String firstName);
	
	@Query(value = "select COUNT(*) \r\n"
			+ "from request a  \r\n"
			+ "left join approval b on a.request_approval_id = b.approval_id \r\n"
			+ "left join items c on a.request_item_id = c.type_id \r\n"
			+ "left join users d on a.request_user_id = d.user_id \r\n"
			+ "left join branch_location e on d.user_branch_id = e.branch_id "
			+ "WHERE b.head_office_approval_status='Pending' "
			+ "and b.head_office_manager = ?1", nativeQuery = true)
	public int findCountPendingHeadOffice(String firstName);
	
	@Query(value = "select COUNT(*) \r\n"
			+ "from request a  \r\n"
			+ "left join approval b on a.request_approval_id = b.approval_id \r\n"
			+ "left join items c on a.request_item_id = c.type_id \r\n"
			+ "left join users d on a.request_user_id = d.user_id \r\n"
			+ "left join branch_location e on d.user_branch_id = e.branch_id "
			+ "WHERE b.head_office_approval_status='Approved' "
			+ "and b.head_office_manager = ?1", nativeQuery = true)
	public int findCountApprovedHeadOffice(String firstName);
	
	@Query(value = "select COUNT(*) \r\n"
			+ "from request a  \r\n"
			+ "left join approval b on a.request_approval_id = b.approval_id \r\n"
			+ "left join items c on a.request_item_id = c.type_id \r\n"
			+ "left join users d on a.request_user_id = d.user_id \r\n"
			+ "left join branch_location e on d.user_branch_id = e.branch_id "
			+ "WHERE b.head_office_approval_status='Rejected' "
			+ "and b.head_office_manager = ?1", nativeQuery = true)
	public int findCountRejectedHeadOffice(String firstName);
}


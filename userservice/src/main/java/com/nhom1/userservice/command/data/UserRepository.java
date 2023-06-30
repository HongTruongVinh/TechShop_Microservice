package com.nhom1.userservice.command.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository  extends JpaRepository<User, String> {
	@Query(nativeQuery = true, value="select total_invoices from User p where p.userid = :userid")
	public int findTotalInvoicesByEmail(@Param("userid") String userid);
}

package com.nhom1.invoiceservice.command.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
	@Query(nativeQuery = true, value = "select * from onlshop_invoice.invoice i where i._id = :id")
	public Invoice findInvoiceById(@Param("id") String id);
	
	@Query(nativeQuery = true, value = "select * from onlshop_invoice.invoice i where i.userID = :userID")
	public List<Invoice> findInvoicesOfUser(@Param("userID") String userID);
}

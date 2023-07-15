package com.nhom1.invoiceservice.command.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface DetailedInvoiceRepository extends JpaRepository<DetailedInvoice, Integer> {
	@Query(nativeQuery = true, value = "select * from onlshop_invoice.detailinvoice d where d._id = :id")
	public DetailedInvoice findDetailedInvoicceById(@Param("id") String id);
	
	@Query(nativeQuery = true, value = "select * from onlshop_invoice.detailinvoice d where d.invoiceID = :invoiceID")
	public List<DetailedInvoice> findDetailedInvoicceByInvoiceId(@Param("invoiceID") String invoiceID);
}

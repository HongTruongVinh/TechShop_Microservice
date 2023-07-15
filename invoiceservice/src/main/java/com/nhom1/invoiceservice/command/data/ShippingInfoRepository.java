package com.nhom1.invoiceservice.command.data;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShippingInfoRepository extends JpaRepository<ShippingInfo, Integer>{
	@Query(nativeQuery = true, value = "select * from onlshop_invoice.shippinginfo s where s.invoiceID = :invoiceID")
	public ShippingInfo findShippingInfoByInvoiceId(@Param("invoiceID") String invoiceID);
}

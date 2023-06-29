package com.nhom1.invoiceservice.command.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailedInvoiceRepository extends JpaRepository<DetailedInvoice, Integer> {
    
}

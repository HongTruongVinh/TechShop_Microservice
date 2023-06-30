package com.nhom1.invoiceservice.query.queries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllInvoiceByUserIdQuery {
    private int userID;
}

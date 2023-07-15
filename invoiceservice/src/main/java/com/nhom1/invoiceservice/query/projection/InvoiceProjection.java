package com.nhom1.invoiceservice.query.projection;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nhom1.commonservice.model.ProductResponseCommonModel;
import com.nhom1.commonservice.model.UserSessionCommonModel;
import com.nhom1.commonservice.query.GetProductCommonQuery;
import com.nhom1.commonservice.query.GetUserSessionCommonQuery;
import com.nhom1.invoiceservice.command.data.DetailedInvoice;
import com.nhom1.invoiceservice.command.data.DetailedInvoiceRepository;
import com.nhom1.invoiceservice.command.data.Invoice;
import com.nhom1.invoiceservice.command.data.InvoiceRepository;
import com.nhom1.invoiceservice.command.data.ShippingInfo;
import com.nhom1.invoiceservice.command.data.ShippingInfoRepository;
import com.nhom1.invoiceservice.query.model.DetailedInvoiceResponseModel;
import com.nhom1.invoiceservice.query.model.InvoiceResponseModel;
import com.nhom1.invoiceservice.query.model.ShippingInfoResponseModel;
import com.nhom1.invoiceservice.query.queries.GetAllInvoiceByUserIdQuery;
import com.nhom1.invoiceservice.query.queries.GetAllInvoiceQuery;
import com.nhom1.invoiceservice.query.queries.GetInvoiceByIdQuery;

@Component
public class InvoiceProjection {
	@Autowired
	private QueryGateway queryGateway;

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	DetailedInvoiceRepository detailedInvoiceRepository;

	@Autowired
	ShippingInfoRepository shippingInfoRepository;

	@QueryHandler
	public InvoiceResponseModel handle(GetInvoiceByIdQuery getInvoiceByIdQuery) {
		InvoiceResponseModel model = new InvoiceResponseModel();
		Invoice entity = invoiceRepository.findInvoiceById(getInvoiceByIdQuery.getInvoiceId());
		BeanUtils.copyProperties(entity, model);
		return model;
	}

	@QueryHandler
	public List<Invoice> handle(GetAllInvoiceQuery query) {
		
		GetUserSessionCommonQuery getUserSessionCommonQuery = new GetUserSessionCommonQuery();
		  
		UserSessionCommonModel userSessionCommonModel = queryGateway.query(getUserSessionCommonQuery,
		ResponseTypes.instanceOf(UserSessionCommonModel.class)).join();
		 
		
		List<Invoice> listInvoices = invoiceRepository.findInvoicesOfUser(userSessionCommonModel.getUserID());
		return listInvoices;
	}

	@QueryHandler
	public List<InvoiceResponseModel> handle(GetAllInvoiceByUserIdQuery getAllInvoiceByUserIdQuery) {
		List<Invoice> listInvoices = invoiceRepository.findAll();
		List<InvoiceResponseModel> responseModels = new ArrayList<>();

		listInvoices.forEach(invoice -> {
			if (invoice.getUserID() == getAllInvoiceByUserIdQuery.getUserID()) {
				InvoiceResponseModel model = new InvoiceResponseModel();

				model.setDetailedInvoices(null);
				model.setEmail(invoice.getUserInvoiceIndex());
				model.setInvoiceDate(invoice.getInvoiceDate());
				model.setNote(invoice.getNote());
				model.setShippingDate(invoice.getShippingDate());
				model.setShippingInfo(null);
				model.setStatusInvoice(invoice.getStatusInvoice());
				model.setTotalPrice(invoice.getTotalCost());

				List<DetailedInvoice> listDetailedInvoices = detailedInvoiceRepository
						.findDetailedInvoicceByInvoiceId(invoice.get_id());
				List<DetailedInvoiceResponseModel> listDetail = new ArrayList<>();
				listDetailedInvoices.forEach(detailedInvoice -> {
					DetailedInvoiceResponseModel detailedInvoiceResponseModel = new DetailedInvoiceResponseModel();
					detailedInvoiceResponseModel.setProductID(detailedInvoice.getProductID());
					detailedInvoiceResponseModel.setQuantity(detailedInvoice.getQuantity());
					detailedInvoiceResponseModel.setTotalPrice(detailedInvoice.getTotalPrice());
					detailedInvoiceResponseModel.setProductPrice(detailedInvoice.getPrice());

					try {
						GetProductCommonQuery getProductCommonQuery = new GetProductCommonQuery();

						ProductResponseCommonModel productResponseCommonModel = queryGateway
								.query(getProductCommonQuery,
										ResponseTypes.instanceOf(ProductResponseCommonModel.class))
								.join();

						detailedInvoiceResponseModel.setProductName(productResponseCommonModel.getProductName());
						detailedInvoiceResponseModel.setCategorySlug(productResponseCommonModel.getCategorySlug());

					} catch (Exception e) {
					}

				});
				model.setDetailedInvoices(listDetail);

				ShippingInfo shippingInfo = shippingInfoRepository.findShippingInfoByInvoiceId(invoice.get_id());
				ShippingInfoResponseModel shippingInfoResponseModel = new ShippingInfoResponseModel();
				shippingInfoResponseModel.setAddress(shippingInfo.getAddress());
				shippingInfoResponseModel.setFullname(shippingInfo.getFullName());
				shippingInfoResponseModel.setPhone(shippingInfo.getPhoneNumber());

				model.setShippingInfo(shippingInfoResponseModel);

				/*
				 * try { GetUserSessionCommonQuery getUserSessionCommonQuery = new
				 * GetUserSessionCommonQuery();
				 * 
				 * UserSessionCommonModel userSessionCommonModel =
				 * queryGateway.query(getUserSessionCommonQuery,
				 * ResponseTypes.instanceOf(UserSessionCommonModel.class)).join();
				 * 
				 * } catch (Exception e) { // TODO: handle exception }
				 */

				responseModels.add(model);
			}
		});
		return responseModels;
	}

}

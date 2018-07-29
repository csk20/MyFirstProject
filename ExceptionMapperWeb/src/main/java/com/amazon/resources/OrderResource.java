package com.amazon.resources;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.amazon.domain.OrderInfo;
import com.amazon.exception.InvalidInputException;

@Path("/order")
public class OrderResource {

	private Map<String, OrderInfo> ordersMap = null;

	public OrderResource() {
		ordersMap = new HashMap<String, OrderInfo>();
	}

	@Path("/placeOrder")
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response placeOrder(OrderInfo orderInfo) throws Exception {
		Response response = null;
		System.out.println(orderInfo);
		String itemCode = orderInfo.getItemCode();
		if (itemCode != null && !itemCode.equals("")) {
			ordersMap.put(orderInfo.getOrderId(), orderInfo);
			response = Response.created(new URI("/rest/order/placeOrder"))
					.build();
		} else {
			throw new InvalidInputException("Item Code is Mandatory..!!");
		}
		return response;
	}

	@Path("/getOrderInfo")
	@GET
	@Consumes(MediaType.APPLICATION_XML)
	public Response fetchOrderInfo(@QueryParam("oid") String oid)
			throws Exception {
		System.out.println(ordersMap); 
		Response response = null;
		if (oid != null && !oid.equals("")) {
			OrderInfo oinfo = ordersMap.get(oid);
			response = Response.ok(oinfo).build();
		} else {
			//throw new InvalidInputException("Order Id is Not Available..!!");
			throw new WebApplicationException("Item Code is Mandatory..!!", 495);

		}
		return response;
	}
}

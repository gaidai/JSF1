
package com.sgaidai.jsfdatetable1;


import java.io.Serializable;
import java.math.BigDecimal;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;

//http://localhost:8080/JavaServerFaces/default.xhtml

@ManagedBean(name="order")
@SessionScoped
public class OrderBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private static final Order[] orderList = new Order[] {

		new Order("A0001", "Intel CPU",
				new BigDecimal("700.00"), 1),
		new Order("A0002", "Harddisk 1000TB",
				new BigDecimal("500.00"), 2),
		new Order("A0003", "Dell Laptop",
				new BigDecimal("11600.00"), 8),
		new Order("A0004", "Samsung LCD",
				new BigDecimal("5200.00"), 3),
		new Order("A0005", "A4Tech Mouse",
				new BigDecimal("100.00"), 10)
	};

	/*public Order[] getOrderList() {return orderList;}*/
        
        private DataModel<Order> order = new ArrayDataModel<Order>(orderList);

	public DataModel<Order> getOrderList() {

		return order;

	}
        public String saveAction() {
		//get all existing value but set "editable" to false
		for (Order order : orderList){order.setEditable(false);}
		//return to current page
		return null;
        }
        
        public String editAction(Order order) {

            order.setEditable(true);
            return null;
        }

	public static class Order{
            
            BigDecimal price;
            boolean editable;
            int qty;
            String orderNo;
            String productName;

            public String getOrderNo() {
                return orderNo;
            }

            public void setOrderNo(String orderNo) {
                this.orderNo = orderNo;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public BigDecimal getPrice() {
                return price;
            }

            public void setPrice(BigDecimal price) {
                this.price = price;
            }

            public int getQty() {
                return qty;
            }

            public boolean isEditable() {
                    return editable;
            }
            public void setEditable(boolean editable) {
                    this.editable = editable;
            }
            public boolean getEditable() {
                return editable;
            }
            public void setQty(int qty) {
                this.qty = qty;
            }


            public Order(String orderNo, String productName,
                            BigDecimal price, int qty) {

                    this.orderNo = orderNo;
                    this.productName = productName;
                    this.price = price;
                    this.qty = qty;
            }

	}
}
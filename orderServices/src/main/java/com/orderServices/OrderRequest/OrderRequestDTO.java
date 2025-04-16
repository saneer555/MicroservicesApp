package com.orderServices.OrderRequest;



import jakarta.validation.constraints.Positive;

public class OrderRequestDTO {
    private Long userId;
    
    private Long productId;
    
    @Positive(message = "Quantity must be positive")
    private int quantity;

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
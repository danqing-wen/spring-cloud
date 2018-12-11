package com.danqing.productserver;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

public class ProductEvent extends RemoteApplicationEvent {
    public static final String ET_UPDATE = "update";
    public static final String ET_DELETE = "delete";

    private String action;
    private String itemCode;

    public ProductEvent() {

    }

    public ProductEvent(Object source, String originService, String destinationService, String action, String itemCode) {
        super(source, originService, destinationService);
        this.action = action;
        this.itemCode = itemCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductEvent{");
        sb.append("action='").append(action).append('\'');
        sb.append(", itemCode='").append(itemCode).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }

    public String getItemCode() {
        return itemCode;
    }
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}



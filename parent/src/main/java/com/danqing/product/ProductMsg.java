package com.danqing.product;
public class ProductMsg {
    /** 消息类型：更新商品，值为: {@value} */
    public static final String MA_UPDATE = "update";
    /** 消息类型：删除商品，值为: {@value} */
    public static final String MA_DELETE = "delete";

    private String action;
    private String itemCode;

    public ProductMsg() {
    }

    public ProductMsg(String action, String itemCode) {
        this.action = action;
        this.itemCode = itemCode;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductMsg{");
        sb.append("action='").append(action).append('\'');
        sb.append(", itemCode='").append(itemCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

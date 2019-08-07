package org.cc.task.model.foreign.customer;

import io.swagger.annotations.ApiModelProperty;

public class Model {

    public enum Operator {

        NONE,

        EQUAL,

        NOT_EQUAL,

        GREATER_THAN,

        LESS_THAN,

        GREATER_THAN_OR_EQUAL,

        LESS_THAN_OR_EQUAL,

        LIKE,

        IN,

        NOT_IN,

        IS_NULL,

        IS_NOT_NULL
    }

    public enum Connector {
        AND,

        OR
    }

    public enum JoinType {

        INNER,

        LEFT,

        RIGHT,

        LEFT_UPPER_INNER_ON_VALUE,

        RIGEHT_UPPER_INNER_ON_VALUE
    }

    @ApiModelProperty(
            value = "当前初始页数(默认为1)")
    public Integer offset = 1;

    @ApiModelProperty(
            value = "每页最大记录数(默认为20)")
    public Integer limit = 20;

    @ApiModelProperty(
            value = "排序方式（例：+signatureNo,-socialCreditId[按照玺号升序、社会信用代码降序]）")
    public String order;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Model)) return false;

        Model that = (Model) o;

        if (offset != null ? !offset.equals(that.offset) : that.offset != null) return false;
        if (limit != null ? !limit.equals(that.limit) : that.limit != null) return false;
        return order != null ? order.equals(that.order) : that.order == null;
    }

    @Override
    public int hashCode() {
        int result = offset != null ? offset.hashCode() : 0;
        result = 31 * result + (limit != null ? limit.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Model{" +
                "offset=" + offset +
                ", limit=" + limit +
                ", order='" + order + '\'' +
                '}';
    }
}

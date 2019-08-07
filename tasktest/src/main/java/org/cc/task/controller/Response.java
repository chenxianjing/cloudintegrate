package org.cc.task.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "服务响应信息")
public class Response<T> implements Serializable {

    @ApiModelProperty(
            value = "响应状态",
            position = 1)
    private HttpResponseStatus code;

    @ApiModelProperty(
            value = "响应信息",
            position = 2)
    private String msg;

    @ApiModelProperty(
            value = "响应数据",
            position = 3)
    private T data;

    @ApiModelProperty(
            value = "响应连接",
            position = 4)
    private Object links;

    public Response() {
    }

    public Response(HttpResponseStatus code) {
        this.code = code;
    }

    public Response(HttpResponseStatus code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(HttpResponseStatus code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Response(HttpResponseStatus code, String msg, T data, Object links) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.links = links;
    }

    public HttpResponseStatus getCode() {
        return code;
    }

    public void setCode(HttpResponseStatus code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Object getLinks() {
        return links;
    }

    public void setLinks(Object links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", links=" + links +
                '}';
    }



    public enum HttpResponseStatus {
        OK("0", "ok"),

        NO_SERVICE("8", "no service"),

        ERR("9", "error");

        private final String value;
        private final String description;

        HttpResponseStatus(String value, String description) {
            this.value = value;
            this.description = description;
        }

        public String value() {
            return this.value;
        }

        public String getDescription() {
            return this.description;
        }
    }

    /**
     * 成功响应
     * @author chenxianjing
     * @date 2019-06-22 11:00
     * @param data
     * @return
     */
    public static Response success(Object data){
        Response response = new Response();
        response.setCode(HttpResponseStatus.OK);
        response.setMsg(HttpResponseStatus.OK.getDescription());
        response.setData(data);
        return response;
    }

    /**
     * 失败响应
     * @author chenxianjing
     * @date 2019-06-22 11:00
     * @param data
     * @return
     */
    public static Response failure(Object data){
        Response response = new Response();
        response.setCode(HttpResponseStatus.ERR);
        response.setMsg(HttpResponseStatus.ERR.getDescription());
        response.setData(data);
        return response;
    }

    /**
     * 无服务响应
     * @author chenxianjing
     * @date 2019-06-22 11:00
     * @param data
     * @return
     */
    public static Response noService(Object data){
        Response response = new Response();
        response.setCode(HttpResponseStatus.NO_SERVICE);
        response.setMsg(HttpResponseStatus.NO_SERVICE.getDescription());
        response.setData(data);
        return response;
    }
}

package org.cc.task.controller;

import java.util.List;

import org.cc.task.model.foreign.customer.in.CustomerSealDataInValidSearchIModel;
import org.cc.task.model.foreign.customer.in.CustomerSealDataUserIModel;
import org.cc.task.model.foreign.customer.out.CustomerSealDataInValidOModel;
import org.cc.task.model.foreign.customer.out.CustomerSealDataUserOModel;
import org.cc.task.model.foreign.in.GovSealDeactiveIModel;
import org.cc.task.model.foreign.in.GovSealReleaseIModel;
import org.cc.task.model.foreign.in.GovSealRenewalIModel;
import org.cc.task.model.foreign.out.GovRandomOModel;
import org.cc.task.service.GovSealService;
import org.cc.task.service.GovSealTransferService;
import org.cc.task.service.GovSecretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(
        value = "/sealWide",
        tags = {"印章状态查询对外接口"})
@RestController
@RequestMapping("/sealWide")
public class SealWideController {
    @Autowired
    private GovSealService govSealService;
    @Autowired
    private GovSealTransferService govSealTransferService;
    @Autowired
    private GovSecretService govSecretService;


    //start
    //国办测试专用
    @ApiOperation(
            value = "获取token(国家)",
            produces = "application/json",
            consumes = "application/json")
    @PostMapping(value = "/getToken")
    public Response<String> getToken(){
        Response<String> reponse = new Response();
        reponse.setCode(Response.HttpResponseStatus.OK);
        reponse.setMsg("成功");
        reponse.setData(govSealService.getToken());
        return reponse;
    }

    @ApiOperation(
            value = "注册用户获取印章状态(国家)",
            produces = "application/json",
            consumes = "application/json")
    @PostMapping(value = "/getRegisterSeal")
    public Response<List<CustomerSealDataUserOModel>> getRegisterSeal(@RequestBody CustomerSealDataUserIModel customerSealDataUserIModel){
        Response<List<CustomerSealDataUserOModel>> reponse = new Response();
        reponse.setCode(Response.HttpResponseStatus.OK);
        reponse.setMsg("成功");
        reponse.setData(govSealService.getRegisterSeal(customerSealDataUserIModel));
        return reponse;
    }

    @ApiOperation(
            value = "非注册用户获取印章状态(国家)",
            produces = "application/json",
            consumes = "application/json")
    @PostMapping(value = "/getUnRegisterSeal")
    public Response<List<CustomerSealDataUserOModel>> getUnRegisterSeal(@RequestBody CustomerSealDataUserIModel customerSealDataUserIModel){
        Response<List<CustomerSealDataUserOModel>> reponse = new Response();
        reponse.setCode(Response.HttpResponseStatus.OK);
        reponse.setMsg("成功");
        reponse.setData(govSealService.getUnRegisterSeal(customerSealDataUserIModel));
        return reponse;
    }

    @ApiOperation(
            value = "获取用户吊销列表(国家)",
            produces = "application/json",
            consumes = "application/json")
    @PostMapping(value = "/getDeactiveSeal")
    public Response<List<CustomerSealDataInValidOModel>> getDeactiveSeal(@RequestBody CustomerSealDataInValidSearchIModel customerSealDataInValidSearchIModel){
        Response<List<CustomerSealDataInValidOModel>> reponse = new Response();
        reponse.setCode(Response.HttpResponseStatus.OK);
        reponse.setMsg("成功");
        reponse.setData(govSealService.getDeactiveSeal(customerSealDataInValidSearchIModel));
        return reponse;
    }

    @ApiOperation(
            value = "电子印章同步数据获取随机数接口（身份认证）(国家)",
            produces = "application/json",
            consumes = "application/json")
    @PostMapping(value = "/getRandom")
    public Response<GovRandomOModel> getRandom(){
        Response<GovRandomOModel> reponse = new Response();
        reponse.setCode(Response.HttpResponseStatus.OK);
        reponse.setMsg("成功");
        reponse.setData(govSealTransferService.getRandom());
        return reponse;
    }

    @ApiOperation(
            value = "印章发布(国家)",
            produces = "application/json",
            consumes = "application/json")
    @PostMapping(value = "/release")
    public Response<Boolean> release(@RequestBody GovSealReleaseIModel govSealReleaseIModel){
        Response<Boolean> reponse = new Response();
        reponse.setCode(Response.HttpResponseStatus.OK);
        reponse.setMsg("成功");
        reponse.setData(govSealTransferService.release(govSealReleaseIModel));
        return reponse;
    }

    @ApiOperation(
            value = "印章吊销(国家)",
            produces = "application/json",
            consumes = "application/json")
    @PostMapping(value = "/deactive")
    public Response<Boolean> deactive(@RequestBody GovSealDeactiveIModel govSealDeactiveIModel){
        Response<Boolean> reponse = new Response();
        reponse.setCode(Response.HttpResponseStatus.OK);
        reponse.setMsg("成功");
        reponse.setData(govSealTransferService.deactive(govSealDeactiveIModel));
        return reponse;
    }

    @ApiOperation(
            value = "印章续期(国家)",
            produces = "application/json",
            consumes = "application/json")
    @PostMapping(value = "/renewal")
    public Response<Boolean> renewal(@RequestBody GovSealRenewalIModel govSealRenewalIModel){
        Response<Boolean> reponse = new Response();
        reponse.setCode(Response.HttpResponseStatus.OK);
        reponse.setMsg("成功");
        reponse.setData(govSealTransferService.renewal(govSealRenewalIModel));
        return reponse;
    }



    @ApiOperation(
            value = "获取密钥(国家)",
            produces = "application/json",
            consumes = "application/json")
    @PostMapping(value = "/getSecret")
    public Response<String> getSecret(){
        Response<String> reponse = new Response();
        reponse.setCode(Response.HttpResponseStatus.OK);
        reponse.setMsg("成功");
        reponse.setData(govSecretService.getSecret());
        return reponse;
    }
}

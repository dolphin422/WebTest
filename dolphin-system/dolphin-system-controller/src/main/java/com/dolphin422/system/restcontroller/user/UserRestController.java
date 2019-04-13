package com.dolphin422.system.restcontroller.user;

import com.dolphin422.common.base.BaseController;
import com.dolphin422.common.exception.BusinessException;
import com.dolphin422.common.returnvo.ReturnVo;
import com.dolphin422.system.model.user.SysUserModel;
import com.dolphin422.system.service.api.user.ISysUserService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @Description: 用户操作Restful接口
 * @author: DamonJT WIN
 * @createDate: 2018.12.21 12:30
 */
@RestController
@RequestMapping("/v1/user")
public class UserRestController extends BaseController {

    @Autowired
    private ISysUserService sysUserService;

    @ApiOperation(value = "查询所有用户", notes = "查询所有用户")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ReturnVo getUsers() throws BusinessException {
        List<SysUserModel> userList = sysUserService.searchListByPage();
        return ReturnVo.successVo(userList);
    }

    @ApiOperation(value = "新增用户", notes = "新增用户")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ReturnVo postUser(@RequestBody SysUserModel sysUserModel) throws BusinessException {
        sysUserService.addUser(sysUserModel);
        ReturnVo<String> returnVo = ReturnVo.successVo();
        returnVo.setMessage("新增用户成功");
        return returnVo;
    }

    @ApiOperation(value = "查询用户", notes = "根据ID查询用户信息 ")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ReturnVo getUser(@PathVariable String id) throws BusinessException {
        SysUserModel userById = sysUserService.findUserById(id);
        return ReturnVo.successVo(userById);
    }

    @ApiOperation(value = "修改信息", notes = "根据ID修改有变动的用户信息")
    @RequestMapping(value = "", method = RequestMethod.PATCH)
    public ReturnVo patchUser(@RequestBody SysUserModel sysUserModel) throws BusinessException {
        sysUserService.updateUserSelective(sysUserModel);
        ReturnVo<String> returnVo = ReturnVo.successVo();
        returnVo.setMessage("修改用户成功");
        return returnVo;
    }

    @ApiIgnore
    @ApiOperation(value = "修改信息", notes = "根据ID修改用户所有信息")
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ReturnVo putUser(@RequestBody SysUserModel sysUserModel) throws BusinessException {
        sysUserService.updateUserFull(sysUserModel);
        ReturnVo<String> returnVo = ReturnVo.successVo();
        returnVo.setMessage("修改用户成功");
        return returnVo;
    }

    @ApiOperation(value = "删除用户", notes = "根据ID删除用户")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ReturnVo deleteUser(@PathVariable String id) throws BusinessException {
        sysUserService.deleteUser(id);
        ReturnVo<String> returnVo = ReturnVo.successVo();
        returnVo.setMessage("删除用户成功");
        return returnVo;
    }

}

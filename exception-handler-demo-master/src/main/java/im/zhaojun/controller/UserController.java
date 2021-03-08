package im.zhaojun.controller;

import im.zhaojun.model.User;
import im.zhaojun.service.UserService;
import im.zhaojun.util.ResultBean;
import io.swagger.annotations.Api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping("Exception/user")
@Api(value = "/Exception/V1/user", tags = {"自定义异常处理"}) 
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/index")
    public String index() {
        return "user-list";
    }

    @GetMapping("/list")
    @ResponseBody
    public ResultBean list() {
        return ResultBean.success(userService.selectAll());
    }

    @GetMapping("/add")
    public String add() {
        return "user-add";
    }

    @PostMapping("/add")
    @ResponseBody
    public ResultBean add(@Valid User user) {
        userService.add(user);
        return ResultBean.success();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResultBean delete(@PathVariable("id") Integer id) {
        userService.delete(id);
        return ResultBean.success();
    }
}

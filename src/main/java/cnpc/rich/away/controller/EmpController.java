package cnpc.rich.away.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmpController {

    //查询所有员工列表返回列表页面
    @GetMapping("/emps")
    public  String list(){
        return "/pages/employee/usersList";
    }
}

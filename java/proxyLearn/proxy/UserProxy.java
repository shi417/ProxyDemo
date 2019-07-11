package proxyLearn.proxy;

import proxyLearn.Service.IUserService;
import proxyLearn.dto.UserParam;

public class UserProxy implements IUserService {

    private IUserService userService;

    public UserProxy(IUserService userService){
        this.userService = userService;
    }

    public void addUser(UserParam user) {
        System.out.println("proxy start");
        userService.addUser(user);
        System.out.println("proxy end");
    }
}

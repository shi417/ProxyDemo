package proxyLearn.Impl;


import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import proxyLearn.Service.IUserService;
import org.slf4j.Logger;
import proxyLearn.dto.UserParam;
import proxyLearn.proxy.ProxyFactory;
import proxyLearn.proxy.UserProxy;

@Service
public class UserServiceImpl implements IUserService {
    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public void addUser(UserParam user) {
        System.out.println("begin save user");
        System.out.println("end save user");
    }

    public static void main(String[] args) {
        UserParam user = new UserParam();
        IUserService userService = new UserServiceImpl();
        //static proxy
        IUserService userProxy = new UserProxy(userService);
        userProxy.addUser(user);
        //jdk proxy
        ProxyFactory proxyFactory = new ProxyFactory(userService);
        IUserService proxy = (IUserService)proxyFactory.getProxyInstance();
        proxy.addUser(user);
    }
}

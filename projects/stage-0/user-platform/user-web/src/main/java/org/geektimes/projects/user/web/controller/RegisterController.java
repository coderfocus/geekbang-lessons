package org.geektimes.projects.user.web.controller;

import org.geektimes.function.ThrowableFunction;
import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.service.UserServiceImpl;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;

/**
 * 输出 “Hello,World” Controller
 */
@Path("/register")
public class RegisterController implements PageController {

//    private UserService userService = new UserServiceImpl();

    @GET
    @Path("/")
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return "register.jsp";
    }

    @POST
    @Path("/register")
    public String register(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        User model = getModel(httpRequest -> {
            BeanInfo userBeanInfo = Introspector.getBeanInfo(User.class, Object.class);
            User user = new User();
            for (PropertyDescriptor propertyDescriptor : userBeanInfo.getPropertyDescriptors()) {
                String fieldName = propertyDescriptor.getName();
                Class fieldType = propertyDescriptor.getPropertyType();
                String paramValue = httpRequest.getParameter(fieldName);

                // 获取 User 类 Setter方法
                // PropertyDescriptor ReadMethod 等于 Getter 方法
                // PropertyDescriptor WriteMethod 等于 Setter 方法
                Method setterMethodFromUser = propertyDescriptor.getWriteMethod();
                setterMethodFromUser.invoke(user, paramValue);
            }
           return user;
        },request);
//        boolean registerResult = userService.register(model);
        boolean registerResult = true;
        if(registerResult){
            return "success.jsp";
        }
        return "failure.jsp";
    }

    private <T> T getModel(ThrowableFunction<HttpServletRequest, T> function,HttpServletRequest request){
        try{
            return function.execute(request);
        } catch (Throwable e) {
        }
        return null;
    }

}

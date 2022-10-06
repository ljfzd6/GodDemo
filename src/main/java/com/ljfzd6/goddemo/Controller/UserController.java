package com.ljfzd6.goddemo.Controller;

import cn.hutool.core.codec.Base64Encoder;
import cn.hutool.core.io.FileUtil;
import com.ljfzd6.goddemo.entity.GodUser;
import com.ljfzd6.goddemo.entity.GodUserImage;
import com.ljfzd6.goddemo.service.UserImageService;
import com.ljfzd6.goddemo.service.UserService;
import com.ljfzd6.goddemo.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.mail.MessagingException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserImageService userImageService;
    @Autowired
    RedisTemplate<String,Object> redisTemplate;
    @Value("${server.port}")
    String port;

    //登录信息
    @RequestMapping("/login")
    public R login(@RequestParam("username") String username,
                   @RequestParam("password") String password)
    {
        GodUser userByUsername = userService.getUserByUsername(username);
        if (userByUsername!=null)
        {
            if (userByUsername.getPassword().equals(password))
            {
                System.out.println("密码");
                return new R(200,true);
            }
            else  {
                return new R(500,false);
            }
        }
        else
        {
            return new R(500,false);
        }
    };
    //根据用户名查询全部用户信息
    @RequestMapping("/selectuserbyusername")
    public R selectuserByusername(@RequestParam("username") String username) {
        GodUser userByUsername = userService.getUserByUsername(username);
        System.out.println(userByUsername);
        return new R(200,userByUsername);
    }
    //修改用户信息
    @GetMapping("/updateuser")
    public R updateUser (@RequestParam("id") Integer id,
                         @RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestParam("age") Integer age,
                         @RequestParam("name") String name,
                         @RequestParam("phone") String phone,
                         @RequestParam("address") String address,
                         @RequestParam("email") String email)
    {
        System.out.println("数据为"+id+username+password+age+name+phone+address);
        boolean b = userService.updateUser(new GodUser(id,age,username,password,name,phone,address,email));
        System.out.println(b);
        if (b ==true){
            return new R(200,"修改成功");
        }else {
            return new R(500,"修改失败");
        }
    }
    //发送验证码
    @RequestMapping("/passwordVerifCode")
    public R sendVerfiCode(@RequestParam("username")String username)  {
        SendEmail sendEmail=new SendEmail();
        String letter = VerifCode.getLetter();
        try {
            sendEmail.sendMail("1650548543@qq.com","验证码为"+letter);
            redisTemplate.opsForValue().set(username,letter,30, TimeUnit.SECONDS);
            return  new R(200,null);
        } catch (MessagingException e) {
            e.printStackTrace();
            return  new R(500,null);
        }
    }
    //修改密码
    @RequestMapping("/updatepassword")
    public R updatePassword(@RequestParam("username")String username,
                            @RequestParam("password")String password,
                            @RequestParam("verifcode")String verifcode)
    {
        System.out.println("进来了");
        System.out.println(username+password+verifcode);
        String verfi = (String) redisTemplate.opsForValue().get(username);
        if (verfi.equals(verifcode)) {
            boolean b = userService.updatePassword(password, username);
            if (b){
                return  new R(200,"密码修改成功");
            }else
            {
                return  new R(500,"密码修改失败");
            }
        }
        else {
            return new R(500,"验证码错误");
        }
    }
    //获取全部用户
    @RequestMapping("/getalluser")
    public R getAllUser()
    {
        System.out.println("进来了");
        List<GodUser> allUser = userService.getAllUser();
        return  new R(200,allUser);
    }
    //删除用户
    @RequestMapping("/deleteuser")
    public  R delteUser(@RequestParam("username")String username)
    {
        System.out.println("进来了");
        boolean deleteuser = userService.deleteuser(username);
        if (deleteuser==true)
        {
            return new R(200,null);
        }else{
            return new R(500,null);
        }
    }
    //添加用户
    @RequestMapping("/adduser")
    public R addUser(@RequestParam("username") String username,
                     @RequestParam("password") String password,
                     @RequestParam("age") Integer age,
                     @RequestParam("name") String name,
                     @RequestParam("phone") String phone,
                     @RequestParam("address") String address,
                     @RequestParam("email") String email)
    {
        System.out.println("开始添加");
        boolean adduser = userService.adduser(new GodUser(null, age, username, password, name, phone, address, email));
        System.out.println(adduser);
        if (adduser==true) {
            return  new R(200,"添加成功");
        }else{
            return  new R(500,"添加失败");
        }
    }
    //添加用户身份证号
    @RequestMapping("/addUserimage")
    // 此处的@RequestParam中的file名应与前端upload组件中的name的值保持一致
    public R upload(@RequestParam("file") MultipartFile multipartFile,
                         @RequestParam("username") String username) throws Exception {
        // replaceAll 用来替换windows中的\\ 为 /
        GodUser userByUsername = userService.getUserByUsername(username);
        String upload = FileUploadUtil.upload(multipartFile);
        boolean b = userImageService.addUserImage(new GodUserImage(
                null,
                userByUsername.getId(),
                upload,
                null));

        if (b) {
            return  new R(200,"添加成功");
        }else{
            return  new R(200,"添加失败");
        }
    }
    //识别二维码
    @RequestMapping("/qrcodeCheck")
    public  R qrcodeCheck(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        String decode = QRCodeUtil.decode(MultipartFileToFile.multipartFileToFile(multipartFile));
        return new R(200,decode);
    }
    //添加用户头像
    @RequestMapping("/addusericon")
    public  R addUserIcon(@RequestParam("file") MultipartFile multipartFile,
                          @RequestParam("username")String username) throws Exception {
        GodUser userByUsername = userService.getUserByUsername(username);
        String upload = FileUploadUtil.upload(multipartFile);
        boolean b = userImageService.addUserIcon(new GodUserImage(
                null,
                userByUsername.getId(),
                null,
                upload));
        String imgBase = FileToBase64.getImgBase(upload);
        if (b)
        {
            return new R(200,"data:image/jpeg;base64,"+imgBase);
        }
        else
        {
            return new R(500,"添加头像之前请先完成身份验证");
        }
    }
    // 获取用户头像
    @RequestMapping("/getusericon")
    public R getusericon(@RequestParam("username")String username){
        String userIconByUsername = userImageService.getUserIconByUsername(username);
        System.out.println("userIconByUsername"+userIconByUsername);
        if (userIconByUsername==null){
            return new R(500,"");
        }
        else if (userIconByUsername.isEmpty()){
            return new R(500,"");
        }else {
            String imgBase = FileToBase64.getImgBase(userIconByUsername);
            return new R(200,"data:image/jpeg;base64,"+imgBase);
        }
    }

}

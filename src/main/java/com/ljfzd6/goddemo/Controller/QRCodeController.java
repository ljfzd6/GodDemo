package com.ljfzd6.goddemo.Controller;

import com.ljfzd6.goddemo.entity.GodUser;
import com.ljfzd6.goddemo.utils.QRCodeUtil;
import com.ljfzd6.goddemo.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>QRCodeController</p>
 *
 * @author lvhaosir6
 * @version 1.0.0
 * @date 2020/7/10
 */
@RestController
@RequestMapping("/qrcode")
public class QRCodeController {

    /**
     * 根据 content 生成二维码
     *
     * @param content
     * @param width
     * @param height
     * @return
     */
    @GetMapping("/getQRCodeBase64")
    public R getQRCode(@RequestParam("id") Integer id,
                       @RequestParam("username") String username,
                       @RequestParam("password") String password,
                       @RequestParam("age") Integer age,
                       @RequestParam("name") String name,
                       @RequestParam("phone") String phone,
                       @RequestParam("address") String address,
                       @RequestParam("email") String email) {
        System.out.println("进来了");
        return new R(200,QRCodeUtil.getBase64QRCode(new GodUser(id,age,username,password,name,phone,address,email).toString()));
    }

    /**
     * 根据 content 生成二维码
     */
    @GetMapping(value = "/getQRCode")
    public void getQRCode(HttpServletResponse response,
                          @RequestParam("content") String content,
                          @RequestParam(value = "logoUrl", required = false) String logoUrl) throws Exception {
        ServletOutputStream stream = null;
        try {
            stream = response.getOutputStream();
            QRCodeUtil.getQRCode(content, logoUrl, stream);
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            if (stream != null) {
                stream.flush();
                stream.close();
            }
        }
    }

}
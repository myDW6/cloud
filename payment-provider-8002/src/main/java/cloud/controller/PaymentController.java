package cloud.controller;

import cloud.service.PaymentService;
import com.shaodw.cloud.domain.CommonResult;
import com.shaodw.cloud.domain.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author shaodw
 * @date 2021/3/22 20:02
 * @description
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping(value = "/add")
    public CommonResult<Boolean> add(@RequestBody Payment payment)
    {
        boolean add = paymentService.add(payment);
        return CommonResult.<Boolean>builder()
                .message("这是端口为: " + port + " 的进程提供的服务")
                .code(200)
                .data(add)
                .build();
    }

    @GetMapping("/getById/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id){
        return CommonResult.<Payment>builder()
                .message("这是端口为: " + port + " 的进程提供的服务")
                .code(200)
                .data(paymentService.getById(id))
                .build();
    }

    @GetMapping("/timeout")
    public String timeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }

}

package cloud.service.impl;

import cloud.dao.PaymentDao;
import cloud.service.PaymentService;
import com.shaodw.cloud.domain.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author shaodw
 * @date 2021/3/22 19:59
 * @description
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public boolean add(Payment payment) {
        return paymentDao.create(payment) > 0;
    }

    @Override
    public Payment getById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}

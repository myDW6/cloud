package cloud.service;

import com.shaodw.cloud.domain.Payment;

/**
 * @author shaodw
 * @date 2021/3/22 19:59
 * @description
 */
public interface PaymentService {

    boolean add(Payment payment);

    Payment getById(Long id);
}

package cloud.dao;

import com.shaodw.cloud.domain.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author shaodw
 * @date 2021/3/22 20:00
 * @description
 */
@Repository
public interface PaymentDao {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}

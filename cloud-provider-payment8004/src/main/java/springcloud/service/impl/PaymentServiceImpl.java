package springcloud.service.impl;

import com.zhanghao.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import springcloud.dao.PaymentDao;
import springcloud.service.PaymentService;

/**
 * @author zhang hao on 2021/5/19
 */
@Service
public class PaymentServiceImpl  implements PaymentService {

    @Autowired
    @Qualifier("paymentDao")
    private PaymentDao paymentDao;

    @Override
    public int creatPayment(Payment payment) {
        return paymentDao.creatPayment(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}

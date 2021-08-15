package springcloud.dao;

import com.zhanghao.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhang hao on 2021/5/19
 */
@Mapper
public interface PaymentDao {

    int creatPayment(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}

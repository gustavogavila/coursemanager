package coursemanagerapi.models.services;

import org.springframework.stereotype.Service;

import coursemanagerapi.models.entities.PaymentView;
import coursemanagerapi.models.repositories.PaymentViewRepository;

@Service
public class PaymentViewService extends BaseService<PaymentView, Long, PaymentViewRepository> {

}

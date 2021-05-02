package me.kimyounghan.springbootjpa;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountAuditAware implements AuditorAware<Account> {
    @Override
    public Optional<Account> getCurrentAuditor() {
        System.out.println("메소드 호출이 되는지만 확인");
        return Optional.empty();
    }
}

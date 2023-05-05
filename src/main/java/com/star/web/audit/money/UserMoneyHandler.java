package com.star.web.audit.money;



import com.star.web.audit.Audit;
import com.star.web.audit.AuditHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author SWUST
 */
@Component
@RequiredArgsConstructor
public class UserMoneyHandler extends AuditHandler {

    @Override
    public void doHandler(Audit audit) {
        System.out.println(audit);
    }

}
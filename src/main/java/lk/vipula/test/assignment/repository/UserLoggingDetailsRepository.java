package lk.vipula.test.assignment.repository;

import lk.vipula.test.assignment.entity.UserLoggingDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoggingDetailsRepository extends JpaRepository<UserLoggingDetail,Long> {
}

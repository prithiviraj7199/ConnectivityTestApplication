package com.customer.travelAgency.bookingRepository;

import com.customer.travelAgency.bookingEntity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {


}

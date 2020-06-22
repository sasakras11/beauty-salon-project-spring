package com.salon.repository;

import com.salon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Repository

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findUserByUsername(String username);

  @Transactional
  @Modifying(clearAutomatically = true)
  @Query(
      value =
          "select user_id,password,role,username from users as u inner join salons_masters as sm on u.user_id = sm.masters_user_id where sm.salon_salon_id = ?1",
      nativeQuery = true)
  List<User> findAllMastersBySalonId(int salonId);
}

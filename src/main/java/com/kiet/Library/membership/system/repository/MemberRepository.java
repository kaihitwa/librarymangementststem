package com.kiet.Library.membership.system.repository;

import com.kiet.Library.membership.system.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByActiveTrue();

}

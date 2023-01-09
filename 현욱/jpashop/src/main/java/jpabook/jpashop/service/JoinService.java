package jpabook.jpashop.service;


import jpabook.jpashop.domain.Join;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.repository.JoinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class JoinService {

    private final JoinRepository joinRepository;

    @Transactional
    public Long join(Join join) {
        validateDuplicateJoin(join);
        joinRepository.save(join);
        return join.getId();
    }

    private void validateDuplicateJoin(Join join) {
        List<Join> findJoin = joinRepository.findByUserName(join.getUser_name());
        if (!findJoin.isEmpty()) {
            throw new IllegalStateException("이미 존재함");
        }

    }

    public List<Join> findJoin() {
        return joinRepository.findAll();
    }

    public Join findOne(Long id) {
        return joinRepository.findOne(id);
    }

    @Transactional
    public Boolean permissionLoginJoin(String user_name, String pw)
    {
        List<Join> permission = joinRepository.permission(user_name, pw);
        if(!permission.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    @Transactional
    public void update(Long id, String user_name, String pw) {
        Join join = joinRepository.findOne(id);
        join.setUser_name(user_name);
        join.setPw(pw);
    }

}

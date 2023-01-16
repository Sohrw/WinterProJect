package deliverySystem.moacall.service;


import deliverySystem.moacall.domain.Address;
import deliverySystem.moacall.domain.Member;
import deliverySystem.moacall.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

    @Transactional
    public void update(Long id, String userId, String name, String password, Address address) {
        Member member = memberRepository.findOne(id);
        member.setName(name);
        member.setPassword(password);
        member.setUserId(userId);
        member.setFoodAddress(address);
    }

    @Transactional
    public Boolean memberPermissionForLogin(String userId, String pw) {
        List<Member> permission = memberRepository.loginPermission(userId, pw);
        if (!permission.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}

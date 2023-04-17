package hello.login.domain.login;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {

  private final MemberRepository memberRepository;

  /**
   *
   * @param loginId
   * @param password
   * @return null 로그인 실패
   */
  public Member login(String loginId, String password) {
    Optional<Member> findMemberOptional = memberRepository.findByLoginId(loginId);
    return findMemberOptional
      .filter(m -> m.getPassword().equals(password))
      .orElse(null);
  }
}
